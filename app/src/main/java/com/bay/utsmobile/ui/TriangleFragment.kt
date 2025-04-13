package com.bay.utsmobile.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.bay.utsmobile.R

class TriangleFragment : Fragment(R.layout.fragment_triangle) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tinggiEdt = view.findViewById<EditText>(R.id.tinggiEdt)
        val alasEdt = view.findViewById<EditText>(R.id.alasEdt)
        val hasilBtn = view.findViewById<Button>(R.id.hasilBtn)
        val hasilLuasTv = view.findViewById<TextView>(R.id.hasilLuasTv)

        hasilBtn.setOnClickListener {
            val tinggiStr = tinggiEdt.text.toString()
            val alasStr = alasEdt.text.toString()

            if (tinggiStr.isNotEmpty() && alasStr.isNotEmpty()) {
                val tinggi = tinggiStr.toDoubleOrNull()
                val alas = alasStr.toDoubleOrNull()

                if (tinggi != null && alas != null) {
                    val luas = 0.5 * alas * tinggi
                    hasilLuasTv.text = "Luas segitiga: %.2f".format(luas)
                } else {
                    hasilLuasTv.text = "Input harus berupa angka"
                }
            } else {
                hasilLuasTv.text = "Tinggi dan alas tidak boleh kosong"
            }
        }
    }
}