package com.jsoftware.zippypos.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userDetails")
data class UserDetails (
    @PrimaryKey(autoGenerate = true)
    val Id: Int
)