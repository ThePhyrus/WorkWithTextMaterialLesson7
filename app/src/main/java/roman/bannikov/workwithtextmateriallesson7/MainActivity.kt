package roman.bannikov.workwithtextmateriallesson7

import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.SpannedString
import android.text.style.AbsoluteSizeSpan
import android.text.style.BulletSpan
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import roman.bannikov.workwithtextmateriallesson7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //todo HW бегущая радуга по тексту
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.tvText.typeface =
//            Typeface.createFromAsset(this@MainActivity.assets, "fonts/ColumbiaRandomBoldItalic.ttf")
        binding.tvGreetingText.typeface =
            Typeface.createFromAsset(this@MainActivity.assets, "fonts/DeCAPitatedMedium.ttf")

        // Инструменты для работы с текстом через span:
        val spannedString: SpannedString //умеет только хранить ссылку на результат работы SpannableString и SpannableStringBuilder
        val spannableString: SpannableString //умеет менять цвета, применять спэны к тексту, но не умеет добавлять в сторку новые символы или склеивать строки
        val spannableStringBuilder: SpannableStringBuilder //самый крутой - умеет фсё!


        //пример из прошлого:
        val text = "My text <ul><li>bullet one</li><li>bullet two</li>"
        binding.tvText.text = Html.fromHtml(text)
        //забыли пример из прошлого))

        // по современному:
        val textSpannable = resources.getString(R.string.the_text)
        val flag = SpannableString.SPAN_INCLUSIVE_INCLUSIVE
        val bulletRadius = 10

        spannableString = SpannableString(textSpannable)
/*        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            spannableString.setSpan(
                BulletSpan(10, ContextCompat.getColor(this, R.color.mr_bullet_color),bulletRadius),
                9,
                19,
                flag
            )
           spannableString.setSpan(
                BulletSpan(10, ContextCompat.getColor(this, R.color.mr_bullet_color), bulletRadius),
                21,
                spannableString.length,
                flag
            )
        } else {
            spannableString.setSpan(
                BulletSpan(10, ContextCompat.getColor(this, R.color.mr_bullet_color)),
                9,
                19,
                flag
            )
            spannableString.setSpan(
                BulletSpan(10, ContextCompat.getColor(this, R.color.mr_bullet_color)),
                21,
                spannableString.length,
                flag
            )
        }*/

       spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.mr_text_color_black)),
            0,
            5,
            flag
        )

        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.mr_text_color_green)),
            6,
            52,
            flag
        )
        spannableString.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.mr_text_color_black)),
            53,
            spannableString.length,
            flag
        )



        val startIndex = 0
        val endIndex = spannableString.length
        val fontSizeInPx = 14
        val isUnitInDp = true
        spannableString.setSpan(AbsoluteSizeSpan(fontSizeInPx, isUnitInDp), startIndex, endIndex, flag)


        binding.tvText.text = spannableString
    }
}