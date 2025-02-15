package ba.etf.rma22.projekat.data.models

import com.google.gson.annotations.SerializedName

/*
naziv: String - jedinstveni naziv pitanja u okviru ankete u kojoj se nalazi
tekst: String - tekst pitanja
opcije: List<String> - lista ponuđenih odgovora

 */
class Pitanje (
    @SerializedName("id") var id: Int,
    @SerializedName("naziv") var naziv:String,
    @SerializedName("tekstPitanja")  var tekstPitanja: String,
    @SerializedName("opcije")  var opcije: List<String>,
){}