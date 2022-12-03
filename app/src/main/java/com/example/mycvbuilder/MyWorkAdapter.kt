package com.example.mycvbuilder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.my_work_card_layout.view.*

class MyWorkAdapter(var context: Context?, var workExperiences :ArrayList<Work>): RecyclerView.Adapter<MyWorkAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent?.context)
            .inflate(R.layout.my_work_card_layout, parent, false)
        return MyViewHolder(v);
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.myJob.apply {
            company_name.text = workExperiences.get(position).company
            role.text = workExperiences.get(position).role
            duration.text = workExperiences.get(position).duration
            location.text = workExperiences.get(position).location
            logo.setImageResource(workExperiences.get(position).image)//, R.drawable.work)
        }
        holder.itemView.myJob.setOnClickListener {

            var res = workExperiences.get(position).company
            Toast.makeText(context, " $res clicked", Toast.LENGTH_LONG).show()

        }
    }

    override fun getItemCount() = workExperiences.size
}
