import items.CartItem
import items.Item
import items.Category
import kotlin.random.Random
import kotlin.random.nextInt

val menu = mutableMapOf<String, List<String>>(
    Pair("main", listOf("Items", "My Cart", "Out")),
    Pair("items", listOf("Add To Cart", "Back")),
    Pair("cart", listOf("Pay", "Back")),
)

var exit = false
var option: Int? = null
var curr = "main"

/*
    Establishing collections...
 */

val items = mutableListOf<Item>()
val inventory = mutableMapOf<String, Int>()
val cart = mutableListOf<CartItem>()

/*
    Creating items...
 */

val clearShampoo = Item("1001", "Clear Shampoo",
    55.56, setOf(Category.FEMALE, Category.MALE))
val moby = Item("1002", "Moby Crunchy Chocolate",
    15.0, setOf(Category.FOOD))
val vaselineIC = Item("1003", "Vaseline Intensive Care",
    383.71, setOf(Category.FEMALE))

fun initialize() {
    items.add(clearShampoo)
    items.add(moby)
    items.add(vaselineIC)

    // Initialize inventory
    items.forEach { item ->
        // Generate random quantity
        val random = Random.nextInt(1, 25)
        inventory[item.id] = random
    }
}

fun showMenu(key:String) {
    if (menu[key] != null) {
        val options = menu[key]!!
        options.forEachIndexed { index, string -> println("[${index + 1}] $string") }
    } else {
        println("Key for menu doesn't exist")
    }
}

fun askOption() {
    print("Enter option: ")
    option = readln().toInt() - 1
}

fun showItems() {
    items.forEachIndexed { index, item ->
        println("${index + 1}. ${item.name} — ${item.basePrice} (Stock: ${inventory[item.id]})")
    }
}

fun addItemsToCart() {
    var browsing = true

    while(browsing) {
        print("Select item index (-1 to end): ")
        val index = readln().toInt()

        when(index) {
            -1 -> {
                browsing = false
            }
            else -> {
                val item = items[index]

                print("How much? ")
                val qty = readln().toInt()

                if(isAvailable(inventory, item.id, qty)) {
                    addToCart(item.id, qty)
                    println("Item added to cart!")
                }
                else {
                    println("Item quantity not enough." +
                            "\nCurrent stock: ${inventory[item.id]}\nYour quantity input: $qty")
                }
            }
        }

    }
}

fun addToCart(itemId: String, quantity: Int) {
    cart.add(CartItem(itemId, quantity))
}

fun showCartItems() {
    // Created a transformed map of the current list (during here, not anywhere else)
    val mapOfItems = items.associateBy { item -> item.id }

    cart.forEachIndexed { index, cartItem ->
        val item = mapOfItems[cartItem.id]
        val itemPrint = item?.name ?: "Unknown Item"

        val subtotal = cartItem.quantity * (item?.basePrice ?: 0.0)

        println("${index + 1}. $itemPrint — ${cartItem.quantity} (Subtotal: $subtotal)")
    }
}

fun main() {
    initialize()

    while(!exit) {
        curr = "main"
        println("<--- Main Menu --->")
        showMenu(curr)
        askOption()

        when(option) {
            0 -> {
                curr = "items"
                println("<--- Items --->")
                showItems()

                println("-- Actions --")
                showMenu(curr)
                askOption()

                when (option) {
                    // Add items to cart
                    0 -> addItemsToCart()
                    1 -> break;
                }
            }
            1 -> {
                curr = "cart"
                println("<--- Your Cart --->")
                showCartItems()

                println("-- Actions --")
                showMenu(curr)
                askOption()

                when (option) {
                    0 -> println("Paying")
                    1 -> break;
                }
            }
            2 -> {
                exit = true
                println("Exiting...")
            }
        }
    }

}