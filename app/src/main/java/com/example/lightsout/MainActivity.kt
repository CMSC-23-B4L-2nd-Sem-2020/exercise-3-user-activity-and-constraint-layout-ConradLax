package com.example.lightsout

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

//    val list: List<Int> = listOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
        setListeners()
    }
    //function for showing nickname
    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)       //gets a reference for the plaintext/edit text nickname_edit
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)   //gets a reference for the nickname_text textView

        if(editText.text.isNotEmpty()){
            nicknameTextView.text = editText.text       //puts the nickname input of user to the nickname_text textView
            editText.visibility = View.GONE             //makes the nickname_edit invisible
            view.visibility = View.GONE                 //makes the button invisible (the view in the parameter will represent the button in the onCreate fxn)
            nicknameTextView.visibility = View.VISIBLE  //shows the nickname input of user

        }
        else{
            nicknameTextView.text = getString(R.string.response)      //puts the nickname input of user to the nickname_text textView
            editText.visibility = View.GONE             //makes the nickname_edit invisible
            view.visibility = View.GONE                 //makes the button invisible (the view in the parameter will represent the button in the onCreate fxn)
            nicknameTextView.visibility = View.VISIBLE  //shows the nickname input of user
        }



        //for hiding the keyboard after using it
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)       //reference for edittext/plainText nickname_edit
        val doneButton = findViewById<Button>(R.id.done_button)         //reference for the button

        editText.visibility = View.VISIBLE      //makes the nickname_edit visible again for editing the nickname
        doneButton.visibility = View.VISIBLE    //makes the button visible again
        view.visibility = View.GONE             //the textView for the nickname is now invisible because the user is editing the nickname

        //the app now focuses on the editing function of the user
        editText.requestFocus()

        //shows the keyboard when this function is called
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)

    }

    //function for accessing each boxes
    private fun getId(int: Int): Int{
        val list: List<Int> = listOf(
            R.id.box_one,
            R.id.box_two,
            R.id.box_three,
            R.id.box_four,
            R.id.box_five,
            R.id.box_six,
            R.id.box_seven,
            R.id.box_eight,
            R.id.box_nine,
            R.id.box_ten,
            R.id.box_eleven,
            R.id.box_twelve,
            R.id.box_thirteen,
            R.id.box_fourteen,
            R.id.box_fifteen,
            R.id.box_sixteen,
            R.id.box_seventeen,
            R.id.box_eighteen,
            R.id.box_nineteen,
            R.id.box_twenty,
            R.id.box_twenty_one,
            R.id.box_twenty_two,
            R.id.box_twenty_three,
            R.id.box_twenty_four,
            R.id.box_twenty_five
        )

        return list[int]
    }

//    private fun isPressed(int: Int): Int{
//        val list: List<Int> = listOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
//        return list[int]
//    }

    private fun decideColor(textView: TextView){
        if(textView.text=="0"){
            textView.setBackgroundColor(Color.DKGRAY)
        }
        else{
            textView.setBackgroundColor(Color.LTGRAY)
        }
    }

    //function that adds an action when a box is pressed
    private fun setListeners(){
        for(item in (0..24)){
            findViewById<TextView>(getId(item)).setOnClickListener{
                makeColored(it)
            }
        }
    }
    //colors the textbox
    private fun makeColored(view: View){
        val box_data = findViewById<TextView>(view.id)
        for (item in (0..24)){
            if(getId(item) == view.id){     //uses the values of each box to represent boolean values (if turned on(1) or off(0))
                if(box_data.text == "0"){
                    view.setBackgroundColor(Color.DKGRAY)
                    box_data.text = "1"
                    if(item==0){
                        var next_box_data = findViewById<TextView>(getId(item+1))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item+5))
                        decideColor(next_box_data)
                    }
                    else if(item==4){
                        var next_box_data = findViewById<TextView>(getId(item-1))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item+5))
                        decideColor(next_box_data)
                    }
                    else if(item==20){
                        var next_box_data = findViewById<TextView>(getId(item+1))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item-5))
                        decideColor(next_box_data)
                    }
                    else if(item==24){
                        var next_box_data = findViewById<TextView>(getId(item-1))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item-5))
                        decideColor(next_box_data)
                    }
                    else if(item>0 && item<4){
                        var next_box_data = findViewById<TextView>(getId(item-1))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item+1))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item+5))
                        decideColor(next_box_data)
                    }
                    else if(item>20 && item <24){
                        var next_box_data = findViewById<TextView>(getId(item-1))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item+1))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item-5))
                        decideColor(next_box_data)
                    }
                    else if(item%5==0){
                        var next_box_data = findViewById<TextView>(getId(item-5))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item+5))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item+1))
                        decideColor(next_box_data)
                    }
                    else if(item==9 || item==14 || item==19){
                        var next_box_data = findViewById<TextView>(getId(item-1))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item-5))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item+5))
                        decideColor(next_box_data)
                    }
                    else{
                        var next_box_data = findViewById<TextView>(getId(item-1))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item-5))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item+5))
                        decideColor(next_box_data)
                        next_box_data = findViewById<TextView>(getId(item+1))
                        decideColor(next_box_data)
                    }
                }
                else if(box_data.text == "1"){
                    view.setBackgroundColor(Color.LTGRAY)
                    box_data.text = "0"
                }

            }
        }
    }
}