package com.jsoftware.zippypos.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jsoftware.zippypos.data.local.entity.UserDetails

@Dao
interface UserDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserDetails)

    @Query("DELETE FROM userDetails WHERE id = :id")
    suspend fun deleteUser(id: Int)
}