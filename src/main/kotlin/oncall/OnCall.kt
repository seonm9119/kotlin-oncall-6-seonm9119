package oncall

class OnCall(private val month: Int,
             private val day: String,
             private val weekMembers: List<String>,
             private val holidayMembers: List<String>) {

    private val daysInEachMonth = listOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    private val monthDaysOfWeek = mutableListOf<String>()
    private val assignedMembers = mutableListOf<String>()

    private fun assignMembers(){

        val repeatedWeekMembers = List(monthDaysOfWeek.size) { weekMembers }.flatten().toMutableList()
        val repeatedHolidayMembers = List(monthDaysOfWeek.size) { holidayMembers }.flatten().toMutableList()


        for (i in 0 until monthDaysOfWeek.size){

            when{
                monthDaysOfWeek[i].contains("(휴일)")->{
                    if (repeatedWeekMembers.size > 2 && repeatedWeekMembers[0] == repeatedWeekMembers[1])
                        switchMember(repeatedWeekMembers, 1,2)
                    assignedMembers.add(repeatedWeekMembers.removeFirst())
                }

                monthDaysOfWeek[i] in Days.weekDay ->{
                    if (repeatedHolidayMembers.first() == repeatedWeekMembers.first())
                        switchMember(repeatedHolidayMembers, 0,1)
                    if (repeatedWeekMembers.size > 2 && repeatedWeekMembers[0] == repeatedWeekMembers[1])
                        switchMember(repeatedWeekMembers, 1,2)
                    assignedMembers.add(repeatedWeekMembers.removeFirst())
                }

                else -> {
                    if (repeatedHolidayMembers.first() == repeatedWeekMembers.first())
                        switchMember(repeatedWeekMembers, 0,1)
                    assignedMembers.add(repeatedHolidayMembers.removeFirst())

                }
            }

        }

    }

    private fun generateCalender(){

        val startIndex = Days.daysOfWeek.indexOf(day)
        var startDay = 1
        for (i in startIndex until startIndex + daysInEachMonth[month-1]) {
            val index = i % Days.daysOfWeek.size

            if (HolidayMonth.nationalHoliday[month]?.contains(startDay) == true && Days.daysOfWeek[index] in Days.weekDay)
                monthDaysOfWeek.add("${Days.daysOfWeek[index]}(휴일)")
            else monthDaysOfWeek.add(Days.daysOfWeek[index])
            startDay +=1
        }
    }

    private fun display(){

        for (i in 0 until daysInEachMonth[month-1]) {
            print("${month}월 ${i+1}일 ${monthDaysOfWeek[i]} ${assignedMembers[i]}\n")
        }

    }

    fun run(){
        generateCalender()
        assignMembers()
        display()
    }
}


