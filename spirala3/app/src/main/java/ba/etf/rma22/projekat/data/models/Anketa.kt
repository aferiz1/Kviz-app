package ba.etf.rma22.projekat.data.models

import com.google.gson.annotations.SerializedName

data class Anketa(
    @SerializedName("id") var id: Int,
    @SerializedName("naziv") var naziv: String,
    @SerializedName("datumPocetak")  var datumPocetak: Date,
    @SerializedName("datumKraj")  var datumKraj: Date,
    @SerializedName("trajanje")   var trajanje: Int,
    @SerializedName("createdAt")  var createdAt: Date,
    @SerializedName("updatedAt")   var updatedAt: Int,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Anketa

        if (id != other.id) return false

        return true
    }


}