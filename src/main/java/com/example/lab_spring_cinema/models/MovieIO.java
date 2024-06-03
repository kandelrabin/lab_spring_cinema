package com.example.lab_spring_cinema.models;

public class MovieIO {
    private String title;
    private String rating;
    private double duration;
    private String message;

    public MovieIO(String title, String rating, double duration){
        this.title = title;
        this.rating = rating;
        this.duration = duration;
        this.message = (this.title == null) ? "Movie not found!": "movie found!";
    }

    public MovieIO(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
