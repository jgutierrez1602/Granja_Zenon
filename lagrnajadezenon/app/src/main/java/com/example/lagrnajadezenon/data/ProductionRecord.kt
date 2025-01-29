package com.example.lagrnajadezenon.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "production_records")
data class ProductionRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: String, // Fecha de registro
    val eggsCollected: Int // Cantidad de huevos recogidos
)