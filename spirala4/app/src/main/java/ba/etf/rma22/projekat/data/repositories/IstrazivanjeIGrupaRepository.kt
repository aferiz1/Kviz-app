package ba.etf.rma22.projekat.data.repositories

import android.annotation.SuppressLint
import android.content.Context
import ba.etf.rma22.projekat.data.ApiAdapter
import ba.etf.rma22.projekat.data.AppDatabase
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.models.Istrazivanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject


/*
IstrazivanjeIGrupaRepository
getIstrazivanja(offset:Int):List<Istrazivanje> - vraća sva istraživanja ili ako je zadan
offset odgovarajući page u rezultatima
getGrupe():List<Grupa> - vraća sve grupe
getGrupeZaIstrazivanje(idIstrazivanja:Int):List<Grupa> - vraća grupe na istraživanju sa id-em idIstrazivanja
upisiUGrupu(idGrupa:Int):Boolean - upisuje studenta u grupu sa id-em idGrupa i vraća true ili vraća
false ako nije moguće upisati studenta
getUpisaneGrupe():List<Grupa> - vraća grupe u kojima je student upisan
 */


@SuppressLint("StaticFieldLeak")
class IstrazivanjeIGrupaRepository {
    companion object{
        private lateinit var context: Context
        fun setContext(_context: Context) {
            context = _context
        }
        suspend fun getIstrazivanja(offset:Int=0):List<Istrazivanje>{
            return withContext(Dispatchers.IO) {
                try{
                    if (offset==0){
                        var istrazivanja = mutableListOf<Istrazivanje>()
                        var i = 1
                        var response = ApiAdapter.retrofit.DajSvaIstrazivanja(i)
                        while(response.isNotEmpty()){
                            for (istrazivanje in response){
                                istrazivanja.add(istrazivanje)
                            }
                            i+=1
                            response = ApiAdapter.retrofit.DajSvaIstrazivanja(i)
                        }
                        writeIstrazivanja(istrazivanja)
                        return@withContext istrazivanja
                    }
                    else {
                        var response = ApiAdapter.retrofit.DajSvaIstrazivanja(offset)
                        writeIstrazivanja(response)
                        return@withContext response
                    }
                }
                catch (e:Exception){
                    dajIstrazivanja()
                }
            }
        }

        suspend fun getGrupe():List<Grupa>{
            return withContext(Dispatchers.IO) {
                try{
                    var response = ApiAdapter.retrofit.DajSveGrupe()
                    writeGrupa(response)
                    return@withContext response
                }
                catch(e:Exception){
                    dajGrupe()
                }
            }
        }

        /*suspend fun getGrupeZaIstrazivanje(idIstrazivanja:Int):List<Grupa>{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.DajSveGrupe()
                return@withContext response
            }*/
        suspend fun getUpisaneGrupe():List<Grupa>{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.DajGrupeStudenta(AccountRepository.getHash())
                return@withContext response
            }
        }
        suspend fun upisiUGrupu(idGrupa:Int):Boolean{
            return withContext(Dispatchers.IO) {
                var response = ApiAdapter.retrofit.DodajStudenta(idGrupa, AccountRepository.getHash())
                if(response.message.contains("Ne postoji"))
                    return@withContext false
                return@withContext true
            }
        }

        suspend fun dajGrupe() : List<Grupa> {
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(IstrazivanjeIGrupaRepository.context)
                    var grupe = db!!.grupaDao().dajSveGrupe()
                    return@withContext grupe
                }
                catch(e:Exception){
                    return@withContext emptyList<Grupa>()
                }

            }
        }

        suspend fun dajIstrazivanja() : List<Istrazivanje> {
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(IstrazivanjeIGrupaRepository.context)
                    var grupe = db!!.grupaDao().dajSvaIstrazivanja()
                    return@withContext grupe
                }
                catch(e:Exception){
                    return@withContext emptyList<Istrazivanje>()
                }

            }
        }
        suspend fun writeGrupa(grupe:List<Grupa>) : String?{
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(IstrazivanjeIGrupaRepository.context)
                    db!!.grupaDao().insertGrupe(grupe)
                    return@withContext "success"
                }
                catch(error:Exception){
                    return@withContext null
                }
            }
        }

        suspend fun writeIstrazivanja(istrazivanja:List<Istrazivanje>) : String?{
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(IstrazivanjeIGrupaRepository.context)
                    db!!.grupaDao().insertIstrazivanja(istrazivanja)
                    return@withContext "success"
                }
                catch(error:Exception){
                    return@withContext null
                }
            }
        }
    }
}