package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RestorePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore_password)

        var btnEnviar: Button = findViewById(R.id.btnEnviar)

        btnEnviar.setOnClickListener {
            var intent: Intent = Intent(this, RestorePasswordCodeActivity::class.java)
            startActivity(intent)
        }
    }
}