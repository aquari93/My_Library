package com.aquari.mylibrary;

import static com.aquari.mylibrary.BookActivity.BOOK_ID_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder> {
    private static final String TAG = "BookRecViewAdapter";
    private ArrayList<Book> _books = new ArrayList<>();
    private Context mContext;
    private String parentActivity;

    public BookRecViewAdapter(Context mContext, String parentActivity) {
        this.mContext = mContext;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder._txtName.setText(_books.get(position).get_name());
        Glide.with(mContext)
                .asBitmap()
                .load(_books.get(position).get_imageUrl())
                .into(holder._imgBook);

        holder._parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,BookActivity.class);
                intent.putExtra(BOOK_ID_KEY,_books.get(position).get_id());
                //intent.putExtra("bookName",_books.get(position).get_name());
                mContext.startActivity(intent);
               // Toast.makeText(mContext, _books.get(position).get_name() + "selected", Toast.LENGTH_SHORT).show();
            }
        });

        holder._txtAuthor.setText(_books.get(position).get_author());
        holder._txtDescription.setText(_books.get(position).get_shortDesc());
        if(_books.get(position).is_isExpanded()){
            TransitionManager.beginDelayedTransition(holder._parent);
            holder._expandedRelLayout.setVisibility(View.VISIBLE);
            holder._downArrow.setVisibility(View.GONE);
            if(parentActivity.equals("allBooks")){
                holder._btnDelete.setVisibility(View.GONE);
            }else if(parentActivity.equals("alreadyRead")){
                holder._btnDelete.setVisibility(View.VISIBLE);
                holder._btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure want to delete "+_books.get(position).get_name()+" ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String removedBook = _books.get(position).get_name();
                                if(Utils.getInstance().removeFromAlreadyRead(_books.get(position))){
                                    Toast.makeText(mContext, removedBook+" book successfully removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(mContext, "Something went wrong", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }else if(parentActivity.equals("wantToRead")){
                holder._btnDelete.setVisibility(View.VISIBLE);
                holder._btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure want to delete "+_books.get(position).get_name()+" ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String removedBook = _books.get(position).get_name();
                                if(Utils.getInstance().removeFromWantToToRead(_books.get(position))){
                                    Toast.makeText(mContext, removedBook+" book successfully removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(mContext, "Something went wrong", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });

            }else if(parentActivity.equals("currentlyReading")){

                holder._btnDelete.setVisibility(View.VISIBLE);
                holder._btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure want to delete "+_books.get(position).get_name()+" ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String removedBook = _books.get(position).get_name();
                                if(Utils.getInstance().removeFromCurrentlyReading(_books.get(position))){
                                    Toast.makeText(mContext, removedBook+" book successfully removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(mContext, "Something went wrong", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });

            }else {
                holder._btnDelete.setVisibility(View.VISIBLE);
                holder._btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        builder.setMessage("Are you sure want to delete "+_books.get(position).get_name()+" ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String removedBook = _books.get(position).get_name();
                                if(Utils.getInstance().removeFromFavorites(_books.get(position))){
                                    Toast.makeText(mContext, removedBook+" book successfully removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(mContext, "Something went wrong", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });

            }
        }
        else
        {
            TransitionManager.beginDelayedTransition(holder._parent);
            holder._expandedRelLayout.setVisibility(View.GONE);
            holder._downArrow.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return _books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView _parent;
        private ImageView _imgBook;
        private TextView _txtName;
        private ImageView _downArrow, _upArrow;
        private RelativeLayout _expandedRelLayout;
        private TextView _txtAuthor, _txtDescription;
        private TextView _btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            _parent=itemView.findViewById(R.id.parentMCV);
            _imgBook=itemView.findViewById(R.id.imgBook);
            _txtName=itemView.findViewById(R.id.txtName);

            _downArrow=itemView.findViewById(R.id.btnDownArrow);
            _upArrow=itemView.findViewById(R.id.btnUpArrow);
            _expandedRelLayout=itemView.findViewById(R.id.expandedRelLayout);
            _txtAuthor=itemView.findViewById(R.id.txtAuthor);
            _txtDescription=itemView.findViewById(R.id.txtShortDesc);
            _btnDelete=itemView.findViewById(R.id.btnDelete);
            _downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = _books.get(getAdapterPosition());
                    book.set_isExpanded(!book.is_isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });

            _upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = _books.get(getAdapterPosition());
                    book.set_isExpanded(!book.is_isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }

    public void set_books(ArrayList<Book> _books) {
        this._books = _books;
        notifyDataSetChanged();
    }
}
