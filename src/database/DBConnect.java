package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/** CONNECTION TO THE DATABASE;
 * Created by Dovile on 2016-04-29.
 */
public class DBConnect {
    public Connection con;
    public Statement st;
    public ResultSet rs;

    public DBConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registras?autoReconnect=true&useSSL=false","root","");
            st = con.createStatement();

        }catch (Exception ex){
            System.out.println("ERROR: "+ ex);
        }
    }
}
