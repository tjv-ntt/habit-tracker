//ref https://www.nutrient.io/blog/seamless-room-database-integration-for-kotlin-multiplatform-projects/

package org.ntt.habittracker

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Database(entities = [HabitEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getHabitDao(): HabitDao
}

@Dao
interface HabitDao {
    @Upsert // Insert and update entities.
    suspend fun upsert(habit: HabitEntity)

    @Delete
    suspend fun delete(habit: HabitEntity)

    @Query("SELECT * FROM HabitEntity")
    fun getAllAsFlow(): Flow<List<HabitEntity>>
}

@Entity
data class HabitEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val name: String,
    val completed: Boolean,
)