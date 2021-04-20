package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class DeleteProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_profile)

        var imgback: ImageView = findViewById(R.id.backMenu)
        var btnEliminar: Button = findViewById(R.id.btnEliminarTuCuenta)
        var btnCancelar: Button = findViewById(R.id.btnCancelarCuenta)

        imgback.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        btnEliminar.setOnClickListener {
            var intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnCancelar.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)

        }
    }
}