package com.example.dweek03a.model

import java.time.LocalDateTime.now
import java.time.format.DateTimeFormatter

class TodoService(val todoList: MutableList<Item>) {

    fun addContent(content: String) {
        val currentTime = now().format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
        todoList.add(Item(content, currentTime))
        println("일정이 추가되었습니다.")
    }

    fun listTodos() {
        if (todoList.isEmpty()) {
            println("등록된 일정이 없습니다.")
        } else {
            todoList.forEachIndexed { index, item ->
                println("$index : $item")
            }
        }
    }

    fun completeTodo(checklist: Int) {
        if(checklist in todoList.indices) {
            todoList[checklist].status = TodoStatus.COMPLETED
            println("`$todoList[index].status.cont` 일정이 완료 되었습니다.")
        } else {
            println("잘못된 체크리스트 입니다.")
        }

    }

    fun searchTodo(keyword: String) {
        val results = todoList.filter { it.content.contains(keyword)}
        if(results.isEmpty()) {
            println("'$keyword'에 대한 검색 결과가 없습니다.")
        } else {
            println("검색 결과: ")
            results.forEachIndexed { result, item -> println("'$result : $item'") }
        }
    }

    fun resultTodo(result: String) {
        if(todoList.isEmpty()) {
            println("등록된 일정이 없습니다.")
        } else {
            println("====== 할 일 목록입니다. ======")
            todoList.forEachIndexed { result, item -> println("`$result : $item") }
        }

    }

}