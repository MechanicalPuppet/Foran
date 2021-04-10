package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RestorePasswordNewPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore_password_new_password)

        var btnGuardarRPNP: Button = findViewById(R.id.btnGuardarRPNP)

        btnGuardarRPNP.setOnClickListener {
            var intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }

    }
}