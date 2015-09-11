import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class FusionTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void find_FusionInDatabase_true() {
    Fusion savedFusion = Fusion.find(1);
    assertEquals("Opal", savedFusion.getName());
  }

  @Test
   public void find_FusionDescription_true() {
     Fusion savedFusion = Fusion.find(1);
     assertEquals("Ultra-powerful, stone-cold Betty.", savedFusion.getDescription());
   }

   @Test
   public void all_returnAllItems() {
     assertEquals(Fusion.all().size(), 5);
   }

}
