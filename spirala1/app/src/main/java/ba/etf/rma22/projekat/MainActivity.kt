package ba.etf.rma22.projekat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma22.projekat.view.AnketaListAdapter
import ba.etf.rma22.projekat.viewmodel.AnketaListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var sveAnkete: RecyclerView
    private lateinit var sveAnketeAdapter: AnketaListAdapter
    private var anketaListViewModel =  AnketaListViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sveAnkete = findViewById(R.id.listaAnketa)
        sveAnkete.layoutManager = GridLayoutManager(this, 2);

        sveAnketeAdapter = AnketaListAdapter(listOf())
        sveAnkete.adapter = sveAnketeAdapter
        sveAnketeAdapter.updateAnkete(anketaListViewModel.dajSveAnkete())


    }
}