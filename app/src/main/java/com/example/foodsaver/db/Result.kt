package com.example.adiva.db

import com.example.adiva.db.Profile

data class Result(
    val disabled: Boolean,
    val email: String,
    val id: String,
    val id_providers: List<String>,
    val last_login_at: String,
    val mfa_providers: List<Any>,
    val profile: Profile,
    val require_mfa: Boolean,
    val scopes: List<Any>,
    val verified: Boolean
)