package oncall

fun main() {
    val inputHandler = InputHandler()

    val (month, day) = inputHandler.readDate()
    val (weekMembers, holidayMembers) = inputHandler.readMembers()

    val oncallProgram = OnCall(month, day, weekMembers, holidayMembers)
    oncallProgram.run()





}
