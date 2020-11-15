package model;

import java.util.ArrayList;

public class IntegerSet {

    private String name;
    private int cardinality;
    private ArrayList<Integer> elements;

    public IntegerSet(String name) {
        this.name = name;
        this.cardinality = 0;
        this.elements = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public int getCardinality() {
        return this.cardinality;
    }

    public ArrayList<Integer> getElements() {
        return elements;
    }

    public void addElement(int element) {
        boolean b = false;
        for (int i = 0; i < cardinality && !b; i++) {
            if (elements.get(i) == element) {
                b = true;
            }
        }

        if (b == false) {
            elements.add(element);
            cardinality++;
        }
    }

    public void removeElement(int element) {
        boolean b = false;
        for (int i = 0; i < cardinality && !b; i++) {
            if (elements.get(i) == element) {
                elements.remove(i);
                cardinality--;
                b = true;
            }
        }
    }

    public IntegerSet union(IntegerSet set, String newName) {
        IntegerSet newSet = new IntegerSet(newName);
        ArrayList<Integer> setElements = set.getElements();
        for (int i = 0; i < cardinality; i++) {
            newSet.addElement(elements.get(i));
        }
        for (int i = 0; i < cardinality; i++) {
            for (int j = 0; j < set.getCardinality(); j++) {
                if (elements.get(i) != setElements.get(j)) {
                    newSet.addElement(setElements.get(j));
                }
            }
        }
        return newSet;
    }

    public IntegerSet difference(IntegerSet set, String newName) {
        IntegerSet newSet = new IntegerSet(newName);
        for (int i = 0; i < cardinality; i++) {
            newSet.addElement(elements.get(i));
        }
        ArrayList<Integer> setElements = set.getElements();
        for (int i = 0; i < set.getCardinality(); i++) {
            newSet.removeElement(setElements.get(i));
        }
        return newSet;
    }

    public IntegerSet intersection(IntegerSet set, String newName) {
        IntegerSet newSet = new IntegerSet(newName);
        ArrayList<Integer> setElements = set.getElements();
        for (int i = 0; i < cardinality; i++) {
            for (int j = 0; j < set.getCardinality(); j++) {
                if (elements.get(i) == setElements.get(j)) {
                    newSet.addElement(setElements.get(j));
                }
            }
        }
        return newSet;
    }

    public IntegerSet symmetricDifference(IntegerSet set, String newName) {
        IntegerSet set1 = union(set, newName);
        IntegerSet set2 = intersection(set, newName);
        IntegerSet newSet = new IntegerSet(newName);
        for (int i = 0; i < set2.getCardinality(); i++) {
            set1.removeElement(set2.getElements().get(i));
        }
        for (int i = 0; i < set1.getCardinality(); i++) {
            newSet.addElement(set1.getElements().get(i));
        }
        return newSet;
    }

    public String showContents() {
        String message = "";
        
        message = "****||||  CONJUNTO  ||||****\n";
        message += "Nombre: " + getName();
        message += "\n Elementos : ";
        for (int i = 0; i < cardinality; i++) {
            message += this.elements.get(i);
        }
        
        return message;
    }
}
