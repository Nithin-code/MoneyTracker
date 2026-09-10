package com.nithin.core.common.workmanager

interface SyncScheduler {
    suspend fun scheduleSync()
}