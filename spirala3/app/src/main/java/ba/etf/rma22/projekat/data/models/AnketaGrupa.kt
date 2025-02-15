package ba.etf.rma22.projekat.data.models

import com.google.gson.annotations.SerializedName

data class AnketaGrupa(
    @SerializedName("id") var id: Int,
    @SerializedName("naziv") var naziv: String,
    @SerializedName("datumPocetak")  var datumPocetak: Date,
    @SerializedName("datumKraj")  var datumKraj: Date,
    @SerializedName("trajanje")   var trajanje: Int,
    @SerializedName("createdAt")  var createdAt: Date,
    @SerializedName("updatedAt")   var updatedAt: Int,
    @SerializedName("AnketaiGrupe") var AnketaiGrupe: AnketaIGrupa
)