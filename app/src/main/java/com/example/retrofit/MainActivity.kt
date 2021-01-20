package com.example.retrofit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.Adapter.DataAdapter
import com.example.retrofit.Interface.RetrofitClients
import com.example.retrofit.Interface.RetrofitService
import com.example.retrofit.Model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var dataList = ArrayList<Data>()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        getData()

    }

    private fun getData() {
         val retrofitClients = RetrofitClients.retrofitService.getDataList()
        retrofitClients.enqueue(object: Callback<ArrayList<Data>>{
            override fun onFailure(call: Call<ArrayList<Data>>, t: Throwable) {
                Log.d("Retrofit", "Error in fetching lists", t)
            }

            override fun onResponse(
                call: Call<ArrayList<Data>>,
                response: Response<ArrayList<Data>>
            ) {
                dataList = response.body()!!
                recyclerView.adapter = DataAdapter(response.body()!!)
            }

        })
    }

}