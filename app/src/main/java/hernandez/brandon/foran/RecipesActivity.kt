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
        recipes.add(Recipe("Arroz con leche", R.drawable.arrozconleche, "100g de arroz redondo\n" +
                "1l de leche entera\n" +
                "1 trozo de cáscara de limón y de naranja\n" +
                "1 rama de canela\n" +
                "canela en polvo\n" +
                "70g de azúcar\n" +
                "10g de mantequilla\n", "1.- En una olla o cazuela, ponemos la leche, el arroz, las cáscaras de los cítricos y la rama de canela. Calentamos a fuego medio mientras no dejamos de remover\n" +
                "2.- Cuando esté caliente, pero que no llegue a ebullición, pues la leche pasados los 95-100ºC se quema y coge un regusto muy desagradable, dejamos cocer. Removemos cada cinco minutos, para asegurarnos que el arroz con leche no se pegue y para liberar el almidón. Así nos quedará más cremoso. Recuerda que no debe llegar a hervir a borbotones fuertes en ningún momento\n" +
                "3.- Pasados unos 45 minutos, cuando el grano esté casi hecho – recuerda remover cada 5 minutos – añadimos el azúcar. Dejamos cocinar 10 minutos más, hasta que el arroz ahora sí que sí, esté bien blando\n" +
                "4.- Apagamos el fuego y añadimos la mantequilla. Quitamos las cáscaras y la canela en rama y mezclamos bien. Dejamos templar. Sigue mezclando de vez en cuando mientras lo dejes templar, para que no salga costra por la superficie\n" +
                "5.- Cuando haya templado algo, ponemos el arroz con leche en cuencos individuales. Puedes decorar con un trocito de la rama de canela que usaste para infusionar. Espolvorea encima un poco de canela molida, para darle el toque final.\n"))
        recipes.add(Recipe("Macarrones con carne picada y tomate frito", R.drawable.macarrones, "500g de macarrones\n" +
                "500g de carne picada o molida. Mejor si es mezcla de ternera y cerdo\n" +
                "500g de tomate frito (salsa de tomate)\n" +
                "1 cebolla\n" +
                "4 dientes de ajo\n" +
                "orégano seco\n" +
                "sal y pimienta\n" +
                "aceite\n", " \n" +
                "1.- Cocemos los macarrones. Para ello, los introducimos en una cazuela con abundante agua hirviendo. Añadimos un buen puñadito de sal y los cocemos durante unos 12-15 minutos. Hasta que estén al dente. Removemos de vez en cuando, sobre todo al principio, para que no se peguen al fondo de la olla\n" +
                "2.- Mientras se cocinan, podemos ir preparando la salsa. En una sartén amplia, ponemos a calentar un chorrito de aceite a fuego medio. Después añadimos la cebolla y los ajos picados muy finos. Salpimentamos y removemos con una cuchara de palo mientras cocinamos durante 5 minutos\n" +
                "3.- Pasado el tiempo, añadimos la carne picada. la salpimentamos y la desmenuzamos con la cuchara de palo para que no queden mazacotes grandes y quede bien suelta. Subimos la fuerza del fuego y la dejamos cocinar hasta que coja algo de color\n" +
                "4.- Una vez hecho esto, añadimos el tomate frito y espolvoreamos con orégano seco. Mezclamos todos los ingredientes y dejamos cocinar 10 minutos más.\n" +
                "5.- Cuando los macarrones estén al dente, reservamos uno 150ml del caldo de la cocción en un vaso y los escurrimos del resto del agua\n" +
                "6.- Cuando tanto los macarrones como la salsa estén cocinados, añadimos los macarrones a la cazuela donde esté la salsa. Añadimos el caldo de la cocción (que potenciará todos los sabores) y lo mezclamos todo bien, mientras cocinamos todo durante un par de minutos\n"))
        recipes.add(Recipe("Pollo frito KENTUCKY\n", R.drawable.pollokentucky, " \n" +
                "8 muslos de pollo\n" +
                " 500ml de leche\n" +
                " 300g de harina\n" +
                "1 cucharada de especias al gusto: orégano, pimentón, curry, cebolla en polvo, ajo en polvo\n" +
                "+1/2 cucharadita de las especias anteriores más 100g de harina\n" +
                "Sal y pimienta\n" +
                "Aceite\n", "1.- Lo Primero para hacer el pollo frito estilo KFC es prepapar una tempura. Para ello, ponemos en un recipiente bastante ancho 300g de la harina y una cucharada de cada una de las especias que hayamos elegido. Añadimos también un buen pellizco de sal. Quizás te parezca que sean demasiadas especias pero, aquí está el secreto de la receta. Además, a la hora de comer, dan ese gusto que deseamos pero, no llegan a notarse tanto en boca. Añadimos también la leche, entre 350 y 400 ml. La cantidad exacta va a depender bastante de la marca de harina empleada. La idea es mezclarlo todo con una varilla y que quede una masa más bien licuada pero, con bastante cuerpo. Cuando estén todos los ingredientes bien mezclados, pasamos la varilla sobre la tempura y, si se pega a ella pero enseguida cae, está será la textura exacta que deseamos.\n" +
                " \n" +
                "2.- Ahora metemos el pollo salpimentado dentro de la tempura. Lo cubrimos bien de la misma y lo tapamos. Lo dejamos macerar mínimo una hora en el frigorífico. Si es más tiempo, mejor.\n" +
                "3.- Pasado el tiempo, preparamos el rebozado exterior que llevará el pollo. En un plato ponemos los 100g de harina que teníamos reservada y le añadimos media cucharadita de las mismas especias que le habíamos puesto anteriormente a la tempura. Removemos bien todo para que se mezclen todas las especias con la harina.\n" +
                "4.- Sacamos el pollo del frigorífico y, sin quitarle demasiado exceso de la masa de la tempura, lo pasamos por la harina. Que se impregne bien de ella. Después lo metemos en abundante aceite de oliva, a fuego fuerte pero, no demasiado o quedarán crudos por el centro (yo lo hago a una potencia de 7, de 9 de máximo que tiene mi vitrocerámica) y lo freimos. Estarán listos en unos 10 minutos."))
        recipes.add(Recipe("Bolitas de arroz y quso", R.drawable.bolitasdearrozyqueso,
            "200g de arroz redondo\n" +
                    "2 dientes de ajo\n" +
                    "50g de mozzarella rallada\n" +
                    "50g de mozzarella fresca\n" +
                    "1 cucharadita de orégano\n" +
                    "Pan rallado\n" +
                    "1 huevo\n" +
                    "Sal y pimienta\n" +
                    "Aceite\n",
            "1.- En una cazuelita ponemos un chorrito de aceite a fuego suave. Añadimos los dientes de ajo y dejamos cocinar un par de minutos. La idea no es dorar el ajo si no aromatizar el aceite con su sabor. Por eso es mejor hacerlo a fuego muy suave\n" +
                    "2.- Añadir el arroz y remover con una cuchara de madera a fuego medio durante un minuto más.\n" +
                    "3.- Es el momento de añadir el agua. El doble de cantidad que de arroz así que, si habíamos puesto 200g de arroz, ponemos 400ml de agua. Puedes añadir caldo de ave o de verduras, si lo prefieres. Añadir una pizca de sal y dejar cocinar el arroz a fuego medio-bajo unos 15 minutos. Hasta que haya absorbido todo el agua\n" +
                    "4.- Una vez cocido el arroz dejar enfriar completamente en la nevera. A partir de este punto, los pasos a seguir son los mismos que si tuvieses un arroz que sobró del día anterior\n" +
                    "5.- Aderezamos el arroz ya frío al gusto. Ponemos un poco de pimienta negra recién molida, una cucharadita de orégano seco y queso mozzarella rallado. Removemos bien con la cuchara de madera\n" +
                    "6.- Ahora cogemos una pequeña porción del arroz y la aplastamos con la otra mano un poco en el centro. En ese lugar, ponemos una pequeña porción de queso mozzarella fresco. Después cogemos otra porción un poco más grande y la ponemos encima. Damos forma de bola de tal forma que esa porción de queso quede encerrada en su interior. Asegurate de prensar bien la bola o si no corre después el peligro de deshacerse. Al final, quedará una bolita que cabrá ampliamente en la palma de nuestras manos. Del tamaño similar a una pelota de tenis.\n" +
                    "7.- Pasar la bola por harina, después por huevo batido y finalmente por pan rallado. Una vez empanadas todas, dejar en un plato y congelar durante 10 minutos, para que la masa se asiente bien. También podrías meterla en la nevera durante 30 minutos\n" +
                    "8.- Freír en abundante aceite que esté bastante caliente. Hacerlo hasta que las bolas estén doradas por fuera y el queso de su interior (tanto el rallado como el fresco) esté totalmente fundido. Llevará alrededor de 3 o 4 minutos así que no pongas el aceite a máxima potencia. Finalmente retirar y poner sobre papel absorbente, antes de comer\n"))
        recipes.add(Recipe("Espaguetis rojos con tomate\n", R.drawable.espaguetirojocontomate,
            "200g de espaguetis\n" +
                    "1/2 cebolla\n" +
                    "2 dientes de ajo\n" +
                    "400g de tomate triturado\n" +
                    "100ml de nata para cocinar (crema de leche)\n" +
                    "1 cucharadita de pimentón dulce\n" +
                    "1 cucharadita de orégano seco\n" +
                    "100ml del caldo donde cozamos los espaguetis\n" +
                    "sal y pimienta\n" +
                    "aceite de oliva\n" +
                    "Opcionalmente queso rallado\n",
            " \n" +
                    " \n" +
                    "1.- En una sartén amplia poner un chorrito de aceite a fuego suave. Añadir la cebolla y el ajo bien picados. Salpimentar y cocinar unos 5 minutos mientras removemos con frecuencia.\n" +
                    "2.- Pasado el tiempo añadir el tomate. Echar su parte de sal y dejar cocinar 10 minutos a fuego suave\n" +
                    "3.- Mientras se hace la salsa, cocer los espaguetis. Para una correcta cocción, es muy importante echar abundante agua en una olla. 1 litro por cada 100g de pasta. Una vez esté hirviendo, echar un buen puñadito de sal (sin miedo), añadir los espaguetis y remover con bastante frecuencia. Especialmente al principio. Así evitamos que se peguen al fondo de la olla\n" +
                    "4.- Una vez estén cocinados – tardarán alrededor de 10 minutos en estar «al dente» – Guardamos unos 100ml del caldo de la cocción. El resto, lo escurrimos de los espaguetis.\n" +
                    "5.- En la salsa de tomate que, ya estará bastante solida y habrá perdido gran parte del agua que tenía (eso es bueno. Coge muy buen sabor esta salsa al hacer eso) añadimos la nata que, junto al caldo de la cocción, que lo añadiremos más tarde, serán los ingredientes que den tanta cremosidad a esta nata. Añadimos también ahora el pimentón que añadirá más sabor y más color rojo y mezclamos bien hasta que todos los ingredientes se vuelvan a calentar\n" +
                    "6.- Cuando se hayan integrado y calentado los ingredientes, añadimos los espaguetis, el orégano seco y el caldo de la cocción que habíamos reservado. Mezclamos y cocinamos todo un par de minutos más. Hasta que los espaguetis hayan absorbido toda la parte «líquida» de la salsa. ¡delicioso!\n"))
        recipes.add(Recipe("Banderillas de salchicha y queso", R.drawable.banderillas, "10 salchichas estilo frankfurt\n" +
                "100g de harina de trigo normal\n" +
                "100g de harina de maiz\n" +
                "1 huevo\n" +
                "aproximadamente 1 vaso de leche. La cantidad exacta varía según la harina empleada\n" +
                "1 cucharadita de sal\n" +
                "1 cucharada de levadura química\n" +
                "Aceite para freírlas\n" +
                "10 lonchas de queso, de estilo sandwich. Una por cada salchicha.\n",
            " \n" +
                    "1.- Con unas brochetas, empalamos las salchichas estilo frankfurt. La brocheta, debe llegar hasta casi el final de la salchicha pero, no debe atravesarla por completo\n" +
                    "2.- En este paso está la novedad. Cogemos una loncha de queso y con ella, enrollamos la salchicha. Las lonchas de queso de sandwich, cuentan con la ventaja de que son similares en tamaño a las salchichas frankfurt y que además, es un queso que se deshace con facilidad. Una vez enrollado, lo aplastamos un poco con las manos sobre la salchicha, para que se adhiera a ella y no se caiga.\n" +
                    "3.- Preparamos una tempura. Ponemos en un bol la harina de trigo y la de maiz, el huevo, la leche, una cucharadita de sal, la levadura o polvos para hornear y opcionalmente el pimentón dulce (Paprika). Lo batimos bien con una varilla o tenedor. Debe quedar con una textura más bien líquida pero, con algo de cuerpo. Que se pegue un poco a la varilla o al tenedor pero, que caiga enseguida.\n" +
                    "4.- Después, ponemos esta masa en un vaso alto u otro recipiente similar. Metemos aquí las salchichas, ya empaladas y con la loncha de queso sobre ella. Las impreganmos bien con la tempura.\n" +
                    "5.- Retiramos el exceso de masa y las freimos en abundante aceite. El aceite debe estar caliente pero, tampoco demasiado o se quemarán. Esta tempura es muy delicada. Las cocinamos 15 segundos por cada cara. Pasados los 30 segundos, cuando estén doradas, las retiramos y las colocamos sobre papel absorbente, antes de comerlas.\n"))
        recipes.add(Recipe("Tortilla de patatas rellena de queso y jamón", R.drawable.tortilladepatatasrellenadejamonyqueso,
            "3 patatas medianas\n" +
                    "5 huevos\n" +
                    "1/2 cebolla\n" +
                    "4 lonchas de jamón york\n" +
                    "8 lonchas de queso, tipo para sandwich\n" +
                    "Sal\n" +
                    "Aceite de oliva\n",
            " \n" +
                    "1.- En una sartén a fuego medio, añadimos un buen chorro de aceite. Después añadimos las patatas bien peladas y picadas y la cebolla cortada en trozos más grandes. Añadir una pizca de sal y dejar cocinar todo, mientras lo removemos con frecuencia con una cuchara de madera, durante unos 10 minutos\n" +
                    "2.- Pasado el tiempo, aplastamos la patata con la cuchara. Ya estarán blanditas así que, no debería ser difícil hacerlo. Dejamos cocinar 5 minutos más mientras aplastamos con frecuencia, hasta haber obtenido una especie de patata en puré muy sólido\n" +
                    "3.- Continuamos con la elaboración de nuestra tortilla de jamon y queso. En un bol poner los huevos. Añadir una pizquita de sal y batir bien. Después añadimos el puré de patata y cebolla y mezclar hasta obtener una masa homogénea\n" +
                    "4.- Poner un pequeño chorrito de aceite de oliva en una sartén más pequeña y más profunda, a fuego bastante moderado. Encima colocar aproximandamente 1/3 de la mezcla de patata y huevo. Con la cuchara lo extendemos por toda la superficie de la sartén y encima, colocamos 4 lonchas de queso, 4 lonchas de jamón york y finalmente otras 4 lonchas de queso. Si quieres puedes añadir la misma cantidad de queso que de jamón. O más jamón que queso. Eso ya, a tu gusto. Encima colocamos el resto de la patata y huevo y con la cuchara lo extendemos de tal forma que la superficie quede bien lista. Si asoma un poquito del relleno no pasa nada. Cocinar a fuego moderado 5 minutos\n" +
                    "5.- Con la ayuda de un plato, damos la vuelta nuestra tortilla de jamón y queso e introducimos el otro lado en la sartén. Nada más hacerlo, pasamos la cuchara de palo por los bordes de la tortilla, de tal forma que la vayamos «recogiendo» un poquito con ella. De esta forma, lograremos que quede con una forma más redondita y más vistosa. Cocinamos otros 5 minutos más\n" +
                    "6.- Finalmente, la sacamos de la sartén con la ayuda del plato. ¡Ya está lista!\n" +
                    " \n" +
                    " \n"))
        recipes.add(Recipe("Galletas de mantequilla", R.drawable.galletasmantequillas,
            "325g de harina normal.\n" +
                    "150g de mantequilla con textura de pomada (mantequilla a temperatura ambiente)\n" +
                    "150g de azúcar\n" +
                    "2 cucharadas de esencia de vainilla\n" +
                    "1 huevo\n" +
                    "una pizca de sal\n",
            " \n" +
                    "1.- Lo primero, ponemos la mantequilla a temperatura ambiente en un bol junto al azúcar y lo mezclamos todo con una varilla o con un tenedor.\n" +
                    "2.- Cuando tengamos una masa homogénea, añadimos el huevo y las dos cucharadas de esencia de vainilla. Volvemos a mezclar todos los ingredientes hasta que nuevamente haya quedado una masa homogénea\n" +
                    "3.- Ahora ponemos la harina y la pizca de sal. Aunque se trate de una elaboración dulce, la sal potenciará el sabor y dejará unas galletas de mantequilla caseras más esponjosas. Mezclamos e integramos todos los ingredientes con la mano. Nos quedará una bola de masa más bien sólida, aunque se pegará un poquito a las manos (esto es bueno)\n" +
                    "4.- Tapamos la masa y la metemos en el frigorífico. Lo bueno de esta receta, es que no es necesario amasar nada. La dejamos en el frigorífico entre una y dos horas. La idea es que la masa se enfríe y se compacte aunque, no demasiado o costará mucho dar la forma de galleta después.\n" +
                    "5.– Pasado el tiempo, colocamos la masa sobre la encimera y con un rodillo, o una botella de cristal si no tienes rodillo, la estiramos sobre la misma encimera. Debe quedar con un dedo de grosor aproximadamente. Hecho esto, hacemos las galletas con los moldes que hayamos elegido. O con un vasito de cristal. Quedarán igual de buenas. Recuerdo que así fue como hice mis primeras galletas de mantequilla caseras (somos tres en casa. No sobró ni una)\n" +
                    "6.- Cuando no quede más espacio en la masa para hacer más galletas, tan simple como recogerla toda y volver a estirarla con el rodillo o la botella de cristal y vuelta a empezar. ¡No quiero ver que tires ni un solo gramo de la masa a la basura!  \n" +
                    "7.- Finalmente, cuando estén todas las galletas hechas, las colocamos sobre papel de horno, encima de la misma placa de hornear, con una pequeña separación entre ellas ya que, aunque será muy poco, crecerán algo, y las metemos al horno previamente calentado a 180ºC, arriba y abajo. Metelas en una rendija más bien cercana a la resistencia de arriba del horno, que a la de abajo. Y vigílalas constantemente porque en 10 minutos o menos estarán cocinadas y es muy fácil que se quemen\n" +
                    " \n"))
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