import ba.etf.rma22.projekat.data.ApiAdapter
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Pitanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object PitanjeAnketaRepository {

    suspend fun getPitanja(id:Int):List<Pitanje>{
        return withContext(Dispatchers.IO) {
                var pitanja = mutableListOf<Pitanje>()
                var response = ApiAdapter.retrofit.DajPitanjaZaAnketu(id)
                for (pitanje in response){
                    pitanja.add(pitanje)
                }
                return@withContext pitanja
        }
    }

}