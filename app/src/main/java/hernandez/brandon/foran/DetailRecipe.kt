package hernandez.brandon.foran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_recipes_details.*

class DetailRecipe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes_details)

        var foranApp: ImageView = findViewById(R.id.ForanImg)
        var backMenu: ImageView = findViewById(R.id.backMenuTransporte)

        foranApp.setOnClickListener {
            var intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        backMenu.setOnClickListener {
            var intent: Intent = Intent(this, RecipesActivity::class.java)
            startActivity(intent)
        }

        val bundle = intent.extras

        if (bundle != null){
            this.iv_recipe_imagen.setImageResource(bundle.getInt("image"))
            this.tv_name_recipe.setText(bundle.getString("name"))
            this.tv_recipe_ingredients.setText(bundle.getString("ingredients"))
            this.tv_recipe_process.setText(bundle.getString("process"))
        }
    }


}