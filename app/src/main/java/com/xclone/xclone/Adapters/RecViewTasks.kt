package com.xclone.xclone.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xclone.xclone.R
import com.xclone.xclone.model.TaskModel

class RecViewTasksAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private var Items: ArrayList<TaskModel> = ArrayList();
    lateinit var context: Context
    constructor(context:Context) : super() {
        this.context= context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RecViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rec_view_items, parent,false)
        )
    }

    override fun getItemCount(): Int {
        return Items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is RecViewHolder ->{
                holder.bind(context,Items.get(position).taskName,position)

            }
        }
    }
    class RecViewHolder constructor(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(context:Context,task:String,position: Int){
            val TaskTV : TextView = itemView.findViewById(R.id.Tvitem_id)
            val ItemLinLayout : LinearLayout = itemView.findViewById(R.id.linearLayoutItemID)
            TaskTV.setText(task)
            ItemLinLayout.setOnClickListener(){
               //todo
            }
        }

    }
    fun newItem(tasks: TaskModel){
        Items.add(tasks)
        notifyDataSetChanged()
    }
    fun setUpList(tasks: List<TaskModel> ){
        Items= ArrayList(tasks)
        notifyDataSetChanged()
    }
}