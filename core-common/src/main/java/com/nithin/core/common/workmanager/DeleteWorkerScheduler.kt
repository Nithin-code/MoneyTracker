package com.nithin.core.common.workmanager

interface DeleteWorkerScheduler {
    suspend fun scheduleDeleteWorker()
}