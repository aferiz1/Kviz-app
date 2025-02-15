package ba.etf.rma22.projekat.data.repositories

import android.content.Context
import ba.etf.rma22.projekat.data.ApiAdapter
import ba.etf.rma22.projekat.data.AppDatabase
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.AnketaTaken
import ba.etf.rma22.projekat.data.models.Odgovor
import ba.etf.rma22.projekat.data.models.OdgovorAnketa
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

class OdgovorRepository {
    companion object{
        private lateinit var context: Context
            fun setContext(_context: Context) {
            context = _context
        }
        suspend fun getOdgovoriAnketa(idAnkete:Int):List<Odgovor> {
            return withContext(Dispatchers.IO) {
                try{
                    val zapocete = TakeAnketaRepository.getPoceteAnkete()
                    var id = -1
                    if (zapocete != null){
                        for (zapoceta in zapocete){
                            if (zapoceta.AnketumId == idAnkete)
                                id=zapoceta.id
                        }
                    }
                    var response =
                        ApiAdapter.retrofit.DajListuOdgovora(AccountRepository.getHash(), id)
                    if (response.size != 0){
                        writeOdgovori(response)
                        return@withContext response
                    }

                    return@withContext emptyList<Odgovor>()
                }
                catch(e:Exception){
                    dajOdgovore()
                }
            }
        }

        suspend fun postaviOdgovorAnketa(idAnketaTaken:Int,idPitanje:Int,odgovor:Int):Int {
            return withContext(Dispatchers.IO) {
                try{
                    val hashStudenta = AccountRepository.getHash()
                    val odgovori = ApiAdapter.retrofit.DajListuOdgovora(hashStudenta,idAnketaTaken)
                    val poceteAnkete  = ApiAdapter.retrofit.DajListuZapocetihAnketa(hashStudenta)
                    var idAT = 0
                    for (pocetaAnketa in poceteAnkete){
                        if (pocetaAnketa.id == idAnketaTaken)
                            idAT = pocetaAnketa.AnketumId
                    }
                    val pitanja = ApiAdapter.retrofit.DajPitanjaZaAnketu(idAT)
                    var brPitanja = pitanja.size
                    var brOdgovora = odgovori.size
                    var progres = formatProgresa((((brOdgovora+1)/brPitanja.toDouble())*100.00).toInt())
                    val odgovorNaAnketu = OdgovorAnketa(idAnketaTaken,idPitanje,progres)
                    ApiAdapter.retrofit.DodajOdgovor(AccountRepository.getHash(),idAnketaTaken,odgovorNaAnketu)
                    var odg = Odgovor(idPitanje,odgovor)
                    writeOdgovor(odg)
                    return@withContext progres
                }
                catch(e: Exception){
                    return@withContext -1
                }
            }
        }
        fun formatProgresa(p:Int):Int{
            var rez = p
            if ((rez / 10)% 2 == 1) rez+=10
            return rez
        }


        suspend fun dajOdgovore() : List<Odgovor> {
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(OdgovorRepository.context)
                    var ankete = db!!.odgovoriDao().dajOdgovore()
                    return@withContext ankete
                }
                catch(e:Exception){
                    return@withContext emptyList<Odgovor>()
                }

            }
        }
        suspend fun writeOdgovori(odgovori: List<Odgovor>) : String?{
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(OdgovorRepository.context)
                    db!!.odgovoriDao().insertOdgovori(odgovori)
                    return@withContext "success"
                }
                catch(error:Exception){
                    return@withContext null
                }
            }
        }

        suspend fun writeOdgovor(odgovor: Odgovor) : String?{
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(OdgovorRepository.context)
                    db!!.odgovoriDao().insertOdgovor(odgovor)
                    return@withContext "success"
                }
                catch(error:Exception){
                    return@withContext null
                }
            }
        }



    }
}