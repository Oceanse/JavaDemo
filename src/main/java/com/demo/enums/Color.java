package com.demo.enums;

public enum Color {
    RED,
    GREEN,
    BLUE;

    public static void main(String[] args) {

        Object o=new Object();//不能传入switch
        Color color = Color.RED;

        switch (color){
            case RED:
                System.out.println("red");
                break;
            case BLUE:
                System.out.println("blue");
                break;
            case GREEN:
                System.out.println("green");
                break;
            default:
                break;
        }






        Color[] values = Color.values();
        //System.out.println(Arrays.toString(values));
    }
}
