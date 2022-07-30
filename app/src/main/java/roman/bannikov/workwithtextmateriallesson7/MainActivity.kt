package roman.bannikov.workwithtextmateriallesson7

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import roman.bannikov.workwithtextmateriallesson7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //todo HW бегущая радуга по тексту
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvText.typeface = Typeface.createFromAsset(this@MainActivity.assets, "fonts/ColumbiaRandomBoldItalic.ttf")
        binding.tvGreetingText.typeface = Typeface.createFromAsset(this@MainActivity.assets, "fonts/DeCAPitatedMedium.ttf")
    }
}