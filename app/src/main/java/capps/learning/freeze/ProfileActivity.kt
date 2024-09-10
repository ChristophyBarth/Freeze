package capps.learning.freeze

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val person1 = Person("Smith", 47, 234567890)
        val person2 = Person("Smith", 47, 34567890)

        if (person1 == person2) {
            Log.wtf("WHAT?", "HOw????????????")
        } else {
            Log.wtf("WHAT?", "I thought as much")
        }
    }
}