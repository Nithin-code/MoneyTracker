package com.nithin.feature.moneytracker.domain.usecases

import com.nithin.core.common.exceptions.AppError
import com.nithin.core.common.result.AppResult
import com.nithin.core.common.workmanager.DeleteWorkerScheduler
import com.nithin.feature.moneytracker.domain.repository.MoneyTrackerRepository

class UpdateDeleteStatusUseCase(
    private val repository: MoneyTrackerRepository,
    private val deleteWorkerScheduler: DeleteWorkerScheduler
) {
    suspend fun updateDeleteStatus(
        id: String,
        isDeleted: Boolean
    ): AppResult<Unit>{
        val result = repository.updateDeleteStatus(id,isDeleted)
        when(result){
            is AppResult.Error -> {

            }
            is AppResult.Success<*> -> {
                //schedule workManager to update status in cloud
                deleteWorkerScheduler.scheduleDeleteWorker()
            }
        }
        return result
    }
}