package com.nithin.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payments")
data class PaymentInfoEntity(
    @PrimaryKey
    val serialNo: String,
    val name: String,
    val description: String?,
    val day: String,
    val month: String,
    val year: String,
    val dayInWeek: String,
    val amount: Double,
    val paymentStatus : String,
    val syncStatus: Int,
    @ColumnInfo(defaultValue = "0")
    val isDeleted: Boolean // new column
)