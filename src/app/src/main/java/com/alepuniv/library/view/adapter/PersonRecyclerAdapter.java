package com.alepuniv.library.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alepuniv.library.R;
import com.alepuniv.library.model.entity.Person;
import com.alepuniv.library.util.Common;
import com.alepuniv.library.view.adapter.viewholder.PersonViewHolder;

import java.util.List;

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private Context context;
    private List<Person> persons;

    public PersonRecyclerAdapter(Context context, List<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_person, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.getTxtRecyclerPersonFirstName().setText(person.getFirstName());
        holder.getTxtRecyclerPersonFatherName().setText(person.getFatherName());
        holder.getTxtRecyclerPersonLastName().setText(person.getLastName());
        holder.getTxtRecyclerPersonAddress().setText(person.getAddress());
        Common.loadImage(context, person.getImage(), holder.getImgRecyclerPersonImage());

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public void setData(List<Person> persons){
        this.persons = persons;
        notifyDataSetChanged();
    }
}
