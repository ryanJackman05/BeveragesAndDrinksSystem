package com.assignment2.beveragesanddrinkssystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    public static Stage mainStage;
    public static Scene home, drinksView, ingsView;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml")); // to be duplicated for each scene
        home = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("drinksView.fxml"));
        drinksView = new Scene(fxmlLoader.load(), 600, 400);
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ingsView.fxml"));
        ingsView = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Theatre Booking System");
        stage.setScene(home);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}
/*
The addition of new drinks/beverages to the system. These might be cocktails, mocktails, hot
beverages (e.g. cup of tea, hot chocolate, Irish coffee), cold non-alcoholic beverages (e.g. rock
shandy), or even drinks that consist of just one ingredient (e.g. pint of stout or lager, glass of red
or white wine, a glass of lemonade, etc.).

 The addition of new drink ingredients/components to the system. Examples are spirits, liqueurs,
mixers, soft/fizzy drinks (e.g. cola, lemonade), wines, beers, and other components such as
sugar, milk, water, coffee, lemon, etc. Anything that could be used to make up a drink could be
added as an ingredient/component.

 Ability to create recipes for drinks that associate ingredients/components with the drinks they
feature in, and the quantities (in millilitres) to use therein. Note that a given ingredient (e.g.
vodka) could be used in various drinks (e.g. Bloody Mary, Sea Breeze, etc.) but in different
amounts.

 Ability to edit/update/delete drinks and ingredients.

 Ability to search for drinks and ingredients using some parameters/options. The search might
be: by name, by description keyword, by maximum alcohol content/ABV, etc. The key thing is
that a search facility is provided with some (minimum of 2) search options.

 Listings of search results (for both drinks and ingredients) should be appropriately sorted
depending on the chosen search parameters/options. The sorting could be (1) alphabetical by
name, or (2) by total alcohol content/ABV (note that ABV would have to be calculated for a drink
comprising various ingredients of varying quantities and ABVs). Other sorting
options/parameters can also be provided, but alphabetical and ABV sorting are the key ones to
implement.

 The system should support some level of interactive “drill down” for additional detail or
navigation/browsing. For instance, searching for drinks containing vodka should provide a list of
any vodka-containing drink; one drink could then be clicked on to see more information
specifically on that drink; that detail could include a list of ingredients in the drink; clicking on
any ingredient opens up details on the ingredient, including a list of all drinks containing that
ingredient; and so on.

 The system should support some form of persistence whereby the internal data is saved to a file
on exit, and reloaded for use on the next execution. You could use e.g. binary files, XML files,
plain text files, or anything else that provides an image/snapshot of all internal data.
o There is no need to look to databases or anything like that. A single snapshot/image file
is fine for our purposes.
*/