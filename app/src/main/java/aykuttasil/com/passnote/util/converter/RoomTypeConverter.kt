package aykuttasil.com.passnote.util.converter

import androidx.room.TypeConverter
import java.util.*

/**
 * Created by aykutasil on 27.12.2017.
 */
class RoomTypeConverter {

    @TypeConverter
    fun fromDateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(long: Long): Date {
        return Date(long)
    }

}