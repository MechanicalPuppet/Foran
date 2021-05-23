package hernandez.brandon.foran

import java.io.Serializable
import java.time.LocalDateTime

data class Comentario(val id: String, var contenido: String, var tituloPost: String): Serializable{
}