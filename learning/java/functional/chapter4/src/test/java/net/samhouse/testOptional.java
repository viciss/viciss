package net.samhouse;

import java.util.Optional;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by stone on 17/9/18.
 */
public class testOptional
{
  @Before
  public void setUp() throws Exception
  {
  }

  @After
  public void tearDown() throws Exception
  {
  }

  @Test
  public void testOption() {
    Optional<String> a = Optional.of("a");
    assertEquals("a", a.get());

    Optional emptyOptional = Optional.empty();
    Optional alsoEmpty = Optional.ofNullable(null);
    assertEquals(emptyOptional, alsoEmpty);

    assertTrue(a.isPresent());

    assertEquals("b", emptyOptional.orElse("b"));
    assertEquals("c", emptyOptional.orElseGet(() -> "c"));
  }
}
