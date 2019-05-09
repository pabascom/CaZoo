package phil.homework.week2day1zoo

import kotlin.random.Random

data class Animal (val name: String, val type: String, val species: String, val weight: Int){

    companion object Generator{
        private val names = arrayOf(
            "George",
            "Michael",
            "George-Michael",
            "Oscar",
            "Lenny",
            "Jan",
            "Kenny",
            "This Motherf*cker",
            "Dat Boi",
            "Charlotte",
            "Pigsley",
            "Kingsley",
            "Harrison",
            "Ford",
            "Jenny",
            "Stan",
            "Kyle",
            "Cartman",
            "Indiana",
            "Genevive",
            "Sandy",
            "Krysha",
            "Tenderloin",
            "Gerald",
            "Jonesey",
            "Jacob",
            "Jeffery",
            "Holland",
            "Hadley"
        )
        private val types = arrayOf(
            "Fast",
            "Ferocious",
            "Cuddly",
            "Cute",
            "Tasty"
        )
        private val species = arrayOf(
            "Cat",
            "Meerkat",
            "Polar Bear",
            "Regular Bear",
            "Just a Plain Ol'... Thing",
            "Whatever this is",
            "Lizard",
            "Big Lizard",
            "Normal-Sized Lizard",
            "Lion",
            "Tiger",
            "Bear",
            "Antlion",
            "Aardvark",
            "Hippopotamus",
            "Land Shark",
            "Mere Cat",
            "Exceptional Cat",
            "Pigeon",
            "Pidgeot",
            "Dolphin",
            "Human Being",
            "Dutch Pig",
            "Dog",
            "Wolf",
            "Super Bear",
            "Superb Owl",
            "Eagle Owl",
            "Lemming",
            "Ant Colony",
            "Barn Owl",
            "Alligator",
            "Crocodile",
            "Python",
            "Java",
            "Kotlin"
        )

        fun getAnimal(): Animal {
            return Animal(
                name = names[Random.nextInt(names.size)],
                type = types[Random.nextInt(types.size)],
                species = species[Random.nextInt(species.size)],
                weight = Random.nextInt(299)+1
            )
        }

        fun getAnimals(size: Int): List<Animal>{
            return (0..size).map{ getAnimal() }
        }
    }

}