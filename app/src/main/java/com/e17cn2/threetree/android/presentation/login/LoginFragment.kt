package com.e17cn2.threetree.android.presentation.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.e17cn2.threetree.android.R
import com.e17cn2.threetree.android.databinding.FragmentLoginBinding
import com.e17cn2.threetree.entity.LoginRequest
import com.orhanobut.hawk.Hawk
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    private val viewModel: LoginViewModel by viewModel()

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.setOnClickListener {
            viewModel.login(
                LoginRequest(
                    binding.editLoginPassword.text.toString(),
                    binding.editLoginUname.text.toString()
                )
            )
        }

        viewModel.response.observe(viewLifecycleOwner) {
            if (it != null && it.isSuccessful) {
                Hawk.put("USER_ID", it.body()?.id)
                Toast.makeText(requireContext(), "Logged in as ${it.body()?.username}", Toast.LENGTH_LONG).show()
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainFragment())
            }
        }
    }
}