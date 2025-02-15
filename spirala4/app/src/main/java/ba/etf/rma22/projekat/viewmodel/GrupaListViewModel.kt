package ba.etf.rma22.projekat.viewmodel

import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.data.repositories.IstrazivanjeIGrupaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

//import ba.etf.rma22.projekat.data.repositories.GrupaRepository

/*class GrupaListViewModel {
    fun dajSveGrupe() : List<Grupa>{
        return GrupaRepository.getAllGrups()
    }
    fun dajGrupePoIstrazivanju(nazivIstrazivanja:String) : List<Grupa>{
        return  GrupaRepository.getGrupsByIstrazivanje(nazivIstrazivanja)
    }

}*/

class GrupaListViewModel() {

    val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun dajGrupe(onSuccess: (grupe: List<Grupa>) -> Unit,
                  onError: () -> Unit){
        // Create a new coroutine on the UI thread
        scope.launch{
            // Make the network call and suspend execution until it finishes
            val result = IstrazivanjeIGrupaRepository.getGrupe()

            // Display result of the network request to the user
            when (result) {
                is List<Grupa> -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }

    fun dajMojeAnkete(onSuccess: (ankete: List<Anketa>) -> Unit,
                      onError: () -> Unit){
        // Create a new coroutine on the UI thread
        scope.launch{
            // Make the network call and suspend execution until it finishes
            val result = AnketaRepository.getUpisane()

            // Display result of the network request to the user
            when (result) {
                is List<Anketa> -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }
    fun dajUradjene(onSuccess: (ankete: List<Anketa>) -> Unit,
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

    fun dajBuduce(onSuccess: (ankete: List<Anketa>) -> Unit,
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

    fun dajNeuradjene(onSuccess: (ankete: List<Anketa>) -> Unit,
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