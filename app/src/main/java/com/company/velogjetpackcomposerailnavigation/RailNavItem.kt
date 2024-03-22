package com.company.velogjetpackcomposerailnavigation

import androidx.compose.ui.graphics.vector.ImageVector

// 1.

data class RailNavItem (
    val title : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val alarm : Boolean,
    val badgeCount : Int? = null
)