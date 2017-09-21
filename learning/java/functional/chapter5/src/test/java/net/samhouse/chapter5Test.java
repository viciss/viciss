package net.samhouse;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class chapter5Test {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testOrder() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> sameOrder = numbers.stream().collect(Collectors.toList());

        assertEquals(numbers, sameOrder);

        Set<Integer> numberSet = new HashSet<>(Arrays.asList(4, 3, 2, 1));
        sameOrder = numberSet.stream().collect(Collectors.toList());

        // As set cannot guarantee the order of elements, so the following
        // assertion sometimes may fail
        assertNotEquals(Arrays.asList(4, 3, 2, 1), sameOrder);

        sameOrder = numberSet.stream().sorted().collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2, 3, 4), sameOrder);
    }
}
