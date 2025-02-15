package ba.etf.rma22.projekat.viewmodel

import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.data.repositories.PitanjeRepository


class PitanjeViewModel {
    fun dajSvaPitanja() : List<Pitanje>{
        return PitanjeRepository.getAllPitanja()
    }
}