package ba.etf.rma22.projekat.data


fun sveAnkete(): List<Anketa> {
    return listOf(
        Anketa("Anketa1","Istrazivanje broj 1",
            Date(10,3,2022),
            Date(10,7,2022),Date(11,4,2022), 10, "a", 0.2),
        Anketa("Anketa2","Istrazivanje broj 1",
            Date(10,3,2022),
            Date(10,7,2022),null, 10, "a", 0.2),
        Anketa("Anketa3","Istrazivanje broj 1",
            Date(10,4,2022),
            Date(10,7,2022),Date(14,4,2022), 10, "a", 0.2),
        Anketa("Anketa4","Istrazivanje broj 1",
            Date(10,7,2022),
            Date(10,8,2022),null, 10, "a", 0.2),
        Anketa("Anketa5","Istrazivanje broj 1",
            Date(7,3,2022),
            Date(10,3,2022),null, 10, "a", 0.2),
    )
}