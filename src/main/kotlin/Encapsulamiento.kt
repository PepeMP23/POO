/*
* Encapsulamiento: Ocultar el estado interno de una clase o de un objeto
* y solo permite acceso atraves de metodos especificos
*
* */

fun main(){
    var person = Person()
    person.getName()
    person.setName("Juan")
    person.setAge(10)
    println(person.getName())
    println(person.getAge())
}

class Person(){
    private var name : String = ""
    private var age : Int = 0

    fun getName() : String{
        return this.name
    }

    fun setName(name:String){
        this.name = name
    }

    fun getAge():Int{
        return this.age
    }

    fun setAge(age:Int) {
        this.age = age
    }
}