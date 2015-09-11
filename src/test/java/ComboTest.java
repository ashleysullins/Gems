import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class ComboTest {

  // @Rule
  // public DatabaseRule database = new DatabaseRule();

  @Test
  public void find_comboId_true() {
    Combo newCombo = new Combo(1, 2);
    Integer fusionId = newCombo.getFusionId();
    assertTrue(fusionId.equals(2));
  }

  @Test
  public void all_returnAllItems() {
    assertEquals(Combo.all().size(), 10);
  }

}
