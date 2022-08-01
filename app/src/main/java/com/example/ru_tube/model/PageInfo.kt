package com.example.ru_tube.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PageInfo(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    val resultsPerPage: Int?, // 5
    val totalResults: Int? // 421
)