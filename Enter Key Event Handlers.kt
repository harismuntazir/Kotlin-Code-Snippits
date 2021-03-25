package com.badtools.logscalculator

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class FlatWoods : AppCompatActivity() {
    //late init vars
    private lateinit var len: TextView
    private lateinit var br: TextView
    private lateinit var hi: TextView
    private lateinit var output: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flat_woods)

        output = findViewById(R.id.output)
        len = findViewById(R.id.len)
        br = findViewById(R.id.br)
        hi = findViewById(R.id.hi)

        //length
        len.setOnEditorActionListener { _, actionId, _ ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                handled = true
                output.text = len.text.toString()
                br.requestFocus()
            }
            handled
        }
        //breadth
        br.setOnEditorActionListener { _, actionId, _ ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                handled = true
                output.text = br.text.toString()
                hi.requestFocus()
            }
            handled
        }
        //height
        hi.setOnEditorActionListener { _, actionId, _ ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                handled = true
                output.text = hi.text.toString()



            }
            handled
        }

    }
}
