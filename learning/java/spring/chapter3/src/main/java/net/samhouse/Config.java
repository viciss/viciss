package net.samhouse;

import net.samhouse.impl.BlankDisc;
import net.samhouse.impl.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.ArrayList;

@Configuration
@PropertySource("classpath:app.properties")
public class Config {
    @Autowired
    private Environment environment;

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }

    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setTitle(environment.getProperty("disc.title"));
        blankDisc.setArtist(environment.getProperty("disc.artist"));
        blankDisc.setTracks(environment.getProperty("disc.tracks", ArrayList.class));
        return blankDisc;
    }
}
