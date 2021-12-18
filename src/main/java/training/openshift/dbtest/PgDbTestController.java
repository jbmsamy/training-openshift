package training.openshift.dbtest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.sql.Connection;
import java.sql.DriverManager;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
public class PgDbTestController {
    private static final Logger log = LoggerFactory.getLogger(PgDbTestController.class);

    @GetMapping("/dbtest")
    public String testDb()  {
      try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","seyoanapp","aDmin1!")) {
        return con==null ? "Failed" : "Success";
      }catch(Exception e) {
          log.info("Error",e);
          return e.getMessage();
      }    
    }
}
