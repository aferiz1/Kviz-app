package ba.etf.rma22.projekat.data.models

import com.google.gson.annotations.SerializedName

class AnketaTaken (
    @SerializedName("id") var id: Int,
    @SerializedName("student") var student:String,
    @SerializedName("progres")  var progres: Number,
    @SerializedName("datumRada")  var datumRada: Date,
)