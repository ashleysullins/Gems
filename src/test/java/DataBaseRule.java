import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/gem_test", null, null);
   }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      // String deleteFusionsQuery = "DELETE FROM fusions WHERE id >= 6;";
      // String deleteCategoriesQuery = "DELETE FROM categories *;";
      // con.createQuery(deleteFusionsQuery).executeUpdate();
      // con.createQuery(deleteCategoriesQuery).executeUpdate();
    }
  }
}
