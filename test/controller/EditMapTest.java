package controller;

import model.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

public class EditMapTest {

    @Test
    public void EditAvenueCost() {
        ArrayList<Tile> al = new ArrayList<>();
        al.add(new Tile("c1", 0, 0, "cost"));
        EditMap editMap = Mockito.mock(EditMap.class);
        Mockito.when(editMap.getTileList()).thenReturn(al);
        Assert.assertFalse(editMap.EditAvenueCost("cost", 200));
        Assert.assertFalse(editMap.EditAvenueCost("cXYZ", 200));
    }

    @Test
    public void EditAvenuehouse() {
        ArrayList<Tile> al = new ArrayList<>();
        al.add(new Tile("h1", 0, 0, "house"));
        EditMap editMap = Mockito.mock(EditMap.class);
        Mockito.when(editMap.getTileList()).thenReturn(al);
        Assert.assertFalse(editMap.EditAvenuehouse("h1", 50));
        Assert.assertFalse(editMap.EditAvenuehouse("h2", 50));
    }

    @Test
    public void EditAvenueRent1() {
        ArrayList<Tile> al = new ArrayList<>();
        al.add(new Tile("r1", 0, 0, "rent1"));
        EditMap editMap = Mockito.mock(EditMap.class);
        Mockito.when(editMap.getTileList()).thenReturn(al);
        Assert.assertFalse(editMap.EditAvenueRent1("r1", 3000));
        Assert.assertFalse(editMap.EditAvenueRent1("r2", 3000));
    }

    @Test
    public void EditAvenueRent2() {
        ArrayList<Tile> al = new ArrayList<>();
        al.add(new Tile("r1", 0, 0, "rent2"));
        EditMap editMap = Mockito.mock(EditMap.class);
        Mockito.when(editMap.getTileList()).thenReturn(al);
        Assert.assertFalse(editMap.EditAvenueRent2("r1", 3000));
        Assert.assertFalse(editMap.EditAvenueRent2("r2", 3000));
    }

    @Test
    public void EditAvenueRent3() {
        ArrayList<Tile> al = new ArrayList<>();
        al.add(new Tile("r1", 0, 0, "rent3"));
        EditMap editMap = Mockito.mock(EditMap.class);
        Mockito.when(editMap.getTileList()).thenReturn(al);
        Assert.assertFalse(editMap.EditAvenueRent2("r1", 3000));
        Assert.assertFalse(editMap.EditAvenueRent2("r2", 3000));
    }
}