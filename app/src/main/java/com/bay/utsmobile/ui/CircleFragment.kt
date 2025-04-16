package com.bay.utsmobile.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.bay.utsmobile.R

class CircleFragment : Fragment(R.layout.fragment_circle) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jariJariEdt = view.findViewById<EditText>(R.id.jarijariEdt)
        val hasilBtn = view.findViewById<Button>(R.id.hitungBtn)
        val hasilLuasTv = view.findViewById<TextView>(R.id.hasilLuasTv)
        val hasilKelilingTv = view.findViewById<TextView>(R.id.hasilKelilingTv)

        hasilBtn.setOnClickListener {
            val jariStr = jariJariEdt.text.toString()

            if (jariStr.isNotEmpty())  {
                val jariJari = jariStr.toDoubleOrNull()

                if (jariJari != null) {
                    val luas = 3.14159 * jariJari * jariJari
                    hasilLuasTv.text = "Luas lingkaran : %.2f".format(luas)

                    val keliling = 3.14159 * 2 * jariJari
                    hasilKelilingTv.text = "Keliling lingkaran : %.2f".format(keliling)
                } else {
                    hasilLuasTv.text = "Input harus berupa angka"
                }
            } else {
                hasilLuasTv.text = "Tinggi dan alas tidak boleh kosong"
            }
        }
    }
}