package com.bay.utsmobile.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bay.utsmobile.R

class LandingFragment : Fragment(R.layout.fragment_landing) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lanjutBtn = view.findViewById<Button>(R.id.lanjutBtn)
        lanjutBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MainMenuFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
