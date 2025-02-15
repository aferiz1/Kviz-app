import android.annotation.SuppressLint
import android.content.Context
import ba.etf.rma22.projekat.data.AppDatabase
import ba.etf.rma22.projekat.data.models.Account
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*

/*
postaviHash(acHash:String):Boolean - postavlja (lokalno, ne putem web servisa) hash studenta koji
će biti korišten u drugim repozitorijima, vraća true ukoliko je hash postavljen, false inače.
getHash():String - vraća hash studenta koji je postavljen

{"message":"Uspješno ste kreirali account!",
"link":"https://rma22ws.herokuapp.com/account/731ad935-4463-4901-8644-2cae256874c8",
"androidLink":"https://rma22ws.herokuapp.com/androidDone/731ad935-4463-4901-8644-2cae256874c8"}
 */

@SuppressLint("StaticFieldLeak")
class AccountRepository {
    companion object {
        var acHash: String = "731ad935-4463-4901-8644-2cae256874c8"
        private lateinit var context: Context
        fun setContext(_context: Context) {
            context = _context
        }

        fun getHash():String {
            return acHash
        }


        suspend fun postaviHash(accHash: String): Boolean {
            return withContext(Dispatchers.IO) {
                acHash = accHash
                try {
                    //obrisati sve tabele
                    val db = AppDatabase.getInstance(context)
                    GlobalScope.launch(Dispatchers.IO) {
                        db.clearAllTables()
                    }
                    //dodati studenta
                    val account = Account(1,"Alma", accHash)
                    val accDao = AppDatabase.getInstance(context).accountDao()
                    GlobalScope.launch(Dispatchers.IO) {
                        accDao.insertAccount(account)
                    }
                    return@withContext true
                } catch (e: Exception) {
                    return@withContext false
                }
            }
        }
    }
}