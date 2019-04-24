package com.seffu.morningprojectnineb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView list;
    ArrayList<Item> users;
    Item person;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = new ArrayList();
        adapter = new CustomAdapter(this,users);
        list = findViewById(R.id.listWatu);
        Item person = new Item("Seffu","0708441307",R.drawable.shulei);
        Item person1 = new Item("King","0708991307",R.drawable.shulei);
        Item person2 = new Item("Nelly","0708465307",R.drawable.shulei);
        Item person3 = new Item("Claire","0708441447",R.drawable.shulei);
        Item person4 = new Item("John","0788441307",R.drawable.shulei);
        Item person5 = new Item("Sam","0708455307",R.drawable.shulei);
        Item person6 = new Item("Andy","0708441357",R.drawable.shulei);
        Item person7 = new Item("Willy","0708491307",R.drawable.shulei);
        Item person8 = new Item("Angie","0708442307",R.drawable.shulei);
        Item person9 = new Item("Tertius","0708443307",R.drawable.shulei);
        Item person10 = new Item("Raymond","0708444307",R.drawable.shulei);
        users.add(person1);
        users.add(person2);
        users.add(person3);
        users.add(person4);
        users.add(person5);
        users.add(person6);
        users.add(person7);
        users.add(person8);
        users.add(person9);
        users.add(person10);

        list.setAdapter(adapter);
    }
}
