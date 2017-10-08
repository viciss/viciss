package net.samhouse;

public class Concert implements Performance {
    public Concert() {
        System.out.println("This is from Concert");
    }

    @Override
    public void perform() {
        System.out.println("Perform in concert!");
    }
}
