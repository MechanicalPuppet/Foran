package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_forum_posts.*
import kotlinx.android.synthetic.main.activity_recipes_details.*

class ForumPosts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum_posts)

        var foranApp: ImageView = findViewById(R.id.ForanImg)
        var backMenu: ImageView = findViewById(R.id.backForum)

        foranApp.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        backMenu.setOnClickListener {
            var intent: Intent = Intent(this, ForumActivity::class.java)
            startActivity(intent)
        }

        val bundle = intent.extras

        if (bundle != null){
            println("si entra")
            this.iv_forum_icon.setImageResource(bundle.getInt("icon"))
            this.tv_forum_title.setText(bundle.getString("title"))
        }

    }
}