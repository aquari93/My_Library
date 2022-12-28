package com.aquari.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
private RecyclerView _booksRecView;
private BookRecViewAdapter _adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        _adapter=new BookRecViewAdapter(this,"allBooks");
        initVariables();
    }


    public void initVariables(){
        _booksRecView=findViewById(R.id.booksRecView);
        _booksRecView.setAdapter(_adapter);
        _booksRecView.setLayoutManager(new LinearLayoutManager(this));


        _adapter.set_books(Utils.getInstance().getAllBooks());
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_out,R.anim.slide_in);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
               onBackPressed();
               break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}