package com.healer.example

import android.os.Bundle
import android.support.v7.util.DiffUtil
import java.util.logging.Logger

class ContactDiffUtilCallBack(val newList: List<Person>, val oldList: List<Person>) : DiffUtil.Callback() {

    companion object {
        val log = Logger.getLogger("ContactDiffUtilCallBack")
    }

    override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
        return true
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
        val result = newList[p1].compareTo(oldList[p0])
        if (result == 0) {
            return true
        }
        return false
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val newPerson = newList[newItemPosition]
        val oldPerson = oldList[oldItemPosition]
        val bundle = Bundle()
        if (newPerson.name != oldPerson.name) {
            bundle.putString("Name", newPerson.name)
        }
        if (newPerson.status != oldPerson.status) {
            bundle.putString("Status", newPerson.status)
        }
        return bundle
    }
}