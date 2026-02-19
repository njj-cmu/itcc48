/*
    File for isolated inventory functions...
 */

/**
 * Checks if an item inside the inventory has enough quantity required.
 */
fun isAvailable(
    inventory: Map<String, Int>,
    itemId: String,
    qty: Int
): Boolean {

    /*
        1. Checks if itemId exists inside the inventory
        2.1 If it does, assume whatever is quantity of inventory[itemId]
        2.2 If it doesn't, set the value as 0
        3. Check if item's quantity meets the required quantity.
     */
    return (inventory[itemId] ?: 0) >= qty
}

fun reserve(
    inventory: MutableMap<String, Int>,
    itemId: String,
    qty: Int
) {
    if (!isAvailable(inventory, itemId, qty)) {
        error("Invalid state: insufficient stock")
    }

    /*
        inventory[itemId]!!

        The symbols, "!!", assert that inventory[itemId] is not a null value
     */

    // Shorthand way of doing it
    // inventory[itemId] = inventory[itemId]!! - qty

    // Clearer way
    val currentStock = inventory[itemId] ?: error("Invalid state: item does not exist in inventory")

    if(currentStock < qty) {
        error("Invalid state: insufficient stock")
    }

    inventory[itemId] = currentStock - qty
}