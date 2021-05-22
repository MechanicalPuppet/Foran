package hernandez.brandon.foran

import java.io.Serializable
import java.time.LocalDateTime

data class Comentario(val id: String, val autor: Usuario, var contenido: String, val fechaHora: LocalDateTime): Serializable{
}