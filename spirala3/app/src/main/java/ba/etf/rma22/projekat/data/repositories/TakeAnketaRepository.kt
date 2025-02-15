package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.ApiAdapter
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.AnketaTaken
import ba.etf.rma22.projekat.data.models.Istrazivanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/*
zapocniAnketu(idAnkete:Int):AnketaTaken - kreira pokušaj za anketu, vraća kreirani pokušaj ili null u slučaju greške
getPoceteAnkete():List<AnketaTaken> - vraća listu pokušaja ili null ukoliko student nema niti jednu započetu anketu

 */
object TakeAnketaRepository {

    suspend fun getPoceteAnkete():List<AnketaTaken>{
        return withContext(Dispatchers.IO) {
            var response = ApiAdapter.retrofit.DajListuZapocetihAnketa(AccountRepository.getHash())
            return@withContext response
        }
    }
    suspend fun zapocniAnketu(idAnkete:Int):AnketaTaken{
        return withContext(Dispatchers.IO) {
            var response = ApiAdapter.retrofit.ZapocniAnketu(AccountRepository.getHash(),idAnkete)
            return@withContext response
        }
    }
}