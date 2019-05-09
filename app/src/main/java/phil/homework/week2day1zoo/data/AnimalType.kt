package phil.homework.week2day1zoo.data

enum class AnimalType {
    CUTE, CUDDLY, FAST, FEROCIOUS;

    override fun toString(): String {
        return when(this){
            CUTE -> "cute"
            CUDDLY -> "cuddly"
            FAST -> "fast"
            FEROCIOUS -> "ferocious"
        }
    }
}