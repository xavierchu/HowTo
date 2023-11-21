package co.xji.loanbook.model.guide

import android.app.Activity

data class GuideModel(
    val title: String,
    val description: String,
    val iconResId: Int, // 图标资源 ID
    val guideActivityClass: Class<out Activity> // 指南对应的 Activity 类
)

