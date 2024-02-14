/*
* Polimorfismo: Permite que objetos de diferentes clases puedan ser tratados de manera uniforme
 */
fun main(){
    val animal = Animal()
    val dog = Dog()
    val cat = Cat()

    dog.makeSound()
    cat.makeSound()
}

open class Animal{
    open fun makeSound(){
        println("The animal makes a sound")
    }
}

class Dog : Animal(){
    override fun makeSound(){
        println("The dog makes a sound")
    }
}

class Cat : Animal(){
    override fun makeSound(){
        println("The cat makes a sound")
    }
}