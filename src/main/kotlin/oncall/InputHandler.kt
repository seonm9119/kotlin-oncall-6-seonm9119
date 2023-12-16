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

    private fun checkMembers(): Pair<List<String>,List<String>>  {

        print("\n평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ")
        val weekMembers = readLine().split(',')

        print("\n휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ")
        val holidayMembers = readLine().split(',')
        require(weekMembers.size == weekMembers.distinct().size){"\n[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."}
        require(holidayMembers.size == holidayMembers.distinct().size){"\n[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요."}

        return Pair(weekMembers, holidayMembers)
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
                return checkMembers()
            } catch (e: IllegalArgumentException) {
                print(e.message)
            }
        }
    }




}