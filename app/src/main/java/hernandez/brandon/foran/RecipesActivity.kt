package hernandez.brandon.foran

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import kotlinx.android.synthetic.main.recipe.view.*

class RecipesActivity : AppCompatActivity() {

    var adapterRecipe: RecipesAdapter? = null
    var recipes = ArrayList<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        var gridviewRecipes: GridView = findViewById(R.id.gridview_recipes)
        var foranApp: ImageView = findViewById(R.id.ForanImg)
        var backMenu: ImageView = findViewById(R.id.backMenuTransporte)


        loadRecipes()

        foranApp.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        backMenu.setOnClickListener {
            var intent: Intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        adapterRecipe = RecipesAdapter(this, recipes)
        gridviewRecipes.adapter =adapterRecipe

    }

    fun loadRecipes(){
        recipes.add(Recipe("Spaguetti", R.drawable.espagueti, "1 paquete de pasta, 1 puré de tomate, 1/4 de media crema, queso parmesano, sal y pimienta al gusto", "asdjkashkdjhasjkdhasjkdhasjkdhjaskhdjkashdjkashdjkashdaskjdhasjkhdj si asdjkhasjkdhasjkdhasjkdh no asdhasjkdhasjkdhjaskdhjkashdjkashdkjashdjkashjkdhasjkdhasjkdhjkashdjkashdjkhasjkd"))
        recipes.add(Recipe("Spaguetti", R.drawable.filete, "1 paquete de pasta, 1 puré de tomate, 1/4 de media crema, queso parmesano, sal y pimienta al gusto", "asdjkashkdjhasjkdhasjkdhasjkdhjaskhdjkashdjkashdjkashdaskjdhasjkhdj si asdjkhasjkdhasjkdhasjkdh no asdhasjkdhasjkdhjaskdhjkashdjkashdkjashdjkashjkdhasjkdhasjkdhjkashdjkashdjkhasjkd"))
        recipes.add(Recipe("Spaguetti", R.drawable.espagueti, "1 paquete de pasta, 1 puré de tomate, 1/4 de media crema, queso parmesano, sal y pimienta al gusto", "asdjkashkdjhasjkdhasjkdhasjkdhjaskhdjkashdjkashdjkashdaskjdhasjkhdj si asdjkhasjkdhasjkdhasjkdh no asdhasjkdhasjkdhjaskdhjkashdjkashdkjashdjkashjkdhasjkdhasjkdhjkashdjkashdjkhasjkd"))
        recipes.add(Recipe("Spaguetti", R.drawable.filete, "1 paquete de pasta, 1 puré de tomate, 1/4 de media crema, queso parmesano, sal y pimienta al gusto", "asdjkashkdjhasjkdhasjkdhasjkdhjaskhdjkashdjkashdjkashdaskjdhasjkhdj si asdjkhasjkdhasjkdhasjkdh no asdhasjkdhasjkdhjaskdhjkashdjkashdkjashdjkashjkdhasjkdhasjkdhjkashdjkashdjkhasjkd"))
        recipes.add(Recipe("Spaguetti", R.drawable.espagueti, "1 paquete de pasta, 1 puré de tomate, 1/4 de media crema, queso parmesano, sal y pimienta al gusto", "asdjkashkdjhasjkdhasjkdhasjkdhjaskhdjkashdjkashdjkashdaskjdhasjkhdj si asdjkhasjkdhasjkdhasjkdh no asdhasjkdhasjkdhjaskdhjkashdjkashdkjashdjkashjkdhasjkdhasjkdhjkashdjkashdjkhasjkd"))
        recipes.add(Recipe("Spaguetti", R.drawable.filete, "1 paquete de pasta, 1 puré de tomate, 1/4 de media crema, queso parmesano, sal y pimienta al gusto", "asdjkashkdjhasjkdhasjkdhasjkdhjaskhdjkashdjkashdjkashdaskjdhasjkhdj si asdjkhasjkdhasjkdhasjkdh no asdhasjkdhasjkdhjaskdhjkashdjkashdkjashdjkashjkdhasjkdhasjkdhjkashdjkashdjkhasjkd"))
        recipes.add(Recipe("Spaguetti", R.drawable.espagueti, "1 paquete de pasta, 1 puré de tomate, 1/4 de media crema, queso parmesano, sal y pimienta al gusto", "asdjkashkdjhasjkdhasjkdhasjkdhjaskhdjkashdjkashdjkashdaskjdhasjkhdj si asdjkhasjkdhasjkdhasjkdh no asdhasjkdhasjkdhjaskdhjkashdjkashdkjashdjkashjkdhasjkdhasjkdhjkashdjkashdjkhasjkd"))
        recipes.add(Recipe("Spaguetti", R.drawable.filete, "1 paquete de pasta, 1 puré de tomate, 1/4 de media crema, queso parmesano, sal y pimienta al gusto", "asdjkashkdjhasjkdhasjkdhasjkdhjaskhdjkashdjkashdjkashdaskjdhasjkhdj si asdjkhasjkdhasjkdhasjkdh no asdhasjkdhasjkdhjaskdhjkashdjkashdkjashdjkashjkdhasjkdhasjkdhjkashdjkashdjkhasjkd"))
    }
}

class RecipesAdapter: BaseAdapter{
    var recipes = ArrayList<Recipe>()
    var context: Context? = null

    constructor(context: Context, recipes: ArrayList<Recipe>){
        this.context = context
        this.recipes = recipes
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var recipe = recipes[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista =inflator.inflate(R.layout.recipe, null)
        vista.iv_recipe.setImageResource(recipe.image)
        vista.tv_recipe_title.setText(recipe.title)

        vista.iv_recipe.setOnClickListener{
            var intent = Intent(context, DetailRecipe::class.java)
            intent.putExtra("name", recipe.title)
            intent.putExtra("image", recipe.image)
            intent.putExtra("ingredients", recipe.ingredients)
            intent.putExtra("process", recipe.process)
            context!!.startActivity(intent)
        }
        return vista
    }

    override fun getItem(position: Int): Any {
        return recipes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return recipes.size
    }

}