package ba.etf.rma22.projekat.viewmodel

import ba.etf.rma22.projekat.data.Anketa
import ba.etf.rma22.projekat.data.AnketaRepository

class AnketaListViewModel {
    fun dajSveAnkete():List<Anketa>{
        return AnketaRepository.dajSveAnkete();
    }
}