package br.com.rphmelo.whatsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.TextView
import br.com.rphmelo.whatsapp.ui.calls.CallsFragment
import br.com.rphmelo.whatsapp.ui.chats.ChatsFragment
import br.com.rphmelo.whatsapp.ui.main.MainViewPagerAdapter
import br.com.rphmelo.whatsapp.ui.status.StatusFragment
import br.com.rphmelo.whatsappcopy.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var messagesNotReadCounter = intArrayOf(0, 2, 0)

    lateinit var adapter: MainViewPagerAdapter

    val fragments = listOf(ChatsFragment(), StatusFragment(), CallsFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        setupViewPager()
        setupTabIcons()
    }

    private fun setupViewPager() {
        viewpager.offscreenPageLimit = fragments.size

        adapter = MainViewPagerAdapter(supportFragmentManager)

        addFragments()

        viewpager.adapter = adapter

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                viewpager.setCurrentItem(position, false)

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    private fun addFragments() {
        for (fragment in fragments) {
            adapter.addFragment(fragment)
        }
    }

    private fun setupTabIcons() {
        tablayout.setupWithViewPager(viewpager)
        for (i in fragments.indices) {
            tablayout.getTabAt(i)?.customView = configureTabView(
                    getString(fragments[i].getTitle()),
                    messagesNotReadCounter[i]
            )
        }
    }

    private fun configureTabView(title: String, counter: Int): View {
        val view = layoutInflater.inflate(R.layout.custom_tab, null)
        val tvTitle = view.findViewById(R.id.tvTitle) as TextView
        val tvCount = view.findViewById(R.id.tvCount) as TextView

        tvTitle.text = title

        if (counter > 0) {
            tvCount.visibility = View.VISIBLE
            tvCount.text = "${counter}"
        } else
            tvCount.visibility = View.GONE

        return view
    }
}
