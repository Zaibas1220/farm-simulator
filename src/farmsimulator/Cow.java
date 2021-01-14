package farmsimulator;

import java.util.Collections;
import java.util.Random;

public class Cow implements Milkable, Alive {
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    private double udderCapacity;
    private String name;
    private double amount;
    private Random random;

    public Cow() {
        this.random = new Random();
        this.name = NAMES[random.nextInt(NAMES.length)];
        this.udderCapacity = 15 + random.nextInt(26);
        this.amount = 0;
    }

    public Cow(String name) {
        this.random = new Random();
        this.name = name;
        this.udderCapacity = 15 + random.nextInt(26);
        this.amount = 0;
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return this.udderCapacity;
    }

    public double getAmount() {
        return this.amount;
    }

    public String toString() {
        return this.name + " " + this.amount + "/" + this.udderCapacity;
    }

    @Override
    public void liveHour() {
        this.amount += 0.7 + (random.nextDouble()*1.3);
        if (this.amount > this.udderCapacity){
            this.amount = this.udderCapacity;
        }
    }

    @Override
    public double milk() {
        double num = this.amount;
        this.amount = 0;
        return num;
    }
}
