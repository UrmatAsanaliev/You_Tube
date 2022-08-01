package com.example.ru_tube.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlayList(
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    val etag: String?, // 5IKG8qe6EBtp67wC5Ra_Brt0DxY
    val items: List<Item>,
    val kind: String?, // youtube#playlistListResponse
    val nextPageToken: String?, // CAUQAA
    val pageInfo: PageInfo?
)