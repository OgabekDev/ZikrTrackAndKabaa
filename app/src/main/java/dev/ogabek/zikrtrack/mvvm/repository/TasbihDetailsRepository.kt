package dev.ogabek.zikrtrack.mvvm.repository

import dev.ogabek.zikrtrack.data.local.TasbihDao
import dev.ogabek.zikrtrack.model.Tasbih
import javax.inject.Inject

class TasbihDetailsRepository @Inject constructor(
    private val tasbihDao: TasbihDao
) {

    suspend fun saveTasbih(data: Tasbih) = tasbihDao.saveTasbih(data)

}