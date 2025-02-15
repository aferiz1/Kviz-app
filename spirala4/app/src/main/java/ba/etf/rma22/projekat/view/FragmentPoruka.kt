package ba.etf.rma22.projekat.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ba.etf.rma22.projekat.R

class FragmentPoruka() : Fragment() {
    var prikaziPoruku: String? = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_poruka, container, false)
        var textView = view.findViewById<TextView>(R.id.tvPoruka)
        prikaziPoruku = arguments?.getString("message")
        prikaziPoruku = arguments?.getString("predaj")
        textView.text = prikaziPoruku.toString()
        return view
    }


}