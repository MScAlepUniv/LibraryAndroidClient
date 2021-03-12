package com.alepuniv.library.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.alepuniv.library.model.dao.PersonDao;
import com.alepuniv.library.model.entity.Person;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities =
        {
                Person.class
        }, version = 1)
public abstract class LibraryDatabase extends RoomDatabase
{
    public static final ExecutorService executorService = Executors.newFixedThreadPool(2);

    private static volatile LibraryDatabase instance;
    public static LibraryDatabase getDatabase(final Context context)
    {
        if (instance == null)
        {
            synchronized (LibraryDatabase.class)
            {
                if (instance == null)
                {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            LibraryDatabase.class, "Library")
                            .build();
                }
            }
        }
        return instance;
    }

    public abstract PersonDao getPersonDao();
}
