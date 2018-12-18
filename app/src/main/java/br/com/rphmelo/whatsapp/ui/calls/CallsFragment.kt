package br.com.rphmelo.whatsapp.ui.calls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.rphmelo.whatsappcopy.R
import br.com.rphmelo.whatsapp.ui.base.BaseFragment

class CallsFragment : BaseFragment() {
    override fun getTitle(): Int {
        return R.string.tab_calls
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }
}