package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_forum.*

class ForumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)

        var foranApp: ImageView = findViewById(R.id.ForanImg)
        var backMenu: ImageView = findViewById(R.id.backMenu)

        foranApp.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        backMenu.setOnClickListener {
            var intent: Intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }


        iv_sellbuy.setOnClickListener{
            var intent: Intent = Intent(this, ForumPosts::class.java)
            intent.putExtra("title", "Se vende/se compra")
            intent.putExtra("icon", R.drawable.sellbuy)
            startActivity(intent)
        }

        iv_rent.setOnClickListener{
            var intent: Intent = Intent(this, ForumPosts::class.java)
            intent.putExtra("title", "Departamentos/Casas en renta")
            intent.putExtra("icon", R.drawable.rent)
            startActivity(intent)
        }

        iv_event.setOnClickListener{
            var intent: Intent = Intent(this, ForumPosts::class.java)
            intent.putExtra("title", "Eventos sociales")
            intent.putExtra("icon", R.drawable.event)
            startActivity(intent)
        }

        iv_help.setOnClickListener{
            var intent: Intent = Intent(this, ForumPosts::class.java)
            intent.putExtra("title", "Ayuda")
            intent.putExtra("icon", R.drawable.help)
            startActivity(intent)
        }

        iv_advice.setOnClickListener{
            var intent: Intent = Intent(this, ForumPosts::class.java)
            intent.putExtra("title", "Consejos")
            intent.putExtra("icon", R.drawable.advice)
            startActivity(intent)
        }

    }
}