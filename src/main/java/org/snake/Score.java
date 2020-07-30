package org.snake;

public class Score {
    private String data;
    private String score;

    public Score(String score, String data){
        this.data = data;
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
