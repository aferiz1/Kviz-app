package ba.etf.rma22.projekat.viewmodel

import ba.etf.rma22.projekat.data.dajPosljednjuAnketu
import ba.etf.rma22.projekat.data.dodajAnketu
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.repositories.AnketaRepository

class AnketaListViewModel {
    fun dajSveMojeAnkete():List<Anketa>{
        return AnketaRepository.getMyAnkete()
    }
    fun dajSveAnkete():List<Anketa>{
        return AnketaRepository.getAll()
    }
    fun dajUradjene():List<Anketa>{
        return AnketaRepository.getDone()
    }
   fun dajBuduce():List<Anketa>{
        return AnketaRepository.getFuture()
    }
    fun dajNeuradjene():List<Anketa>{
        return AnketaRepository.getNotTaken()
    }
    fun dajPosljednju(): Anketa{
        return AnketaRepository.getLastOne()
    }
    fun dodajAnketu(anketa: Anketa){
        return AnketaRepository.addAnketu(anketa)
    }

}