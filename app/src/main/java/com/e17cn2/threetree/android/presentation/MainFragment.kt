package com.e17cn2.threetree.android.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.e17cn2.threetree.android.R
import com.e17cn2.threetree.android.databinding.FragmentMainBinding
import com.e17cn2.threetree.android.view.PlayingCardView
import com.e17cn2.threetree.entity.Room
import com.e17cn2.threetree.entity.SuiteCard
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        val onItemClickCallback : (room: Room) -> Unit = {
            findNavController(this).navigate(MainFragmentDirections.actionMainFragmentToRoomFragment(it))
        }

        binding.recyclerMainRooms.adapter = RoomsListAdapter(onItemClickCallback)
        binding.recyclerMainRooms.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardMainTest.setOnClickListener {
            (it as PlayingCardView).setValue(8)
            it.setSuite(SuiteCard.DIAMONDS)
        }
    }
}