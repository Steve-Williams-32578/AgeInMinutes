package com.example.ageinminutes

import android.app.Activity
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.NullPointerException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    //var selected = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.unitOfTime)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.units_of_time,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        btnDatePicker.setOnClickListener{
            clickDatePicker()
        }

        val calculate = findViewById(R.id.calculate) as Button
        calculate.setOnClickListener{
            val selected = unitOfTime.selectedItem.toString()

            val selectedDate = tvSelectedDate.text
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate.toString())
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            if (selected == "Your Age In Seconds"){
                val selectedDateInSeconds = theDate!!.time / 1000
                val currentDateToSeconds = currentDate!!.time / 1000
                val result = currentDateToSeconds - selectedDateInSeconds
                tvSelectedDateInMinutes.text = result.toString()

            }

            if (selected == "Your Age In Minutes"){
                val selectedDateInMinutes = theDate!!.time / 60000
                val currentDateToMinutes = currentDate!!.time / 60000
                val result = currentDateToMinutes - selectedDateInMinutes
                tvSelectedDateInMinutes.text = result.toString()
            }

            if (selected == "Your Age In Hours"){
                val selectedDateInHours = theDate!!.time / 3600000
                val currentDateToHours = currentDate!!.time / 3600000
                val result = currentDateToHours - selectedDateInHours
                tvSelectedDateInMinutes.text = result.toString()
            }

            if (selected == "Your Age In Days"){
                val selectedDateInDays = theDate!!.time / 86400000
                val currentDateToDays = currentDate!!.time / 86400000
                val result = currentDateToDays - selectedDateInDays
                tvSelectedDateInMinutes.text = result.toString()
            }

            if (selected == "Your Age In Weeks"){
                val selectedDateInWeeks = theDate!!.time / 604800000
                val currentDateToWeeks = currentDate!!.time / 604800000
                val result = currentDateToWeeks - selectedDateInWeeks
                tvSelectedDateInMinutes.text = result.toString()
            }

            if (selected == "Select Time Duration"){
                tvSelectedDateInMinutes.text = "0"
                Toast.makeText(this, "Select a Time Duration", Toast.LENGTH_LONG).show()
            }


        }

    }

    fun clickDatePicker() {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,
            {
                    _, selectedYear, selectedMonth, selectedDayOfMonth ->

                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"

                tvSelectedDate.text = selectedDate



/*
                if (selected == "Your Age In Seconds"){
                    val selectedDateInSeconds = theDate!!.time / 1000
                    val currentDateToSeconds = currentDate!!.time / 1000
                    tvSelectedDateInMinutes.text = {currentDateToSeconds - selectedDateInSeconds}.toString()
                }

                if (selected == "Your Age In Minutes"){
                    val selectedDateInMinutes = theDate!!.time / 60000
                    val currentDateToMinutes = currentDate!!.time / 60000
                    tvSelectedDateInMinutes.text = {currentDateToMinutes - selectedDateInMinutes}.toString()
                }

                if (selected == "Your Age In Hours"){
                    val selectedDateInHours = theDate!!.time / 3600000
                    val currentDateToHours = currentDate!!.time / 3600000
                    tvSelectedDateInMinutes.text = {currentDateToHours - selectedDateInHours}.toString()
                }

                if (selected == "Your Age In Days"){
                    val selectedDateInDays = theDate!!.time / 86400000
                    val currentDateToDays = currentDate!!.time / 86400000
                    tvSelectedDateInMinutes.text = {currentDateToDays - selectedDateInDays}.toString()
                }

                if (selected == "Your Age In Weeks"){
                    val selectedDateInWeeks = theDate!!.time / 604800000
                    val currentDateToWeeks = currentDate!!.time / 604800000
                    tvSelectedDateInMinutes.text = {currentDateToWeeks - selectedDateInWeeks}.toString()
                }

                //else {
                //    tvSelectedDateInMinutes.text = "Something went wrong."
                //}
*/

            }
            ,year
            , month
            , day)

        dpd.datePicker.maxDate = Date().time - 86400000
        dpd.show()
    }
}