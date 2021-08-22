package com.naniak.githubapi.features.home.view

import Command
import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.naniak.githubapi.R
import com.naniak.githubapi.databinding.FragmentHomeBinding
import com.naniak.githubapi.datamodel.DataAuthor
import com.naniak.githubapi.features.home.view.adapter.AuthorItemAdapter
import com.naniak.githubapi.features.home.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private  var binding: FragmentHomeBinding? = null
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            viewModel = ViewModelProvider(it).get(HomeViewModel::class.java)
            viewModel.command = MutableLiveData<Command>()


        }
       binding?.run {

           viewModel.getRepositoryGithub()
            setupObservables()
       }

    }



    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
    private fun setupObservables() {
        viewModel.onSuccessRepositoryGithub.observe(viewLifecycleOwner, {
            val authorList = mutableListOf<DataAuthor>()
            it.items.forEach {
                authorList.add(
                    DataAuthor(
                        authorName = it.owner.login,
                        repositoryName =it.name ,
                        image = it.owner.avatarUrl,
                        forksNumbers = it.forks,
                        starsNumbers = it.stargazersCount
                    )
                )
            }
          activity?.let {
              val authorAdapter = AuthorItemAdapter(authorList,it){
                  if (it.layoutInfo.isVisible) {
                      it.layoutInfo.apply {
                          visibility = View.GONE
                          isVisible = false
                      }
                  } else {
                      it.layoutInfo.apply {
                          visibility = View.VISIBLE
                          isVisible = true
                      }
                  }
              }
              binding?.let {
                  with(it) {
                      vgRepository.layoutManager = LinearLayoutManager(context)
                      vgRepository.adapter = authorAdapter
                  }
              }
          }





        })


        viewModel.onErrorRepositoryGithub.observe(viewLifecycleOwner, {
            it
        })


    }



}