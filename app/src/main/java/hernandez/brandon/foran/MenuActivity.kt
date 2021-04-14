package hernandez.brandon.foran

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var foranApp: ImageView = findViewById(R.id.ForanImg)
        var btnCerrarSesion: Button = findViewById(R.id.btnCerrarSesionMenu)
        var imgLocation: ImageView = findViewById(R.id.ImgUbicaciones)
        var imgTransportation: ImageView = findViewById(R.id.ImgTransportes)
        var imgRecetas: ImageView = findViewById(R.id.imgRecetas)
        var imgForo: ImageView = findViewById(R.id.ImgForo)


        foranApp.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        btnCerrarSesion.setOnClickListener {
            var intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        imgLocation.setOnClickListener {
            var intent: Intent = Intent(this, UbicationActivity::class.java)
            startActivity(intent)
        }

        imgTransportation.setOnClickListener {
            var intent: Intent = Intent(this, TransportActivity::class.java)
            startActivity(intent)
        }

        imgRecetas.setOnClickListener{
            var intent: Intent = Intent(this, RecipesActivity::class.java)
            startActivity(intent)
        }

        imgForo.setOnClickListener{
            var intent: Intent = Intent(this, ForumActivity::class.java)
            startActivity(intent)
        }
    }
}
