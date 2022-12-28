package com.aquari.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button _btnAllBooks, _btnAlreadyRead, _btnWantToRead, _btnCurrentlyReading, _btnFavorite,_btnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        initViews();

        _btnAllBooks.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
            startActivity(new Intent(MainActivity.this, AllBooksActivity.class));
            Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();

        });

        Utils.getInstance();

        _btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });
        _btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WantToReadActivity.class);
                startActivity(intent);
            }
        });

        _btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });

        _btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FavoriteActivity.class);
                startActivity(intent);
            }
        });

        _btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Designed and developed with love by Alexandru.\nCheck my GitHubPage: ");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Visit Github", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,WebsiteActivty.class);
                        intent.putExtra("url","https://github.com/aquari93");
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });
    }

    private void initViews(){

        _btnAllBooks= findViewById(R.id.btnMyBooks);
        _btnAlreadyRead=findViewById(R.id.btnAlreadyReadBooks);
        _btnWantToRead=findViewById(R.id.btnWishList);
        _btnCurrentlyReading=findViewById(R.id.btnCurrentlyReadingBooks);
        _btnFavorite=findViewById(R.id.btnFavorites);
        _btnAbout=findViewById(R.id.btnAbout);
    }
}