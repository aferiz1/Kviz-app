package ba.etf.rma22.projekat.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Date
import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.viewmodel.AnketaListViewModel
import ba.etf.rma22.projekat.viewmodel.PitanjeOdgovorViewModel
import java.time.LocalDate
import java.time.LocalDateTime


class FragmentPredaj(pitanja:List<Pitanje>, anketa: Anketa) : Fragment() {
    private var pitanja: List<Pitanje> = pitanja
    private var anketa: Anketa = anketa
    private lateinit var textViewProgress: TextView
    private var pitanjeOdgovorViewModel = PitanjeOdgovorViewModel()
    private var anketaListViewModel = AnketaListViewModel()
    private lateinit var comunicator: Comunicator
    private lateinit var dugmePredaj: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_predaj, container, false)

        textViewProgress = view.findViewById<TextView>(R.id.progresTekst)
        updatePostotak()

        for (a in anketaListViewModel.dajSveAnkete()){
            if (a.naziv == anketa.naziv && a.nazivIstrazivanja == anketa.nazivIstrazivanja){
                textViewProgress.text = "${formatProgresa(a.progres).toString()}%"
            }
        }

        dugmePredaj = view.findViewById(R.id.dugmePredaj)


        comunicator = activity as Comunicator


        // datum kraja
        val day = anketa.datumKraj.day
        val month = anketa.datumKraj.month
        val year = anketa.datumKraj.year



        //trenutni datum
        val current = LocalDateTime.now()
        val currentDay = current.dayOfMonth
        val currentMonth = current.monthValue
        val currentYear = current.year

        val dE = LocalDate.of(year,month,day)
        val dC = LocalDate.of(currentYear,currentMonth,currentDay)

        if(!dC.isBefore(dE)){
            dugmePredaj.isEnabled = false
        }


        dugmePredaj.setOnClickListener{
            //trenutni datum
            val current = LocalDateTime.now()
            val currentDay = current.dayOfMonth
            val currentMonth = current.monthValue
            val currentYear = current.year

            for (a in anketaListViewModel.dajSveAnkete()){
                if (a.naziv == anketa.naziv && a.nazivIstrazivanja == anketa.nazivIstrazivanja){
                    a.datumRada = Date(currentDay,currentMonth,currentYear)
                    a.progres = izracunajPostotak()
                }
            }
            for (a in anketaListViewModel.dajSveMojeAnkete()){
                if (a.naziv == anketa.naziv && a.nazivIstrazivanja == anketa.nazivIstrazivanja){
                    a.datumRada = Date(currentDay,currentMonth,currentYear)
                    a.progres = izracunajPostotak()
                }
            }

            val poruka = "Završili ste anketu ${anketa.naziv} u okviru istraživanja ${anketa.nazivIstrazivanja}"
            comunicator.predajAnketu(poruka)

        }

        return view
    }

    override fun onResume() {
        super.onResume()
        izracunajPostotak()
        updatePostotak()
    }

    fun izracunajPostotak(): Double {
        val brojPitanja = pitanja.size.toDouble()
        val brojOdgovorenih = pitanjeOdgovorViewModel.dajBrojOdgovorenihPitanja(pitanja).toDouble()
        val postotak = brojOdgovorenih/brojPitanja
        return postotak
    }

    fun updatePostotak(){
        for (a in anketaListViewModel.dajSveAnkete()){
            if (a.naziv == anketa.naziv && a.nazivIstrazivanja == anketa.nazivIstrazivanja){
                a.progres = izracunajPostotak()
                textViewProgress.text = "${formatProgresa(a.progres).toString()}%"
            }
        }

    }

    fun formatProgresa(p:Double):Int{
        var rez = (100 * p).toInt()
        rez = rez - rez%10
        if ((rez / 10)% 2 == 1) return rez+10
        return rez
    }


    companion object {

    }
}