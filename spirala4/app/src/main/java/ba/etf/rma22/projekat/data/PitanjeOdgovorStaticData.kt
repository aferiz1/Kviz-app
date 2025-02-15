package ba.etf.rma22.projekat.data

//import ba.etf.rma22.projekat.data.repositories.PitanjeRepository

/*var svaPitanjaOdgovori = mutableListOf<PitanjeOdgovor>(
    PitanjeOdgovor("Pitanje1", null),
    PitanjeOdgovor("Pitanje2", null),
    PitanjeOdgovor("Pitanje3", null),
    PitanjeOdgovor("Pitanje4", null),
    PitanjeOdgovor("Pitanje5", null),
    PitanjeOdgovor("Pitanje6", null),
    PitanjeOdgovor("Pitanje7", null),
    PitanjeOdgovor("Pitanje8", null),
    PitanjeOdgovor("Pitanje9", null),
    PitanjeOdgovor("Pitanje10", null),
    PitanjeOdgovor("Pitanje11", null),
    PitanjeOdgovor("Pitanje12", null),
    PitanjeOdgovor("Pitanje13", null),
    PitanjeOdgovor("Pitanje14", null),
    PitanjeOdgovor("Pitanje15", null),
    PitanjeOdgovor("Pitanje16", null),
    PitanjeOdgovor("Pitanje17", null),
    PitanjeOdgovor("Pitanje18", null),
    PitanjeOdgovor("Pitanje19", null),
    PitanjeOdgovor("Pitanje20", null),
    PitanjeOdgovor("Pitanje21", null),
    PitanjeOdgovor("Pitanje22", null),
    PitanjeOdgovor("Pitanje23", null),
    PitanjeOdgovor("Pitanje24", null),
    PitanjeOdgovor("Pitanje25", null),
    PitanjeOdgovor("Pitanje26", null),
    PitanjeOdgovor("Pitanje27", null),
    PitanjeOdgovor("Pitanje28", null),
    PitanjeOdgovor("Pitanje29", null),
    PitanjeOdgovor("Pitanje30", null),
    PitanjeOdgovor("Pitanje31", null),
    PitanjeOdgovor("Pitanje32", null),
    PitanjeOdgovor("Pitanje33", null),
    PitanjeOdgovor("Pitanje34", null),
    PitanjeOdgovor("Pitanje35", null),
    PitanjeOdgovor("Pitanje36", null),
    PitanjeOdgovor("Pitanje37", null),
    PitanjeOdgovor("Pitanje38", null),
    PitanjeOdgovor("Pitanje39", null),
    PitanjeOdgovor("Pitanje40", null),
    PitanjeOdgovor("Pitanje41", null),
    PitanjeOdgovor("Pitanje42", null),
    PitanjeOdgovor("Pitanje43", null),
    PitanjeOdgovor("Pitanje44", null),
    PitanjeOdgovor("Pitanje45", null),
    PitanjeOdgovor("Pitanje46", null),
    PitanjeOdgovor("Pitanje47", null),
    PitanjeOdgovor("Pitanje48", null),
    PitanjeOdgovor("Pitanje49", null),
    PitanjeOdgovor("Pitanje50", null),
    PitanjeOdgovor("Pitanje51", null),
    PitanjeOdgovor("Pitanje52", null),
    PitanjeOdgovor("Pitanje53", null),
    PitanjeOdgovor("Pitanje54", null),
    PitanjeOdgovor("Pitanje55", null),
    PitanjeOdgovor("Pitanje56", null),
    PitanjeOdgovor("Pitanje57", null),
    PitanjeOdgovor("Pitanje58", null),
    PitanjeOdgovor("Pitanje59", null),
    PitanjeOdgovor("Pitanje60", null),

)

fun svaPitanjaOdgovor(): List<PitanjeOdgovor> {
    return svaPitanjaOdgovori
}

fun dajOdgovor(pitanje: String):Int{
    val sviOdgovori = svaPitanjaOdgovor()
    var odgovor = ""
    for (po in sviOdgovori){
        if (po.nazivPitanja == pitanje){
            odgovor = po.odgovor.toString()
        }
    }
    var i = -1

    if(odgovor != "null"){

        var svaPitanja = PitanjeRepository.getAllPitanja()

        for (p in svaPitanja){
            if (p.naziv == pitanje){
                for (o in p.opcije){
                    i++
                    if (odgovor == o){
                        break
                    }
                }
                break
            }
        }
    }
    return i
}

fun brojOdgovorenih (listaPitanja: List<Pitanje>): Int{
    var broj = 0

    var pitanjaOdgovori = svaPitanjaOdgovor()
    for (p in listaPitanja){
        for (pO in pitanjaOdgovori){
            if (p.naziv == pO.nazivPitanja && pO.odgovor != null){
                broj++
            }
        }
    }
    return broj
}*/