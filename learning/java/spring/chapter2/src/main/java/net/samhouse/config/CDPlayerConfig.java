package net.samhouse.config;

import net.samhouse.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
//@ComponentScan(basePackages = "net.samhouse")
public class CDPlayerConfig {
    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public CompactDisc randomBeatlesCD() {
        int choice = (int) Math.floor(Math.random() * 4);
        if (choice == 0) {
            return new SgtPeppers();
        }
        else if (choice == 1) {
            return new WhiteAlbum();
        }
        else if (choice == 2) {
            return new HardDaysNight();
        }
        else {
            return new Revolver();
        }
    }

    @Bean
    public CDPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }

    @Bean
    public CDPlayer cdPlayer1(CompactDisc sgtPeppers) {
        return new CDPlayer(sgtPeppers);
    }

    @Bean
    public CDPlayer cdPlayer2(CompactDisc sgtPeppers) {
        System.out.println("Constructed from cdPlayer2!");
        CDPlayer cdPlayer = new CDPlayer(sgtPeppers);
        cdPlayer.setCompactDisc(sgtPeppers);
        return cdPlayer;
    }

    @Bean
    @Profile("prod")
    public BlankDisc blankDisc() {
        System.out.println("Constructed from blankdis!");
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setArtist("The Beatles");
        blankDisc.setTitle("Sgt. Pepper's LoneLy Hearts Club Band");
        List<String> tracks = new ArrayList<>();
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        tracks.add("With a Little Help from My Friend");
        blankDisc.setTracks(tracks);

        return blankDisc;
    }
}
