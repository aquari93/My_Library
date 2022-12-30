package com.aquari.mylibrary;

/**
 * Un ModelView care contine elementele cartii. Impreuna cu constructorul, getterele si setterele
 */
public class Book {

    private int _id;
    private String _name;
    private String _author;
    private int _pages;
    private String _imageUrl;
    private String _shortDesc;
    private String _longDesc;
    private boolean _isExpanded;


    public Book(int _id, String _name, String _author, int _pages, String _imageUrl, String _shortDesc, String _longDesc) {
        this._id = _id;
        this._name = _name;
        this._author = _author;
        this._pages = _pages;
        this._imageUrl = _imageUrl;
        this._shortDesc = _shortDesc;
        this._longDesc = _longDesc;
        _isExpanded=false;
    }

    /**
     * O metoda custom pentru verificarea starii Expanded a RelativeLayout din RecycleView
     * @return
     */
    public boolean is_isExpanded() {
        return _isExpanded;
    }

    /**
     * Se seteaza expanded atunci cand apasam pe butonul downArrow din interfata.
     * @param _isExpanded
     */
    public void set_isExpanded(boolean _isExpanded) {
        this._isExpanded = _isExpanded;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_author() {
        return _author;
    }

    public void set_author(String _author) {
        this._author = _author;
    }

    public int get_pages() {
        return _pages;
    }

    public void set_pages(int _pages) {
        this._pages = _pages;
    }

    public String get_imageUrl() {
        return _imageUrl;
    }

    public void set_imageUrl(String _imageUrl) {
        this._imageUrl = _imageUrl;
    }

    public String get_shortDesc() {
        return _shortDesc;
    }

    public void set_shortDesc(String _shortDesc) {
        this._shortDesc = _shortDesc;
    }

    public String get_longDesc() {
        return _longDesc;
    }

    public void set_longDesc(String _longDesc) {
        this._longDesc = _longDesc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "_id=" + _id +
                ", _name='" + _name + '\'' +
                ", _author='" + _author + '\'' +
                ", _pages=" + _pages +
                ", _imageUrl='" + _imageUrl + '\'' +
                ", _shortDesc='" + _shortDesc + '\'' +
                ", _longDesc='" + _longDesc + '\'' +
                '}';
    }
}
