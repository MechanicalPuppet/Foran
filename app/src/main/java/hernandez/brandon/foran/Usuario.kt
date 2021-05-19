package hernandez.brandon.foran

import java.io.Serializable

data class Usuario(val id: Int, var nombre: String, var correo: String, var contraseña: String ): Serializable {
}