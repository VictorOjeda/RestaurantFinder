package com.victorojeda.restaurantfinder.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.victorojeda.restaurantfinder.R
import com.victorojeda.restaurantfinder.model.Business
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private val searchViewModel by viewModels<SearchViewModel>()

    private lateinit var businessesRecyclerView: RecyclerView
    private var adapter = BusinessAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        businessesRecyclerView = view.findViewById(R.id.recycler_businesses) as RecyclerView
        businessesRecyclerView.layoutManager = LinearLayoutManager(context)
        businessesRecyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchViewModel.businesses.observe(
            viewLifecycleOwner,
            Observer { businesses ->
                updateUI(businesses)
            })

        if (savedInstanceState == null) {
            searchViewModel.findRestaurantsNearMe(33.4028076, -111.901385)
        }
    }

    private fun updateUI(businesses: List<Business>) {
        adapter = BusinessAdapter(businesses)
        businessesRecyclerView.adapter = adapter
    }

    companion object {
        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }
}