fun main() {
    val heigh=1.55F
    val theweigh=59.0F
    val index = bodyMassIndex(heigh,theweigh)
    val verdict = when {
        heigh<=0.0->"Ошибка в данных"
        index<16.01->"Выраженный дефицит массы тела"
        index>16.00&&index<18.51->"Недостаточная (дефицит) масса тела"
        index>18.50&&index<25.01->"Норма"
        index>25.00&&index<30.01->"Избыточная масса тела (предожирение)"
        index>30.00&&index<35.01->"Ожирение"
        index>35.00&&index<40.01->"Ожирение резкое"
        index>40.00->"Очень резкое ожирение"
        else->"Something went wrong"
    }
    println("Индекс массы тела - $index : $verdict")
}

fun bodyMassIndex(heigh: Float, theweigh: Float): Float {
    var index=0.0F
    try {
        index=theweigh/(heigh * heigh).toFloat()
    } catch (e: Exception) {
        println("Ошибка в данных - рост 0")
    }
    return index
}
