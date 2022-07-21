import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{
    private Config configuration = new Config();
    private Connection connection;

    public MySQLAdsDao() throws SQLException {
        Config configuration = new Config();

        //Step 1 : Registered the driver
        DriverManager.registerDriver(new Driver());

        //Step 2: Create connection
        connection = DriverManager.getConnection(
                configuration.getUrl(),
                configuration.getUser(),
                configuration.getPassword()
        );
    }

    public List<Ad> all() throws SQLException {
        //Step 3: Create statement object
        Statement stmt = connection.createStatement();
        //ResultSet needs to be handled so we create an instance;
        //Step 4: Execute statement
        ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
        List<Ad> adsList = new ArrayList<>();

        while (rs.next()) {
            // Step 5: Interpret ResultSet
            adsList.add(new Ad(
                    rs.getLong("id"),
                    rs.getLong("userId"),
                    rs.getString("title"),
                    rs.getString("description")
            ));
        }
        return adsList;
    }

    @Override
    public Long insert(Ad ad) {
        String title = ad.getTitle();
        String desc = ad.getDescription();
        String query = "INSERT INTO ads(user_id, title, description) VALUE(1, '"+title+"', '"+desc+"')";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        }catch(SQLException e) {
            System.out.println("whatever");
        }

    }


}
