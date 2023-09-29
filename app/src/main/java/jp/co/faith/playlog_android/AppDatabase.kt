package jp.co.faith.playlog_android

import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.Provides

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}