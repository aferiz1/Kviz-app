package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.*
import ba.etf.rma22.projekat.data.models.Anketa

object AnketaRepository {
    fun getMyAnkete()  : List<Anketa> {
        return dajMojeAnkete()
    }
    fun getAll()  : List<Anketa> {
        return sveAnkete()
    }
    fun getDone()  : List<Anketa> {
        return dajUradjene()
    }
    fun getFuture()  : List<Anketa> {
        return dajBuduce()
    }
    fun getNotTaken()  : List<Anketa> {
        return dajNeuradjene()
    }
    fun getLastOne(): Anketa{
        return dajPosljednjuAnketu()
    }
    fun addAnketu(anketa: Anketa){
        return dodajAnketu(anketa)
    }

}

