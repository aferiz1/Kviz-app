package ba.etf.rma22.projekat.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ba.etf.rma22.projekat.data.models.AnketaTaken

@Dao
interface TakeAnketaDAO {
    @Query("SELECT * FROM anketataken")
    suspend fun dajZapocete(): List<AnketaTaken>
    @Insert
    suspend fun insertZapocete(ankete: List<AnketaTaken>)
}