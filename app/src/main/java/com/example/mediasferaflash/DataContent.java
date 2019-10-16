package com.example.mediasferaflash;

public class DataContent {
    private String articleTitle;
    private String priceArticle;
    private Boolean bookmarksArticle;

    public DataContent(String articleTitle, String priceArticle, Boolean bookmarksArticle) {
        this.articleTitle = articleTitle;
        this.priceArticle = priceArticle;
        this.bookmarksArticle = bookmarksArticle;
    }

    public DataContent(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public DataContent(String articleTitle, String priceArticle) {
        this.articleTitle = articleTitle;
        this.priceArticle = priceArticle;
    }

    public DataContent(String articleTitle, Boolean bookmarksArticle) {
        this.articleTitle = articleTitle;
        this.bookmarksArticle = bookmarksArticle;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getPriceArticle() {
        return priceArticle;
    }

    public void setPriceArticle(String priceArticle) {
        this.priceArticle = priceArticle;
    }

    public Boolean getBookmarksArticle() {
        return bookmarksArticle;
    }

    public void setBookmarksArticle(Boolean bookmarksArticle) {
        this.bookmarksArticle = bookmarksArticle;
    }
}
