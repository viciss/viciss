package net.samhouse.config;

import net.samhouse.impl.BraveKnight;
import net.samhouse.impl.Knight;
import net.samhouse.impl.Quest;
import net.samhouse.impl.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfig {
    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
