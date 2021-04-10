package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class LoadingActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading_activity)


        var imgLoading: ImageView = findViewById(R.id.imgLoading)
        imgLoading.setOnClickListener {
            var intent:Intent = Intent(this, LoginActivity:: class.java)
            startActivity(intent)
        }
    }
}