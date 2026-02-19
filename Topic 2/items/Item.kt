package items

/**
 * Item inside the online shopping cart.
 */
data class Item(
    val id: String,
    val name: String,
    val basePrice: Double,
    val category: Set<Category>,
    val description: String? = null
)

data class CartItem(
    val id: String,
    val quantity: Int,
)