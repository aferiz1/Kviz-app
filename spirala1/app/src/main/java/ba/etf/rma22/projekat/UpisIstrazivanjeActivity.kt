package ba.etf.rma22.projekat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.data.repositories.GrupaRepository
import ba.etf.rma22.projekat.data.repositories.IstrazivanjeRepository
import ba.etf.rma22.projekat.data.mojeAnkete
import ba.etf.rma22.projekat.viewmodel.AnketaListViewModel
import ba.etf.rma22.projekat.viewmodel.GrupaListViewModel
import ba.etf.rma22.projekat.viewmodel.IstrazivanjeListViewModel


class UpisIstrazivanjeActivity : AppCompatActivity() {
    private var grupaListViewModel =  GrupaListViewModel()
    private var istrazivanjeListViewModel =  IstrazivanjeListViewModel()
    private var anketaListViewModel =  AnketaListViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upis_istrazivanje)

        val sveAnkete : List<Anketa> = AnketaRepository.getAll()
        val spinerZaGodine = findViewById<Spinner>(R.id.odabirGodina)
        val spinerZaIstrazivanja = findViewById<Spinner>(R.id.odabirIstrazivanja)
        val spinerZaGrupu = findViewById<Spinner>(R.id.odabirGrupa)
        val dugmeDodaj = findViewById<Button>(R.id.dodajIstrazivanjeDugme)
        var odabranoIstrazivanje : String?=""
        var odabranaGrupa : String? =""
        var popunjenaGodina = false
        var popunjenoIstrazivanje = false
        var popunjenaGrupa = false
        dugmeDodaj.isEnabled = false
        val a = anketaListViewModel.dajPosljednju()
        var g = istrazivanjeListViewModel.dajGodinu(a.nazivIstrazivanja)
        //var g = IstrazivanjeRepository.getYear(a.nazivIstrazivanja)
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
                spinerZaIstrazivanja.adapter = ArrayAdapter<String>(this@UpisIstrazivanjeActivity, android.R.layout.simple_list_item_1, lni)
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

                spinerZaGrupu.adapter = ArrayAdapter<String>(this@UpisIstrazivanjeActivity, android.R.layout.simple_list_item_1,grupe)
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
           for (anketa in sveAnkete){
               if (anketa.nazivIstrazivanja == odabranoIstrazivanje && anketa.nazivGrupe == odabranaGrupa){
                   mojeAnkete+=anketa

               }
           }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}