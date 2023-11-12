package com.example.demodb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.demodb.Constants.NEWS_TABLE

@Entity(tableName = NEWS_TABLE)
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    val newsId: Int,
    @ColumnInfo(name= "news_title")
    val newstitle: String,
    @ColumnInfo(name = "news_desc")
    val newsdesc: String
)
