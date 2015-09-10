import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/gem_test", null, null);
   }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      // WILL BE NAMING THESE BASED ON USER-GENERATED TABLE
      // String deleteTasksQuery = "DELETE FROM tasks *;";
      // String deleteCategoriesQuery = "DELETE FROM categories *;";
      // con.createQuery(deleteTasksQuery).executeUpdate();
      // con.createQuery(deleteCategoriesQuery).executeUpdate();
    }
  }
}
