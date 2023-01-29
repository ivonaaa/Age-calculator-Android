package com.example.danimjesecigodine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class dateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_date, container, false)

        var button = view.findViewById<Button>(R.id.calculateButton)
        button.setOnClickListener {
            var x = view.findViewById<EditText>(R.id.numberOfDays).text.toString().toInt()
            var y = x / 365
            x = (x - y * 365)
            var m = x / 30
            var d = (x - m * 30)
            view.findViewById<TextView>(R.id.yearsTextView).text = y.toString()
            view.findViewById<TextView>(R.id.monthsTextView).text = m.toString()
            view.findViewById<TextView>(R.id.daysTextView).text = d.toString()
        }

        return view
    }

}