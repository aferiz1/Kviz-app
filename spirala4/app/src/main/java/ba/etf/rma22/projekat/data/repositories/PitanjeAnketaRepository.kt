import android.content.Context
import ba.etf.rma22.projekat.data.ApiAdapter
import ba.etf.rma22.projekat.data.AppDatabase
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PitanjeAnketaRepository {
    companion object{
        private lateinit var context: Context
        fun setContext(_context: Context) {
            context = _context
        }
        suspend fun getPitanja(id:Int):List<Pitanje>{
            return withContext(Dispatchers.IO) {
                try{
                    var pitanja = mutableListOf<Pitanje>()
                    var response = ApiAdapter.retrofit.DajPitanjaZaAnketu(id)
                    for (pitanje in response){
                        pitanja.add(pitanje)
                    }
                    writePitanja(pitanja)
                    return@withContext pitanja
                }
                catch(e:Exception){
                    dajPitanja()
                }
            }
        }

        suspend fun dajPitanja() : List<Pitanje> {
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(PitanjeAnketaRepository.context)
                    var pitanja = db!!.pitanjeDao().dajPitanja()
                    return@withContext pitanja
                }
                catch(e:Exception){
                    return@withContext emptyList<Pitanje>()
                }
            }
        }

        suspend fun writePitanja(pitanja:List<Pitanje>) : String?{
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(PitanjeAnketaRepository.context)
                    db!!.pitanjeDao().insertPitanja(pitanja)
                    return@withContext "success"
                }
                catch(error:Exception){
                    return@withContext null
                }
            }
        }

    }
}

