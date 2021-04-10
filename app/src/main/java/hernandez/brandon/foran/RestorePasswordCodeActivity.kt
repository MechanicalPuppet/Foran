package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RestorePasswordCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restore_password_code)

        var btnEnviarCode: Button = findViewById(R.id.btnEnviarCode)

        btnEnviarCode.setOnClickListener {

            var intent: Intent = Intent(this, RestorePasswordNewPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}