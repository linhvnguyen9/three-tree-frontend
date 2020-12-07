package com.e17cn2.threetree.android.presentation.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.e17cn2.threetree.android.R
import com.e17cn2.threetree.android.databinding.FragmentRoomBinding
import com.e17cn2.threetree.android.presentation.RoomsListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoomFragment : Fragment() {
    private lateinit var binding: FragmentRoomBinding
    private val viewModel: RoomViewModel by viewModel()

    private val args: RoomFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRoomBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val room = args.room
        viewModel.setRoom(room)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerRoomOtherPlayers.adapter = PlayerRoundsAdapter()
        binding.recyclerRoomOtherPlayers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.recyclerRoomConnections.adapter = ConnectionsAdapter()
        binding.recyclerRoomConnections.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.buttonRoomReady.setOnClickListener {
            viewModel.voteStart()
        }

        binding.buttonRoomQuit.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}