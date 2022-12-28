package com.aquari.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY="bookId";
    private TextView _txtBookname, _txtAuthor, _txtPages, _txtDescription;
    private Button _btnAddToWantToRead, _btnAddToAlreadyRead, _btnAddToCurrentlyReading, _btnAddToFavorites;
    private ImageView _bookImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initView();


        Intent intent = getIntent();
        if(intent!=null){
            //int bookId=intent.getIntExtra("bookId",-1);
            int bookId=intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookId!=-1){
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (incomingBook!=null){
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);
                }
            }
        }



    }

    private void handleFavoriteBooks(final Book book) {
        ArrayList<Book> favoritesBooks = Utils.getInstance().getFavoriteBooks();
        boolean existInFavoriteBooks=false;
        for(Book b: favoritesBooks){
            if(b.get_id()== book.get_id()){
                existInFavoriteBooks=true;
            }
        }
        if(existInFavoriteBooks){
            _btnAddToFavorites.setEnabled(false);
        }else
        {
            _btnAddToFavorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToFavorites(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,FavoriteActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    private void handleCurrentlyReadingBooks(final Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getCurrentlyReadingBooks();
        boolean existInCurrentlyReadingBooks=false;
        for(Book b: currentlyReadingBooks){
            if(b.get_id()== book.get_id()){
                existInCurrentlyReadingBooks=true;
            }
        }
        if(existInCurrentlyReadingBooks){
            _btnAddToCurrentlyReading.setEnabled(false);
        }else
        {
            _btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToCurrentlyReading(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,CurrentlyReadingActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    private void handleWantToReadBooks(final Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();
        boolean existInWantToReadBooks=false;
        for(Book b: wantToReadBooks){
            if(b.get_id()== book.get_id()){
                existInWantToReadBooks=true;
            }
        }
        if(existInWantToReadBooks){
            _btnAddToWantToRead.setEnabled(false);
        }else
        {
            _btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToWantToRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,WantToReadActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }

    private void handleAlreadyRead(final Book book){
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();
        boolean existInAlreadyReadBooks=false;
        for(Book b: alreadyReadBooks){
            if(b.get_id()== book.get_id()){
                existInAlreadyReadBooks=true;
            }
        }
        if(existInAlreadyReadBooks){
            _btnAddToAlreadyRead.setEnabled(false);
        }else
        {
            _btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happened, try again", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }
    private void setData(@NonNull Book book){
        _txtBookname.setText(book.get_name());
        _txtAuthor.setText(book.get_author());
        _txtPages.setText(String.valueOf(book.get_pages()));
        _txtDescription.setText(book.get_shortDesc());

        Glide.with(this)
                .asBitmap()
                .load(book.get_imageUrl())
                .into(_bookImage);
    }


    private void initView()
    {
        _txtBookname=findViewById(R.id.txtBookName);
        _txtAuthor=findViewById(R.id.txtAuthorName);
        _txtPages=findViewById(R.id.txtPages);
        _txtDescription=findViewById(R.id.txtDescription);

        _btnAddToWantToRead=findViewById(R.id.btnAddToWantToReadList);
        _btnAddToAlreadyRead=findViewById(R.id.btnAddToAlreadyReadList);
        _btnAddToCurrentlyReading=findViewById(R.id.btnAddToCurrentlyReading);
        _btnAddToFavorites=findViewById(R.id.btnAddToFavorite);

        _bookImage=findViewById(R.id.bookImage);
    }
}