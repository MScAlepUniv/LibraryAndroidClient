package com.alepuniv.library.view.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alepuniv.library.R;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private View view;
    private TextView txtRecyclerPersonFirstName;
    private TextView txtRecyclerPersonFatherName;
    private TextView txtRecyclerPersonLastName;
    private TextView txtRecyclerPersonAddress;
    private ImageView imgRecyclerPersonImage;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;
        txtRecyclerPersonFirstName = view.findViewById(R.id.txtRecyclerPersonFirstName);
        txtRecyclerPersonFatherName = view.findViewById(R.id.txtRecyclerPersonFatherName);
        txtRecyclerPersonLastName = view.findViewById(R.id.txtRecyclerPersonLastName);
        txtRecyclerPersonAddress = view.findViewById(R.id.txtRecyclerPersonAddress);
        imgRecyclerPersonImage = view.findViewById(R.id.imgRecyclerPersonImage);
    }

    public View getView() {
        return view;
    }

    public TextView getTxtRecyclerPersonFirstName() {
        return txtRecyclerPersonFirstName;
    }

    public TextView getTxtRecyclerPersonFatherName() {
        return txtRecyclerPersonFatherName;
    }

    public TextView getTxtRecyclerPersonLastName() {
        return txtRecyclerPersonLastName;
    }

    public TextView getTxtRecyclerPersonAddress() {
        return txtRecyclerPersonAddress;
    }

    public ImageView getImgRecyclerPersonImage() {
        return imgRecyclerPersonImage;
    }
}
