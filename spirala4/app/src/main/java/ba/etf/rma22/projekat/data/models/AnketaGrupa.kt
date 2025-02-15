package ba.etf.rma22.projekat.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class AnketaGrupa(
    @PrimaryKey @SerializedName("id") var id: Int,
    @ColumnInfo (name ="naziv") @SerializedName("naziv") var naziv: String,
    @ColumnInfo (name="datumKraj") @SerializedName("datumKraj")  var datumKraj: String,
    @ColumnInfo (name="datumPocetak") @SerializedName("datumPocetak")  var datumPocetak: String,
    @ColumnInfo(name="trajanje") @SerializedName("trajanje")   var trajanje: Int,
    @ColumnInfo(name="createdAt") @SerializedName("createdAt")  var createdAt: String,
    @ColumnInfo(name="updatedAt") @SerializedName("updatedAt")   var updatedAt: String,
)
