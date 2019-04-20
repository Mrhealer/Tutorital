package com.healer.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_view_main.layoutManager = linearLayoutManager
        val dataSource = DataSource()
        contactAdapter = ContactAdapter(applicationContext, dataSource.getData())
        recycler_view_main.adapter = contactAdapter
        val dividerItemDecoration = DividerItemDecoration(recycler_view_main.context, linearLayoutManager.orientation)
        recycler_view_main.addItemDecoration(dividerItemDecoration)
        swipeRefreshLayout.setOnRefreshListener {
            contactAdapter.updateData(dataSource.getUpdateData())
            swipeRefreshLayout.isRefreshing = false
        }

    }
}
