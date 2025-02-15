package ba.etf.rma22.projekat.view

/*import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import ba.etf.rma22.projekat.MainActivity
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.mojeAnkete
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.viewmodel.AnketaListViewModel
import ba.etf.rma22.projekat.viewmodel.GrupaListViewModel
import ba.etf.rma22.projekat.viewmodel.IstrazivanjeListViewModel

class FragmentIstrazivanje : Fragment() {
    private var grupaListViewModel =  GrupaListViewModel()
    private var istrazivanjeListViewModel =  IstrazivanjeListViewModel()
    private var anketaListViewModel =  AnketaListViewModel()
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var comunicator: Comunicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_istrazivanje, container, false)

        val sveAnkete : List<Anketa> = AnketaRepository.getAll()
        val spinerZaGodine = view.findViewById<Spinner>(R.id.odabirGodina)
        val spinerZaIstrazivanja = view.findViewById<Spinner>(R.id.odabirIstrazivanja)
        val spinerZaGrupu = view.findViewById<Spinner>(R.id.odabirGrupa)
        val dugmeDodaj = view.findViewById<Button>(R.id.dodajIstrazivanjeDugme)
        var odabranoIstrazivanje : String?=""
        var odabranaGrupa : String? =""
        var popunjenaGodina = false
        var popunjenoIstrazivanje = false
        var popunjenaGrupa = false
        dugmeDodaj.isEnabled = false
        val a = anketaListViewModel.dajPosljednju()
        var g = istrazivanjeListViewModel.dajGodinu(a.nazivIstrazivanja)
        //var g = IstrazivanjeRepository.getYear(a.nazivIstrazivanja)
        comunicator = activity as Comunicator
        spinerZaGodine.setSelection(g)
        spinerZaGodine.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val listaNeupisanihIstrazivanja = istrazivanjeListViewModel.neupisanaIstrazivanja(position)
                //val listaNeupisanihIstrazivanja = IstrazivanjeRepository.istrazivanjaPoGodinamaNeupisana(position)
                val lni = mutableListOf<String>()
                lni.add("-istrazivanje-")
                for (i in listaNeupisanihIstrazivanja){
                    lni.add(i.naziv)
                }
                spinerZaIstrazivanja.setAdapter(null)
                spinerZaIstrazivanja.adapter = view?.let { ArrayAdapter<String>(it?.context, android.R.layout.simple_list_item_1, lni) }
                odabranoIstrazivanje = spinerZaIstrazivanja.getSelectedItem()?.toString()
                odabranaGrupa = spinerZaGrupu.getSelectedItem()?.toString()
                if (position == 0) {
                    popunjenaGodina = false
                    popunjenoIstrazivanje = false
                }
                else{
                    popunjenaGodina = true
                }

                if (popunjenaGodina && popunjenoIstrazivanje && popunjenaGrupa){
                    dugmeDodaj.isEnabled = true
                }
                else{
                    dugmeDodaj.isEnabled = false
                }
                g = position
            }


        }
        spinerZaIstrazivanja?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val lGrupaPoIstrazivanju = grupaListViewModel.dajGrupePoIstrazivanju(spinerZaIstrazivanja.getItemAtPosition(position).toString())
                //val lGrupaPoIstrazivanju = GrupaRepository.getGrupsByIstrazivanje(spinerZaIstrazivanja.getItemAtPosition(position).toString())
                val grupe = mutableListOf<String>()
                grupe.add("-grupe-")
                for (gr in lGrupaPoIstrazivanju){
                    grupe.add(gr.naziv)
                }

                spinerZaGrupu.adapter = view?.context?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1,grupe) }
                odabranoIstrazivanje = spinerZaIstrazivanja.getSelectedItem()?.toString()
                odabranaGrupa = spinerZaGrupu.getSelectedItem()?.toString()
                if (position == 0) {
                    popunjenoIstrazivanje = false
                    popunjenaGrupa = false
                }
                else
                    popunjenoIstrazivanje = true
                if (popunjenaGodina && popunjenoIstrazivanje && popunjenaGrupa){
                    dugmeDodaj.isEnabled = true
                }
                dugmeDodaj.isEnabled = false

            }

        }

        spinerZaGrupu?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val lGrupaPoIstrazivanju = grupaListViewModel.dajGrupePoIstrazivanju(spinerZaIstrazivanja.getItemAtPosition(position).toString())
                //val lGrupaPoIstrazivanju = GrupaRepository.getGrupsByIstrazivanje(spinerZaIstrazivanja.getItemAtPosition(position).toString())
                val grupe = mutableListOf<String>()
                for (gr in lGrupaPoIstrazivanju){
                    grupe.add(gr.naziv)
                }

                //  spinerZaGrupu.adapter = ArrayAdapter<String>(this@UpisIstrazivanjeActivity, android.R.layout.simple_list_item_1,grupe)
                odabranoIstrazivanje = spinerZaIstrazivanja.getSelectedItem()?.toString()
                odabranaGrupa = spinerZaGrupu.getSelectedItem()?.toString()

                if (position == 0) {
                    popunjenaGrupa = false
                }
                else {
                    popunjenaGrupa = true
                }
                if (popunjenaGodina && popunjenoIstrazivanje && popunjenaGrupa){
                    dugmeDodaj.isEnabled = true
                }else {
                    dugmeDodaj.isEnabled = false
                }
            }

        }
        dugmeDodaj.setOnClickListener {
            var g =""
            var i = ""
            for (anketa in sveAnkete){
                if (anketa.nazivIstrazivanja == odabranoIstrazivanje && anketa.nazivGrupe == odabranaGrupa){
                    mojeAnkete +=anketa
                    g = anketa.nazivGrupe
                    i = anketa.nazivIstrazivanja
                }
            }

            var tekst = "Uspješno ste upisani u grupu ${g} istraživanja ${i}!"

            comunicator.proslijediPoruku(tekst)

        }

        return view
    }

    companion object {
        fun newInstance() : FragmentIstrazivanje = FragmentIstrazivanje()
    }

}*/