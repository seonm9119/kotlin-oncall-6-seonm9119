package oncall

import camp.nextstep.edu.missionutils.Console.readLine

class InputHandler {

    private fun checkDate(): Pair<Int, String> {
        val inputs = readLine().split(',')

        val month = inputs[0].toInt()
        val day = inputs[1]
        require(month >= 1 && month <= 12){"\n[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.\n"}
        require(day in listOf("일", "월", "화", "수", "목", "금", "토")){"\n[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.\n"}

        return Pair(month, day)
    }

    private fun checkMembers(members: List<String>) {


        require(members.size == members.distinct().size){"\n[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."}
        require(members.all { it.length < 6 }){"\n[ERROR] 5자 이상의 닉네임을 가진 근무자가 있습니다. 다시 입력해 주세요."}
        require(members.size > 5){"\n[ERROR] 최소 근무자가 5명 이상이도록 하십시오. 다시 입력해 주세요."}
        require(members.size < 36){"\n[ERROR] 근무자수가 35명을 넘지 않도록 하시오. 다시 입력해 주세요."}

    }


    fun readDate(): Pair<Int, String>{

        while (true){
            print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ")
            try {
                return checkDate()
            } catch (e: NumberFormatException) {
                print("\n[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.\n")
            } catch (e: IllegalArgumentException) {
                print(e.message)
            }
        }
    }

    fun readMembers(): Pair<List<String>,List<String>>{

        while (true){
            try {

                print("\n평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ")
                val weekMembers = readLine().split(',')

                print("\n휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ")
                val holidayMembers = readLine().split(',')

                checkMembers(weekMembers)
                checkMembers(holidayMembers)
                return Pair(weekMembers, holidayMembers)
            } catch (e: IllegalArgumentException) {
                print(e.message)
            }
        }
    }




}