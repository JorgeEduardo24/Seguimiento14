package model;

import java.util.ArrayList;

public class MathApp {

    private ArrayList<IntegerSet> sets;
    
    private int amount;

    
    public MathApp() {
        this.amount = 0;
        this.sets = new ArrayList<IntegerSet>();
    }

    public void addSet(String name) {
        IntegerSet newSet = new IntegerSet(name);
        this.sets.add(newSet);
        this.amount++;
    }
    

    public void removeSet(String name) {
        boolean b = false;
        for (int i = 0; i < amount && !b; i++) {
            if (this.sets.get(i).getName().equalsIgnoreCase(name)) {
                this.sets.remove(i);
                b = true;
                this.amount--;
            }
        }
    }

    public void addElementToSet(String setName, int element) {
        boolean b = false;
        for (int i = 0; i < amount && !b; i++) {
            if (this.sets.get(i).getName().equalsIgnoreCase(setName)) {
                this.sets.get(i).addElement(element);
                b = true;
            }
        }
    }

    public void removeElementFromSet(String setName, int element) {
        boolean b = false;
        for (int i = 0; i < amount && !b; i++) {
            if (this.sets.get(i).getName().equalsIgnoreCase(setName)) {
                this.sets.get(i).removeElement(element);
                b = true;
            }
        }
    }

    public void union(String setName1, String setName2, String newName) {
        IntegerSet newSet = new IntegerSet(newName);
        boolean b = false;
        for (int i = 0; i < amount && !b; i++) {
            for (int j = 0; j < amount && !b; j++) {
                if (this.sets.get(i).getName().equalsIgnoreCase(setName1) && this.sets.get(j).getName().equalsIgnoreCase(setName2)) {
                    newSet = this.sets.get(i).union(this.sets.get(j), newName);
                    this.sets.add(newSet);
                    b = true;
                    amount++;
                }
            }
        }
    }
    

    public void difference(String setName1, String setName2, String newName) {
        IntegerSet newSet = new IntegerSet(newName);
        boolean b = false;
        for (int i = 0; i < amount && !b; i++) {
            for (int j = 0; j < amount && !b; j++) {
                if (this.sets.get(i).getName().equalsIgnoreCase(setName1) && this.sets.get(j).getName().equalsIgnoreCase(setName2)) {
                    newSet = this.sets.get(i).difference(this.sets.get(j), newName);
                    this.sets.add(newSet);
                    b = true;
                    amount++;
                }
            }
        }
    }

    public void intersection(String setName1, String setName2, String newName) {
        IntegerSet newSet = new IntegerSet(newName);
        boolean b = false;
        for (int i = 0; i < amount && !b; i++) {
            for (int j = 0; j < amount && !b; j++) {
                if (this.sets.get(i).getName().equalsIgnoreCase(setName1) && this.sets.get(j).getName().equalsIgnoreCase(setName2)) {
                    newSet = this.sets.get(i).intersection(this.sets.get(j), newName);
                    this.sets.add(newSet);
                    b = true;
                    amount++;
                }
            }
        }
    }

    public void symmetricDifference(String setName1, String setName2, String newName) {
        IntegerSet newSet = new IntegerSet(newName);
        boolean b = false;
        for (int i = 0; i < amount && !b; i++) {
            for (int j = 0; j < amount && !b; j++) {
                if (this.sets.get(i).getName().equalsIgnoreCase(setName1) && this.sets.get(j).getName().equalsIgnoreCase(setName2)) {
                    newSet = this.sets.get(i).symmetricDifference(this.sets.get(j), newName);
                    this.sets.add(newSet);
                    b = true;
                    amount++;
                }
            }
        }
    }
    

    public String showInfoSet(String name) {
        boolean b = false;
        String message = "";
        for (int i = 0; i < amount && !b; i++) {
            if (this.sets.get(i).getName().equalsIgnoreCase(name)) {
                message = this.sets.get(i).showContents();
                b = true;
            }
        }
        return message;
    }

    
    public String showInfoSets() {
        String message = "";
        message = "||||||||--  CONJUNTOS EXISTENTES --||||||||" + "\n";
        for (int i = 0; i < amount; i++) {
            message += this.sets.get(i).showContents() + "\n";
        }
        
        return message;
    }

}
