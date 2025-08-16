package com.xclone.xclone.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.xclone.xclone.R
import java.util.Calendar

class ActivityAddTasks : AppCompatActivity(), View.OnClickListener {

    lateinit var AddTaskEditTextId: TextView
    lateinit var AddTaskCheckBoxId: CheckBox
    lateinit var AddTaskEtDueDateId: EditText
    lateinit var AddTaskDateId: ImageView
    lateinit var AddTaskResetDateId: ImageView
    lateinit var AddTaskEtDueTimeId: EditText
    lateinit var AddTaskTimeId: ImageView
    lateinit var AddTaskResetTimeId: ImageView
    lateinit var AddTaskSaveButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_tasks)
        AddTaskEditTextId=findViewById(R.id.AddTaskEditTextId)
        AddTaskCheckBoxId=findViewById(R.id.AddTaskCheckBoxId)
        AddTaskEtDueDateId=findViewById(R.id.AddTaskEtDueDateId)
        AddTaskDateId=findViewById(R.id.AddTaskDateId)
        AddTaskResetDateId=findViewById(R.id.AddTaskResetDateId)
        AddTaskEtDueTimeId=findViewById(R.id.AddTaskEtDueTimeId)
        AddTaskTimeId=findViewById(R.id.AddTaskTimeId)
        AddTaskResetTimeId=findViewById(R.id.AddTaskResetTimeId)
        AddTaskSaveButton=findViewById(R.id.AddTaskSaveButton)

        AddTaskEtDueDateId.setOnClickListener(this)
        AddTaskDateId.setOnClickListener(this)
        AddTaskResetDateId.setOnClickListener(this)
        AddTaskEtDueTimeId.setOnClickListener(this)
        AddTaskTimeId.setOnClickListener(this)
        AddTaskResetTimeId.setOnClickListener(this)
        AddTaskSaveButton.setOnClickListener(this)



    }

    override fun onClick(v: View) {
        if(v.id==R.id.AddTaskEtDueDateId){
            DateDialog()

        }else if(v.id==R.id.AddTaskDateId){

        }else if(v.id==R.id.AddTaskResetDateId){

        }else if(v.id==R.id.AddTaskEtDueTimeId){

        }else if(v.id==R.id.AddTaskTimeId){

        }else if(v.id==R.id.AddTaskResetTimeId){

        }else if(v.id==R.id.AddTaskSaveButton){

        }

    }

    fun DateDialog(){
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Create DatePickerDialog
        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // Month is 0-based, so we add 1
                val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                AddTaskEtDueDateId.setText(formattedDate)
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }
}