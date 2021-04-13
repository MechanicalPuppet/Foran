package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class UbicationActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubication)
        createFragment()

        var foranApp: ImageView = findViewById(R.id.ForanImgUbication)
        var backMenu: ImageView = findViewById(R.id.backMenuUbication)

        foranApp.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        backMenu.setOnClickListener {
            var intent: Intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createFragment() {
        val mapFragment  = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }

    private fun createMarker() {
        val coordinates = LatLng(27.484271, -109.959540)
        var marker = MarkerOptions().position(coordinates).title("Soriana")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }
}