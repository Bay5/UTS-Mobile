package com.bay.utsmobile.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bay.utsmobile.R

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val lingkaranBtn = view.findViewById<Button>(R.id.lingkaranBtn)
        lingkaranBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, CircleFragment())
                .addToBackStack(null)
                .commit()
        }

        val persegiBtn = view.findViewById<Button>(R.id.persegiBtn)
        persegiBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RectangleFragment())
                .addToBackStack(null)
                .commit()
        }

        val segitigaBtn = view.findViewById<Button>(R.id.segitigaBtn)
        segitigaBtn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, TriangleFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}