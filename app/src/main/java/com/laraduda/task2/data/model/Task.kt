package com.laraduda.task2.data.model

import android.os.Parcelable
// Alterado para o novo pacote oficial:
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task (
    val id: String,
    val description: String
): Parcelable