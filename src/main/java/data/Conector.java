package data;

import java.sql.*;

public class Conector {
    Connection cn;
    
    public Conector(){
        try{
            cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_vaccination", "root", "");
        }catch(Exception e){}
    }
    
    public Connection getConnection(){
        return cn;
    }
}
