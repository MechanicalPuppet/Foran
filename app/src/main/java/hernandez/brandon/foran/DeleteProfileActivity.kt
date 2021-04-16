package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DeleteProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_profile)

        var imgback: ImageView = findViewById(R.id.backMenu)

        imgback.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}