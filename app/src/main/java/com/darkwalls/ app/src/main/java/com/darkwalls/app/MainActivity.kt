
package com.darkwalls.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {

    private val green = Color.rgb(0, 220, 130)
    private val dark = Color.rgb(12, 15, 18)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = dark
        window.navigationBarColor = dark
        createHome()
    }

    private fun createHome() {
        val scroll = ScrollView(this)
        scroll.setBackgroundColor(dark)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(20, 28, 20, 24)

        scroll.addView(layout)

        val logo = TextView(this)
        logo.text = "DARKWALLS"
        logo.textSize = 30f
        logo.setTextColor(green)
        logo.typeface = Typeface.DEFAULT_BOLD
        logo.gravity = Gravity.CENTER
        layout.addView(logo)

        val subtitle = TextView(this)
        subtitle.text = "عالم من الخلفيات يليق بهاتفك"
        subtitle.textSize = 15f
        subtitle.setTextColor(Color.LTGRAY)
        subtitle.gravity = Gravity.CENTER
        subtitle.setPadding(0, 8, 0, 25)
        layout.addView(subtitle)

        addTitle(layout, "اكتشف الخلفيات")

        addCategory(layout, "الطبيعة 🌿")
        addCategory(layout, "الفضاء 🌌")
        addCategory(layout, "السيارات 🏎️")
        addCategory(layout, "الفخامة 🖤")
        addCategory(layout, "الأنمي 🎭")

        addTitle(layout, "أنواع الخلفيات")

        addWallpaperCard(
            layout,
            "خلفيات ثابتة",
            "صور عالية الجودة لشاشة هاتفك"
        )

        addWallpaperCard(
            layout,
            "خلفيات متحركة",
            "خلفيات حية تتحرك على شاشة هاتفك"
        )

        addWallpaperCard(
            layout,
            "المفضلة ❤️",
            "احتفظ بخلفياتك التي تحبها"
        )

        val footer = TextView(this)
        footer.text = "DARKWALLS • VERSION 1.0"
        footer.setTextColor(Color.GRAY)
        footer.gravity = Gravity.CENTER
        footer.setPadding(0, 35, 0, 10)
        layout.addView(footer)

        setContentView(scroll)
    }

    private fun addTitle(
        layout: LinearLayout,
        text: String
    ) {
        val title = TextView(this)
        title.text = text
        title.textSize = 21f
        title.setTextColor(Color.WHITE)
        title.typeface = Typeface.DEFAULT_BOLD
        title.setPadding(0, 20, 0, 15)
        layout.addView(title)
    }

    private fun addCategory(
        layout: LinearLayout,
        name: String
    ) {
        val button = Button(this)
        button.text = name
        button.setTextColor(Color.WHITE)
        button.textSize = 16f
        button.setBackgroundColor(Color.rgb(30, 38, 40))

        button.setOnClickListener {
            Toast.makeText(
                this,
                "القسم: $name",
                Toast.LENGTH_SHORT
            ).show()
        }

        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            58
        )
        params.bottomMargin = 10
        layout.addView(button, params)
    }

    private fun addWallpaperCard(
        layout: LinearLayout,
        title: String,
        description: String
    ) {
        val card = LinearLayout(this)
        card.orientation = LinearLayout.VERTICAL
        card.setPadding(18, 18, 18, 18)

        val background = GradientDrawable()
        background.setColor(Color.rgb(25, 33, 34))
        background.cornerRadius = 22f
        background.setStroke(2, green)
        card.background = background

        val heading = TextView(this)
        heading.text = title
        heading.textSize = 20f
        heading.setTextColor(green)
        heading.typeface = Typeface.DEFAULT_BOLD

        val detail = TextView(this)
        detail.text = description
        detail.textSize = 14f
        detail.setTextColor(Color.LTGRAY)
        detail.setPadding(0, 8, 0, 12)

        val button = Button(this)
        button.text = "استكشف"
        button.setTextColor(Color.BLACK)
        button.setBackgroundColor(green)

        button.setOnClickListener {
            Toast.makeText(
                this,
                "سيتم تجهيز قسم $title",
                Toast.LENGTH_SHORT
            ).show()
        }

        card.addView(heading)
        card.addView(detail)
        card.addView(button)

        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.bottomMargin = 16
        layout.addView(card, params)
    }
}
