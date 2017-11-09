package com.team4.share_books.login.model.imp;

import android.content.Context;

import com.team4.share_books.entities.BookEntity;
import com.team4.share_books.login.model.BookListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 17/11/7.
 */

public class BookListModelImp implements BookListModel {
    private Context mContext;
    private String url;
    private String token;
    private List<BookEntity> bookEntityList;
    private CompleteListener completeListener;

    public BookListModelImp(Context context, CompleteListener c){
        mContext = context;
        completeListener = c;
        bookEntityList = new ArrayList<>();
    }


    @Override
    public void setData() {

    }
}
