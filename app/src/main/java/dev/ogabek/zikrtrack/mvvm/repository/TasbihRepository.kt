package dev.ogabek.zikrtrack.mvvm.repository

import dev.ogabek.zikrtrack.data.local.TasbihDao
import dev.ogabek.zikrtrack.model.Tasbih
import javax.inject.Inject

class TasbihRepository @Inject constructor(
    private val tasbihDao: TasbihDao
) {

    suspend fun getList() = tasbihDao.getTasbihList()

    suspend fun delete(data: Tasbih) = tasbihDao.deleteTasbih(data.id)

    suspend fun create(data: Tasbih) = tasbihDao.saveTasbih(data)

}