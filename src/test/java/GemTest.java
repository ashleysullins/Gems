import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class GemTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void equals_returnsTrueIfSame() {
    Gem firstGem = new Gem("Pearl");
    Gem secondGem = new Gem("Pearl");
    assertTrue(firstGem.equals(secondGem));
  }

  @Test
  public void find_returnsObjectByID() {
    Gem gem1 = new Gem("Pearl");
    gem1.save();
    Gem saved = Gem.find(gem1.getId());
    assertTrue(gem1.equals(saved));
  }

  @Test
  public void find_findGemInDatabase_true() {
    Gem myGem = new Gem("Pearl");
    myGem.save();
    Gem savedGem = Gem.find(myGem.getId());
    assertTrue(myGem.equals(savedGem));
  }

  @Test
  public void getPairs_returnsPotentialPairs() {
    Gem myFusionOptions = new Gem("Pearl");
  }

  @Test
  public void all_returnSixItems() {
    assertEquals(Gem.all().size(), 6);
  }

}
