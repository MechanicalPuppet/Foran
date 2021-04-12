package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var tvOlvideContrasena: TextView = findViewById(R.id.tvOlvideContraseña)
        var btnIniciarSesion: Button = findViewById(R.id.btnIniciarSesion)
        var tvRegistrarme: TextView = findViewById(R.id.tvRegistrarme)

        tvOlvideContrasena.setOnClickListener {
            var intent: Intent = Intent(this, RestorePasswordActivity::class.java)
            startActivity(intent)
        }

        btnIniciarSesion.setOnClickListener {
            var intent: Intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        tvRegistrarme.setOnClickListener {
            var intent: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}