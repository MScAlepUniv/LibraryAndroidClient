package com.alepuniv.library.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.alepuniv.library.model.dao.PersonDao;
import com.alepuniv.library.model.database.LibraryDatabase;
import com.alepuniv.library.model.entity.Person;

import java.util.List;

public class PersonRepository {
    private PersonDao personDao;

    public PersonRepository(Application application) {
        personDao = LibraryDatabase.getDatabase(application).getPersonDao();
    }

    public void insert(Person person){
        LibraryDatabase.executorService.execute(() -> {
            personDao.insert(person);
        });
    }

    public void delete(Person person){
        LibraryDatabase.executorService.execute(() -> {
            personDao.delete(person);
        });
    }

    public void update(Person person){
        LibraryDatabase.executorService.execute(() -> {
            personDao.update(person);
        });
    }

    public LiveData<List<Person>> getAll(){
        return personDao.getAll();
    }
}
