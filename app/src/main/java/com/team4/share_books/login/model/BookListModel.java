package com.team4.share_books.login.model;

import com.team4.share_books.entities.BookEntity;

import java.util.List;

/**
 * Created by john on 17/11/7.
 */

public interface BookListModel {
    interface CompleteListener {
        void onSuccess(List<BookEntity> list);
    }

    void setData();
}
