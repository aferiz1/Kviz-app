package ba.etf.rma22.projekat.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.models.Istrazivanje

@Dao
interface GrupaDAO {
    @Query("SELECT * FROM istrazivanje")
    suspend fun dajSvaIstrazivanja(): List<Istrazivanje>
    @Insert
    suspend fun insertIstrazivanja(istrazivanja: List<Istrazivanje>)
    @Query("SELECT * FROM grupa")
    suspend fun dajSveGrupe(): List<Grupa>
    @Insert
    suspend fun insertGrupe(ankete: List<Grupa>)

}