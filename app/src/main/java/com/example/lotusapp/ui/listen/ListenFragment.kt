package com.example.lotusapp.ui.listen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lotusapp.R

class ListenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root: View = inflater.inflate(R.layout.fragment_listen,container,false)

        return root
    }
}