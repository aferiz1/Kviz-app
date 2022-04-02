package ba.etf.rma22.projekat.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma22.projekat.R
import ba.etf.rma22.projekat.data.Anketa
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class AnketaListAdapter(
    private var ankete: List<Anketa>
) : RecyclerView.Adapter<AnketaListAdapter.AnketaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnketaViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.element_list, parent, false)
        return AnketaViewHolder(view)
    }
    override fun getItemCount(): Int = ankete.size
    override fun onBindViewHolder(holder: AnketaViewHolder, position: Int) {
        holder.nazivAnkete.text = ankete[position].naziv
        holder.nazivIstrazivanja.text = ankete[position].nazivIstrazivanja

        // datum kraja
        val day = ankete[position].datumKraj.day
        val month = ankete[position].datumKraj.month
        val year = ankete[position].datumKraj.year
        val endDateString = "$day.$month.$year"


        //trenutni datum
        val current = LocalDateTime.now()
        val currentDay = current.dayOfMonth
        val currentMonth = current.monthValue
        val currentYear = current.year
        val currentDateString = "$currentDay.$currentMonth.$currentYear"


        //datum rada
        val dRada = ankete[position].datumRada
        val danRada = ankete[position].datumKraj.day
        val mjesecRada = ankete[position].datumKraj.month
        val godinaRada = ankete[position].datumKraj.year
        val datumRadaString = "$danRada.$mjesecRada.$godinaRada"

        //datum pocetka
        val dPocetka = ankete[position].datumPocetak
        val danPocetka = ankete[position].datumPocetak.day
        val mjesecPocetka = ankete[position].datumPocetak.month
        val godinaPocetka = ankete[position].datumPocetak.year
        val datumPocetkaString = "$danPocetka.$mjesecPocetka.$godinaPocetka"


        val dE = LocalDate.of(year,month,day)
        val dC = LocalDate.of(currentYear,currentMonth,currentDay)
        val dR = LocalDate.of(godinaRada,mjesecRada,danRada)
        val dP= LocalDate.of(godinaPocetka,mjesecPocetka,danPocetka)

        if(dRada != null ){
            holder.anketaAktivnost.setImageResource(R.drawable.plava)
            holder.datumKraja.text = "Anketa urađena: $datumRadaString"
        }
        else if (dE.isBefore(dC) && ankete[position].datumRada == null){
            holder.anketaAktivnost.setImageResource(R.drawable.crvena)
            holder.datumKraja.text = "Anketa zatvorena: $endDateString"
        }
        else if(dPocetka != null && dC.isBefore(dP)){
            holder.anketaAktivnost.setImageResource(R.drawable.zuta)
            holder.datumKraja.text = "Vrijeme aktiviranja: $datumPocetkaString"
        }

        else if(dC.isBefore(dE) && dRada == null ){
            holder.anketaAktivnost.setImageResource(R.drawable.zelena)
            holder.datumKraja.text = "Vrijeme zatvaranja: $endDateString"
        }


    }
    fun updateAnkete(ankete: List<Anketa>) {
        this.ankete = ankete
        notifyDataSetChanged()
    }
    inner class AnketaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val anketaAktivnost: ImageView = itemView.findViewById(R.id.statusImage)
        val nazivAnkete: TextView = itemView.findViewById(R.id.nazivAnkete)
        val nazivIstrazivanja: TextView = itemView.findViewById(R.id.nazivIstrazivanja)
        val progres: ProgressBar = itemView.findViewById(R.id.progresZavrsetka)


        val datumKraja: TextView = itemView.findViewById(R.id.datumKraja)
    }


}