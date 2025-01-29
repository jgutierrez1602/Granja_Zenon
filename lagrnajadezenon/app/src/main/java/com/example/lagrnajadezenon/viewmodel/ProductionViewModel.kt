package com.example.lagrnajadezenon.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.lagrnajadezenon.data.AppDatabase
import com.example.lagrnajadezenon.data.ProductionRecord
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProductionViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)
    private val dao = db.productionDao()

    val allRecords: Flow<List<ProductionRecord>> = dao.getAllRecords()

//    init {
//        val dbFile = application.getDatabasePath("production_database")
//        Log.d("RoomDB", "Ruta de la BD: ${dbFile.absolutePath}, Existe: ${dbFile.exists()}")
//    }



    fun insertRecord(record: ProductionRecord) {
        viewModelScope.launch {
            dao.insert(record)
        }
    }

    fun clearRecords() {
        viewModelScope.launch {
            dao.deleteAll()
            Log.d("RoomDB", "Todos los registros eliminados")  // ← Agregado para verificar
        }
    }

}
