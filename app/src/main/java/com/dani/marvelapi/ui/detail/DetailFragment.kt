package com.dani.marvelapi.ui.detail

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.navArgs
import com.dani.marvelapi.ApiApplication
import com.dani.marvelapi.databinding.ActivityCharactersDetailTwoBinding
import com.dani.marvelapi.ui.common.BaseFragment
import com.dani.marvelapi.utils.getViewModel
import com.dani.domain.Mycharacter

class DetailFragment : BaseFragment() {

    private lateinit var component: CharactersDetailComponent
    private val viewModel by lazy { getViewModel {component.viewModel }}

    private val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: ActivityCharactersDetailTwoBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityCharactersDetailTwoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        component = (activity?.application as ApiApplication).charactersComponent.plus(
            CharactersDetailModule().apply { itemId = args.id }
        )

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }
}