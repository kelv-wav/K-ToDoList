package com.kel.k_todolist

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fab = findViewById<ExtendedFloatingActionButton>(R.id.fab)

        fab.setOnClickListener{

            val intent = Intent(this, InputTask::class.java)
            startActivity(intent)
        }

        val tasks = listOf(
            Task("Buy groceries", "Milk, bread, and eggs"),
            Task("Walk the dog", "Take the dog for a walk in the park"),

        )

        val adapter = Adapter(tasks)
        recyclerView.adapter = adapter


    }
}