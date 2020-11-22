package com.example.addnewviewonbuttontap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.addnewviewonbuttontap.Interface.OnItemClick;
import com.example.addnewviewonbuttontap.adapter.AddNewViewAdapter;
import com.example.addnewviewonbuttontap.model.AddNewViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etPhone;
    private Button btAdd;
    private RecyclerView rvPhoneList;
    private ArrayList<AddNewViewModel> viewList = new ArrayList<>();
    private AddNewViewAdapter addNewViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    private void Init() {
        etPhone = findViewById(R.id.etPhone);
        btAdd = findViewById(R.id.btAdd);
        rvPhoneList = findViewById(R.id.rvPhoneList);

        ClickListener();
    }

    private void AddNewViewList() {
        viewList.add(new AddNewViewModel()); // add view in list
        rvPhoneList.setHasFixedSize(true);
        rvPhoneList.setLayoutManager(new LinearLayoutManager(this));
        addNewViewAdapter = new AddNewViewAdapter(viewList, MainActivity.this, position -> {
            viewList.remove(position);
            addNewViewAdapter.notifyDataSetChanged();
        });
        rvPhoneList.setAdapter(addNewViewAdapter);
    }

    private void ClickListener() {
        btAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btAdd:
                AddNewViewList();
                break;
        }
    }
}