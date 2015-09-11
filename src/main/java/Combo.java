import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class Combo {
  private int gem1_id;
  private int gem2_id;
  private int fusion_id;
  private int id;

  public Combo (int gem1_id, int gem2_id) {
    this.gem1_id = gem1_id;
    this.gem2_id = gem2_id;
  }

  public int getGem1() {
    return gem1_id;
  }

  public int getId() {
    return id;
  }
  public int getGem2() {
    return gem2_id;
  }

  public int fusionId() {
    return fusion_id;
  }

  public static List<Combo> all() {
    String sql = "SELECT id, gem1_id, gem2_id, fusion_id FROM combos";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Combo.class);
    }
  }

  // public String getFusion() {
  //     String sql ="SELECT fusion_id FROM combos WHERE (((gem1_id = :gem1_id) OR (gem2_id = :gem1_id)) && ((gem1_id = :gem2_id) OR (gem2_id = :gem2_id)))";
  //   } return fusion;
  // }

  //
  // public ArrayList<Combo> getPotentialPairs() {
  //   try(Connection con = DB.sql2o.open()) {
  //   String sql = "SELECT gem_name FROM gems JOIN combos ON (combos.gem1_id = gems.id) OR (combos.gem2_id = gems.id) WHERE combos.id = :id";
  //   List<Integer> comboIds = con.createQuery(sql)
  //     .addParameter("comboId", this.getId())
  //     .executeAndFetch(Integer.class);
  //
  //     ArrayList<Combo> combos = new ArrayList<Combo>();
  //
  //     for (Integer comboId : comboIds ) {
  //       String comboQuery = "Select * FROM combos WHERE id = :comboId";
  //       Combo combo = con.createQuery(comboQuery)
  //         .addParameter("comboId", comboId)
  //         .executeAndFetchFirst(Combo.class);
  //       }
  //       return combos;
  //   }
  // }

  public Integer getFusionId() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT fusion_id FROM combos WHERE (combos.gem1_id = :gem1_id) AND (combos.gem2_id = :gem2_id)";
      Integer fusionId = con.createQuery(sql)
        .addParameter("gem1_id", this.getGem1())
        .addParameter("gem2_id", this.getGem2())
        .executeAndFetchFirst(Integer.class);
        return fusionId;
      }
  }

}
