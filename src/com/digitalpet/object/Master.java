package com.digitalpet.object;

public class Master{
    public void feed(Pet pet){
        pet.hungry+=5;
        System.out.println(pet.name+"的饥饿度为:"+pet.hungry);
    }

    public void touch(Pet pet) {
        pet.love+=5;
        System.out.println(pet.name+"的情感值为:"+pet.love);
    }
}
