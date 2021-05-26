package hernandez.brandon.foran


import java.io.Serializable
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

data class Publicacion(val id: String, var nombre: String,var titulo: String, var contenido: String, var categoria: String, var comentarios: ArrayList<Comentario>): Serializable {
}