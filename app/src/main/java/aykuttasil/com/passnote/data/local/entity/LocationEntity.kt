package aykuttasil.com.passnote.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by aykutasil on 27.12.2017.
 */
@Entity(tableName = "location")
data class LocationEntity(
        @PrimaryKey(autoGenerate = true) val locationId: Long? = null,
        @ColumnInfo val locLat: Double,
        @ColumnInfo val locLong: Double,
        @ColumnInfo val locTime: Date,
        @ColumnInfo val placesName: String? = null
)