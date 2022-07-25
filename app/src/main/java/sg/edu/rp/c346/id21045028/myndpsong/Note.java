package sg.edu.rp.c346.id21045028.myndpsong;

import java.io.Serializable;

public class Note implements Serializable {
    private int id;
    private String title;
    private String singer;
    private String year;
    private String rating;

    public Note(int id,String title, String singer, String year, String rating) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }
}
