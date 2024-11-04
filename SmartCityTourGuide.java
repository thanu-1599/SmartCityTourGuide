import java.sql.*;
import java.util.Scanner;
public class SmartCityTourGuide {

   
    public void  showAttractions(String cityName) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","thanu","thanu");
        PreparedStatement statement = con.prepareStatement("SELECT Attractions FROM smartcity WHERE Cityname= ? and Attractions!='NULL'");
        statement.setString(1, cityName);
        System.out.println("Famous Attractions of "+cityName+" are:");
        ResultSet resultSet = statement.executeQuery();
       
        while (resultSet.next()) {
            System.out.println(resultSet.getString("Attractions"));
        }
        con.close();
        System.out.println();
    }

    public void showRestaurants(String cityName) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","thanu","thanu");
        PreparedStatement statement = con.prepareStatement("SELECT Restaurants FROM smartcity WHERE Cityname = ? and Restaurants!='NULL'");
        statement.setString(1, cityName);
        System.out.println("Restaurants of "+cityName+" are:");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("Restaurants"));
        }
        con.close();
        System.out.println();
    }
    public void showMalls(String cityName) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","thanu","thanu");
        PreparedStatement statement = con.prepareStatement("SELECT Malls FROM smartcity WHERE Cityname = ? and Malls!='NULL'");
        statement.setString(1, cityName);
        System.out.println("Shopping Malls of "+cityName+" are:");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("Malls"));
        }
        con.close();
        System.out.println();
    }

    public void updateAttraction(String cityName, String attractionName, String newName) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","thanu","thanu");
        PreparedStatement statement = con.prepareStatement("UPDATE smartcity SET Attractions= ? WHERE Cityname = ? AND Attractions = ?");
        statement.setString(1, newName);
        statement.setString(2, cityName);
        statement.setString(3, attractionName);
        statement.executeUpdate();
        System.out.println("1 row updated");
        con.close();
    }
    public void updateMall(String cityName, String mallName, String newName) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","thanu","thanu");
        PreparedStatement statement = con.prepareStatement("UPDATE smartcity SET Malls= ? WHERE Cityname = ? AND Malls = ?");
        statement.setString(1, newName);
        statement.setString(2, cityName);
        statement.setString(3, mallName);
        statement.executeUpdate();
        System.out.println("1 row updated");
        con.close();
    }
    public void updateRestaurant(String cityName, String restaurantName, String newName) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","thanu","thanu");
        PreparedStatement statement = con.prepareStatement("UPDATE smartcity SET Restaurants= ? WHERE Cityname = ? AND Restaurants= ?");
        statement.setString(1, newName);
        statement.setString(2, cityName);
        statement.setString(3, restaurantName);
        statement.executeUpdate();
        System.out.println("1 row updated");
        con.close();
    }

   public void insertCity(String ciName, String restName,String attName,String mName) throws Exception {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","thanu","thanu");
        PreparedStatement statement = con.prepareStatement("INSERT INTO smartcity VALUES (?, ?,?,?)");
        statement.setString(1, ciName);
        statement.setString(2, attName);
        statement.setString(3, restName);
        statement.setString(4, mName);
        statement.executeUpdate();
        System.out.println("1 row inserted");
        con.close();
    }

    public void deleteMalls(String mallName,String cName) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","thanu","thanu");
        PreparedStatement statement = con.prepareStatement("DELETE FROM smartcity WHERE Malls =? and Cityname=?");
        statement.setString(1, mallName);
        statement.setString(2, cName);
        statement.executeUpdate();
        System.out.println("1 row deleted");
        con.close();
    }
    public void deleteAttractions(String attName,String cName) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","thanu","thanu");
        PreparedStatement statement = con.prepareStatement("DELETE FROM smartcity WHERE Attractions= ? and Cityname=?");
        statement.setString(1, attName);
        statement.setString(2, cName);
        statement.executeUpdate();
        System.out.println("1 row deleted");
        con.close();
    }
    public void deleteRestaurants(String restName,String cname) throws Exception {
    Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","thanu","thanu");
        PreparedStatement statement = con.prepareStatement("DELETE FROM smartcity WHERE  Restaurants= ? and Cityname=?");
        statement.setString(1, restName);
        statement.setString(2, cname);
        statement.executeUpdate();
        System.out.println("1 row deleted");
        con.close();
    }

    public static void main(String[] args) throws Exception {
        SmartCityTourGuide tourGuide = new SmartCityTourGuide();
        Scanner scanner = new Scanner(System.in) ;
String userType;
System.out.print("Enter your user type (Admin/User): ");
userType = scanner.nextLine();

if (userType.equals("Admin")) {
   System.out.println("You are an Admin . You can interact with the database.");

   System.out.println("Would you like to update, insert, or delete?");
   String action = scanner.nextLine();

   if (action.equals("update")) {
    System.out.print("Enter the city name: ");
 String cityName = scanner.nextLine();
    System.out.print("Enter the attractions,restaurant,malls to update: ");
    String name=scanner.nextLine();
    if(name.equals("attractions")) {
       System.out.print("Enter the attraction name to update: ");
       String attractionName = scanner.nextLine();
       System.out.print("Enter the new attraction name: ");
       String newName = scanner.nextLine();
       tourGuide.updateAttraction(cityName, attractionName, newName);
    }else if(name.equals("malls")){

       System.out.print("Enter the Mall name to update: ");
       String mallName = scanner.nextLine();
       System.out.print("Enter the new Shopping Mall name: ");
       String newName = scanner.nextLine();
       tourGuide.updateMall(cityName, mallName, newName);
    }else {
       System.out.print("Enter the restaurant name to update: ");
       String restaurantName = scanner.nextLine();
       System.out.print("Enter the new restaurant name: ");
       String newName = scanner.nextLine();
       tourGuide.updateRestaurant(cityName, restaurantName, newName);
    }
   } else if (action.equals("insert")) {
    System.out.print("Enter the city name to insert: ");
       String ciName = scanner.nextLine();
       System.out.print("Enter the restaurant name to insert: ");
       String restName = scanner.nextLine();
       System.out.print("Enter the attraction name to insert: ");
       String attName = scanner.nextLine();
       System.out.print("Enter the shopping mall name to insert: ");
       String mName = scanner.nextLine();
       tourGuide.insertCity(ciName, restName,attName,mName);
   }
else if (action.equals("delete")) {
System.out.print("Enter the Cityname: ");
String cyName=scanner.nextLine();
       System.out.print("Enter the malls or attractions or restaurants to delete: ");
       String ur=scanner.nextLine();
       if(ur.equals("attractions")) {
        System.out.print("Enter the attraction name to delete: ");
       String mallName = scanner.nextLine();

       tourGuide.deleteAttractions(mallName,cyName);
       }else if(ur.equals("malls")) {
        System.out.print("Enter the Shopping mall name to delete: ");
       String mallName = scanner.nextLine();

       tourGuide.deleteMalls(mallName,cyName);
       }
       else {
        System.out.print("Enter the restaurant name to delete: ");
        String mallName = scanner.nextLine();

       tourGuide.deleteRestaurants( mallName,cyName);
       }
   } else {
       System.out.println("Invalid action.");
   }
}
else {
   System.out.println("You are a user. You can only view the data.");
   Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","tiger");
  Statement st=con.createStatement();
      ResultSet res=st.executeQuery("select distinct Cityname from smartcity");
      while(res.next()) {
      System.out.println(res.getString(1));
     
      }
      con.close();
      System.out.print("Enter the city name: ");
 String c = scanner.nextLine();
   System.out.println("Would you like to see Attractions, Restaurants, Malls or All?");
   
   String option = scanner.nextLine();
               
   if (option.equals("Attractions")) {
       tourGuide.showAttractions(c);
   } else if (option.equals("Restaurants")) {
       tourGuide.showRestaurants(c);
   } else if (option.equals("Malls")) {
       tourGuide.showMalls(c);
   }else if(option.equals("All")) {
    tourGuide.showAttractions(c);
    tourGuide.showRestaurants(c);
    tourGuide.showMalls(c);
   }
   else {
       System.out.println("Invalid option.");
   }
}
}
