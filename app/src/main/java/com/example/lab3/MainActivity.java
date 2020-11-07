package com.example.lab3;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<IPerson> persons = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnClear = findViewById(R.id.btnClearList);
        btnClear.setOnClickListener(view -> {
            persons.clear();
            recyclerView.getAdapter().notifyDataSetChanged();
        });

        Button btnRead = findViewById(R.id.btnReadFromDB);
        btnRead.setOnClickListener(view -> new Thread(() -> {
            List<PersonAddress> personAddresses = PersonDataBase.getDB(getApplicationContext()).personDAO().getPersonAddressFromBD();
            persons.addAll(personAddresses);
            List<PersonPhone> personPhones = PersonDataBase.getDB(getApplicationContext()).personDAO().getPersonPhoneFromBD();
            persons.addAll(personPhones);

            runOnUiThread(() -> recyclerView.getAdapter().notifyDataSetChanged());
        }).start());

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PersonAdapter(persons));

        intData();
    }

    private void intData() {
        new Thread(() -> {
            List<CompositePerson> compositePersons = ApiPersonService.get().getPersons(null);
            for (CompositePerson compositePerson : compositePersons) {
                persons.add(compositePerson.toIPerson());
            }

            for (IPerson iPerson : persons){
                switch (iPerson.getType()){
                    case 1:
                        PersonDataBase.getDB(getApplicationContext()).personDAO().insertPersonPhone((PersonPhone)iPerson);
                        break;
                    case 2:
                        PersonDataBase.getDB(getApplicationContext()).personDAO().insertPersonAddress((PersonAddress) iPerson);
                        break;
                }
            }

            runOnUiThread(() -> recyclerView.getAdapter().notifyDataSetChanged());
        }).start();
    }
}