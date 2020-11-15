package ui;

import model.*;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private MathApp newMathApp;
    
    //Options on the Menu
    private final static int ADD_SET = 1;
    private final static int ERASE_SET = 2;
    private final static int ADD_ELEMENT = 3;
    private final static int ERASE_ELEMENT = 4;
    private final static int UNION = 5;
    private final static int INTERSECTION = 6;
    private final static int DIFFERENCE = 7;
    private final static int SYMMETRIC_DIFFERENCE = 8;
    private final static int SHOW_SET = 9;
    private final static int SHOW_SETS = 10;
    private final static int EXIT = 11;
    

    public Menu() {
        this.newMathApp = new MathApp();
    }

    public void showMenu() {
        System.out.println("Por favor, elije la opcion que desees realizar:");
        System.out.println("                                               ");
        System.out.println("(1) Agregar un nuevo conjunto");
        System.out.println("(2) Eliminar un conjunto existente");
        System.out.println("(3) Agregar un elemento a un conjunto");
        System.out.println("(4) Eliminar un elemento de un conjunto");
        System.out.println("(5) Aplicar la union entre 2 conjuntos");
        System.out.println("(6) Aplicar la interseccion entre 2 conjuntos");
        System.out.println("(7) Aplicar la diferencia entre 2 conjuntos");
        System.out.println("(8) Aplicar la diferencia simetrica entre 2 conjuntos");
        System.out.println("(9) Mostrar los elementos de un conjunto");
        System.out.println("(10) Mostrar todos los conjuntos");
        System.out.println("(11) Salir del programa");
    }

    public void readAddSet() {
        String msg = "Conjunto añadido correctamente";
        System.out.println("Ingrese el nombre del conjunto");
        String nameSet = sc.nextLine();
        newMathApp.addSet(nameSet);
    }

    public void readRemoveSet() {
        System.out.println("Ingrese el nombre del conjunto");
        String nameSet = sc.nextLine();
        newMathApp.removeSet(nameSet);
    }

    public void readAddElementToSet() {
        System.out.println("Ingrese el nombre del conjunto");
        String setName = sc.nextLine();
        System.out.println("Ingrese el elemento que quiere agregar:");
        int element = sc.nextInt();
        sc.nextLine();
        newMathApp.addElementToSet(setName, element);
    }

    public void readRemoveElementFromSet() {
        System.out.println("Ingrese el nombre del conjunto");
        String setName = sc.nextLine();
        System.out.println("Ingrese el elemento que quiere eliminar:");
        int element = sc.nextInt();
        sc.nextLine();
        newMathApp.removeElementFromSet(setName, element);
    }

    public void readUnion() {
        System.out.println("Ingrese el nombre del conjunto 1:");
        String setName1 = sc.nextLine();
        System.out.println("Ingrese el nombre del conjunto 2:");
        String setName2 = sc.nextLine();
        System.out.println("Ingrese el nombre del conjunto union:");
        String newName = sc.nextLine();
        newMathApp.union(setName1, setName2, newName);
    }

    public void readDifference() {
        System.out.println("Ingrese el nombre del conjunto 1:");
        String setName1 = sc.nextLine();
        System.out.println("Ingrese el nombre del conjunto 2:");
        String setName2 = sc.nextLine();
        System.out.println("Ingrese el nombre del conjunto diferencia:");
        String newName = sc.nextLine();
        newMathApp.difference(setName1, setName2, newName);
    }

    public void readIntersection() {
        System.out.println("Ingrese el nombre del conjunto 1:");
        String setName1 = sc.nextLine();
        System.out.println("Ingrese el nombre del conjunto 2:");
        String setName2 = sc.nextLine();
        System.out.println("Ingrese el nombre del conjunto interseccion:");
        String newName = sc.nextLine();
        newMathApp.intersection(setName1, setName2, newName);
    }

    public void readSymmetricDifference() {
        System.out.println("Ingrese el nombre del conjunto 1:");
        String setName1 = sc.nextLine();
        System.out.println("Ingrese el nombre del conjunto 2:");
        String setName2 = sc.nextLine();
        System.out.println("Ingrese el nombre del conjunto diferencia simetrica:");
        String newName = sc.nextLine();
        newMathApp.symmetricDifference(setName1, setName2, newName);
    }

    public String readShowInfoSet() {
        String msg = "";
        System.out.println("Ingrese el nombre del conjunto:");
        String name = sc.nextLine();
        msg = newMathApp.showInfoSet(name);
        return msg;
    }

    public void startProgram() {
        System.out.println("          *--------------*");
        System.out.println("          |    MATHAPP   |");
        System.out.println("          *--------------*");
        
        int option;
        do {
            showMenu();
            option = readOption();
            doOperation(option);
        } while (option != EXIT);
    }

    public int readOption() {
        int select = sc.nextInt();
        sc.nextLine();
        return select;
    }

    public void doOperation(int select) {
        switch (select) {
            case ADD_SET:
                readAddSet();
                break;
            case ERASE_SET:
                readRemoveSet();
                break;
            case ADD_ELEMENT:
                readAddElementToSet();
                break;
            case ERASE_ELEMENT:
                readRemoveElementFromSet();
                break;
            case UNION:
                readUnion();
                break;
            case INTERSECTION:
                readIntersection();
                break;
            case DIFFERENCE:
                readDifference();
                break;
            case SYMMETRIC_DIFFERENCE:
                readSymmetricDifference();
                break;
            case SHOW_SET:
                System.out.println(readShowInfoSet());
                break;
            case SHOW_SETS:
                System.out.println(newMathApp.showInfoSets());
                break;
            case EXIT:
                break;
            default:
                System.out.println("Opcion inválida");
        }
    }

}
