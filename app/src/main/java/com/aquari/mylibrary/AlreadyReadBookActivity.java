package com.aquari.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.util.Util;

public class AlreadyReadBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_book);

        //Definim recyclerView-ul si il alocam din interfata.
        RecyclerView recyclerView = findViewById(R.id.booksRecView);
        //definim adapter-ul interfetei cu acest context si cu un activity. Acest activity tine cont daca afiseaza sau nu butonul delete.

        BookRecViewAdapter adapter = new BookRecViewAdapter(this,"alreadyRead");
        recyclerView.setAdapter(adapter);
        //Aici se seteaza tipul de layout. Este setat linear si nu GridView, datorita acelui RelativeLayout colapsed care daca sunt asezate in Grid se seteaza expanded amandoua.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //setam ce afisam in adaptor.
        adapter.set_books(Utils.getAlreadyReadBooks());
    }

    /**
     * Se face ovr pe metoda onBack ca atunci cand apasam back ne ducem catre MainMenu, sa stergem  stack-ul din spate si sa setam MainMenu ca o noua activitate.
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}