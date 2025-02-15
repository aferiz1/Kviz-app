package ba.etf.rma22.projekat.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ba.etf.rma22.projekat.data.models.AnketaTaken
import ba.etf.rma22.projekat.data.models.Odgovor
import ba.etf.rma22.projekat.data.models.OdgovorAnketa

@Dao
interface OdgovorDAO {
    @Query("SELECT * FROM odgovor")
    suspend fun dajOdgovore(): List<Odgovor>
    @Insert
    suspend fun insertOdgovori (odgovori: List<Odgovor>)
    @Insert
    suspend fun insertOdgovor (odgovor: Odgovor)
}