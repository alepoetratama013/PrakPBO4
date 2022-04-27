package javapbo4;

import java.sql.*;
public class Connector {
    String DBurl = "jdbc:mysql://localhost:3306/tugaspbo4?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String DBuname = "root";
    String DBpw = "";
    
    public Connection conn;
    public Statement stat;

    public Connector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection)DriverManager.getConnection(DBurl, DBuname, DBpw);
            stat = (Statement)conn.createStatement();
            System.out.println("Connection success");
        } catch (Exception ex) {
            System.out.println("Connection failed");
        }
    }
    
    void insertData(String username, String password){
        try {
            String query = "INSERT INTO `users`(`username`,`password`)" + "VALUES('" + username + "','" + password + "')";

            stat = conn.createStatement();
            stat.executeUpdate(query);

            System.out.println("Register success");
        } catch (Exception ex) {
            System.out.println("Register failed");
        }
    }
    
    boolean checkLogin(String username, String password){
        try {
            String query = "SELECT * FROM `users` WHERE username='" + username +"' AND password='" + password + "'";
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(query);
            if(resultSet.next()){
                stat.close();
                return true;
            }else{
                stat.close();
                return false;
            }
            
        } catch (Exception ex) {  
            return false;
        }
    }
    
    boolean checkUsername(String username){
         try {
            String query = "SELECT * FROM `users` WHERE username='" + username +"'";
            stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(query);
            if(resultSet.next()){
                stat.close();
                return true;
            }else{
                stat.close();
                return false;
            }
            
        } catch (Exception ex) {  
            return false;
        }
    }
}