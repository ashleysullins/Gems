import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class Gem {
  private String gem_name;
  private int id;
  private ArrayList<Integer> potential_pairs;

  public Gem (String gem_name, int id, ArrayList<Integer> potential_pairs) {
    this.id = id;
    this.gem_name = gem_name;
    this.potential_pairs = potential_pairs;
  }

  public String getGemName() {
    return gem_name;
  }

  public int getId() {
    return id;
  }

  public ArrayList<Integer> getPotentialPairs() {
    return potential_pairs;
  }

  @Override
  public boolean equals(Object otherGemInstance) {
    if (!(otherGemInstance instanceof Gem)) {
      return false;
    } else {
      Gem newGemInstance = (Gem) otherGemInstance;
      return this.getGemName().equals(newGemInstance.getGemName()) &&
             this.getPotentialPairs() == (newGemInstance.getPotentialPairs()) &&
             this.getId() == newGemInstance.getId();
    }
  }

  public static List<Gem> all() {
    String sql = "SELECT * FROM gems";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Gem.class);
    }
  }

  public List<Gem> getName() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT gem_name FROM gems WHERE id = :id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Gem.class);
    }
  }

  /*
  public void get

  public void save(){
      try (Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO brands (brand_name) VALUES (:brand_name)";
        this.id = (int) con.createQuery(sql, true)
        .addParameter("brand_name", brand_name)
        .executeUpdate()
        .getKey();
      }
    }
*/
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
