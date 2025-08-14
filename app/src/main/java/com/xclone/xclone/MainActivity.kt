package com.xclone.xclone
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xclone.xclone.Adapters.RecViewTasksAdapter


class MainActivity :AppCompatActivity(),OnClickListener {

    lateinit var eTTaskView:EditText
    lateinit var tVTaskView:TextView
    lateinit var RecView:RecyclerView
    lateinit var recyclewViewAdapter: RecViewTasksAdapter
    private var Items:ArrayList<String> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        eTTaskView=findViewById(R.id.eTtaskId)
        tVTaskView=findViewById(R.id.tVTaskId)
        RecView=findViewById(R.id.my_recycler_view)
        tVTaskView.setOnClickListener(this)
        initRecView()



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
    override fun onClick(v: View) {
       if(v.id==R.id.tVTaskId){
           //TODO
           var text=eTTaskView.text.toString()
           Items.add(text);
           recyclewViewAdapter.newItem(Items)

       }
    }

}

