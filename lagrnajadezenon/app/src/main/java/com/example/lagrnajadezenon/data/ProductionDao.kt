package com.example.lagrnajadezenon.data

import androidx.room.*

@Dao
interface ProductionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: ProductionRecord)

    @Query("SELECT * FROM production_records ORDER BY date DESC")
    fun getAllRecords(): kotlinx.coroutines.flow.Flow<List<ProductionRecord>>

    @Query("DELETE FROM production_records")
    suspend fun deleteAll()
}
