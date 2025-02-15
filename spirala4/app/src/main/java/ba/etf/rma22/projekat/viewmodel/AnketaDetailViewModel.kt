package ba.etf.rma22.projekat.viewmodel

import android.content.Context
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AnketaDetailViewModel {
    val scope = CoroutineScope(Job() + Dispatchers.Main)
    fun writeDB(context: Context, ankete: List<Anketa>, onSuccess: (anketa: String) -> Unit,
                onError: () -> Unit){
        scope.launch{
            val result = AnketaRepository.writeAnkete(ankete)
            when (result) {
                is String -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }
}