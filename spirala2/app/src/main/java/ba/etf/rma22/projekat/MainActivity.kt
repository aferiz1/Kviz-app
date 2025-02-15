package ba.etf.rma22.projekat

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import ba.etf.rma22.projekat.data.models.Anketa
import ba.etf.rma22.projekat.data.models.Istrazivanje
import ba.etf.rma22.projekat.data.models.Pitanje
import ba.etf.rma22.projekat.view.*


class MainActivity : AppCompatActivity(), Comunicator{
    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager)

        val fragments: ArrayList<Fragment> = arrayListOf(
            FragmentAnkete(),
            FragmentIstrazivanje()
            )

        viewPager.offscreenPageLimit = 15
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, fragments, lifecycle)
        viewPager.adapter = viewPagerAdapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 0 && fragments[1] is FragmentPoruka)
                    zamijeniFragmentPorukaZaIstrazivanje()

            }


            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(position: Int,
                                        positionOffset: Float,
                                        positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

            }
        })

    }


    private inner class ScreenSlidePagerAdapter(
        val items: ArrayList<Fragment>,
        activity: AppCompatActivity
    ) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int{
            return items.size
        }

        override fun createFragment(position: Int): Fragment{
            return items[position]
        }
    }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_main)

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager)

        val fragments: ArrayList<Fragment> = arrayListOf(
            FragmentAnkete(),
            FragmentIstrazivanje()
        )

        viewPager.offscreenPageLimit = 15
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, fragments, lifecycle)
        viewPager.adapter = viewPagerAdapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 0 && fragments[1] is FragmentPoruka)
                    zamijeniFragmentPorukaZaIstrazivanje()

            }


            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(position: Int,
                                        positionOffset: Float,
                                        positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)

            }
        })

    }

    override fun onPause() {
        super.onPause()
    }

    override fun proslijediPoruku(poruka: String) {
        val bundle = Bundle()
        bundle.putString("message", poruka)
        val fragmentPoruka = FragmentPoruka()
        fragmentPoruka.arguments = bundle
        zamijeniFragmentIstrazivanjeZaPoruka(fragmentPoruka)

    }

    override fun proslijediPitanja(pitanja: List<Pitanje>, anketa: Anketa){
        val fragments: ArrayList<Fragment> = arrayListOf()
        for (p in pitanja){
            val fragmentPitanje = FragmentPitanje(p)
            fragments.add(fragmentPitanje)
        }
        fragments.add(FragmentPredaj(pitanja, anketa))

        var i = 0
        for (f in fragments){
            viewPagerAdapter.add(i,f)
            i++
        }
        viewPagerAdapter.remove(viewPagerAdapter.itemCount-2)
        viewPagerAdapter.remove(viewPagerAdapter.itemCount-1)

    }

    override fun zaustaviAnketu() {
        viewPagerAdapter.add(0,FragmentAnkete())
        viewPagerAdapter.add(1, FragmentIstrazivanje())
        var i = viewPagerAdapter.itemCount-1
        while (i > 1 ){
            viewPagerAdapter.remove(i)
            i--
        }

    }

    override fun predajAnketu(poruka: String) {
        val bundle = Bundle()
        bundle.putString("predaj", poruka)
        val fragmentPoruka = FragmentPoruka()
        fragmentPoruka.arguments = bundle
        viewPagerAdapter.add(0,FragmentAnkete())
        Handler(Looper.getMainLooper()).postDelayed({
            viewPagerAdapter.refreshFragment(1, fragmentPoruka)
        }, 100)
        var i = viewPagerAdapter.itemCount-1
        while (i > 1 ){
            viewPagerAdapter.remove(i)
            i--
        }

    }


    private fun zamijeniFragmentIstrazivanjeZaPoruka(fragement: FragmentPoruka) {
        Handler(Looper.getMainLooper()).postDelayed({
            viewPagerAdapter.refreshFragment(1, fragement)
        }, 100)
        Handler(Looper.getMainLooper()).postDelayed({
            viewPagerAdapter.refreshFragment(0, FragmentAnkete())
        }, 100)
    }

    private fun zamijeniFragmentPorukaZaIstrazivanje() {
        Handler(Looper.getMainLooper()).postDelayed({
            viewPagerAdapter.refreshFragment(1, FragmentIstrazivanje())
        },100)
    }
}


