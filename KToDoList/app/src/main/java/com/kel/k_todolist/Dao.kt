package com.kel.k_todolist

class Dao {

    fun addTask(task: Task) {
        Companion.tasks.add(task)
    }

    fun searchTask() : List<Task> {
        return Companion.tasks.toList();
    }

    companion object {
        private val tasks = mutableListOf<Task>()
    }
}