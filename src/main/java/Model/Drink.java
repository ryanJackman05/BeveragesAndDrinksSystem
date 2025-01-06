package Model;

import java.util.Objects;

public class Drink {
    private String drinkname = "";
    private String drinkcountry = "";
    private  String drinkdescription="";

    private String imageURL ="";

    private Recipe recipe;


    //Drink name, place/country of origin, textual description, and an image/picture of the
    //completed drink (as a URL) are among key data to store


    public Drink(String drinkname, String drinkcountry, String drinkdescription) {
        this.drinkname = drinkname;
        this.drinkcountry = drinkcountry;
        this.drinkdescription = drinkdescription;
    }

    public String getDrinkName() {
        return drinkname;
    }

    public void setDrinkName(String drinkname) {
        this.drinkname = drinkname;
    }

    public String getDrinkCountry() {
        return drinkcountry;
    }

    public void setDrinkCountry(String drinkcountry) {
        this.drinkcountry = drinkcountry;
    }

    public String getDrinkDescription() {
        return drinkdescription;
    }

    public void setDrinkDescription(String drinkdescription) {
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
        return Objects.equals(getDrinkName(), drink.getDrinkName()) && Objects.equals(getDrinkCountry(), drink.getDrinkCountry()) && Objects.equals(getDrinkDescription(), drink.getDrinkDescription()) && Objects.equals(getImageURL(), drink.getImageURL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDrinkName(), getDrinkCountry(), getDrinkDescription(), getImageURL());
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
