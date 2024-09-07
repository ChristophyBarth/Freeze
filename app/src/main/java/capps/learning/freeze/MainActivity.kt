package capps.learning.freeze

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var email : EditText
    private lateinit var password : EditText
    private lateinit var loginButton: Button

    private lateinit var showEmail : TextView
    private lateinit var showPassword : TextView

    private lateinit var seekBar: SeekBar
    private lateinit var radio1: RadioButton
    private lateinit var radio2: RadioButton

    private lateinit var radioGroup: RadioGroup

    private var gender: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email =  findViewById(R.id.email)
        password =  findViewById(R.id.password)
        loginButton = findViewById(R.id.login)

        showEmail = findViewById(R.id.gottenEmail)
        showPassword = findViewById(R.id.gottenPassword)

        seekBar = findViewById(R.id.seekbar)
        radio1 = findViewById(R.id.radio1)
        radio2 = findViewById(R.id.radio2)

        radioGroup = findViewById(R.id.gender_group)

        loginButton.setOnClickListener {
            if (gender == null){
                Snackbar.make(it.rootView, "Kindly select your gender", Snackbar.LENGTH_SHORT).show()
            }else {

//            Snackbar.make(it.rootView, "Clicked", Snackbar.LENGTH_LONG).show()
                var inputtedEmail = email.text.toString()
                val inputtedPassword = password.text.toString()

                inputtedEmail = inputtedEmail.replace('r', 'g', true)

                showEmail.text = inputtedEmail
                showPassword.text = inputtedPassword
            }
        }

        val seekBarChangeListener = object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d("MainActivity", "Progress is: $progress")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.d("MainActivity", "started touch")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                val progress = seekBar?.progress
                Log.d("MainActivity", "stopped touch at $progress")
            }
        }

        seekBar.setOnSeekBarChangeListener(seekBarChangeListener)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.radio1 -> {
                    gender = "male"
                }
                R.id.radio2 -> {
                   gender = "female"
                }
                else -> throw Exception("Unknown Radio Button ID")
            }
        }

    }
}