package com.naniak.githubapi.features.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.naniak.githubapi.R
import com.naniak.githubapi.databinding.FragmentHomeBinding
import com.naniak.githubapi.datamodel.DataAuthor
import com.naniak.githubapi.features.home.view.adapter.AuthorItemAdapter


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private  var binding: FragmentHomeBinding? = null

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

        val authorList = listOf(
            DataAuthor(
                authorName = "Kainan",
                repositoryName = "API-MARVEL",
                image = R.drawable.ic_launcher_background.toString(),
                forksNumbers = 8432,
                starsNumbers = 12333
            ),
            DataAuthor(
                authorName = "Kainan",
                repositoryName = "API-MARVEL",
                image = R.drawable.ic_launcher_background.toString(),
                forksNumbers = 8432,
                starsNumbers = 12333
            ),
            DataAuthor(
                authorName = "Kainan",
                repositoryName = "API-MARVEL",
                image = R.drawable.ic_launcher_background.toString(),
                forksNumbers = 8432,
                starsNumbers = 12333
            ),
            DataAuthor(
                authorName = "Kainan",
                repositoryName = "API-MARVEL",
                image = R.drawable.ic_launcher_background.toString(),
                forksNumbers = 8432,
                starsNumbers = 12333
            ),
            DataAuthor(
                authorName = "Kainan",
                repositoryName = "API-MARVEL",
                image = R.drawable.ic_launcher_background.toString(),
                forksNumbers = 8432,
                starsNumbers = 12333
            )
        )
        val authorAdapter = AuthorItemAdapter(authorList){
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
    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

}