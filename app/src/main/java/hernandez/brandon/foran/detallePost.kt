package hernandez.brandon.foran

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detalle_post.*

class detallePost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_post)

        val bundle = intent.extras

        if(bundle != null){
            val publicacion = bundle.getSerializable("publicacion") as Publicacion
            tv_titulo_publicacion_detalle.setText(publicacion.titulo)
            contenidoPostDetalle.setText(publicacion.contenido)
            var listView: ListView = findViewById(R.id.listView_comentarios)
            var adaptador: AdaptadorComentarios = AdaptadorComentarios(this, publicacion.comentarios)
            listView.adapter = adaptador
        }

    }

    private class AdaptadorComentarios: BaseAdapter {
        var comentarios = ArrayList<Comentario>()
        var contexto: Context? = null

        constructor(contexto: Context, comentario1: ArrayList<Comentario>){
            this.comentarios = comentario1
            this.contexto = contexto
        }




        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var coment = comentarios[position]
            var inflator = LayoutInflater.from(contexto)
            var vista = inflator.inflate(R.layout.publicacion_view, null)

            var imagen = vista.findViewById(R.id.imgfotoPerfilPublicacion) as ImageView
            var titulo = vista.findViewById(R.id.tv_titulo_publicacion) as TextView
            var contenido = vista.findViewById(R.id.tvContenidoPost) as TextView

            titulo.setText(coment.autor.nombre)
            contenido.setText(coment.contenido)

            return vista
        }

        override fun getItem(position: Int): Any {
            return comentarios[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return comentarios.size
        }

    }

}