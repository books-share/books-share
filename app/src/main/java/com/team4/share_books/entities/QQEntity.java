package com.team4.share_books.entities;

/**
 * Created by john on 17/11/9.
 */

public class QQEntity {
    private String openid;
    private String access_token;
    private String expires_in;

    public QQEntity(){}

    public QQEntity(String openid, String access_token, String expires_in) {
        this.openid = openid;
        this.access_token = access_token;
        this.expires_in = expires_in;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "QQEntity{" +
                "openid='" + openid + '\'' +
                ", access_token='" + access_token + '\'' +
                ", expires_in='" + expires_in + '\'' +
                '}';
    }
}
