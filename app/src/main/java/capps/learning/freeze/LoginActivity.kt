package capps.learning.freeze

import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import capps.learning.freeze.databinding.ActivityLoginBinding
import capps.learning.freeze.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var gender: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            if (gender == null) {
                Snackbar.make(binding.root, "Kindly select your gender", Snackbar.LENGTH_SHORT)
                    .show()
            } else {
                Snackbar.make(binding.root, "Clicked", Snackbar.LENGTH_LONG).show()
                var inputtedEmail = binding.email.text.toString()
                val inputtedPassword = binding.password.text.toString()

                inputtedEmail = inputtedEmail.replace('r', 'g', true)

                binding.gottenEmail.text = inputtedEmail
                binding.gottenPassword.text = inputtedPassword
            }
        }

        val seekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
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

        binding.seekbar.setOnSeekBarChangeListener(seekBarChangeListener)

        binding.genderGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
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