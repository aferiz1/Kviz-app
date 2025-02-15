package ba.etf.rma22.projekat.viewmodel

import ba.etf.rma22.projekat.data.*
import ba.etf.rma22.projekat.data.models.Istrazivanje
import ba.etf.rma22.projekat.data.repositories.IstrazivanjeRepository

class IstrazivanjeListViewModel {
    fun dajIstrazivanjaPoGodinama(godina:Int) : List<Istrazivanje>{
        return IstrazivanjeRepository.getIstrazivanjeByGodina(godina)
    }
    fun dajSvaIstrazivanja() : List<Istrazivanje> {
        return IstrazivanjeRepository.getAll()
    }
    fun  dajUpisana() : List<Istrazivanje> {
        return IstrazivanjeRepository.getUpisani()
    }

    fun neupisanaIstrazivanja(godina: Int) : List<Istrazivanje>{
        return IstrazivanjeRepository.istrazivanjaPoGodinamaNeupisana(godina)
    }

    fun dajGodinu(istrazivanje:String):Int{
        return IstrazivanjeRepository.getYear(istrazivanje)
    }
}