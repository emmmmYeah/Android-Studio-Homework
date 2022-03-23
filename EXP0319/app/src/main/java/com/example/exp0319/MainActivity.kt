package com.example.exp0319

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isGone
import java.util.*

class MainActivity : AppCompatActivity() {

   /* val  TAG="@MainActivity"

    private var username:String?=null
    private var password:String?=null*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val iptUsername=findViewById<EditText>(R.id.ipt_username)//获取输入框信息
        val iptPassword=findViewById<EditText>(R.id.ipt_password)

        val userNameWatcher = object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.i(TAG,"beforeTextChanged:$s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                 Log.i(TAG,"onTextChanged:$s")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG,"afterTextChanged:$s")

            }

        }
 val passwordWatcher = object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.i(TAG,"beforeTextChanged:$s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.i(TAG,"onTextChanged:$s")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG,"afterTextChanged:$s")
            }

        }

        iptUsername.addTextChangedListener(userNameWatcher)
        iptPassword.addTextChangedListener(passwordWatcher)
        //username=iptUsername.transitionName
    }



    fun onClick(view: View){
        Log.d(TAG,"username=$username")
        Log.d(TAG,"password=$password")

       /* AlertDialog.Builder(this)//对话框+页面跳转
            .setTitle("请确认")
            .setMessage("您确定要登陆吗？")
            .setNegativeButton("取消"){d,w->
Toast.makeText(this,"已取消",Toast.LENGTH_LONG).show()//没有理解它
            }
            .setPositiveButton("确定"){d,w->//等候进度条
tologin()
            }*/

        val process=findViewById<ProgressBar>(R.id.progress)
        process.visibility=View.VISIBLE
        process.progress=0
        //TODO:请求网络  耗时

        val timer =Timer()
        val task =object: TimerTask(){
            override fun run() {//定时
                Log.d(TAG,"progress=${process.progress}")
                process.progress=process.progress+1
                if(process.progress==10){
                    timer.cancel()
                    process.visibility=View.GONE
                }
            }

        }

        timer.schedule(task,0,1000)//一秒钟执行一次fun run()


    }

    /*private fun tologin() {
        val process=findViewById<ProgressBar>(R.id.progress)
    }*/
}