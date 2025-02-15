package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.ApiAdapter
import ba.etf.rma22.projekat.data.models.Odgovor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*
OdgovorRepository
getOdgovoriAnketa(idAnkete:Int):List<Odgovor> - vraća listu odgovora za anketu,
praznu listu ako student nije odgovarao ili nije upisan na zadanu anketu
postaviOdgovorAnketa(idAnketaTaken:Int,idPitanje:Int,odgovor:Int):Int - funkcija
postavlja odgovor sa indeksom odgovor na pitanje sa id-em idPitanje u okviru pokušaja sa id-em
idAnketaTaken. Funkcija vraća progres (0-100) na anketi nakon odgovora ili -1 ukoliko ima neka greška u zahtjevu
*/

object OdgovorRepository {
    suspend fun getOdgovoriAnketa(idAnkete:Int):List<Odgovor> {
        return withContext(Dispatchers.IO) {
            var response =
                ApiAdapter.retrofit.DajListuOdgovora(AccountRepository.getHash(), idAnkete)
            return@withContext response
        }
    }
}