package com;

public class Ingredient {
    private String name;
    private String password;
    private Type type;
    public Ingredient(String name, String password, Type type){
        this.name = name;
        this.password = password;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public Type getType(){
        return type;
    }
    public static enum Type{
        ace, mvp
    }
    public String toString(){
        return "\nname: " + this.name + "\n"+ "password: " + this.password+"\n" + "type: " + this.type ;
    }
}
