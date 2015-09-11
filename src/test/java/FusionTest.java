import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class FusionTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void equals_returnsTrueIfSame() {
    Fusion firstFusion = new Fusion("Opal", "GEEEMMM");
    Fusion secondFusion = new Fusion("Opal", "GEEEMMM");
    assertTrue(firstFusion.equals(secondFusion));
  }

  @Test
  public void find_returnsObjectByID() {
    Fusion fusion = new Fusion("Opal", "GEEMMM");
    Fusion saved = Fusion.find(fusion.getId());
    assertTrue(fusion.equals(saved));
  }

  // @Test
  // public void find_findFusionInDatabase_true() {
  //   Fusion myFusion = new Fusion("Opal");
  //   myFusion.save();
  //   Fusion savedFusion = Fusion.find(myFusion.getId());
  //   assertTrue(myFusion.equals(savedFusion));
  // }
  //
  // @Test
  // public void getPairs_returnsPotentialPairs() {
  //   Fusion myFusionOptions = new Fusion("Opal");
  // }
  //
  // @Test
  // public void all_returnSixItems() {
  //   assertEquals(Fusion.all().size(), 6);
  // }


}
