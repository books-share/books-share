package com.team4.share_books.entities;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by john on 17/11/7.
 *
 * nameTx.setText("用户的名字");
 homepageViewholder.detailTx.setText("书上说");
 homepageViewholder.numTx.setText("23");
 homepageViewholder.booknameTx.setText("书的名字");
 homepageViewholder.authorTx.setText("作者名字");
 homepageViewholder.newPriceTx.setText("43");
 */

public class BookEntity implements Serializable {
    private Integer applynum;
    private String available;
    private String coverurl;
    private Integer id;
    private String name;
    private Date publishdate;
    private String status;
    private String tags;

    public BookEntity(String available, String coverurl, String name, String status, String tags) {

        this.available = available;
        this.coverurl = coverurl;

        this.name = name;
        this.status = status;
        this.tags = tags;
    }

    public Integer getApplynum() {
        return applynum;
    }

    public void setApplynum(Integer applynum) {
        this.applynum = applynum;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getCoverurl() {
        return coverurl;
    }

    public void setCoverurl(String coverurl) {
        this.coverurl = coverurl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
