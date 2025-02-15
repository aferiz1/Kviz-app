package ba.etf.rma22.projekat.viewmodel

import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.data.models.PitanjeOdgovor
import ba.etf.rma22.projekat.data.repositories.PitanjeOdgovorRepository

class PitanjeOdgovorViewModel {
    fun dajSvaPitanjaIOdgovore():List<PitanjeOdgovor>{
        return PitanjeOdgovorRepository.dajSvaPitanjaOdgovor()
    }
    fun dajIndeksOdgovora(pitanje:String) : Int{
        return PitanjeOdgovorRepository.dajIndOdgovora(pitanje)
    }
    fun dajBrojOdgovorenihPitanja(pitanja:List<Pitanje>):Int{
        return PitanjeOdgovorRepository.dajBrojOdgovorenih(pitanja)
    }
}