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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_crear_publicacion.*
import kotlinx.android.synthetic.main.activity_detalle_post.*
import kotlinx.android.synthetic.main.activity_forum_posts.*
import java.time.LocalDateTime

class detallePost : AppCompatActivity() {

    //Comentarios en Firebase
    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth
    private var adaptador: AdaptadorComentarios? = null

    companion object {
        var comentarios = ArrayList<Comentario>()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_post)

        comentarios = ArrayList()
        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        var foranApp: ImageView = findViewById(R.id.ForanImg)
        var backMenu: ImageView = findViewById(R.id.backForum)

        val bundle = intent.extras

        if (bundle != null) {
            val publicacion = bundle.getSerializable("publicacion") as Publicacion
            tv_titulo_publicacion_detalle.setText(publicacion.titulo)
            contenidoPostDetalle.setText(publicacion.contenido)
        }


        var icon: Int = R.drawable.help
        var title: String = tv_titulo_publicacion_detalle.text.toString()

        agregarPublicaciones(title)

        if (!comentarios.isEmpty()){
            adaptador = AdaptadorComentarios(this, comentarios)
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

        botonEnviarComentario.setOnClickListener {
            val comentario = hashMapOf(
                "email" to usuario.currentUser?.email,
                "comentarios" to txtComentario.text.toString(),
                "fechaHora" to LocalDateTime.now(),
                "tituloPost" to tv_titulo_publicacion_detalle.text.toString()
            )

            storage.collection("comentario")
                .add(comentario)
                .addOnSuccessListener {
                    Toast.makeText(this, "Comentario agregado correctamente", Toast.LENGTH_SHORT)
                        .show()

                    agregarPublicaciones(title)
                    adaptador = AdaptadorComentarios(this, comentarios)
                    listaComentarios.adapter = adaptador
                    txtComentario.setText("")

                }
                .addOnFailureListener {
                    Toast.makeText(this, "Error: intente de nuevo", Toast.LENGTH_SHORT).show()
                }
        }

        foranApp.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        backMenu.setOnClickListener {
            var intent: Intent = Intent(this, ForumPosts::class.java)
            intent.putExtra("title", title)
            intent.putExtra("icon", icon)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun agregarPublicaciones(tituloPost: String) {
        comentarios = ArrayList()
        storage = FirebaseFirestore.getInstance()

        storage.collection("comentario")
            .whereEqualTo("tituloPost", tituloPost)
            .get()
            .addOnSuccessListener {
                it.forEach { it ->

                    var comentario: Comentario = Comentario(
                        it.id,
                        it.getString("email")!!,
                        it.getString("comentarios")!!,
                        it.getString("tituloPost")!!
                    )

                    comentarios.add(comentario)
                }
                adaptador = AdaptadorComentarios(this, comentarios)
                listaComentarios.adapter = adaptador
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error.", Toast.LENGTH_SHORT).show()
            }
    }

    private class AdaptadorComentarios : BaseAdapter {
        var comentarios = ArrayList<Comentario>()
        var contexto: Context? = null

        constructor(contexto: Context, comentario1: ArrayList<Comentario>) {
            this.comentarios = comentario1
            this.contexto = contexto
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var coment = comentarios[position]
            var inflator = LayoutInflater.from(contexto)
            var vista = inflator.inflate(R.layout.publicacion_view, null)
            var autor = vista.findViewById(R.id.tvEmailPublicacion) as TextView
            var contenido = vista.findViewById(R.id.tvContenidoPost) as TextView

            autor.setText(coment.email)
            contenido.setText(coment.contenido)

            return vista
        }

        override fun getItem(position: Int): Any {
            return comentarios[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return comentarios.size
        }

    }
}

