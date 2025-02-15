/*
postaviHash(acHash:String):Boolean - postavlja (lokalno, ne putem web servisa) hash studenta koji
će biti korišten u drugim repozitorijima, vraća true ukoliko je hash postavljen, false inače.
getHash():String - vraća hash studenta koji je postavljen

{"message":"Uspješno ste kreirali account!",
"link":"https://rma22ws.herokuapp.com/account/731ad935-4463-4901-8644-2cae256874c8",
"androidLink":"https://rma22ws.herokuapp.com/androidDone/731ad935-4463-4901-8644-2cae256874c8"}
 */
class AccountRepository {
    companion object {
        var acHash: String = "731ad935-4463-4901-8644-2cae256874c8"

        fun postaviHash(acHash: String): Boolean {
            this.acHash = acHash
            if (acHash != null) return true
            return false
        }
        fun getHash():String {
            return acHash
        }
    }
}