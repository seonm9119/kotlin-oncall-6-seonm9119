package oncall

fun main() {
    val inputHandler = InputHandler()

    val date = inputHandler.readDate()
    val members = inputHandler.readMembers()

    generateCalender(date)
    display(date,members)





}
