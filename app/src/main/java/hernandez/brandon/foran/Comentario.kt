package hernandez.brandon.foran

import java.io.Serializable
import java.time.LocalDateTime
import java.util.*

data class Comentario(val id: Int, val autor: Usuario, var contenido: String, val fechaHora: LocalDateTime): Serializable{
}