package ba.etf.rma22.projekat.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

/*
naziv: String - jedinstveni naziv pitanja u okviru ankete u kojoj se nalazi
tekst: String - tekst pitanja
opcije: List<String> - lista ponuđenih odgovora

 */

@TypeConverters(Converter::class)
@Entity
class Pitanje (
    @PrimaryKey @SerializedName("id") var id: Int,
    @ColumnInfo(name="naziv") @SerializedName("naziv") var naziv:String,
    @ColumnInfo(name="tekstPitanja") @SerializedName("tekstPitanja")  var tekstPitanja: String,
    @ColumnInfo(name="opcije") @SerializedName("opcije")  var opcije: List<String>,
){}