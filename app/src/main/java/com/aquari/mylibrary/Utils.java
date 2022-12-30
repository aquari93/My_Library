package com.aquari.mylibrary;

import android.content.SharedPreferences;

import java.util.ArrayList;

public  class Utils {


    private static Utils instance;
    private SharedPreferences _sharedPreferences;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    private Utils() {

        if (allBooks ==null){
            allBooks= new ArrayList<>();
            initData();
        }

        if(alreadyReadBooks==null){
            alreadyReadBooks=new ArrayList<>();
        }
        if(wantToReadBooks==null){
            wantToReadBooks=new ArrayList<>();
        }
        if(currentlyReadingBooks==null){
            currentlyReadingBooks= new ArrayList<>();
        }
        if(favoriteBooks==null){
            favoriteBooks=new ArrayList<>();
        }
    }

    private void initData() {
        //TODO: add initial data

        allBooks.add( new Book(1, "1Q84" ,"Haruki Muraky", 1350, "https://m.media-amazon.com/images/I/41FdmYnaNuL._AC_SY780_.jpg",
                "A work of maddening brilliance", "Long Description"));
        allBooks.add( new Book(2, "The Myth Of Sisyphus" ,"Albert Camus", 1243, "https://cdn.waterstones.com/bookjackets/large/9780/1411/9780141182001.jpg",
                "Influenced by philosophers such as Søren Kierkegaard, Arthur Schopenhauer, and Friedrich Nietzsche, Camus introduces his philosophy of the absurd.", "Long Description"));
        allBooks.add( new Book(3, "DUNE" ,"Frank Herbert", 4123, "https://s13emagst.akamaized.net/products/16296/16295671/images/res_d4e96512a4c8c2527bdcc06479a25b25.jpg",
                "Dune is a 1965 epic science fiction novel by American author Frank Herbert, originally published as two separate serials in Analog magazine.", "Long Description"));
        allBooks.add( new Book(4, "The Great Gatsby" ,"F. SCOTT FITZGERALD", 4233, "https://cdn.dc5.ro/img-prod/1630051033-0-240.jpeg",
                "Relive the glorious excess of the roaring 1920s with this beautifully designed, jacketed hardcover edition of The Great Gatsby.", "Long Description"));
        allBooks.add( new Book(5, "Helliconia" ,"BRIAN ALDISS", 3222, "https://cdn.dc5.ro/img-prod/97648275-0-240.jpeg",
                "A vast world where the seasons last tens of thousands of years - the classic SF epic of world building.", "Long Description"));
        allBooks.add( new Book(6, "The Ministry for the Future" ,"KIM STANLEY ROBINSON", 1233, "https://cdn.dc5.ro/img-prod/919609964-0-240.jpeg",
                "The Ministry for the Future is a masterpiece of the imagination, using fictional eyewitness accounts to tell the story of how climate change will affect us all. ", "Long Description"));
    }


    public static Utils getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new Utils();
            return instance;

        }

    }


    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookById(int id){
        for(Book b: allBooks){
            if(b.get_id()==id){
                return b;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book);
    }
    public boolean addToWantToRead (Book book){
        return wantToReadBooks.add(book);
    }
    public boolean addToFavorites(Book book){
        return favoriteBooks.add(book);
    }
    public boolean addToCurrentlyReading(Book book){
        return currentlyReadingBooks.add(book);
    }
    public boolean removeFromAlreadyRead(Book book){
        return alreadyReadBooks.remove(book);
    }
    public boolean removeFromFavorites(Book book) {
        return favoriteBooks.remove(book);
    }
    public boolean removeFromCurrentlyReading(Book book) {
        return currentlyReadingBooks.remove(book);
    }
    public boolean removeFromWantToToRead (Book book){
        return wantToReadBooks.remove(book);
    }
}



