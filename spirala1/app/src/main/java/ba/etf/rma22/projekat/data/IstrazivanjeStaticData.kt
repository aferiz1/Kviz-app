package ba.etf.rma22.projekat.data

import ba.etf.rma22.projekat.data.models.Istrazivanje
import ba.etf.rma22.projekat.data.repositories.AnketaRepository


fun svaIstrazivanja(): List<Istrazivanje> {
    return listOf(
        Istrazivanje("Istrazivanje broj 0", 2),
        Istrazivanje("Istrazivanje broj 1", 2),
        Istrazivanje("Istrazivanje broj 2", 2),
        Istrazivanje("Istrazivanje broj 3", 2),
        Istrazivanje("Istrazivanje broj 4", 2),
        Istrazivanje("Istrazivanje broj 5", 2),
        Istrazivanje("Istrazivanje broj 6", 1),
        Istrazivanje("Istrazivanje broj 7", 3),
        Istrazivanje("Istrazivanje broj 8", 4),
        Istrazivanje("Istrazivanje broj 9", 5),
    )
}

fun istrazivanjaPoGodinama(godina: Int) : List<Istrazivanje> {
    val listaSvih = svaIstrazivanja()
    val istrPoGodinama = mutableListOf<Istrazivanje> ()
    for (istrazivanje in listaSvih) {
        if (istrazivanje.godina == godina)
            istrPoGodinama.add(istrazivanje)
    }
    return istrPoGodinama
}

fun dajUpisana() : List<Istrazivanje> {
    val listaSvihIst = svaIstrazivanja()
    val upisanaIstrazivanja = mutableListOf<Istrazivanje> ()

    val listaMojihAnketa = AnketaRepository.getMyAnkete()

    for (i in listaSvihIst) {
        for (anketa in listaMojihAnketa){
            if (i.naziv == anketa.nazivIstrazivanja) {
                upisanaIstrazivanja.add(i)
            }
        }
    }
    return upisanaIstrazivanja
}

fun listaNeupisanihIstrazivanjaPoGodinama(godina: Int) : List<Istrazivanje>{
    val istrPoGodinama = istrazivanjaPoGodinama(godina)

    val upisIstrazivanja  = dajUpisana()

    val neupisanaIstrazivanja = mutableListOf<Istrazivanje>()
    if (upisIstrazivanja.isEmpty()) return istrPoGodinama
    var imaUS: Boolean
    var ima = false
    for (iPG in istrPoGodinama) {
        imaUS = false
        for (uI in upisIstrazivanja) {
            if (iPG.naziv == uI.naziv) {
                imaUS = true
                break
            }

        }
        if (!imaUS) {
            ima = false
            for (n in neupisanaIstrazivanja) {
                if (n.naziv == iPG.naziv) {
                    ima = true
                    break
                }
            }
        }
        if (!ima && !imaUS) {
            neupisanaIstrazivanja.add(iPG)
        }
    }

    return neupisanaIstrazivanja
}

fun dajGodinuIstrazivanja (istrazivanje: String):Int{
    val listaSvih = svaIstrazivanja()
    for ( i in listaSvih){
        if (i.naziv == istrazivanje){
            return i.godina
        }
    }
    return 0
}


