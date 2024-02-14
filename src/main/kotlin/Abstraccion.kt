/*
* Abstraccion: Consisten en mostrar solo la informacion esencial y ocultar los detalles innecesarios.
* */
fun main(){
    val circle = Circle(5.0)
    val rectangle = Rectangle(2.0,10.0)

    println(circle.calculateArea())
    println(rectangle.calculateArea())
}

abstract class Shape{
    abstract fun calculateArea():Double
}

class Circle(private val radius: Double): Shape(){
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Rectangle(private val width: Double, private val height:Double) : Shape()
{
    override fun calculateArea(): Double {
        return width * height
    }

}