package hernandez.brandon.foran

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_transport.*

class TransportActivity : AppCompatActivity() {
    val uber:String = "https://play.google.com/store/apps/details?id=com.ubercab"
    val didi:String = "https://play.google.com/store/apps/details?id=com.didiglobal.passenger"
    val inDriver:String = "https://play.google.com/store/apps/details?id=sinet.startup.inDriver"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_transport)
        var btUber: TextView = lblUber
        var btDidi: TextView = lblDidi
        var btInDriver: TextView = lblInDriver


        var foranApp: ImageView = findViewById(R.id.ForanImg)
        var backMenu: ImageView = findViewById(R.id.backMenuTransporte)

        foranApp.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        backMenu.setOnClickListener {
            var intent: Intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        btUber.setOnClickListener {
            var uriUber: Uri = Uri.parse(uber)
            var intent: Intent = Intent(Intent.ACTION_VIEW, uriUber)
            startActivity(intent)
        }

        btDidi.setOnClickListener {
            var uriiDidi: Uri = Uri.parse(didi)
            var intent: Intent = Intent(Intent.ACTION_VIEW, uriiDidi)
            startActivity(intent)
        }

        btInDriver.setOnClickListener {
            var uriDriver: Uri = Uri.parse(inDriver)
            var intent: Intent = Intent(Intent.ACTION_VIEW, uriDriver)
            startActivity(intent)
        }
    }
}