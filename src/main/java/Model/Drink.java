package Model;

import java.util.Objects;

public class Drink {
    private String drinkname = "";
    private String drinkcountry = "";
    private  String drinkdescription="";

    private String imageURL ="";


    //Drink name, place/country of origin, textual description, and an image/picture of the
    //completed drink (as a URL) are among key data to store


    public Drink(String drinkname, String drinkcountry, String drinkdescription, String imageURL) {
        this.drinkname = drinkname;
        this.drinkcountry = drinkcountry;
        this.drinkdescription = drinkdescription;
        this.imageURL = imageURL;
    }

    public String getDrinkname() {
        return drinkname;
    }

    public void setDrinkname(String drinkname) {
        this.drinkname = drinkname;
    }

    public String getDrinkcountry() {
        return drinkcountry;
    }

    public void setDrinkcountry(String drinkcountry) {
        this.drinkcountry = drinkcountry;
    }

    public String getDrinkdescription() {
        return drinkdescription;
    }

    public void setDrinkdescription(String drinkdescription) {
        this.drinkdescription = drinkdescription;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drink drink)) return false;
        return Objects.equals(getDrinkname(), drink.getDrinkname()) && Objects.equals(getDrinkcountry(), drink.getDrinkcountry()) && Objects.equals(getDrinkdescription(), drink.getDrinkdescription()) && Objects.equals(getImageURL(), drink.getImageURL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrinkname(), getDrinkcountry(), getDrinkdescription(), getImageURL());
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkname='" + drinkname + '\'' +
                ", drinkcountry='" + drinkcountry + '\'' +
                ", drinkdescription='" + drinkdescription + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
