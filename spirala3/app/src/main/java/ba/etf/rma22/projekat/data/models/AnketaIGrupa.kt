package ba.etf.rma22.projekat.data.models

import com.google.gson.annotations.SerializedName

data class AnketaIGrupa(
    @SerializedName("createdAt")  var createdAt: String,
    @SerializedName("updatedAt")   var updatedAt: String,
    @SerializedName("GrupaId") var GrupaId: Int,
    @SerializedName("AnketumId") var AnketumId: Int,

)
