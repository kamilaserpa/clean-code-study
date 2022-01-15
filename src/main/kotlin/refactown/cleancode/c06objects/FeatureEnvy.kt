package refactown.cleancode.c06objects

import java.lang.IllegalArgumentException
import java.time.LocalDate

// EVITAR Classe que se confunde entre estrutura de dados e objeto
// Duas formas de calcular a área, alguma está sobrando

// Métodos que possíbilitam acessar o cálculo de área de forma externa
class HybridSquare(val side: Double) : Shape {
    override fun area() = side * side
}

class HybridRectangle(val height: Double, val width: Double) : Shape {
    override fun area() = height * width
}

class HybridCircle( val radius: Double) : Shape {
    override fun area() = PI * radius * radius
}
// A própria classe tem o cálculo de área
fun calculateAreaFeatureEnvy(shape: Any): Double {
    return when (shape) {
        is HybridSquare -> shape.side * shape.side
        is HybridRectangle -> shape.height * shape.width
        is HybridCircle -> PI * shape.radius * shape.radius
        else -> throw IllegalArgumentException()
    }
}

class AnemicOrder(val date: LocalDate, var cancelled: Boolean)

fun isValidOrder(order:AnemicOrder): Boolean{
    return !order.cancelled && order.date <= order.date.plusDays(365)
}

class Order(val date: LocalDate, var cancelled: Boolean){
    fun isValid()= !cancelled && date <= date.plusDays(365)
}