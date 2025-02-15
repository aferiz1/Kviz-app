package ba.etf.rma22.projekat

import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Date
import ba.etf.rma22.projekat.data.models.Grupa
import ba.etf.rma22.projekat.data.repositories.AnketaRepository
import ba.etf.rma22.projekat.data.repositories.GrupaRepository
import ba.etf.rma22.projekat.data.repositories.IstrazivanjeRepository

import org.hamcrest.CoreMatchers.`is` as Is
import org.hamcrest.MatcherAssert.*
import org.hamcrest.Matchers.hasItem
import org.hamcrest.Matchers.not
import org.hamcrest.beans.HasPropertyWithValue.hasProperty
import org.junit.Assert.assertEquals

import org.junit.Test
import java.time.LocalDate
import java.time.LocalDateTime

class RepositoryUnitTest {
    // testiramo sve moje ankete
    @Test
    fun testGetAll(){
        val sveAnkete = AnketaRepository.getAll()
        assertEquals(18,sveAnkete.size)
        assertThat(sveAnkete, hasItem<Anketa>(hasProperty("nazivIstrazivanja", Is("Istrazivanje broj 0"))))
        assertThat(sveAnkete, not(hasItem<Anketa>(hasProperty("godina", Is("6")))))
    }

    @Test
    fun testGetMyAnkete(){
        val sveAnkete = AnketaRepository.getMyAnkete()
        assertEquals(sveAnkete.size,5)
    }

    @Test
    fun testGetFuture(){
        val buduce = AnketaRepository.getFuture()

        val listaMojih = AnketaRepository.getMyAnkete()

        var brojBuducih = 0

        //trenutni datum
        val current = LocalDateTime.now()
        val currentDay = current.dayOfMonth
        val currentMonth = current.monthValue
        val currentYear = current.year
        val dC = LocalDate.of(currentYear,currentMonth,currentDay)


        for (anketa in listaMojih) {
            val danPocetka = anketa.datumPocetak.day
            val mjesecPocetka = anketa.datumPocetak.month
            val godinaPocetka = anketa.datumPocetak.year
            val dP= LocalDate.of(godinaPocetka,mjesecPocetka,danPocetka)
            if (dC.isBefore(dP)){
                brojBuducih++
            }
        }

        assertEquals(buduce.size,brojBuducih)
    }

    @Test
    fun testGetDone(){
        val uradjene = AnketaRepository.getDone()
        val listaMojih = AnketaRepository.getMyAnkete()

        var brojUradjenih = 0


        for (anketa in listaMojih) {
            if (anketa.datumRada != null){
                brojUradjenih++
            }
        }
        assertEquals(uradjene.size,brojUradjenih)
    }

    @Test
    fun testGetNotTaken(){
        val neuraadjene = AnketaRepository.getNotTaken()
        val listaMojih = AnketaRepository.getMyAnkete()

        var brojNeuradjenih = 0

        //trenutni datum
        val current = LocalDateTime.now()
        val currentDay = current.dayOfMonth
        val currentMonth = current.monthValue
        val currentYear = current.year
        val dC = LocalDate.of(currentYear,currentMonth,currentDay)


        for (anketa in listaMojih) {
            //datum kraja
            val day = anketa.datumKraj.day
            val month = anketa.datumKraj.month
            val year = anketa.datumKraj.year
            val dE = LocalDate.of(year,month,day)
            if (dE.isBefore(dC) && anketa.datumRada == null){
                brojNeuradjenih++
            }
        }
        assertEquals(neuraadjene.size,brojNeuradjenih)
    }
    @Test
    fun testGetLastOneAndAddAnket(){
       val nova = Anketa("NovaAnketa1","NovoIstrazivanje",
           Date(10,3,2022), Date(10,8,2022), Date(11,4,2022),
           10, "a", 0.4)
        AnketaRepository.addAnketu(nova)
        val posljednja = AnketaRepository.getLastOne()

        // nakon sto dodamo novu anketu, lista sa svim mojim anketama treba da se poveca za 1
        assertEquals(6,AnketaRepository.getMyAnkete().size)

        // provjeravamo da li je fija getLastOne zaista vratila posljednju
        // tj. anketu koju smo upravo dodali
        assertEquals(nova.naziv,posljednja.naziv)
        assertEquals(nova.nazivIstrazivanja,posljednja.nazivIstrazivanja)

    }

    //--------------------------------------------------
    // testiranje IstrazivanjeRepository
    //--------------------------------------------------

    @Test
    fun testGetAllIstrazivanja(){
        val istrazivanja = IstrazivanjeRepository.getAll()
        assertEquals(istrazivanja.size, 10)
    }

    @Test
    fun testGetIstrazivanjaByGodina(){
        val prva = IstrazivanjeRepository.getIstrazivanjeByGodina(1)
        val druga = IstrazivanjeRepository.getIstrazivanjeByGodina(2)
        val treca = IstrazivanjeRepository.getIstrazivanjeByGodina(3)
        val cetvrta = IstrazivanjeRepository.getIstrazivanjeByGodina(4)
        val peta = IstrazivanjeRepository.getIstrazivanjeByGodina(5)


        assertEquals(prva.size, 1)
        assertEquals(druga.size, 6)
        assertEquals(treca.size, 1)
        assertEquals(cetvrta.size, 1)
        assertEquals(peta.size, 1)
    }

    @Test
    fun testGetUpisana(){
        val upisana = IstrazivanjeRepository.getUpisani()
        val upisaneAnkete = AnketaRepository.getMyAnkete()
        assertEquals(upisana.size, upisaneAnkete.size)
    }

    @Test
    fun testGetNeupisanaIstrazivanjaPoGodinama(){
        val neupisana = IstrazivanjeRepository.istrazivanjaPoGodinamaNeupisana(2)
        val svaIstrazivanja = IstrazivanjeRepository.getIstrazivanjeByGodina(2)
        assertEquals(4+neupisana.size,svaIstrazivanja.size)
    }

    @Test
    fun testGetYear(){
        val godina = IstrazivanjeRepository.getYear("Istrazivanje broj 9")
        assertEquals(5, godina)
    }

    //--------------------------------------------------
    // testiranje GrupaRepository
    //--------------------------------------------------

    @Test
    fun testGetAllGroups(){
        val sveGrupe = GrupaRepository.getAllGrups()
        assertEquals(18, sveGrupe.size)
    }

    @Test
    fun testGetGrupsByIstrazivanje(){
        val grupe = GrupaRepository.getGrupsByIstrazivanje("Istrazivanje broj 0")
        assertEquals(3, grupe.size)
        assertThat(grupe, hasItem<Grupa>(hasProperty("naziv", Is("a"))))
        assertThat(grupe, hasItem<Grupa>(hasProperty("naziv", Is("b"))))
        assertThat(grupe, hasItem<Grupa>(hasProperty("naziv", Is("c"))))

    }

}