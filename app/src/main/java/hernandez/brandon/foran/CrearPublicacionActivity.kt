package hernandez.brandon.foran

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_crear_publicacion.*
import kotlinx.android.synthetic.main.activity_crear_publicacion.iv_forum_icon
import kotlinx.android.synthetic.main.activity_crear_publicacion.tv_forum_title
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CrearPublicacionActivity : AppCompatActivity() {

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_publicacion)

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        val bundle = intent.extras

        if (bundle != null) {
            this.iv_forum_icon.setImageResource(bundle.getInt("icon"))
            this.tv_forum_title.setText(bundle.getString("title"))
        }

        var icon: Int = R.drawable.help
        var title: String = tv_forum_title.text.toString()


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

        back.setOnClickListener {
            var intent: Intent = Intent(this, ForumPosts::class.java)
            intent.putExtra("title", title)
            intent.putExtra("icon", icon)
            startActivity(intent)
        }

        btnPublicar.setOnClickListener {
            val publicacion = hashMapOf(
                "autor" to usuario.currentUser?.displayName,
                "categoria" to title,
                "comentarios" to ArrayList<Comentario>(),
                "contenido" to et_contenido.text.toString(),
                "titulo" to et_Titulo.text.toString(),
                "fechaHora" to LocalDateTime.now()
            )

            storage.collection("publicacion")
                .add(publicacion)
                .addOnSuccessListener {
                    Toast.makeText(this, "publicacion agregada", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "error: intente de nuevo", Toast.LENGTH_SHORT).show()
                }
        }

    }

}