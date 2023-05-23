package MySql.Crud.ObjectStreamIntoDataBase;

import java.io.Serializable;

public class Employee implements Serializable {
    private int ID;
    private String NAME;
    private int AGE;
    private long PHONE;
    private String ADDRESS;
    private String SKILLS;


    public Employee(int ID, String NAME, int AGE, long PHONE, String ADDRESS, String SKILLS) {
        this.ID = ID;
        this.NAME = NAME;
        this.AGE = AGE;
        this.PHONE = PHONE;
        this.ADDRESS = ADDRESS;
        this.SKILLS = SKILLS;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", AGE=" + AGE +
                ", PHONE=" + PHONE +
                ", ADDRESS='" + ADDRESS + '\'' +
                ", SKILLS='" + SKILLS + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public long getPHONE() {
        return PHONE;
    }

    public void setPHONE(long PHONE) {
        this.PHONE = PHONE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getSKILLS() {
        return SKILLS;
    }

    public void setSKILLS(String SKILLS) {
        this.SKILLS = SKILLS;
    }
}
