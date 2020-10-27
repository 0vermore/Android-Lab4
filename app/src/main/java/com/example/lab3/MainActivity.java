package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Europe> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        DataAdapter adapter = new DataAdapter(this, countries);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData(){
        countries.add(new Europe("Австрия", "Вена", R.drawable.wien));
        countries.add(new Europe("Бельгия", "Брюссель", R.drawable.brussels));
        countries.add(new Europe("Болгария", "София", R.drawable.sofia));
        countries.add(new Europe("Венгрия", "Будапешт", R.drawable.budapest));
        countries.add(new Europe("Германия", "Берлин", R.drawable.berlin));
        countries.add(new Europe("Греция", "Афины", R.drawable.athens));
        countries.add(new Europe("Дания", "Копенгаген", R.drawable.copenhagen));
        countries.add(new Europe("Ирландия", "Дублин", R.drawable.dublin));
        countries.add(new Europe("Испания", "Мадрид", R.drawable.madrid));
        countries.add(new Europe("Италия", "Рим", R.drawable.rome));
        countries.add(new Europe("Кипр", "Никосия", R.drawable.nicosia));
        countries.add(new Europe("Латвия", "Рига", R.drawable.riga));
        countries.add(new Europe("Литва", "Вильнюс", R.drawable.vilnus));
        countries.add(new Europe("Люксембург", "Люксембург", R.drawable.luxembourg));
        countries.add(new Europe("Мальта", "Валлетта", R.drawable.valletta));
        countries.add(new Europe("Нидерланды", "Амстердам", R.drawable.amsterdam));
        countries.add(new Europe("Польша", "Варшава", R.drawable.warsaw));
        countries.add(new Europe("Португалия", "Лиссабон", R.drawable.lisbon));
        countries.add(new Europe("Румыния", "Бухарест", R.drawable.bucharest));
        countries.add(new Europe("Словакия", "Братислава", R.drawable.bratislava));
        countries.add(new Europe("Словения", "Любляна", R.drawable.ljubljana));
        countries.add(new Europe("Финляндия", "Хельсинки", R.drawable.helsinki));
        countries.add(new Europe("Франция", "Париж", R.drawable.paris));
        countries.add(new Europe("Хорватия", "Загреб", R.drawable.zagreb));
        countries.add(new Europe("Чехия", "Прага", R.drawable.prague));
        countries.add(new Europe("Швеция", "Стокгольм", R.drawable.stockholm));
        countries.add(new Europe("Эстония", "Таллин", R.drawable.tallinn));
    }
}