package com.example.demodb

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.demodb.databinding.ActivityAddNewsBinding
import com.google.android.material.snackbar.Snackbar

class AddNewsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddNewsBinding
    private lateinit var newsEntity: NewsEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSave.setOnClickListener {
                val title = edtTitle.text.toString()
                val desc = edtDesc.text.toString()
                if(title.isNotEmpty() || desc.isNotEmpty()){
                    newsEntity = NewsEntity(0, title, desc)
                    newsDB.doa().insertNews(newsEntity)
                    finish()
                }

                else{
                    Snackbar.make(it, "Title and Description can not be Empty", Snackbar.LENGTH_LONG).show()
                }
                startActivity(Intent(this@AddNewsActivity, MainActivity::class.java))
            }
        }
    }
    private val newsDB: NewsDatabase by lazy {
        Room.databaseBuilder(this, NewsDatabase::class.java, Constants.NEWS_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}