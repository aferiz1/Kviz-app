package ba.etf.rma22.projekat.data.models
/*
naziv: String - jedinstveni naziv pitanja u okviru ankete u kojoj se nalazi
tekst: String - tekst pitanja
opcije: List<String> - lista ponuđenih odgovora

 */
class Pitanje (
    val naziv:String,
    val tekst:String,
    val opcije: List<String>,
)