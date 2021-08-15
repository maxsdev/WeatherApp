package ru.maxsdev.domain.response

data class ConditionResponse constructor(
    val text: String,
    val icon: String, // url
    val code: Int
)
