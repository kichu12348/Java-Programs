import java.sql.*;

//pass :
//user: avnadmin

//uri : mysql://avnadmin:AVNS_NXzsmswZAd0COxYvhmb@mysql-1bfd5082-rmahadevan573-5ab3.e.aivencloud.com:13235/defaultdb?ssl-mode=REQUIRED

public class connectToDb {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String password = System.getenv("AIVEN_SERVICE_PASSWORD"); // or use a secure vault
            Connection con = DriverManager.getConnection("jdbc:mysql://mysql-1bfd5082-rmahadevan573-5ab3.e.aivencloud.com:13235/defaultdb?ssl-mode=REQUIRED", "avnadmin", password);
            Statement stmt = con.createStatement();
            
            //create table
            stmt.executeUpdate("CREATE TABLE secondSmall (id INT, secondSmall INT)");
            System.out.println("Table created successfully...");

            //insert data

            int[] arr = { 7, 2, 3, 4, 5, 6, 1, 8, 9, 10 };
            for (int i = 0; i < arr.length; i++) {
                stmt.executeUpdate("INSERT INTO secondSmall VALUES (" + i + ", " + arr[i] + ")");
            }

            System.out.println("Data inserted successfully...");

            //fetch data

            ResultSet rs = stmt.executeQuery("SELECT * FROM secondSmall");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getInt(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
