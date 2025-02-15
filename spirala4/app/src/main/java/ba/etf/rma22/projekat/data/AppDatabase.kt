package ba.etf.rma22.projekat.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ba.etf.rma22.projekat.data.models.*

@Database(entities = arrayOf(Anketa::class, Account::class, AnketaGrupa::class,AnketaTaken::class,Odgovor::class,Pitanje::class, Istrazivanje::class, Grupa::class), version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun anketaDao(): AnketaDAO
    abstract fun grupaDao(): GrupaDAO
    abstract fun pitanjeDao():PitanjeDAO
    abstract fun takeAnketaDao(): TakeAnketaDAO
    abstract fun odgovoriDao(): OdgovorDAO
    abstract fun accountDao(): AccountDao
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = buildRoomDB(context)
                }
            }
            return INSTANCE!!
        }
        fun setInstance(appdb:AppDatabase):Unit{
            INSTANCE=appdb
        }
        private fun buildRoomDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "RMA22DB"
            ).build()
    }
}