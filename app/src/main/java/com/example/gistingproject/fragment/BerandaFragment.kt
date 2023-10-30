package com.example.gistingproject.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.gistingproject.R
import com.example.gistingproject.databinding.FragmentBerandaBinding


@Suppress("UNREACHABLE_CODE")
class BerandaFragment : Fragment() {

    private lateinit var binding: FragmentBerandaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBerandaBinding.inflate(layoutInflater, container, false)
    return binding.root
    }
      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
          binding.btntoGreenHouse.setOnClickListener {
              findNavController().navigate(R.id.action_berandaFragment_to_greenHouseFragment)
          }
          binding.btntoKlimatologi.setOnClickListener {
              findNavController().navigate(R.id.action_berandaFragment_to_klimatologiFragment)
          }
          binding.buttonTableGH.setOnClickListener{
              startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://semata.isi-net.org")))
          }
          binding.buttonGraphGH.setOnClickListener{
              startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://semata.isi-net.org")))
          }
          binding.buttonTableKlimatologi.setOnClickListener{
              startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://semata.isi-net.org")))
          }
          binding.buttonGraphKlimatologi.setOnClickListener{
              startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://semata.isi-net.org")))
          }
      }
}




