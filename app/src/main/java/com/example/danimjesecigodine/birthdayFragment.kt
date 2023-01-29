package com.example.danimjesecigodine

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class birthdayFragment : Fragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_birthday, container, false)

        view.findViewById<Button>(R.id.chooseDateButton).setOnClickListener {
            val dp = onCreateDialog(savedInstanceState)
            dp.show()
        }

        return view
    }

    fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(), this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        display_date(year, month, day)
        val dobs = "${day}/${month + 1}/${year}"
        val today = Date()
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val dob = sdf.parse(dobs)
        val days = (today.time - dob.time) / 86400000
        display_days(days)
    }
    fun display_date(year: Int, month: Int, day: Int){
        view?.findViewById<TextView>(R.id.displayDateTextView)?.text =
            "Chosen date: ${day}/${month + 1}/${year}"
    }
    fun display_days(days:Long){
        view?.findViewById<TextView>(R.id.displayAgeInDaysTextView)?.text =
            "Number of days: " + days
    }
}