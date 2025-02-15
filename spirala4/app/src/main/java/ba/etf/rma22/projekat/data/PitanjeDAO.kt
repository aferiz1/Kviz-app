package ba.etf.rma22.projekat.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Pitanje

@Dao
interface PitanjeDAO {
    @Query("SELECT * FROM pitanje")
    suspend fun dajPitanja(): List<Pitanje>
    @Insert
    suspend fun insertPitanja(ankete: List<Pitanje>)

}