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
import com.example.lotusapp.retrofitConnections.Interface
import com.example.lotusapp.retrofitConnections.MyRetrofit
import com.example.lotusapp.retrofitConnections.feelings
import com.example.lotusapp.retrofitConnections.quotes
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val feel_recycler: RecyclerView = root.findViewById(R.id.feel_rec)

        val feelings = MyRetrofit().getRetrofit()
        val feel_api_ret = feelings.create(Interface::class.java)
        val feelings_call: retrofit2.Call<feelings> = feel_api_ret.getFeel()
        feelings_call.enqueue(object : retrofit2.Callback<feelings>{
            override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
                if (response.isSuccessful)
                {
                    feel_recycler.adapter = response.body()?.let {FeelRecycler(requireContext(), it)}
                }
            }
            override fun onFailure(call: Call<feelings>, t: Throwable) {
            }
        })


        val state_recycler: RecyclerView = root.findViewById(R.id.state_rec)

        val quotes = MyRetrofit().getRetrofit()
        val quotes_api_ret = quotes.create(Interface::class.java)
        val quotes_call: retrofit2.Call<quotes> = quotes_api_ret.getQuotes()
        quotes_call.enqueue(object : retrofit2.Callback<quotes>{
            override fun onResponse(call: Call<quotes>, response: Response<quotes>) {
                if (response.isSuccessful)
                {
                    state_recycler.adapter =
                        response.body()?.let {StateRecycler(requireContext(),it)}
                }
            }
            override fun onFailure(call: Call<quotes>, t: Throwable) {
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


}