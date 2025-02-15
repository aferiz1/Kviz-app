package ba.etf.rma22.projekat.data

import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Date
import java.time.LocalDate
import java.time.LocalDateTime

var mojeAnkete = mutableListOf(
    Anketa("Anketa1","Istrazivanje broj 1",
        Date(10,3,2022),
        Date(10,8,2022),null, 10, "a", 0.14),
    Anketa("Anketa1","Istrazivanje broj 0",
        Date(10,3,2022),
        Date(10,8,2022),Date(11,4,2022), 10, "a", 1.0),
    Anketa("Anketa1","Istrazivanje broj 2",
        Date(10,8,2022),
        Date(10,9,2022),null, 10, "a", 0.0),
    Anketa("Anketa1","Istrazivanje broj 3",
        Date(10,3,2022),
        Date(10,4,2022),null, 10, "a", 0.0),
    Anketa("Anketa1","Istrazivanje broj 9",
        Date(10,3,2022),
        Date(10,8,2022),null, 10, "a", 0.0),
)

var sveAnketeee = listOf(
    Anketa("Anketa1","Istrazivanje broj 0",
        Date(10,3,2022),
        Date(10,8,2022),Date(11,4,2022), 10, "a", 1.0),
    Anketa("Anketa2","Istrazivanje broj 0",
        Date(10,3,2022),
        Date(10,8,2022),Date(11,4,2022), 10, "b", 1.0),
    Anketa("Anketa3","Istrazivanje broj 0",
        Date(10,3,2022),
        Date(10,8,2022),Date(11,4,2022), 10, "c", 1.0),
    //
    //
    Anketa("Anketa1","Istrazivanje broj 1",
        Date(10,3,2022),
        Date(10,8,2022),null, 10, "a", 0.14),
    Anketa("Anketa2","Istrazivanje broj 1",
        Date(10,3,2022),
        Date(10,8,2022),null, 10, "b", 0.5),
    Anketa("Anketa3","Istrazivanje broj 1",
        Date(10,3,2022),
        Date(10,8,2022),null, 10, "c", 0.33),
    //
    //
    Anketa("Anketa1","Istrazivanje broj 2",
        Date(10,8,2022),
        Date(10,9,2022),null, 10, "a", 0.0),
    Anketa("Anketa2","Istrazivanje broj 2",
        Date(7,8,2022),
        Date(10,9,2022),null, 10, "b", 0.0),
    Anketa("Anketa3","Istrazivanje broj 2",
        Date(7,8,2022),
        Date(10,9,2022),null, 10, "c", 0.0),
    //
    //
    Anketa("Anketa1","Istrazivanje broj 3",
        Date(10,3,2022),
        Date(10,4,2022),null, 10, "a", 0.0),
    Anketa("Anketa2","Istrazivanje broj 3",
        Date(10,3,2022),
        Date(10,4,2022),null, 10, "b", 0.0),
    Anketa("Anketa3","Istrazivanje broj 3",
        Date(10,3,2022),
        Date(10,4,2022),null, 10, "c", 0.0),
    //
    //
    Anketa("Anketa1","Istrazivanje broj 4",
        Date(10,3,2022),
        Date(10,4,2022),null, 10, "a", 0.0),
    Anketa("Anketa1","Istrazivanje broj 5",
        Date(10,3,2022),
        Date(10,8,2022),null, 10, "a", 1.0),
    Anketa("Anketa1","Istrazivanje broj 6",
        Date(10,3,2022),
        Date(10,8,2022),Date(11,4,2022), 10, "a", 1.0),
    Anketa("Anketa1","Istrazivanje broj 7",
        Date(10,3,2022),
        Date(10,8,2022),Date(11,4,2022), 10, "a", 1.0),
    Anketa("Anketa1","Istrazivanje broj 8",
        Date(10,3,2022),
        Date(10,8,2022),Date(14,4,2022), 10, "a", 1.0),
    Anketa("Anketa1","Istrazivanje broj 9",
        Date(10,3,2022),
        Date(10,8,2022),null, 10, "a", 0.0),
)

fun sveAnkete(): List<Anketa> {
    return sveAnketeee
}
fun dajMojeAnkete() : List<Anketa>{
    return mojeAnkete
}

fun dajUradjene() : List<Anketa> {
    val listaSvih = mojeAnkete
    val uradjeneAnkete = mutableListOf<Anketa> ()
    for (anketa in listaSvih) {
        if (anketa.datumRada != null){
            uradjeneAnkete.add(anketa)
        }
    }
    return uradjeneAnkete
}

fun dajBuduce() : List<Anketa> {
    val listaSvih = mojeAnkete
    val buduceAnkete = mutableListOf<Anketa>()

    //trenutni datum
    val current = LocalDateTime.now()
    val currentDay = current.dayOfMonth
    val currentMonth = current.monthValue
    val currentYear = current.year
    val dC = LocalDate.of(currentYear,currentMonth,currentDay)


    for (anketa in listaSvih) {
        val danPocetka = anketa.datumPocetak.day
        val mjesecPocetka = anketa.datumPocetak.month
        val godinaPocetka = anketa.datumPocetak.year
        val dP= LocalDate.of(godinaPocetka,mjesecPocetka,danPocetka)
        if (dC.isBefore(dP)){
            buduceAnkete.add(anketa)
        }
    }
    return buduceAnkete
}

fun dajNeuradjene() : List<Anketa> {
    val listaSvih = mojeAnkete
    val neuradjeneAnkete = mutableListOf<Anketa>()

    //trenutni datum
    val current = LocalDateTime.now()
    val currentDay = current.dayOfMonth
    val currentMonth = current.monthValue
    val currentYear = current.year
    val dC = LocalDate.of(currentYear,currentMonth,currentDay)

    for (anketa in listaSvih) {
        //datum kraja
        val day = anketa.datumKraj.day
        val month = anketa.datumKraj.month
        val year = anketa.datumKraj.year
        val dE = LocalDate.of(year,month,day)
        if (dE.isBefore(dC) && anketa.datumRada == null){
            neuradjeneAnkete.add(anketa)
        }
    }
    return neuradjeneAnkete
}

fun dajPosljednjuAnketu():Anketa{
    val listaSvihAnketa = dajMojeAnkete()
    return listaSvihAnketa[listaSvihAnketa.size - 1]
}

fun dodajAnketu(anketa:Anketa){
    mojeAnkete.add(anketa)
}