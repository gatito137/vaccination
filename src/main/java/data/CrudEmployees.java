package data;

import java.sql.*;
import javax.swing.JOptionPane;

public class CrudEmployees extends Crud{
    @Override
    public void addReg(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_vaccination", "root", "");
            super.command = "insert into tabemployees values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cn.prepareStatement(super.command);
            ps.setInt(1, 1);
            ps.setString(2, super.getVar11());
            ps.setInt(3, super.getVar1());
            ps.setString(4, super.getVar22());
            ps.setInt(5, super.getVar2());
            ps.setInt(6, super.getVar3());
            ps.setString(7, super.getVar33());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Record added successfully!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
