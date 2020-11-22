package com.example.addnewviewonbuttontap.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addnewviewonbuttontap.Interface.OnItemClick;
import com.example.addnewviewonbuttontap.R;
import com.example.addnewviewonbuttontap.helper.Utils;
import com.example.addnewviewonbuttontap.model.AddNewViewModel;

import java.util.ArrayList;

public class AddNewViewAdapter extends RecyclerView.Adapter<AddNewViewAdapter.ViewHolder> {

    ArrayList<AddNewViewModel> viewList;
    Context context;
    OnItemClick onItemClick;

    public AddNewViewAdapter(ArrayList<AddNewViewModel> viewList, Context context, OnItemClick onItemClick) {
        this.viewList = viewList;
        this.context = context;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_add_new_view, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final AddNewViewModel model = viewList.get(i);

        String phoneNumber = model.getPhoneNumber();
        if (!Utils.isStringNull(phoneNumber)) {
            viewHolder.etPhone.setText(phoneNumber);
        }

        // set phone number to which edit text in add
        viewHolder.etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                model.setPhoneNumber(viewHolder.etPhone.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        viewHolder.btRemove.setOnClickListener(v -> onItemClick.onItemClickListener(i));
    }

    @Override
    public int getItemCount() {
        return viewList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        Button btRemove;
        EditText etPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btRemove = itemView.findViewById(R.id.btRemove);
            etPhone = itemView.findViewById(R.id.etPhone);
        }
    }

}
