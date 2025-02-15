package ba.etf.rma22.projekat.view

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.viewmodel.AnketaListViewModel
import java.time.LocalDateTime


class FragmentAnkete : Fragment() {
    private lateinit var sveAnkete: RecyclerView
    private lateinit var sveAnketeAdapter: AnketaListAdapter
    private var anketaListViewModel =  AnketaListViewModel()
    private lateinit var comunicator: Comunicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_ankete, container, false)
        anketaListViewModel.dajAnkete( onSuccess = ::onSuccess, onError = ::onError)
        sveAnkete = view.findViewById(R.id.listaAnketa)
        sveAnkete.layoutManager = GridLayoutManager(activity, 2)
        sveAnketeAdapter = AnketaListAdapter(arrayListOf()) { }
        sveAnketeAdapter = AnketaListAdapter(listOf()){ anketa ->

            //trenutni datum
            val current = LocalDateTime.now()
            val currentDay = current.dayOfMonth
            val currentMonth = current.monthValue
            val currentYear = current.year


            /*//datum pocetka
            val dPocetka = anketa.datumPocetak
            val danPocetka = anketa.datumPocetak.day
            val mjesecPocetka = anketa.datumPocetak.month
            val godinaPocetka = anketa.datumPocetak.year


            val dC = LocalDate.of(currentYear,currentMonth,currentDay)
            val dP= LocalDate.of(godinaPocetka,mjesecPocetka,danPocetka)



            if (daLiJeKorisnikUpisan(anketa) && !dC.isBefore(dP))
                otvoriPitanja(anketa)*/
        }
        sveAnkete.adapter = sveAnketeAdapter
        val mySpinner = view.findViewById<Spinner>(R.id.filterAnketa)

         mySpinner.setSelection(1)
            anketaListViewModel.dajAnkete( onSuccess = ::onSuccess, onError = ::onError)
        //sveAnketeAdapter.updateAnkete(anketaListViewModel.dajSveAnkete())

       // comunicator = activity as Comunicator

        mySpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        anketaListViewModel.dajMojeAnkete( onSuccess = ::onSuccess, onError = ::onError)
                    }
                    2 -> {
                        anketaListViewModel.dajUradjene( onSuccess = ::onSuccess, onError = ::onError)
                    }
                    3 -> {
                        anketaListViewModel.dajBuduce( onSuccess = ::onSuccess, onError = ::onError)
                    }
                    4 -> {
                        anketaListViewModel.dajNeuradjene( onSuccess = ::onSuccess, onError = ::onError)
                    }
                    else -> {
                        anketaListViewModel.dajAnkete( onSuccess = ::onSuccess, onError = ::onError)
                    }
                }
            }
        }
        return view
    }

    companion object {
        fun newInstance(): FragmentAnkete = FragmentAnkete()
    }



    fun onSuccess(ankete:List<Anketa>){
        sveAnketeAdapter.updateAnkete(ankete)
    }

    fun onError() {
        val toast = Toast.makeText(context, "Search error", Toast.LENGTH_SHORT)
        toast.show()
    }

   /* private fun otvoriPitanja(anketa: Anketa) {
        val listaPitanja = PitanjeAnketaRepository.getPitanja(anketa.naziv,anketa.nazivIstrazivanja)
        comunicator.proslijediPitanja(listaPitanja, anketa)

    }
    private fun daLiJeKorisnikUpisan (anketa:Anketa) : Boolean{
        val sveAnkete = AnketaRepository.getMyAnkete()
        for (a in sveAnkete){
            if (a.naziv == anketa.naziv && a.nazivIstrazivanja == anketa.nazivIstrazivanja){
                return true
            }
        }
        return false
    }*/

}