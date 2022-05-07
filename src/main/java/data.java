import java.util.Date;

public class data {

    //Paraméterek:
    protected String taj;
    protected String nev;
    protected Date szul;
    protected String lak;
    protected String tel;
    protected String diagn;
    protected int szoba;

    //Constructor:
    public data() {
    }

    //Getters Setters:
    public String getTaj() {
        return taj;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
    public Date getSzul() {
        return szul;
    }

    public void setSzul(Date szul) {
        this.szul = szul;
    }

    public String getLak() {
        return lak;
    }

    public void setLak(String lak) {
        this.lak = lak;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDiagn() {
        return diagn;
    }

    public void setDiagn(String diagn) {
        this.diagn = diagn;
    }

    public int getSzoba() {
        return szoba;
    }

    public void setSzoba(int szoba) {
        this.szoba = szoba;
    }

}