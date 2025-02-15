package ba.etf.rma22.projekat.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class Grupa (
   @PrimaryKey @SerializedName("id") var id: Int,
   @ColumnInfo(name="naziv") @SerializedName("naziv") var naziv: String,
) {
   override fun equals(other: Any?): Boolean {
      if (this === other) return true
      if (javaClass != other?.javaClass) return false

      other as Grupa

      if (id != other.id) return false

      return true
   }

   override fun hashCode(): Int {
      return id
   }
}