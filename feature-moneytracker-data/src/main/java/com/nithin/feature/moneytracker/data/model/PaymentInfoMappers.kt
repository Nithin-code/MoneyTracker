package com.nithin.feature.moneytracker.data.model

import com.nithin.core.common.data.PaymentStatus
import com.nithin.core.common.data.SyncStatus
import com.nithin.core.database.model.PaymentInfoEntity
import com.nithin.core.firebase.model.PaymentRemoteModel
import com.nithin.feature.moneytracker.domain.model.PaymentInfo

fun PaymentInfo.toPaymentEntity() : PaymentInfoEntity {
    return PaymentInfoEntity(
        serialNo = serialNo,
        name = name,
        day = day,
        month = month,
        year = year,
        dayInWeek = dayInWeek,
        amount = amount,
        paymentStatus = paymentStatus.status,
        syncStatus = syncStatus.status,
        description = description,
        isDeleted = false
    )
}

fun PaymentInfoEntity.toPaymentInfo() : PaymentInfo {
    return PaymentInfo(
        serialNo = serialNo,
        name = name,
        description = description,
        day = day,
        month = month,
        year = year,
        dayInWeek = dayInWeek,
        amount = amount,
        paymentStatus = PaymentStatus.getPaymentStatusFromValue(paymentStatus),
        syncStatus = SyncStatus.getSyncStatusFromValue(syncStatus)
    )
}

fun PaymentInfoEntity.toPaymentRemoteData() : PaymentRemoteModel {
    return PaymentRemoteModel(
        serialNo = serialNo,
        name = name,
        description = description,
        day = day,
        month = month,
        year = year,
        dayInWeek = dayInWeek,
        amount = amount,
        paymentStatus = paymentStatus,
    )
}
