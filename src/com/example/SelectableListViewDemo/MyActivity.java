package com.example.SelectableListViewDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MyActivity extends Activity {

    private List<String> coffees = Arrays.asList("Caffe Americano","Caffe Latte", "Caffe Medici", "Flat white", "Macchiato");
    private ListView listView;
    private TextView selectedCoffee;
    private AdapterView.OnItemClickListener onCoffeeSelected = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
           updateSelectedCoffeeDisplay(coffees.get(i));
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listView = (ListView)findViewById(R.id.demoList);
        selectedCoffee = (TextView)findViewById(R.id.selectedCoffee);


        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.coffee_item, coffees));
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(onCoffeeSelected);

        initialiseSelections();
    }

    private void initialiseSelections() {
        listView.setItemChecked(2, true);
        updateSelectedCoffeeDisplay(coffees.get(2));
    }

    private void updateSelectedCoffeeDisplay(String coffee) {
        selectedCoffee.setText(coffee);
    }
}
