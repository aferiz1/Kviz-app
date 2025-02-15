package ba.etf.rma22.projekat.data

import androidx.room.*
import ba.etf.rma22.projekat.data.models.Account

@Dao
interface AccountDao {
    @Query("SELECT * FROM account")
    fun getAll(): List<Account>

    @Query("SELECT * FROM account WHERE id = :idAcc")
    fun getAccount(idAcc : Int): Account

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAccount(account: Account)
}