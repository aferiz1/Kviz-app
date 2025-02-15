package ba.etf.rma22.projekat.data.repositories

import android.annotation.SuppressLint
import android.content.Context
import ba.etf.rma22.projekat.data.ApiAdapter
import ba.etf.rma22.projekat.data.AppDatabase
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Istrazivanje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/*
getAll(offset:Int):List<Anketa> - vraća listu svih anketa ili ako je zadan offset odgovarajući page u rezultatima (npr ako je pozvana metoda bez parametra vraćaju se sve ankete, a ako je offset 1 vraća se samo prvih 5)
getById(id:Int):Anketa - vraća jednu anketu koja ima zadani id ili null ako anketa ne postoji
getUpisane():List<Anketa> - vraća listu svih anketa za grupe na kojima je student upisan
 */

@SuppressLint("StaticFieldLeak")
class AnketaRepository {
    companion object {
        var acHash: String = "731ad935-4463-4901-8644-2cae256874c8"
        private lateinit var context: Context
        fun setContext(_context: Context) {
            context = _context
        }
        suspend fun getAll(offset:Int=0):List<Anketa>{
            return withContext(Dispatchers.IO) {
                try{
                    if (offset==0){
                        var ankete = mutableListOf<Anketa>()
                        var i = 1
                        var response = ApiAdapter.retrofit.DajSveAnkete(i)
                        while(response.isNotEmpty()){
                            for (anketa in response){
                                ankete.add(anketa)
                            }
                            i+=1
                            response = ApiAdapter.retrofit.DajSveAnkete(i)
                        }
                        writeAnkete(ankete)
                        return@withContext ankete
                    }
                    else {
                        var response = ApiAdapter.retrofit.DajSveAnkete(offset)
                        return@withContext response
                    }
                }
                catch(e:Exception){
                    getAnkete()
                }
            }
        }

        suspend fun getById(id:Int):Anketa{
            return withContext(Dispatchers.IO){
                var response = ApiAdapter.retrofit.DajAnketu(id)
                return@withContext response
            }
        }

        suspend fun getUpisane():List<Anketa>?{
            return withContext(Dispatchers.IO){
                var grupe = IstrazivanjeIGrupaRepository.getUpisaneGrupe()
                var ankete = mutableListOf<Anketa>()
                for (g in grupe){
                    var response = ApiAdapter.retrofit.DajAnketeZaGrupu(g.id)
                    for (a in response){
                        ankete.add(Anketa(a.id,a.naziv,a.datumPocetak,a.datumKraj,a.trajanje,a.createdAt,a.updatedAt))
                    }
                }
                if (ankete.size == 0) return@withContext null
                return@withContext ankete
            }
        }

        suspend fun getAnkete() : List<Anketa> {
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(context)
                    var ankete = db!!.anketaDao().getAll()
                    return@withContext ankete
                }
                catch(e:Exception){
                    return@withContext emptyList<Anketa>()
                }

            }
        }
        suspend fun writeAnkete(ankete:List<Anketa>) : String?{
            return withContext(Dispatchers.IO) {
                try{
                    var db = AppDatabase.getInstance(context)
                    db!!.anketaDao().insertAll(ankete)
                    return@withContext "success"
                }
                catch(error:Exception){
                    return@withContext null
                }
            }
        }
    }

}

