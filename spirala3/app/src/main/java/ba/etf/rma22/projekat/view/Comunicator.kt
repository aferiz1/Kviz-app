package ba.etf.rma22.projekat.view


import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Pitanje

interface Comunicator {
    fun proslijediPoruku(poruka:String)
    fun proslijediPitanja(pitanja: List<Pitanje>, anketa: Anketa)
    fun zaustaviAnketu()
    fun predajAnketu(poruka:String)

}