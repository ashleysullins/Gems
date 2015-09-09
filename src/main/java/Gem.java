import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class Gem {
  private String name;
  private int id;
  private ArrayList<int> potentialPairs;

  public Gem (String name, int id, ArrayList<int> potentialPairs) {
    this.id = id;
    this.name = name;
    this.potentialPairs = potentialPairs;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public ArrayList<int> getPairs() {
    return potentialPairs;
  }

  @Override
  public boolean equals(Object otherGemObject) {
    if (!(otherGemInstance instanceof Gem)) {
      return false;
    } else {
      Gem newGemInstance = (Gem) otherGemInstance;
      return this.getName().equals(newGemInstance.getName()) &&
             this.getPairs() == (newGemInstance.getPairs()) &&
             this.getId() == newGemInstance.getId();
    }
  }

  public static List<Gem> all() {
    String sql = "SELECT id, gem_name, potential_pairs FROM gems";
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
