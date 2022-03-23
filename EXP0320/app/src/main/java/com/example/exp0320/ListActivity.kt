package com.example.exp0320

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    val teacher= arrayListOf<Teacher>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initData()

        val recycler=findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter=TeacherAdapter(teacher)
    }

    private fun initData(){
        for(i in 1..10)
        teacher.add(Teacher().apply {
            name="王晓佳"
            description="从前车马很慢一生只够爱一个人"
            avater=R.mipmap.bg
        })

    }
}