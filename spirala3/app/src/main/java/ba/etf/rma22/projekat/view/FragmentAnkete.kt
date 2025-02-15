package ba.etf.rma22.projekat.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        sveAnkete = view.findViewById(R.id.listaAnketa)
        sveAnkete.layoutManager = GridLayoutManager(activity, 2)
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

        anketaListViewModel.dajAnkete( onSuccess = ::onSuccess,
            onError = ::onError)
        mySpinner.setSelection(1)
        //sveAnketeAdapter.updateAnkete(anketaListViewModel.dajSveAnkete())

        comunicator = activity as Comunicator

        /*mySpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        sveAnketeAdapter.updateAnkete(anketaListViewModel.dajSveMojeAnkete())
                    }
                    2 -> {
                        sveAnketeAdapter.updateAnkete(anketaListViewModel.dajUradjene())
                    }
                    3 -> {
                        sveAnketeAdapter.updateAnkete(anketaListViewModel.dajBuduce())
                    }
                    4 -> {
                        sveAnketeAdapter.updateAnkete(anketaListViewModel.dajNeuradjene())
                    }
                    else -> {
                        sveAnketeAdapter.updateAnkete(anketaListViewModel.dajSveAnkete())
                    }
                }
            }

        }*/
        return view
    }

    companion object {
        fun newInstance(): FragmentAnkete = FragmentAnkete()
    }
    fun onSuccess(ankete:List<Anketa>){
        val toast = Toast.makeText(context, "Upcoming movies found", Toast.LENGTH_SHORT)
        toast.show()
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