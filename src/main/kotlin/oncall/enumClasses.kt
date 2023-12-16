package oncall

enum class HolidayMonth(val days: Map<Int, List<Int>>) {
    JANUARY(mapOf(1 to listOf(1))),
    MARCH(mapOf(1 to listOf(1))),
    MAY(mapOf(5 to listOf(5))),
    JUNE(mapOf(6 to listOf(6))),
    AUGUST(mapOf(15 to listOf(15))),
    OCTOBER(mapOf(3 to listOf(3), 9 to listOf(9))),
    DECEMBER(mapOf(25 to listOf(25)));

    companion object {
        val nationalHoliday: Map<Int, List<Int>> by lazy {
            entries.flatMap { it.days.entries }.associate { it.toPair() }
        }
    }
}

enum class Days(val names: String){
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    companion object {
        val daysOfWeek: List<String> by lazy {
            entries.map { it.names }
        }
        val weekDay: List<String> by lazy { entries.filter { it != SATURDAY && it != SUNDAY }.map { it.names } }
        val weekendDay: List<String> by lazy { entries.filter { it == SATURDAY || it == SUNDAY }.map { it.names } }


    }


}
