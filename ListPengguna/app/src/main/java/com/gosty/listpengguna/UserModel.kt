package com.gosty.listpengguna

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val id: Int,
    val photo: String,
    val name: String,
    val email: String,
    val jurusan: String,
    val semester: Int
): Parcelable
