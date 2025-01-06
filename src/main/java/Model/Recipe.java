package Model;

import controller.LinkList;

public class Recipe {
    LinkList<Measure> measures;

    public Recipe(LinkList<Measure> measures)
    {
        this.measures = measures;
    }
}
