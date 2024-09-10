package com.kel.k_todolist

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class InputTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_task)

        val dao = Dao()

        val inputName = findViewById<TextInputEditText>(R.id.contentName)
        val inputDesc = findViewById<TextInputEditText>(R.id.contentDesc)

        val saveButton = findViewById<MaterialButton>(R.id.saveTaskButton)

        saveButton.setOnClickListener {

            val taskName = inputName.text.toString()
            val descName = inputDesc.text.toString()

            if(taskName.isNotEmpty() && descName.isNotEmpty()) {
                val newTask = Task(taskName, descName)

                dao.addTask(newTask)

                finish()
            } else {


                Snackbar.make(saveButton, "Insira alguma tarefa!", Snackbar.LENGTH_SHORT).apply {
                    view.setBackgroundColor(Color.RED)
                    setTextColor(Color.WHITE)
                    show()
                }
            }

        }

    }
}