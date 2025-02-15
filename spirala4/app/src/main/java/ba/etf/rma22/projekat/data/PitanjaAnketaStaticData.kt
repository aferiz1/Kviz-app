package ba.etf.rma22.projekat.data

import ba.etf.rma22.projekat.data.models.*
//import ba.etf.rma22.projekat.data.repositories.PitanjeRepository

/*
naziv: String - jedinstveni naziv pitanja u okviru ankete u kojoj se nalazi
tekst: String - tekst pitanja
opcije: List<String> - lista ponuđenih odgovora

 */
/*fun svaPitanjaAnkete(): List<PitanjeAnketa> {
    return listOf(
        PitanjeAnketa("Pitanje1", "Anketa1", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje2", "Anketa1", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje3", "Anketa1", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje4", "Anketa1", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje5", "Anketa1", "Istrazivanje broj 0"),
        //
        //
        PitanjeAnketa("Pitanje6", "Anketa2", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje7", "Anketa2", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje8", "Anketa2", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje9", "Anketa2", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje10", "Anketa2", "Istrazivanje broj 0"),
        //
        //
        PitanjeAnketa("Pitanje11", "Anketa3", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje12", "Anketa3", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje13", "Anketa3", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje14", "Anketa3", "Istrazivanje broj 0"),
        PitanjeAnketa("Pitanje15", "Anketa3", "Istrazivanje broj 0"),
        //
        //
        PitanjeAnketa("Pitanje16", "Anketa1", "Istrazivanje broj 1"),
        PitanjeAnketa("Pitanje17", "Anketa1", "Istrazivanje broj 1"),
        //
        //
        PitanjeAnketa("Pitanje18", "Anketa2", "Istrazivanje broj 1"),
        PitanjeAnketa("Pitanje19", "Anketa2", "Istrazivanje broj 1"),
        //
        //
        PitanjeAnketa("Pitanje20", "Anketa3", "Istrazivanje broj 1"),
        PitanjeAnketa("Pitanje21", "Anketa3", "Istrazivanje broj 1"),
        //
        //
        PitanjeAnketa("Pitanje22", "Anketa1", "Istrazivanje broj 2"),
        PitanjeAnketa("Pitanje23", "Anketa1", "Istrazivanje broj 2"),
        //
        //
        PitanjeAnketa("Pitanje24", "Anketa2", "Istrazivanje broj 2"),
        PitanjeAnketa("Pitanje25", "Anketa2", "Istrazivanje broj 2"),
        //
        //
        PitanjeAnketa("Pitanje26", "Anketa3", "Istrazivanje broj 2"),
        PitanjeAnketa("Pitanje27", "Anketa3", "Istrazivanje broj 2"),
        //
        //
        PitanjeAnketa("Pitanje28", "Anketa1", "Istrazivanje broj 3"),
        PitanjeAnketa("Pitanje29", "Anketa1", "Istrazivanje broj 3"),
        //
        //
        PitanjeAnketa("Pitanje30", "Anketa2", "Istrazivanje broj 3"),
        PitanjeAnketa("Pitanje31", "Anketa2", "Istrazivanje broj 3"),
        //
        //
        PitanjeAnketa("Pitanje32", "Anketa3", "Istrazivanje broj 3"),
        PitanjeAnketa("Pitanje33", "Anketa3", "Istrazivanje broj 3"),
        //
        //
        PitanjeAnketa("Pitanje34", "Anketa1", "Istrazivanje broj 4"),
        PitanjeAnketa("Pitanje35", "Anketa1", "Istrazivanje broj 4"),
        //
        //
        PitanjeAnketa("Pitanje36", "Anketa2", "Istrazivanje broj 4"),
        PitanjeAnketa("Pitanje37", "Anketa2", "Istrazivanje broj 4"),
        //
        //
        PitanjeAnketa("Pitanje38", "Anketa3", "Istrazivanje broj 4"),
        PitanjeAnketa("Pitanje39", "Anketa3", "Istrazivanje broj 4"),
        //
        //
        PitanjeAnketa("Pitanje40", "Anketa1", "Istrazivanje broj 5"),
        PitanjeAnketa("Pitanje41", "Anketa1", "Istrazivanje broj 5"),
        //
        //
        PitanjeAnketa("Pitanje42", "Anketa1", "Istrazivanje broj 6"),
        PitanjeAnketa("Pitanje43", "Anketa1", "Istrazivanje broj 6"),
        //
        //
        PitanjeAnketa("Pitanje44", "Anketa1", "Istrazivanje broj 7"),
        PitanjeAnketa("Pitanje45", "Anketa1", "Istrazivanje broj 7"),
        //
        //
        PitanjeAnketa("Pitanje46", "Anketa1", "Istrazivanje broj 8"),
        PitanjeAnketa("Pitanje47", "Anketa1", "Istrazivanje broj 8"),
        //
        //
        PitanjeAnketa("Pitanje48", "Anketa1", "Istrazivanje broj 9"),
        PitanjeAnketa("Pitanje49", "Anketa1", "Istrazivanje broj 9"),
        //
        //




    )
}

fun dajPitanja(anketa:String, istrazivanje: String):List<Pitanje>{
    val listaPitanjeAnketa = svaPitanjaAnkete()
    var listaNazivaPitanja = mutableListOf<String> ()
    for (pa in listaPitanjeAnketa){
        if (pa.anketa == anketa && pa.istrazivanje == istrazivanje){
            listaNazivaPitanja.add(pa.naziv)
        }
    }
    val pitanja = PitanjeRepository.getAllPitanja()
    val listaPitanja = mutableListOf<Pitanje> ()
    for (naziv in listaNazivaPitanja){
        for (pitanje in pitanja) {
            if (naziv == pitanje.naziv){
                listaPitanja.add(pitanje)
            }
        }
    }
    return  listaPitanja
}*/