package ba.etf.rma22.projekat

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma22.projekat.data.mojeAnkete
import ba.etf.rma22.projekat.view.AnketaListAdapter
import ba.etf.rma22.projekat.viewmodel.AnketaListViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var sveAnkete: RecyclerView
    private lateinit var sveAnketeAdapter: AnketaListAdapter
    private var anketaListViewModel =  AnketaListViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sveAnkete = findViewById(R.id.listaAnketa)
        sveAnkete.layoutManager = GridLayoutManager(this, 2)
        sveAnketeAdapter = AnketaListAdapter(listOf())
        sveAnkete.adapter = sveAnketeAdapter
        val mySpinner = findViewById<Spinner>(R.id.filterAnketa)

        mySpinner.setSelection(1)
        sveAnketeAdapter.updateAnkete(anketaListViewModel.dajSveAnkete())

        mySpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
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

        }
        val buttonClick = findViewById<FloatingActionButton>(R.id.upisDugme)
        buttonClick.setOnClickListener {
            val intent = Intent(this, UpisIstrazivanjeActivity::class.java)
            startActivity(intent)
        }

    }
}