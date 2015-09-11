import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class GemTest {

  public List<Integer> pairs;

  // @Rule
  // public DatabaseRule database = new DatabaseRule();

  @Test
  public void equals_returnsTrueIfGemsAreTheSame() {
    Gem firstGem = new Gem("Melocite");
    Gem secondGem = new Gem("Melocite");
    assertTrue(firstGem.equals(secondGem));
  }

  @Test
  public void find_returnsObjectById() {
    Gem savedGem = Gem.find(1);
    assertEquals("Garnet", savedGem.getGemName());
  }

  @Test
  public void all_returnSixItems() {
    assertEquals(Gem.all().size(), 6);
  }

}
