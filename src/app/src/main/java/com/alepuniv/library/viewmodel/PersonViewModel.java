package com.alepuniv.library.viewmodel;

import android.app.Application;
import com.alepuniv.library.model.entity.Person;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.alepuniv.library.repository.PersonRepository;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {

    private PersonRepository personRepository;

    public PersonViewModel(@NonNull Application application) {
        super(application);
        personRepository = new PersonRepository(application);
    }

    public void insert(Person person){
        personRepository.insert(person);
    }

    public void delete(Person person){
        personRepository.delete(person);
    }

    public void update(Person person){
        personRepository.update(person);
    }

    public LiveData<List<Person>> getAll(){
        return personRepository.getAll();
    }
}
