package oncall

fun switchMember(list: MutableList<String>, index1: Int, index2: Int) {
    require(index1 in list.indices && index2 in list.indices) { "\n[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.\n" }

    val temp = list[index1]
    list[index1] = list[index2]
    list[index2] = temp
}

fun switchIfFirstTwoEqual(list: MutableList<String>) {
    if (list.size > 2 && list[0] == list[1]) {
        val temp = list[1]
        list[1] = list[2]
        list[2] = temp
    }
}