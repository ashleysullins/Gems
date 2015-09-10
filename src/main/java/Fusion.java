import org.sql2o.*;
import java.util.List;

  public class Fusion {
    private String name;
    private String description;
    private int id;

  public Fusion (String name, String description) {
    this.name = name;
    this.description = description;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getId() {
    return id;
  }

  public static Fusion find(int id) {
     try(Connection con = DB.sql2o.open()) {
       String sql = "SELECT * FROM fusions WHERE id = :id";
       Fusion fusion = con.createQuery(sql)
       .addParameter("id", id)
       .executeAndFetchFirst(Fusion.class);
       return fusion;
     }
   }

  // public int getFusion(int gemOneId, int gemTwoId) {
  //   //get from the database.... where gemOneId and gemTwoId are



  // }


}
