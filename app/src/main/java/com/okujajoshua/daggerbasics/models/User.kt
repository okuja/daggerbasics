package com.okujajoshua.daggerbasics.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") val name: String
)