package com.example.demo.springboot;

import java.util.Scanner;

public class pscm {


    public static void main(String[] args) {
//        [2022, 2022222022]
        /*（1）偶数位至少4位-10*/
//        int i = 2;
//        int count4=0;
//        for (int i = 2;i<=9;i++){
//            for (int j=0;j<=i;j++){
//                count4++;
//            }
//        }
//        for (int i = 2;i<=9;i++){
//            for (int j=0;j<=i;j++){
//                count4++;
//            }
//        }
        int[] arry = new int[5];
        int count = 0;
        for (int a=21;a<=20222;a++){
            String flag = a+"";
            int len = flag.length();

            for (int i=0;i<len;i++){
                arry[i] = Integer.parseInt(flag.substring(i, i+1));
            }
            boolean tags = true;
            for(int j =0;j<=len-2;j++){
                if (arry[j] > arry[j + 1]) {
                    tags = false;
                    break;
                }
            }
            if (tags){
                if (flag.length()>2){
                    System.out.println(flag);
//                    System.out.println(dao(flag, "2"));
                    count+=2;
                }else {
                    System.out.println(flag);
                    count++;
                }

            }


        }
        Scanner sc = new Scanner(System.in);

        System.out.println(1+"");
        System.out.println(count);
        sc.nextLine();


    }
    public static String dao(String flag, String tags){
        char[] chars = flag.toCharArray();
        StringBuilder flagBuilder = new StringBuilder(flag);
        StringBuilder flagBuilder1 = new StringBuilder(flag);
        if(chars.length>2){
            for (int i = chars.length-1; i>=0; i--) {
                flagBuilder.append(chars[i]);
            }
            for (int i = chars.length-2;i>=0;i--){
                flagBuilder1.append(chars[i]);
            }
        }else {
            for (int i = chars.length-1; i>=0; i--) {
                flagBuilder.append(chars[i]);
            }
        }
        if (tags.equals("1")){
            return flagBuilder1.toString();
        }else {
            return flagBuilder.toString();
        }


    }
}
