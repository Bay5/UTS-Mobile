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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val panjangEdt = view.findViewById<EditText>(R.id.panjangEdt)
        val lebarEdt = view.findViewById<EditText>(R.id.lebarEdt)
        val checkbox = view.findViewById<CheckBox>(R.id.checkBox)
        val hasilBtn = view.findViewById<Button>(R.id.hasilBtn)
        val hasilLuasTv = view.findViewById<TextView>(R.id.hasilLuasTv)
        val hasilKelilingTv = view.findViewById<TextView>(R.id.hasilKelilingTv)

        // disable widthEdt and make value for width same as length
        checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                lebarEdt.isEnabled = false
                lebarEdt.setText(panjangEdt.text.toString())

                // Update lebar whenever panjang changes
                panjangEdt.addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {
                        lebarEdt.setText(s.toString())
                    }

                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                })
            } else {
                lebarEdt.isEnabled = true
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