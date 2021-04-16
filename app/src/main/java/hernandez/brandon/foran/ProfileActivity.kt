package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        var imgback: ImageView = findViewById(R.id.backMenu)
        var btnCerrarSesion: Button = findViewById(R.id.btnCerrarSesion)
        var btnEliminarCuenta: Button = findViewById(R.id.btnEliminarCuenta)
        /* Variable a la pantalla del Arturito */

        imgback.setOnClickListener {
            var intent: Intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        btnCerrarSesion.setOnClickListener {
            var intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnEliminarCuenta.setOnClickListener{
            var intent: Intent = Intent(this, DeleteProfileActivity::class.java)
            startActivity(intent)
        }

        /**
                 btnCerrarSesion.setOnClickListener {
                 var intent: Intent = Intent(this, PantallaArturito::class.java)
                 startActivity(intent)
             }
         */
    }
}