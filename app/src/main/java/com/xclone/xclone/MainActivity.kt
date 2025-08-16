package com.xclone.xclone
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xclone.xclone.Adapters.RecViewTasksAdapter
import com.xclone.xclone.RoomDB.TasksDb
import com.xclone.xclone.Utils.DateTimeCustom
import com.xclone.xclone.model.TaskModel
import com.xclone.xclone.repository.RepositoryTask
import com.xclone.xclone.view.ActivityAddTasks
import com.xclone.xclone.viewModel.TaskViewModel
import com.xclone.xclone.viewModel.TaskViewModelFactory
import java.util.ArrayList


class MainActivity :AppCompatActivity(),OnClickListener {

    lateinit var eTTaskView:EditText
    lateinit var tVTaskView:TextView
    lateinit var RecView:RecyclerView
    lateinit var recyclewViewAdapter: RecViewTasksAdapter

    lateinit var TaskviewModel: TaskViewModel

    lateinit var db : TasksDb
    lateinit var repository: RepositoryTask
    lateinit var factory : TaskViewModelFactory
    lateinit var viewModel : TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        eTTaskView=findViewById(R.id.eTtaskId)
        tVTaskView=findViewById(R.id.tVTaskId)
        RecView=findViewById(R.id.my_recycler_view)
        tVTaskView.setOnClickListener(this)

        //
        db = TasksDb.getDatabase(applicationContext)
        repository = RepositoryTask(db.taskDao())
        factory = TaskViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[TaskViewModel::class.java]

        viewModel.allTasks.observe(this) { tasks ->
            recyclewViewAdapter.setUpList(tasks)
        }
        initRecView()
        //
        startAddTaskActivity()

    }

    private fun startAddTaskActivity() {
        val intent = Intent(this, ActivityAddTasks::class.java)
        startActivity(intent)
    }

    private fun initRecView(){
        recyclewViewAdapter= RecViewTasksAdapter(this)
        RecView.layoutManager = LinearLayoutManager(this)
        RecView.adapter = recyclewViewAdapter
    }

    override fun onStart() {
        super.onStart()
    }
    override fun onPause() {
        super.onPause()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(v: View) {
       if(v.id==R.id.tVTaskId){
           //TODO
           var taskName=eTTaskView.text.toString()
           var dueDate= DateTimeCustom().getDate()
           var dueTime= DateTimeCustom().getTime()
           var parentList="Work"
           var isRepeatOn=true
           if(taskName.length!=0){
               var taskModel= TaskModel(0,taskName,dueDate,dueTime,isRepeatOn,parentList)
               recyclewViewAdapter.newItem(taskModel)
               saveToDb(taskModel)
           }
       }
    }

    private fun saveToDb(task: TaskModel) {
        viewModel.insert(task)

    }


}

