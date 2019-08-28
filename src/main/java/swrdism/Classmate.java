package swrdism;

import org.springframework.stereotype.Component;

@Component
public class Classmate {
    private int id;
    private int number;
    private int score;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }
}