package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog{
    public Beagle(String name) {
        super(name);
    }

    public void feed() {
        increaseHappiness(2);
    }

    public void play(int hours) {
        increaseHappiness(hours * 2);
    }
}
