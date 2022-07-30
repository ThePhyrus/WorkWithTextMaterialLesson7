package roman.bannikov.workwithtextmateriallesson7

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.SpannedString
import roman.bannikov.workwithtextmateriallesson7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //todo HW бегущая радуга по тексту
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvText.typeface =
            Typeface.createFromAsset(this@MainActivity.assets, "fonts/ColumbiaRandomBoldItalic.ttf")
        binding.tvGreetingText.typeface =
            Typeface.createFromAsset(this@MainActivity.assets, "fonts/DeCAPitatedMedium.ttf")

        // Инструменты для работы с текстом через span:
        val spannedString: SpannedString //умеет только хранить ссылку на результат работы SpannableString и SpannableStringBuilder
        val spannableString: SpannableString //умеет менять цвета, применять спэны к тексту, но не умеет добавлять в сторку новые символы или склеивать строки
        val spannableStringBuilder: SpannableStringBuilder //самый крутой - умеет фсё!
    }
}