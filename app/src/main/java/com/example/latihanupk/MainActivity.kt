package com.example.latihanupk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var simpan : Button
    private lateinit var hasile: TextView
    private lateinit var txtAlas: EditText
    private lateinit var txtTinggi: EditText
    private lateinit var viewmanager: RecyclerView.LayoutManager
    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var hitung : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simpan = findViewById(R.id.btsimpan)
        hasile = findViewById(R.id.tvhasil)
        txtAlas = findViewById(R.id.txtalas)
        txtTinggi = findViewById(R.id.txtTinggi)
        hitung = findViewById(R.id.bthitung)
        recyclerView = findViewById(R.id.Listdata)

        val data = mutableListOf<DataHasil>()
        viewmanager = LinearLayoutManager(this)
        recyclerAdapter = HasilAdapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewmanager

        simpan.setOnClickListener {
            val bilanganA = txtAlas.text.toString().trim()
            val bilanganT = txtTinggi.text.toString().trim()
            val hasil = hasile.text.toString()


            val dataaa = DataHasil(bilanganA,bilanganT,hasil)
            data.add(dataaa)
            recyclerAdapter.notifyDataSetChanged()

        }
        hitung.setOnClickListener {
            val Alas = txtAlas.text.toString().trim()
            val Tinggi = txtTinggi.text.toString().trim()

            var isEmptyFields = false
            when{
                Alas.isEmpty()->{
                    isEmptyFields = true
                    txtAlas.error = " Alas tidak boleh kosong"
                }
                Tinggi.isEmpty()->{
                    isEmptyFields = true
                    txtTinggi.error = "Tinggi tidak boleh kosong"
                }
            }
            if (!isEmptyFields){
                val hasil = 0.5 * Alas.toDouble() * Tinggi.toDouble()
                hasile.text = hasil.toString()+"CM"}
            }
        }
    }
