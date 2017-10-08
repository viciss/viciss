package net.samhouse.impl;

import org.springframework.stereotype.Component;

@Component
public class HardDaysNight implements CompactDisc {
    private String title = "Hard days night";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
