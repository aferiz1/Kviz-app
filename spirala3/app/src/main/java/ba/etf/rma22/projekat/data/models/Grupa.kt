package ba.etf.rma22.projekat.data.models

import com.google.gson.annotations.SerializedName

class Grupa (
   @SerializedName("id") var id: Int,
   @SerializedName("naziv") var naziv: String,
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