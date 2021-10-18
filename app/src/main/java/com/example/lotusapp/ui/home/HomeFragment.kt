package com.example.lotusapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.lotusapp.R
import com.example.lotusapp.databinding.FragmentHomeBinding
import com.example.lotusapp.recadapters.FeelRecycler
import com.example.lotusapp.recadapters.StateRecycler
import com.example.lotusapp.recadapters.feel
import com.example.lotusapp.recadapters.state

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root: View = inflater.inflate(R.layout.fragment_home,container,false)

        return root

        val feel_recycler :RecyclerView=root.findViewById(R.id.feel_rec)
        feel_recycler.adapter=FeelRecycler(requireContext(), feel.MyFeel().list)
        val state_recycler: RecyclerView = root.findViewById(R.id.state_rec)
        state_recycler.adapter=StateRecycler(requireContext(), state.MyState().list)
    }


}