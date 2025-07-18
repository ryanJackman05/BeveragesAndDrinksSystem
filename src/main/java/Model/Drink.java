package Model;

import controller.LinkList;

import java.util.Objects;

public class Drink {
    private String drinkname = "";
    private String drinkcountry = "";
    private  String drinkdescription="";

    private String imageURL ="";

    private Recipe recipe;


    //Drink name, place/country of origin, textual description, and an image/picture of the
    //completed drink (as a URL) are among key data to store


    public Drink(String drinkname, String drinkcountry, String drinkdescription, LinkList<Measure> measures) {
        this.drinkname = drinkname;
        this.drinkcountry = drinkcountry;
        this.drinkdescription = drinkdescription;
        this.recipe = new Recipe(measures);
    }
    public void addRecipe(Recipe recipe)
    {
        this.recipe = recipe;
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
    public String getIngredients()
    {
        String output = "Ingredients:           (ABV = "+getABV()+")";
        if (recipe.measures.getLength() == 0)
            return output + "none";
        for (int i = 0; i < recipe.measures.getLength(); i++) {
            output += '\n' + recipe.measures.getNode(i).getContents().toString();
        }
        return output;
    }

    public Recipe getRecipe()
    {
        return recipe;
    }

    public double getABV()
    {
        double totalVolume = 0, totalAlcVolume = 0;
        for (int i = 0; i < recipe.measures.getLength(); i++) {
            double volume = recipe.measures.getNode(i).getContents().getVolume();
            double ABV = recipe.measures.getNode(i).getContents().getIngredient().getAbv() / 100; // val between 0 and 1

            totalVolume += volume;
            totalAlcVolume += volume * ABV;
        }
        return totalAlcVolume / totalVolume;
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
