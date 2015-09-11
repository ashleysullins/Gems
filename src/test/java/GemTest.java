import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class GemTest {

  public List<Integer> pairs;

  // @Before
  // public void initialize() {
  //   pairs = new List<Integer>();
  //   pairs.add(2);
  //   pairs.add(3);
  // }

  // @Rule
  // public DatabaseRule database = new DatabaseRule();

  @Test
  public void equals_returnsTrueIfGemsAreTheSame() {
    Gem firstGem = new Gem("Pearl");
    Gem secondGem = new Gem("Pearl");
    assertTrue(firstGem.equals(secondGem));
  }

  @Test
  public void find_returnsObjectById() {
    Gem gem1 = new Gem("Garnet");
    Gem savedGem = Gem.find(1);
    // System.out.println(savedGem.getPotentialPairs().getArray()[0]);
    // assertTrue(savedGem.getPotentialPairs() instanceof ArrayList);
  }

  // @Test
  // public void find_findGemInDatabase_true() {
  //   Gem savedGem = Gem.find(1);
  //   Gem myGem = new Gem("Garnet", pairs);
  //   assertTrue(myGem.equals(savedGem));
  // }

  // @Test
  // public void getPairs_returnsPotentialPairs() {
  //   Gem myGem = new Gem("Pearl");
  //   Assert.assertEquals(myGem.getPotentialPairs());
  // }

  @Test
  public void all_returnSixItems() {
    assertEquals(Gem.all().size(), 6);
  }

}
