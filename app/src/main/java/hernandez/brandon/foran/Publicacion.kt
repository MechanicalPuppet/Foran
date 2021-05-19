package hernandez.brandon.foran


import java.io.Serializable
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

data class Publicacion(val id: Int, val autor: Usuario,var titulo: String, var contenido: String, var categoria: String, var comentarios: ArrayList<Comentario>, val fechaHora: LocalDateTime): Serializable {
}