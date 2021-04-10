package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var btnRegistrarme: Button = findViewById(R.id.btnRegistrarme)


        /**
        btnRegistrarme.setOnClickListener {
            var intent:Intent = Intent(this, CLASEDEHUERTA::class.java)
            startActivity(intent)


        }
        */

    }
}