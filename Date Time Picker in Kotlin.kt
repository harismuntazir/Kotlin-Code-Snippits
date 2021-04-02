package com.badtools.logscalculator

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.DocumentsContract
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedWriter
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.util.*


class Save : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    //utility methods
    private val util = UtilityMethods
    private lateinit var contxt: Context

    //date time vars
    var dayy = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0

    //date time vars
    var savedDayy = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0


    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logs_app_save)

        contxt = applicationContext

        
        //the date time picker
        val dateField = findViewById<TextView>(R.id.date).setOnTouchListener{ _, _ ->
            pickDate()
            true
        }
    }

    //date time picker
    private fun getDateTimeCalendar() {
        val cal: Calendar = Calendar.getInstance()
        dayy = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }
    private fun pickDate() {
        getDateTimeCalendar()
        DatePickerDialog(this, this, year, month, dayy).show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDayy = dayOfMonth
        savedMonth = month
        savedYear = year
        getDateTimeCalendar()
        TimePickerDialog(this, this, hour, minute, true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hour
        savedMinute = minute
        //set the date time to the date view
        val date = "$savedDayy-$savedMonth-$savedYear At $savedHour:$savedMinute"
        findViewById<TextView>(R.id.date).text = date
    }

}
