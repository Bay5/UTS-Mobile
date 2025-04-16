package com.bay.utsmobile.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.bay.utsmobile.R

class RectangleFragment : Fragment(R.layout.fragment_rectangle) {
    private lateinit var panjangEdt: EditText
    private lateinit var lebarEdt: EditText
    private lateinit var checkbox: CheckBox
    private lateinit var hasilBtn: Button
    private lateinit var hasilLuasTv: TextView
    private lateinit var hasilKelilingTv: TextView

    private val panjangWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            lebarEdt.setText(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        panjangEdt = view.findViewById(R.id.panjangEdt)
        lebarEdt = view.findViewById(R.id.lebarEdt)
        checkbox = view.findViewById(R.id.checkBox)
        hasilBtn = view.findViewById(R.id.hitungBtn)
        hasilLuasTv = view.findViewById(R.id.hasilLuasTv)
        hasilKelilingTv = view.findViewById(R.id.hasilKelilingTv)

        checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                lebarEdt.isEnabled = false
                lebarEdt.setText(panjangEdt.text.toString())
                panjangEdt.addTextChangedListener(panjangWatcher)
            } else {
                lebarEdt.isEnabled = true
                panjangEdt.removeTextChangedListener(panjangWatcher)
            }
        }

        hasilBtn.setOnClickListener {
            val panjang = panjangEdt.text.toString().toDoubleOrNull()
            val lebar = lebarEdt.text.toString().toDoubleOrNull()

            if (panjang != null && lebar != null) {
                val luas = panjang * lebar
                val keliling = 2 * (panjang + lebar)

                hasilLuasTv.text = "Luas: $luas"
                hasilKelilingTv.text = "Keliling: $keliling"
            } else {
                hasilLuasTv.text = "Masukkan panjang dan lebar yang valid"
                hasilKelilingTv.text = ""
            }
        }
    }
}