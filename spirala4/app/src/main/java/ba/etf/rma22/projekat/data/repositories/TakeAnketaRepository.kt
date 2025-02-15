package ba.etf.rma22.projekat.data.repositories

import android.content.Context
import ba.etf.rma22.projekat.data.ApiAdapter
import ba.etf.rma22.projekat.data.AppDatabase
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.AnketaTaken
import ba.etf.rma22.projekat.data.models.Istrazivanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/*
zapocniAnketu(idAnkete:Int):AnketaTaken - kreira pokušaj za anketu, vraća kreirani pokušaj ili null u slučaju greške
getPoceteAnkete():List<AnketaTaken> - vraća listu pokušaja ili null ukoliko student nema niti jednu započetu anketu

 */
class TakeAnketaRepository {
    companion object{
        private lateinit var context: Context
        fun setContext(_context: Context) {
            context = _context
        }
        suspend fun getPoceteAnkete():List<AnketaTaken>?{
            return withContext(Dispatchers.IO) {
                try{
                    var response = ApiAdapter.retrofit.DajListuZapocetihAnketa(AccountRepository.getHash())
                    if (response.size != 0) {
                        writePocete(response)
                        return@withContext response
                    }
                    return@withContext null
                }
                catch(e:Exception){
                    dajPocete()
                }
            }
        }

        suspend fun zapocniAnketu(idAnkete:Int):AnketaTaken{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.ZapocniAnketu(AccountRepository.getHash(),idAnkete)
                return@withContext response
            }
        }

        suspend fun dajPocete() : List<AnketaTaken> {
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(TakeAnketaRepository.context)
                    var ankete = db!!.takeAnketaDao().dajZapocete()
                    return@withContext ankete
                }
                catch(e:Exception){
                    return@withContext emptyList<AnketaTaken>()
                }

            }
        }
        suspend fun writePocete(zapocete:List<AnketaTaken>) : String?{
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(TakeAnketaRepository.context)
                    db!!.takeAnketaDao().insertZapocete(zapocete)
                    return@withContext "success"
                }
                catch(error:Exception){
                    return@withContext null
                }
            }
        }


    }

}