package com.example.core.database.bootlogs

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
interface BootRecordsDao {

    @Transaction
    @Query(
        """
            SELECT * FROM boot_records WHERE id == :id
            ORDER BY timestamp ASC LIMIT 1
            """
    )
    fun get(
        id: String
    ): Flow<BootRecordEntity?>

    @Transaction
    @Query(
        """
            SELECT * FROM boot_records WHERE 
                CASE WHEN :dateStart IS NOT NULL
                    THEN timestamp >= :dateStart
                    ELSE 1
                END 
                AND
                CASE WHEN :dateEnd IS NOT NULL
                    THEN timestamp <= :dateEnd
                    ELSE 1
                END
            ORDER BY timestamp ASC
            """
    )
    fun get(
        dateStart: LocalDateTime?,
        dateEnd: LocalDateTime?,
    ): Flow<List<BootRecordEntity?>>

    @Transaction
    @Query(
        """
            SELECT COUNT(*) FROM boot_records WHERE 
                CASE WHEN :dateStart IS NOT NULL
                    THEN timestamp >= :dateStart
                    ELSE 1
                END 
                AND
                CASE WHEN :dateEnd IS NOT NULL
                    THEN timestamp <= :dateEnd
                    ELSE 1
                END
            ORDER BY timestamp ASC
            """
    )
    fun getCount(
        dateStart: LocalDateTime?,
        dateEnd: LocalDateTime?,
    ): Flow<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: BootRecordEntity)

    @Query("DELETE FROM boot_records WHERE id = :id")
    suspend fun delete(id: String)
}