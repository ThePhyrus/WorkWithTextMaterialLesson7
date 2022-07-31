package roman.bannikov.workwithtextmateriallesson7

import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.SpannedString
import android.text.style.*
import androidx.core.content.ContextCompat
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
//        val spannableString: SpannableString //умеет менять цвета, применять спэны к тексту, но не умеет добавлять в сторку новые символы или склеивать строки
        var spannableStringBuilder: SpannableStringBuilder //самый крутой - умеет фсё!


        //пример из прошлого:
        val text = "My text <ul><li>bullet one</li><li>bullet two</li>"
        binding.tvText.text = Html.fromHtml(text)
        //забыли пример из прошлого))

        // по современному:
        val textSpannable = resources.getString(R.string.the_text)
        val bulletRadius = 10
        spannableStringBuilder = SpannableStringBuilder(textSpannable)



        spannableStringBuilder.setSpan(
            RelativeSizeSpan(1.5f),
            0,
            5,
            SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE
        )

        spannableStringBuilder.setSpan(
            UnderlineSpan(),
            0,
            5,
            SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE
        )

        spannableStringBuilder.delete(12, 13)

        spannableStringBuilder.insert(12, "инского слова")

        spannableStringBuilder.setSpan(
            UnderlineSpan(),
            26,
            33,
            SpannableStringBuilder.SPAN_EXCLUSIVE_INCLUSIVE
        )


        spannableStringBuilder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.mr_text_color_black)),
            0,
            spannableStringBuilder.length,
            SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE
        )

        spannableStringBuilder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.mr_text_color_green)),
            6,
            66,
            SpannableStringBuilder.SPAN_EXCLUSIVE_INCLUSIVE
        )

        spannableStringBuilder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.mr_text_color_black)),
            26,
            33,
            SpannableStringBuilder.SPAN_EXCLUSIVE_INCLUSIVE
        )

        spannableStringBuilder.setSpan(
            RelativeSizeSpan(1.5f),
            26,
            33,
            SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE
        )


// API 28 or below

        val color = ContextCompat.getColor(this, R.color.mr_bullet_color)
        spannableStringBuilder.setSpan(
            BulletSpan(5, color),
            36,
            spannableStringBuilder.length,
            0
        )

        spannableStringBuilder.setSpan(
            BulletSpan(5, color),
            44,
            spannableStringBuilder.length,
            0
        )

        spannableStringBuilder.setSpan(
            BulletSpan(5, color),
            56,
            spannableStringBuilder.length,
            0
        )


        spannedString = SpannedString(spannableStringBuilder)

        binding.tvText.text = spannedString
    }
}