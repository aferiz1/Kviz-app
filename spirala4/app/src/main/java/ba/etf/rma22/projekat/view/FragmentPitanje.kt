package ba.etf.rma22.projekat.view

/*import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.core.view.size
import androidx.fragment.app.Fragment
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.viewmodel.PitanjeOdgovorViewModel
import ba.etf.rma22.projekat.viewmodel.PitanjeViewModel


class FragmentPitanje(pitanje: Pitanje) : Fragment() {
    private var pitanje:Pitanje = pitanje
    private var pitanjeOdgovorViewModel = PitanjeOdgovorViewModel()
    private var pitanjeViewModel = PitanjeViewModel()
    private var arrayAdapter:ArrayAdapter<String>?=null
    private lateinit var comunicator: Comunicator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_pitanje, container, false)

        val arrayList = ArrayList(pitanje.opcije)
        val tvPitanje = view.findViewById<TextView>(R.id.tekstPitanja)
        tvPitanje.text = pitanje.tekst
        val dugmeZaustavi = view.findViewById<Button>(R.id.dugmeZaustavi)
        val adapter = view?.let { ArrayAdapter<String>(it?.context, android.R.layout.simple_list_item_single_choice, arrayList)}

        val listView: ListView = view.findViewById(R.id.odgovoriLista)
        listView.setAdapter(adapter)
        listView?.choiceMode= ListView.CHOICE_MODE_SINGLE
        if (pitanjeOdgovorViewModel.dajIndeksOdgovora(pitanje.naziv) != -1) {
            listView.setItemChecked(pitanjeOdgovorViewModel.dajIndeksOdgovora(pitanje.naziv), true)
        }
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            for (p in pitanjeOdgovorViewModel.dajSvaPitanjaIOdgovore()){
                if (p.nazivPitanja == pitanje.naziv){
                    p.odgovor = parent.getItemAtPosition(position).toString()
                }
            }
            var i = 0
            while (i < parent.size){
                (parent[i] as TextView).setTextColor(Color.parseColor("#FFFFFF"))
                i++
            }
            (view as TextView).setTextColor(Color.parseColor("#0000FF"))
        }
        comunicator = activity as Comunicator
        dugmeZaustavi.setOnClickListener{
            comunicator.zaustaviAnketu()
        }

        return view
    }

    companion object {

    }


}*/