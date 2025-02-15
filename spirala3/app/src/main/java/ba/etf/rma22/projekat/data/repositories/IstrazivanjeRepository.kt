package ba.etf.rma22.projekat.data.repositories

/*import ba.etf.rma22.projekat.data.*
import ba.etf.rma22.projekat.data.models.Istrazivanje

object IstrazivanjeRepository {
  /*  getIstrazivanjeByGodina(godina:Int) : List<Istrazivanje> - lista istraživanja na godini
    getAll() : List<Istrazivanje> - lista svih istraživanja
    getUpisani() : List<Istrazivanje> - lista istraživanja na kojima je korisnik upisan*/


  fun getIstrazivanjeByGodina(godina:Int) : List<Istrazivanje>{
      return istrazivanjaPoGodinama(godina)
  }
    fun getAll() : List<Istrazivanje> {
        return svaIstrazivanja()
    }
    fun  getUpisani() : List<Istrazivanje> {
        return dajUpisana()
    }

    fun istrazivanjaPoGodinamaNeupisana(godina: Int) : List<Istrazivanje>{
        return listaNeupisanihIstrazivanjaPoGodinama(godina)
    }

    fun getYear(istrazivanje:String):Int{
        return dajGodinuIstrazivanja(istrazivanje)
    }

}*/