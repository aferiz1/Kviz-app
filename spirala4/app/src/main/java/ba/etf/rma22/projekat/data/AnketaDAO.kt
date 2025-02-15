package ba.etf.rma22.projekat.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ba.etf.rma22.projekat.data.models.Anketa

@Dao
interface AnketaDAO {
    @Query("SELECT * FROM anketa")
    suspend fun getAll(): List<Anketa>
    @Insert
    suspend fun insertAll(ankete: List<Anketa>)
}