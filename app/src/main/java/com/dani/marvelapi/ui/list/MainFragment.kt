package com.dani.marvelapi.ui.list

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dani.marvelapi.ApiApplication
import com.dani.marvelapi.databinding.ActivityCharactersListBinding
import com.dani.marvelapi.ui.common.BaseFragment
import com.dani.marvelapi.utils.getViewModel
import com.dani.domain.Mycharacter

class MainFragment : BaseFragment() {

    private lateinit var navController: NavController
    private lateinit var component: CharactersListActivityComponent
    private val viewModel by lazy { getViewModel {component.viewModel }}

    private lateinit var adapter: MainAdapter

    private lateinit var binding: ActivityCharactersListBinding
    private var characterList = mutableListOf<Mycharacter>()
    private var name: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle? ): View {
        binding = ActivityCharactersListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        component = (activity?.application as ApiApplication).charactersComponent.plus(CharactersListActivityModule())

        binding.rvItems.layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        adapter = MainAdapter(characterList, viewModel::onItemClicked, ::reloadList)
        binding.rvItems.adapter = adapter

        binding.btnSearch.setOnClickListener {
            name = binding.editText.text.toString()
            viewModel.getCharacters(characterList.size, name)
        }

        viewModel.model.observe(viewLifecycleOwner, Observer(::updateUi))
    }

    private fun reloadList(){
        viewModel.getCharacters(characterList.size, name)
    }

    override fun loadData() {
        viewModel.getCharacters(characterList.size, name)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCharacters(characterList.size, name)
    }

    private fun updateUi(uiModel: MainViewModel.UiModel) {

        binding.itemLoading.loading.visibility = if (uiModel is MainViewModel.UiModel.Loading) View.VISIBLE else View.GONE

        when (uiModel) {
            is MainViewModel.UiModel.Content -> {
                characterList.clear()
                characterList.addAll(uiModel.items)
                adapter.notifyDataSetChanged()
            }
            is MainViewModel.UiModel.Navigation -> {
                val action = MainFragmentDirections.actionMainFragmentToDetailFragment(uiModel.item.id)
                navController.navigate(action)
            }

            MainViewModel.UiModel.Loading -> {}
        }
    }
}