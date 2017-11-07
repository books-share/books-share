package com.team4.share_books.login.view;

import com.team4.share_books.entities.BookEntity;

import java.util.List;


/**
 * Created by john on 2017/1/7.
 */

public interface HomeView extends BaseView{
    void onSuccess(List<BookEntity> list);
}
