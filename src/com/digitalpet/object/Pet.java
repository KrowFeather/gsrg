package com.digitalpet.object;

public abstract class Pet {
    public String name;
    public int health;
    public int hungry;
    public int love;
    public String strain;
    public Pet(){
        this.health=100;
        this.love=60;
        this.hungry=100;
        this.name="无名氏";
    }
    public void reduceHunger(){
        this.hungry--;
    }

    public void showStatus() {
        System.out.println("名字");
        System.out.println("");
        System.out.println("");
    }
}
