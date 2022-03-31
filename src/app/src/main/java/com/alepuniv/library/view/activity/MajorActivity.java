package com.alepuniv.library.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.alepuniv.library.R;
import com.alepuniv.library.model.entity.Person;
import com.alepuniv.library.util.Common;
import com.alepuniv.library.view.adapter.PersonRecyclerAdapter;
import com.alepuniv.library.viewmodel.PersonViewModel;

import java.util.ArrayList;
import java.util.List;

public class MajorActivity extends AppCompatActivity {


    private RecyclerView recyclerMainPersons;
    private List<Person> persons;
    private PersonRecyclerAdapter personRecyclerAdapter;


    private CardView cardMainAuthorsAndPublishers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*recyclerMainPersons = findViewById(R.id.recyclerMainPersons);
        recyclerMainPersons.setHasFixedSize(true);

        persons = new ArrayList<>();
        //persons.add(new Person(1, "Jamil", "Mazen", "Abodan", "Syria", , 125))
        personRecyclerAdapter = new PersonRecyclerAdapter(this, persons);
        recyclerMainPersons.setAdapter(personRecyclerAdapter);*/



        cardMainAuthorsAndPublishers = findViewById(R.id.cardMainAuthorsAndPublishers);

        cardMainAuthorsAndPublishers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MajorActivity.this, AuthorActivity.class);
                startActivity(intent);

            }
        });



    }
}