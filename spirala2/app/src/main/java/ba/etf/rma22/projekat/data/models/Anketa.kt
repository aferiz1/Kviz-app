package ba.etf.rma22.projekat.data.models

data class Anketa(
    val naziv: String,
    val nazivIstrazivanja: String,
    val datumPocetak: Date,
    val datumKraj: Date,
    var datumRada: Date?,
    val trajanje: Int,
    val nazivGrupe: String,
    var progres: Double
)