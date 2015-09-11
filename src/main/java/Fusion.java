import org.sql2o.*;
import java.util.List;

  public class Fusion {
    private String fusion_name;
    private String description;
    private int id;

  public Fusion (String name, String description) {
    this.fusion_name = fusion_name;
    this.description = description;
  }

  @Override
  public boolean equals(Object otherFusion) {
    if (!(otherFusion instanceof Fusion)) {
      return false;
    } else {
      Fusion newFusion = (Fusion) otherFusion;
      return this.getName().equals(newFusion.getName()) &&
      this.getDescription().equals(newFusion.getDescription()) &&
      this.getId() == newFusion.getId();
    }
  }

  public String getName() {
    return fusion_name;
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

   public static List<Fusion> all() {
     String sql = "SELECT id, fusion_name, description FROM fusions";
     try(Connection con = DB.sql2o.open()) {
       return con.createQuery(sql).executeAndFetch(Fusion.class);
     }
   }

  //  public void save() {
  //  try(Connection con = DB.sql2o.open()) {
  //    String sql = "INSERT INTO fusions (name, description) VALUES (:name, :description)";
  //      this.id = (int) con.createQuery(sql, true)
  //      .addParameter("name", name)
  //      .executeUpdate()
  //      .getKey();
  //    }
  //  }

   public String getImgURL() {
     String imgURL = String.format("/img/%s.png", fusion_name);
     return imgURL;
   }

   public String getImgURL2() {
     String imgURL2 = String.format("/img/%s2.png", fusion_name);
     return imgURL2;
   }



}
