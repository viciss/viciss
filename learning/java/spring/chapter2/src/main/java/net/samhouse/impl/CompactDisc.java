package net.samhouse.impl;

public interface CompactDisc {
    void play();

    default void playTrack(int trackNumber) {
        System.out.println("In CompactDisc, the track number is " + trackNumber);
    }
}
