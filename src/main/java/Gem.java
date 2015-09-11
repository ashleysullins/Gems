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

  @Override
  public boolean equals(Object otherGemObject) {
    if (!(otherGemObject instanceof Gem)) {
      return false;
    } else {
      Gem newGemObject = (Gem) otherGemObject;
      return this.getGemName().equals(newGemObject.getGemName());
    }
  }

  public String getImgURL() {
    String imgURL = String.format("/img/%s.png", gem_name);
    return imgURL;
  }

  public String getImgURL2() {
    String imgURL2 = String.format("/img/%s2.png", gem_name);
    return imgURL2;
  }

  public static List<Gem> all() {
    String sql = "SELECT id, gem_name FROM gems";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Gem.class);
    }
  }

  public ArrayList<Gem> getCombos(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT gem2_id FROM combos WHERE gem1_id = :id";
      List<Integer> gemIds = con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Integer.class);

      ArrayList<Gem> gems = new ArrayList<Gem>();

    for(Integer gemId : gemIds) {
      String gemQuery = "Select * From gems WHERE id = :gemId";
      Gem gem = con.createQuery(gemQuery)
        .addParameter("gemId", gemId)
        .executeAndFetchFirst(Gem.class);
      gems.add(gem);
      } return gems;
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
}
