import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Gem {
  private String gem_name;
  private int id;

  public Gem (String gem_name) {
    this.gem_name = gem_name;
  }

  public String getGemName() {
    return gem_name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  // public List<PotentialPairs> getPotentialPairs() {
  //   String sql = "select gem1_id, gem2_id from combos where gem1_id = :id;";
  //   return Arrays.asList(gem_name);
  // }

  @Override
  public boolean equals(Object otherGemObject) {
    if (!(otherGemObject instanceof Gem)) {
      return false;
    } else {
      Gem newGemObject = (Gem) otherGemObject;
      return this.getGemName().equals(newGemObject.getGemName());
    }
  }

  public static List<Gem> all() {
    String sql = "SELECT id, gem_name FROM gems";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Gem.class);
    }
  }


  public static Gem find(int id) {
     try(Connection con = DB.sql2o.open()) {
       String sql = "SELECT * FROM gems WHERE id = :id";
       Gem gem = con.createQuery(sql)
       .addParameter("id", id)
       .executeAndFetchFirst(Gem.class);
       return gem;
     }
   }

 ////idkkkkkkkkk?!?!!
//   public List<Pair> getPairs() {
//   try(Connection con = DB.sql2o.open()) {
//     String sql = "SELECT potential_pairs.* FROM stores JOIN stores_brands ON (stores.id = stores_brands.stores_id) JOIN brands ON (stores_brands.brands_id = brands.id) WHERE stores.id = :id";
//     List<Pair> potentialpairs = con.createQuery(sql)
//         .addParameter("id", id)
//         .executeAndFetch(Pair.class);
//     return potentialpairs;
//   }
// }

}
