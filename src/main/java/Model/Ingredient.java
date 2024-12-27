package Model;

import java.util.Objects;

public class Ingredient {
    private String ingname = "";
    private String ingdescription = "";
    String name, description;
    double ABV;

    public Ingredient ( String ingname, String ingdescription, double ABV){
        this.ingname = ingname;
        this.ingdescription = ingdescription;
        this.ABV=ABV;
    }
    //Name, textual description, and alcohol content (ABV)


    public String getIngname() {
        return ingname;
    }

    public void setIngname(String ingname) {
        this.ingname = ingname;
    }

    public String getIngdescription() {
        return ingdescription;
    }

    public void setIngdescription(String ingdescription) {
        this.ingdescription = ingdescription;
    }

    public double getABV() {
        return ABV;
    }

    public void setABV(double ABV) {
        this.ABV = ABV;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient that)) return false;
        return Double.compare(getABV(), that.getABV()) == 0 && Objects.equals(getIngname(), that.getIngname()) && Objects.equals(getIngdescription(), that.getIngdescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngname(), getIngdescription(), getABV());
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingname='" + ingname + '\'' +
                ", ingdescription='" + ingdescription + '\'' +
                ", ABV=" + ABV +
                '}';
    }
}
