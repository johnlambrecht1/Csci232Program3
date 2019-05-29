package Csci232Program3;

import java.util.Arrays;
import java.util.Scanner;

public class Hash {
    Entry[] table;
    double threshold = .8;
    int arraySize =3;
    int itemsInArray = 0;
    int maxSize = 3;


    Hash(){
        table = new Entry[arraySize];
        for (int i = 0;i<arraySize;i++){
            table[i] = null;
        }
    }
    public void setMaxSize(){
        maxSize = (int)Math.round(table.length * threshold);
    }
    public Entry checkKey(int key){
        if (key>arraySize-1){
            System.out.println("The table is too small for that key");
        }else{
            if (table[key]==null){
                System.out.println("That location is still empty");
            }else{
                System.out.println(table[key].getValue());
                return table[key];
            }
        }
        return null;
    }
    public void remove(int key){
        if (table[key]!=null){
            System.out.println("That location is already empty");
        }else{
            table[key]=null;
            itemsInArray--;
        }
    }
    public void setKey(int value){
        int hash = (value%table.length);
        int probe = 1;
        while (table[hash] !=null){
            hash = (int)(hash + Math.pow(probe,2))%table.length;
            probe++;
        }
        table[hash] = new Entry(hash, value);
        itemsInArray++;
        setMaxSize();
        if (itemsInArray>=maxSize){
            resize();
        }
    }
    private void resize(){
        int arraySize = 2*table.length;
        setMaxSize();
        Entry[] old = table;
        table = new Entry[arraySize];
        itemsInArray = 0;
        for(int i = 0;i<old.length;i++){
            if(old[i]!=null){
                setKey(old[i].getValue());
            }
        }
    }
    public void displayStack(){
        int count = 10;
        for (int i = 0; i<(int)table.length/10+1;i++){
            for(int j = 0;j<71;j++){
                System.out.print("-");
            }
            System.out.println();
            for (int j = count - 10;j<(Math.min(count,table.length));j++){
                System.out.format("| %3s " + " ", j);
            }
            System.out.println("|");
            for (int j = 0;j<71;j++){
                System.out.print("-");
            }
            System.out.println();
            for (int j = count - 10;j<Math.min(count,table.length);j++){
                try{
                    if (table[j]==null){
                        System.out.print("|      ");
                    }else{
                        System.out.print(String.format("| %3s " + " ", table[j].getValue()));
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.print("|      ");
                }
            }
            System.out.println("|");
            for(int j = 0; j<71;j++){
                System.out.print("-");
            }
            System.out.println();
            if (count < table.length){
                count +=10;
            }
        }
    }
}
