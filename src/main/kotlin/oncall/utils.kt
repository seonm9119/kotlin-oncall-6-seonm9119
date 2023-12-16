package oncall

val daysInEachMonth = listOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
val daysOfWeek = listOf("일", "월", "화", "수", "목", "금", "토")
val nationalHoliday = mapOf(1 to listOf(1),
    3 to listOf(1),
    5 to listOf(5),
    6 to listOf(6),
    8 to listOf(15),
    10 to listOf(3,9),
    12 to listOf(25)
)
val weekDay = listOf("월", "화", "수", "목", "금")
val weekendDay = listOf("토", "일")

val monthDaysOfWeek = mutableListOf<String>()
val assignedMembers = mutableListOf<String>()

fun assignMembers(members: Pair<List<String>, List<String>>){

    val (weekMembers, holidayMembers) = members
    val copyWeekMembers = weekMembers.toMutableList()
    val copyHolidayMembers = holidayMembers.toMutableList()

    for (i in 0 until monthDaysOfWeek.size){

        when{
            monthDaysOfWeek[i].contains("(휴일)")->
                assignedMembers.add(copyHolidayMembers.removeFirst())
            monthDaysOfWeek[i] in weekDay ->
                assignedMembers.add(copyWeekMembers.removeFirst())
            else -> assignedMembers.add(copyHolidayMembers.removeFirst())
        }

    }








}

fun generateCalender(date: Pair<Int, String>){

    val (month, day) = date
    val startIndex = daysOfWeek.indexOf(day)

    var startDay = 1
    for (i in startIndex until startIndex + daysInEachMonth[month-1]) {
        val index = i % daysOfWeek.size

        if (nationalHoliday[month]?.contains(startDay) == true && daysOfWeek[index] in weekDay)
            monthDaysOfWeek.add("${daysOfWeek[index]}(휴일)")
        else monthDaysOfWeek.add(daysOfWeek[index])
        startDay +=1
    }
}

fun display(date: Pair<Int, String>, members: Pair<List<String>,List<String>>){

    val (month, day) = date
    assignMembers(members)

    var result = ""
    for (i in 0 until daysInEachMonth[month-1]) {
        print("${month}월 ${i+1}일 ${monthDaysOfWeek[i]} ${assignedMembers[i]}\n")
    }

    //print("\n${result}")

}



