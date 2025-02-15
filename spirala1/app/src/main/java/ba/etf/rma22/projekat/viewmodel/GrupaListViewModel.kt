package ba.etf.rma22.projekat.viewmodel

import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.repositories.GrupaRepository

class GrupaListViewModel {
    fun dajSveGrupe() : List<Grupa>{
        return GrupaRepository.getAllGrups()
    }
    fun dajGrupePoIstrazivanju(nazivIstrazivanja:String) : List<Grupa>{
        return  GrupaRepository.getGrupsByIstrazivanje(nazivIstrazivanja)
    }

}