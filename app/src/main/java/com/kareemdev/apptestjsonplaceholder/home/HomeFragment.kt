package com.kareemdev.apptestjsonplaceholder.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kareemdev.apptestjsonplaceholder.R
import com.kareemdev.apptestjsonplaceholder.core.data.Resource
import com.kareemdev.apptestjsonplaceholder.core.ui.JsonAdapter
import com.kareemdev.apptestjsonplaceholder.core.ui.ViewModelFactory
import com.kareemdev.apptestjsonplaceholder.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val jsonAdapter = JsonAdapter()
            jsonAdapter.onItemClick = {}
            val factory = ViewModelFactory.getInstance(requireActivity())
            homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

            homeViewModel.jsonUser.observe(viewLifecycleOwner) { json ->
                if(json != null){
                    when(json){
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success ->{
                            binding.progressBar.visibility = View.GONE
                            jsonAdapter.setData(json.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = json.message ?: "Oops, something error"

                        }
                    }
                }
            }
            with(binding.rvJson){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = jsonAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}