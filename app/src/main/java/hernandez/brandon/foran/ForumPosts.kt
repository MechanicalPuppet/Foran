package hernandez.brandon.foran

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.get
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import kotlinx.android.synthetic.main.activity_forum_posts.*
import kotlinx.android.synthetic.main.activity_recipes_details.*
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class ForumPosts : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth
    private var adaptador: AdaptadorPublicaciones? = null

    companion object {
        var allPubs = ArrayList<Publicacion>()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum_posts)

        allPubs = ArrayList()
        storage = FirebaseFirestore.getInstance()

        var listView: ListView = findViewById(R.id.listview_forum)
        var foranApp: ImageView = findViewById(R.id.ForanImg)
        var backMenu: ImageView = findViewById(R.id.backForum)

        val bundle = intent.extras

        if (bundle != null) {
            this.iv_forum_icon.setImageResource(bundle.getInt("icon"))
            this.tv_forum_title.setText(bundle.getString("title"))
        }

        var icon: Int = R.drawable.help
        var title: String = tv_forum_title.text.toString()

        agregarPublicaciones(title)

        if (!allPubs.isEmpty()) {
            adaptador = AdaptadorPublicaciones(this, allPubs)
            listview_forum.adapter = adaptador
        }

        if (title.equals("Se vende/se compra")) {
            icon = R.drawable.sellbuy
        } else if (title.equals("Eventos sociales")) {
            icon = R.drawable.event
        } else if (title.equals("Ayuda")) {
            icon = R.drawable.help
        } else if (title.equals("Consejos")) {
            icon = R.drawable.advice
        } else if (title.equals("Departamentos/Casas en renta")) {
            icon = R.drawable.rent
        }

        btnCrearPublicacion.setOnClickListener {
            var intent: Intent = Intent(this, CrearPublicacionActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("icon", icon)
            startActivity(intent)
        }

        foranApp.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        listView.setOnItemClickListener { parent, view, position, id ->
            var intent: Intent = Intent(this, detallePost::class.java)
            intent.putExtra("publicacion", listView.getItemAtPosition(position) as Serializable)
            startActivity(intent)
        }

        backMenu.setOnClickListener {
            var intent: Intent = Intent(this, ForumActivity::class.java)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun agregarPublicaciones(title: String) {

        allPubs = ArrayList()
        storage = FirebaseFirestore.getInstance()

        storage.collection("publicacion")
            .whereEqualTo("categoria", title)
            .get()
            .addOnSuccessListener {

                it.forEach {
                    var comentarios: ArrayList<Comentario> =
                        it.get("comentarios") as ArrayList<Comentario>

                    allPubs.add(
                        Publicacion(
                            it.id,
                            it.getString("titulo")!!,
                            it.getString("contenido")!!,
                            it.getString("categoria")!!,
                            comentarios
                        )
                    )
                }
                adaptador = AdaptadorPublicaciones(this, allPubs)
                listview_forum.adapter = adaptador
            }
            .addOnFailureListener {
                Toast.makeText(this, "failure", Toast.LENGTH_SHORT).show()
            }

/*
        var fecha = LocalDateTime.now()
        var usuario: Usuario = Usuario(1, "Brandon Hernandez" , "jbrandonhdez@gmail.com","brandon1" )
        var comentario: Comentario = Comentario(1, usuario, "Terminen con esto porfa", fecha)
        var comentario2: Comentario = Comentario(2, usuario, "Por favor", fecha)
        var comentarios = ArrayList<Comentario>()
        comentarios.add(comentario)
        comentarios.add(comentario2)
        allPubs.add(Publicacion(1,usuario,"Tengo ansiedad", "Ya quiero terminar esta materia", "Ayuda", comentarios, fecha ))
        allPubs.add(Publicacion(2,usuario,"Plebes ayudenme", "Sólo quiero dormir", "Ayuda", comentarios, fecha ))
        allPubs.add(Publicacion(3,usuario,"Merezco dormir", "Por favor ayudenme, no quiero ser el que de ordenes aaaa", "Ayuda", comentarios, fecha ))
        allPubs.add(Publicacion(4,usuario,"Perdón", "Hasta yo me caigo mal, una disculpa.", "Ayuda", comentarios, fecha ))
         */
    }

    private class AdaptadorPublicaciones : BaseAdapter {
        var publicaciones = ArrayList<Publicacion>()
        var contexto: Context? = null

        constructor(contexto: Context, publicaciones1: ArrayList<Publicacion>) {
            this.publicaciones = publicaciones1
            this.contexto = contexto
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var publi = publicaciones[position]
            var inflator = LayoutInflater.from(contexto)
            var vista = inflator.inflate(R.layout.publicacion_view, null)

            var imagen = vista.findViewById(R.id.imgfotoPerfilPublicacion) as ImageView
            var titulo = vista.findViewById(R.id.tv_titulo_publicacion) as TextView
            var contenido = vista.findViewById(R.id.tvContenidoPost) as TextView

            titulo.setText(publi.titulo)
            contenido.setText(publi.contenido)

            return vista
        }

        override fun getItem(position: Int): Any {
            return publicaciones[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return publicaciones.size
        }

    }
}