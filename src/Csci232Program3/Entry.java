package Csci232Program3;

public class Entry {
    private int key;
    private int value;
    Entry(int key, int value){
        this.key = key;
        this.value = value;
    }
    public int getKey(){
        return key;
    }
    public int getValue(){
        return value;
    }
    public void setKey(int key){
        this.key = key;
    }
    public void setValue(int value){
        this.value = value;
    }
}
