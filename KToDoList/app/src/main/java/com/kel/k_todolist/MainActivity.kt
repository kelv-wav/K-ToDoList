package com.kel.k_todolist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {


    private val dao = Dao() // Instância única do DAO
    private lateinit var adapterTasks: AdapterTasks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val fab = findViewById<ExtendedFloatingActionButton>(R.id.fab)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        adapterTasks = AdapterTasks(dao.searchTask()) // Inicializa o adapter com as tarefas
        recyclerView.adapter = adapterTasks
        recyclerView.layoutManager = LinearLayoutManager(this)

        Log.i("Tasks", "onResume: ${dao.searchTask()}")

        fab.setOnClickListener{
            val intent = Intent(this, InputTask::class.java)
            startActivity(intent)
        }
    }
}
