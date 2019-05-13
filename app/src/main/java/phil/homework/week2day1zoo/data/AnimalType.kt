package phil.homework.week2day1zoo.data

enum class AnimalType {
    CUTE, CUDDLY, FAST, FEROCIOUS;

    override fun toString(): String {
        return when(this){
            CUTE -> "Cute"
            CUDDLY -> "Cuddly"
            FAST -> "Fast"
            FEROCIOUS -> "Ferocious"
        }
    }

    companion object {
        fun fromString(string: String): AnimalType{
            return when(string){
                "Cute" -> CUTE
                "Cuddly" -> CUDDLY
                "Fast" -> FAST
                else -> FEROCIOUS
            }
        }
    }
}