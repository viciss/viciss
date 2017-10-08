package net.samhouse;

import net.samhouse.config.CDPlayerConfig;
import net.samhouse.impl.BlankDisc;
import net.samhouse.impl.CompactDisc;
import net.samhouse.impl.MediaPlayer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
@ActiveProfiles("prod")
public class CDPlayerTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    @Autowired
    private CompactDisc sgtPeppers;

    @Autowired
    private MediaPlayer cdPlayer2;

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(sgtPeppers);
    }

    @Test
    public void play() {
        systemOutRule.enableLog();
        cdPlayer2.play();
        assertEquals(
                "Playing Sgt. Pepper's Lonely Hearts Club Band" +
                        " by The Beatles\n",
                systemOutRule.getLog()
        );
    }

    @Test
    public void blankDisc() {
        blankDisc.play();
    }
}
