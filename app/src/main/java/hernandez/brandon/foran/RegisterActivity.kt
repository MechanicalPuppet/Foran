package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth = FirebaseAuth.getInstance()
        var btnRegistrarme: Button = findViewById(R.id.btnRegistrarme)




        btnRegistrarme.setOnClickListener {

            valida_registro();

        }

    }

    private fun registrarFirebase(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                    //INSERCION DE BD

                        Toast.makeText(baseContext, "${user?.email}Se ha creado correctamente", Toast.LENGTH_SHORT).show()
                    var intent: Intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }

    private fun valida_registro(){
        var txtUsuario: EditText = findViewById(R.id.txtUsuarioRegister)
        var txtEmail: EditText = findViewById(R.id.txtEmailRegister)
        var txtContrasena: EditText = findViewById(R.id.txtcontraseña)
        var correo: String = txtEmail.text.toString()
        var contra1: String = txtContrasena.text.toString()

        if(!correo.isNullOrBlank() && !contra1.isNullOrBlank()){
                registrarFirebase(correo, contra1)
        }else{
            Toast.makeText(this, "Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }
    }
}