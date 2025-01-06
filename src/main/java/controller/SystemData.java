package controller;

import Model.*;
import javafx.fxml.FXML;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SystemData {
    public static LinkList<Drink> drinks;
    public static LinkList<Ingredient> ingredients;

    @FXML
    protected void save()
    {
        try{
            fileSave();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    @FXML
    protected void load()
    {
        try{
            fileLoad();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void fileSave() throws Exception { // taken from "Technology App" from Programming Fundamentals II
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("saveFile.xml"));
        out.writeObject(SystemData.drinks);
        out.writeObject(SystemData.ingredients);
        out.close();

    }
    public static void fileLoad() throws Exception { // taken from "Technology App" from Programming Fundamentals II
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[]{LinkList.class, LinkList.Node.class, Drink.class, Recipe.class, Measure.class, Ingredient.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("saveFile.xml"));
        SystemData.drinks = (LinkList<Drink>) in.readObject();
        SystemData.ingredients = (LinkList<Ingredient>) in.readObject();
        in.close();
    }
}
