package com.healer.example

import android.content.Context
import android.os.Bundle
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_view.view.*
import java.util.logging.Logger

class ContactAdapter(val context: Context, private val personList: MutableList<Person>) :
    RecyclerView.Adapter<ContactAdapter.MyRecyclerView>() {

    companion object {
        val log = Logger.getLogger("ContactAdapter")
    }

    class MyRecyclerView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binItem(person: Person) {
            itemView.name_text_view.text = person.name
            itemView.status_text_view.text = person.status
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactAdapter.MyRecyclerView {

        val view = LayoutInflater.from(context).inflate(R.layout.item_view, p0, false)
        return MyRecyclerView(view)

    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(p0: ContactAdapter.MyRecyclerView, p1: Int) {
        p0.binItem(personList[p1])
    }

    override fun onBindViewHolder(holder: MyRecyclerView, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            val bundle = payloads[0] as Bundle

            for (key in bundle.keySet()) {
                if (key == "Name") {
                    holder.itemView.name_text_view.text = personList[position].name
                }
                if (key == "Status") {
                    holder.itemView.status_text_view.text = personList[position].status
                }
            }

        }
    }

    fun updateData(newList: List<Person>) {
        val diffResult = DiffUtil.calculateDiff(ContactDiffUtilCallBack(newList, personList))
        diffResult.dispatchUpdatesTo(this)
        this.personList.clear()
        this.personList.addAll(newList)
    }
}