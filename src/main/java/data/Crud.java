package data;

import java.sql.*;

public abstract class Crud {
    //Variables
    private int Var1 = 0;
    private int Var2 = 0;
    private int Var3 = 0;
    private String Var11 = "";
    private String Var22 = "";
    private String Var33 = "";
    protected String command = "";
 
    //Method setter and getter
    public int getVar1() {
        return Var1;
    }
    public void setVar1(int Var1) {
        this.Var1 = Var1;
    }
    public int getVar2() {
        return Var2;
    }
    public void setVar2(int Var2) {
        this.Var2 = Var2;
    }
    public int getVar3() {
        return Var3;
    }
    public void setVar3(int Var3) {
        this.Var3 = Var3;
    }
    public String getVar11() {
        return Var11;
    }
    public void setVar11(String Var11) {
        this.Var11 = Var11;
    }
    public String getVar22() {
        return Var22;
    }
    public void setVar22(String Var22) {
        this.Var22 = Var22;
    }
    public String getVar33() {
        return Var33;
    }
    public void setVar33(String Var33) {
        this.Var33 = Var33;
    }
    
    //Abstract methods
    public abstract void addReg();
}
