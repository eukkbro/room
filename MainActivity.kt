package abled.tstory.room

import abled.tstory.room.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter= MyAdapter() //어댑터 객체 만듦

        // Database 초기화
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "databaseName"
        ).build()

        // userDao 초기화
        val userDao = db.userDao()

        Thread { //room에 접근하기 위해 Thread 사용

            var userList = userDao.getAll() as ArrayList<User>
            Log.d("사이즈", "onCreate: ${userList.size}")

            adapter.datalist = userList

            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = adapter
        }.start()

        binding.buttonAdd.setOnClickListener {

            Thread { //room에 접근하기 위해 Thread 사용

                var addUser = User(adapter.itemCount,binding.editText1.text.toString(), binding.editText2.text.toString())
                userDao.insertAll(addUser)

                adapter.datalist.add(addUser)

                Handler(Looper.getMainLooper()).post{

                    adapter.notifyDataSetChanged()
                    Toast.makeText(this,"성공적으로 추가했습니다",Toast.LENGTH_SHORT).show()
                    binding.editText1.setText("")
                    binding.editText2.setText("")

                }

                    }.start()

                }


        }
    }

