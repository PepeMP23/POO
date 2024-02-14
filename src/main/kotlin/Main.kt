import java.util.UUID

/*
* Hacer una fabrica de vehiculos
* Coches, Motocicletas
* Modelo
* Metodos especifcos para cada vehicula
* Marcas de coches
* */
fun main(){
    try{
        val factory = Factory()
        val tesla = factory.produceCar("Tesla","Model S") as Tesla
        val ferrari : Car = factory.produceCar("Ferrari","Enzo") as Ferrari
        val tesla2 = factory.produceCar("Tesla","Model X") as Tesla
        val ferrari2 = factory.produceCar("Ferrari","F8 Turbo") as Ferrari
        factory.addCar(tesla)
        factory.addCar(ferrari)
        factory.addCar(tesla2)
        factory.addCar(ferrari2)
        ferrari2.turbo()
        ferrari.openDoors()
        ferrari.enableAC()
        tesla.charge()
        tesla.autopilot()
        val cars = factory.getAllCars()
        cars.forEach { c->
            println("The car is a ${c.brand} with model ${c.model} with VIN ${c.getVin()}")
        }
    }
    catch (e:Exception){
        println(e)
    }
}


abstract class Vehicle(val wheels: Int){
    fun stop(){
        println("Stoping")
    }
    fun accelerate(){
        println("Accelerating")
    }

    open fun brake(){
        println("Braking with $wheels wheels")
    }
}

abstract class Car(val brand: String, val maxSpeed : Double,open val model :String):Vehicle(4){
    private val vin : UUID = UUID.randomUUID()

    fun openDoors(){
        println("Opening doors")
    }

    fun enableAC(){
        println("Enable AC")
    }
    fun getVin():UUID{
        return vin
    }
}

class Tesla(override val model : String) : Car("Tesla",300.0,model){
    fun autopilot(){
        println("Enabling autopilot")
    }

    fun charge(){
        println("Charging")
    }

    override fun brake() {
        super.brake()
        println("Recharging battery")
    }
}

class Ferrari(override val model: String) : Car("Ferrari",400.0,"Enzo"){
    fun turbo(){
        println("Turbo")
    }

    fun drift(){
        println("Drift")
    }
}

class Motorcycle(val brand : String, val maxSpeed: Double,val model : String) : Vehicle(2){
    fun wheelie(){
        println("Wheelie")
    }
}


class Factory{
    private val cars = mutableListOf<Car>()
    fun produceCar(brand:String,model:String) :Car {
        val car = when(brand){
            "Tesla" -> Tesla(model)
            "Ferrari" -> Ferrari(model)
            else -> throw IllegalArgumentException("Brand not found")
        }

        return car
    }

    fun produceMotorcycle(brand:String,model:String,maxSpeed: Double) : Motorcycle{
        return Motorcycle(brand,maxSpeed,model)
    }

    fun addCar(car:Car){
        cars.add(car)
    }

    fun removeCar(car:Car){
        cars.remove(car)
    }

    fun removeCarWithIndex(index:Int){
        cars.removeAt(index)
    }

    fun getCarsByBrand(brand:String):List<Car>{
        return cars.filter { it.brand == brand }
    }
    fun getAllCars():List<Car>{
        return cars
    }
}