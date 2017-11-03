package net.samhouse.impl;

import org.springframework.stereotype.Component;

@Component
public class WhiteAlbum implements CompactDisc {
    private String title = "White albums";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
