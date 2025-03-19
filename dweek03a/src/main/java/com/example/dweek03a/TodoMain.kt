package com.example.dweek03a

import com.example.dweek03a.model.TodoListFactory
import com.example.dweek03a.model.TodoService
import java.util.Scanner

//alt + enter -> 자동 임포트 단축키, 임포트 할 때 잘 정의해야 함
fun main() {

    val scanner = Scanner(System. `in`)
    val todoService = TodoService(TodoListFactory.makeTodoList())

    while(true) {
        println("학번: 202214315, 학과: 스마트ict융합공학과, 이름: 전용학")
        println("\n ===== TodoList 메뉴 =====")
        println("1. 메모 등록")
        println("2. 메모 완료 체크")
        println("3. 메모 검색")
        println("4. 메모 전체 리스트 보기")
        println("5. 종료")
        print("메뉴 선택: ")

        when(scanner.nextInt()) {
            1 -> {
                print("추가할 메모 입력 :")
                scanner.nextLine()
                val content = scanner.nextLine()
                todoService.addContent(content)
            }
            2 -> {
                todoService.listTodos()
                print("완료 표시할 메모의 번호를 입력하세요: ")
                val checklist = scanner.nextInt()
                todoService.completeTodo(checklist)
            }
            3 -> {
                print("검색할 키워드를 입력하세요: ")
                scanner.nextLine()
                val keyword = scanner.nextLine()
                todoService.searchTodo(keyword)
            }
            4 -> {
                todoService.listTodos()
            }
            5 -> {
                println("프로그램을 종료합니다.")
                return
            }
            else -> println("올바른 번호를 입력하세요.")
        }

//    val todoService = TodoService(TodoListFactory.makeTodoList())
//    todoService.addContent("모프 공부하기0")
//    todoService.listTodos()
    }


}