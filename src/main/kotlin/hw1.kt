fun main() {
    val amount = 200 // стоимость текущей продажи
    val total = 11_000 // сумма предыдущих продаж
    var fee = calculateFee(200, 11_000)  // exclusive по умолчанию = false
    println("Discount for non exclusive $fee") // 40
    fee = calculateFee(200, 11_000, true)  // exclusive по умолчанию = false
    println("Discount includes exclusive $fee") // 40
}

fun calculateFee(amount: Int, total: Int, exclusive: Boolean = false): Int {
    val sum: Int = (amount + total).toInt()
    val vip: Int = if (exclusive) 5 else 0
    var discount = when {
        sum < 1001 -> 30
        sum > 1000 && sum < 10001 -> 25
        sum > 10000 && sum < 500001 -> 20
        else -> 15 - vip
    }
    return (amount * (discount-vip) / 100).toInt()
}
