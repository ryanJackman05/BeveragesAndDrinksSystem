package Model;

import controller.LinkList;

public class Recipe {
    LinkList<Measure> measures;

    public Recipe(LinkList<Measure> measures)
    {
        this.measures = measures;
    }

    public LinkList<Measure> getMeasures()
    {
        return measures;
    }

    public void setMeasures(LinkList<Measure> measures)
    {
        this.measures = measures;
    }
}
