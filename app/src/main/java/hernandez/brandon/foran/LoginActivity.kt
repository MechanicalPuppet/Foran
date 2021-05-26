package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        var tvOlvideContrasena: TextView = findViewById(R.id.tvOlvideContraseña)
        var btnIniciarSesion: Button = findViewById(R.id.btnIniciarSesion)
        var tvRegistrarme: TextView = findViewById(R.id.tvRegistrarme)

        tvOlvideContrasena.setOnClickListener {
            var intent: Intent = Intent(this, RestorePasswordActivity::class.java)
            startActivity(intent)
        }

        btnIniciarSesion.setOnClickListener {
           valida_ingreso()
        }

        tvRegistrarme.setOnClickListener {
            var intent: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun valida_ingreso(){
        val et_correo: EditText = findViewById(R.id.txtCorreo)
        val et_contra: EditText = findViewById(R.id.txtcontraseña)

        var correo: String = et_correo.text.toString()
        var contra: String = et_contra.text.toString()

        if(!correo.isNullOrBlank() && !contra.isNullOrBlank()){
            ingresaFirebase(correo, contra)
        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }

    }

    private fun ingresaFirebase(email:String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val user = auth.currentUser

                    val intent: Intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
    }
}