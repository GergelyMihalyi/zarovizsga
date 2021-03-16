package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog {

    public Husky(String name) {
        super(name);
    }

    public void feed() {
        increaseHappiness(4);
    }

    public void play(int hours) {
        increaseHappiness(hours * 3);
    }
}
