package com.imrul.replog.feature_auth.presentation.screen_login.model

data class LoginState(
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
    val error: String? = null
)