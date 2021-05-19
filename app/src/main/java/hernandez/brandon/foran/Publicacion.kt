package hernandez.brandon.foran

import java.util.*
import kotlin.collections.ArrayList

data class Publicacion(val autor: Usuario, var mensaje: String, var comentarios: ArrayList<Comentario>, val fechaHora: Date) {
}