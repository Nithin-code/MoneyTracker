package com.nithin.feature.moneytracker.domain.usecases

import com.nithin.core.common.workmanager.SyncScheduler

class FakeScheduler : SyncScheduler {
    override suspend fun scheduleSync() {}
}