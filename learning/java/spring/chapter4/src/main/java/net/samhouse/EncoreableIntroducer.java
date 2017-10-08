package net.samhouse;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "net.samhouse.Performance+",
    defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
