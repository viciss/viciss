package net.samhouse;

import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan
public class Config {
    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public Audience1 audience1() {
        return new Audience1();
    }

    @Bean
    public Audience2 audience2() {
        return new Audience2();
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }

    @Bean
    public Concert concert() {
        return new Concert();
    }

    @Bean
    public EncoreableIntroducer ecoreIntroducer() {
        return new EncoreableIntroducer();
    }

    @Bean
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
