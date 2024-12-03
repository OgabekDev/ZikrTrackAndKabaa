package dev.ogabek.zikrtrack.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.ogabek.zikrtrack.model.*

@Database(entities = [Tasbih::class], version = 6, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun tasbihDao(): TasbihDao

    companion object {
        @Volatile
        private var DB_INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (DB_INSTANCE == null) {
                DB_INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database.db"
                )
//                    .addTypeConverter(GsonConverterFactory.create())
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return DB_INSTANCE!!
        }
    }

}