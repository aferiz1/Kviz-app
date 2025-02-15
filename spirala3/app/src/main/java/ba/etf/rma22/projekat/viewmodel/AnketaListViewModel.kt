package ba.etf.rma22.projekat.viewmodel

//import ba.etf.rma22.projekat.data.dajPosljednjuAnketu
//import ba.etf.rma22.projekat.data.dodajAnketu
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class AnketaListViewModel() {

    val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun dajAnkete( onSuccess: (ankete: List<Anketa>) -> Unit,
                     onError: () -> Unit){
        // Create a new coroutine on the UI thread
        scope.launch{
            // Make the network call and suspend execution until it finishes
            val result = AnketaRepository.getAll()

            // Display result of the network request to the user
            when (result) {
                is List<Anketa> -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }

}

/*class AnketaListViewModel {
    fun dajSveMojeAnkete():List<Anketa>{
        return AnketaRepository.getMyAnkete()
    }
    fun dajSveAnkete():List<Anketa>{
        return AnketaRepository.getAll()
    }
    fun dajUradjene():List<Anketa>{
        return AnketaRepository.getDone()
    }
   fun dajBuduce():List<Anketa>{
        return AnketaRepository.getFuture()
    }
    fun dajNeuradjene():List<Anketa>{
        return AnketaRepository.getNotTaken()
    }
    fun dajPosljednju(): Anketa{
        return AnketaRepository.getLastOne()
    }
    fun dodajAnketu(anketa: Anketa){
        return AnketaRepository.addAnketu(anketa)
    }

}*/