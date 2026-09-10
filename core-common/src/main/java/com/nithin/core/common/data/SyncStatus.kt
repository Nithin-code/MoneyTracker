package com.nithin.core.common.data

enum class SyncStatus(val status: Int) {
    PENDING(0),
    COMPLETED(1);
    companion object{
        fun getSyncStatusFromValue(value: Int) : SyncStatus {
            return when {
                value == PENDING.status -> PENDING
                else -> COMPLETED
            }
        }
    }
}