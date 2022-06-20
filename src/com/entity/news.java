package com.entity;

public class news {
    private int news_id;
    private String news_content;
    private int month;
    private int day;
    private String name;
    private String published;

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "news{" +
                "news_id=" + news_id +
                ", news_content='" + news_content + '\'' +
                ", month=" + month +
                ", day=" + day +
                ", name='" + name + '\'' +
                ", published='" + published + '\'' +
                '}';
    }
}

