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

class RecViewTasksAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private var Items:List<String> = ArrayList();
    lateinit var context: Context
    constructor(context:Context) : super() {
        this.context= context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RecViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rec_view_items,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return Items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is RecViewHolder ->{
                holder.bind(context,Items.get(position),position)

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
    fun newItem(keyDataModel: List<String>){
        Items=keyDataModel
        notifyDataSetChanged()
    }
}