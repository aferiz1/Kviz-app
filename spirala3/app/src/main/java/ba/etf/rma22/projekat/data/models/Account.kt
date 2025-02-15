package ba.etf.rma22.projekat.data.models

import com.google.gson.annotations.SerializedName

class Account (
    @SerializedName("id") var id: Int,
    @SerializedName("student") var naziv: String,
    @SerializedName("acHash")  var datumPocetka: String,
)