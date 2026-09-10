package com.nithin.core.work.manager.delete_payment_worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.nithin.core.common.workmanager.DeleteWorker
import kotlinx.coroutines.CancellationException

class DeletePaymentWorker(
    private val context: Context,
    private val workerParameters: WorkerParameters,
    private val deleteWorker: DeleteWorker
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        return try {
            deleteWorker.deleteWork()
            Result.success()
        }catch (cancellationException: CancellationException){
            throw cancellationException
        }catch (exception: Exception){
            Result.retry()
        }
    }
}