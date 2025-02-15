package ba.etf.rma22.projekat.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Anketa(
    @PrimaryKey @SerializedName("id") var id: Int,
    @ColumnInfo (name = "naziv")@SerializedName("naziv") var naziv: String,
    @ColumnInfo (name = "datumPocetak") @SerializedName("datumPocetak")  var datumPocetak: String?,
    @ColumnInfo(name="datumKraj") @SerializedName("datumKraj")  var datumKraj: String?,
    @ColumnInfo(name="trajanje") @SerializedName("trajanje")   var trajanje: Int,
    @ColumnInfo(name="createdAt") @SerializedName("createdAt")  var createdAt: String,
    @ColumnInfo(name="updatedAt") @SerializedName("updatedAt")   var updatedAt: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Anketa

        if (id != other.id) return false

        return true
    }


}