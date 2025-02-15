package ba.etf.rma22.projekat.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
data class OdgovorAnketa (
    @PrimaryKey @SerializedName("odgovor") var id: Int,
    @ColumnInfo(name="pitanje") @SerializedName("pitanje") var pitanje: Int,
    @ColumnInfo(name="progres") @SerializedName("progres") var progres: Int,
)