package ba.etf.rma22.projekat.data.repositories

import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.data.svaPitanja

object PitanjeRepository {
    fun getAllPitanja():List<Pitanje>{
        return svaPitanja()
    }
}