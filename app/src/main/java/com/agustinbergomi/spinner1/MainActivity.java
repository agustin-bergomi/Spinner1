package com.agustinbergomi.spinner1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    presidents es una variable de clase (o class field)
    String[] presidents;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        agarramos el array
        presidents = getResources().getStringArray(R.array.presidents_array);
//        instancio spinner (creo un objeto s1 de tipo spinner) le asigno el recurso spinner1
        Spinner s1 = (Spinner) findViewById(R.id.spinner1);
//        Uso el adapter provisto por la clase ArrayAdapter. Crea vistas a partir de colecciones de vistas, por ejemplo: List View, Spinner View.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, presidents);
//
        s1.setAdapter(adapter);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                Toast.makeText(getBaseContext(),
                        "You have selected item : " + presidents[index],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
    }
}