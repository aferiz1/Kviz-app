package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.dajPitanja
import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.data.svaPitanja

object PitanjeAnketaRepository {

    fun getPitanja(nazivAnkete: String, nazivIstrazivanja: String): List<Pitanje>{
        return dajPitanja(nazivAnkete, nazivIstrazivanja)
    }

    fun allPitanja():List<Pitanje>{
        return svaPitanja()
    }
}