package swrdism;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classmate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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