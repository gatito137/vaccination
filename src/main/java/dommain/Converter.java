package dommain;

import data.*;

public class Converter {
    //Variables
    private String Var1 ="";
    private String Var2 ="";
    private String Var3 ="";
    private String Var11 ="";
    private String Var22 ="";
    private String Var33 ="";

    //Methods setter and getter
    public String getVar1() {
        return Var1;
    }
    public void setVar1(String Var1) {
        this.Var1 = Var1;
    }
    public String getVar2() {
        return Var2;
    }
    public void setVar2(String Var2) {
        this.Var2 = Var2;
    }
    public String getVar3() {
        return Var3;
    }
    public void setVar3(String Var3) {
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
    
    public void addReg(String type){
        switch(type){
            case "Empleoyees":
                Crud o = new CrudEmployees();
                
                o.setVar1(Integer.parseInt(Var1));
                o.setVar2(Integer.parseInt(Var2));
                o.setVar3(Integer.parseInt(Var3));
                o.setVar11(Var11.trim());
                o.setVar22(Var22.trim());
                o.setVar33(Var33.trim());
                
                o.addReg();
            break;
        }
    }
}
