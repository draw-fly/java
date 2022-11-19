package com;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File("C:/java基础/src/com");
        String[] list;
//        if (args.length == 0){
//            list = path.list();
//        }else {
//            list = path.list(new DirFiler(args[0]));
//        }


        list = path.list(new DirFiler("^.{3,12}$"));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
//        for (String arg : args) {
//            System.out.println(arg);
//        }
        dict dict = new dict();
        new m();
        new DirList.m();
//        new many();

    }
    {
        new many();
    }

    class many{
        private String demo;
        private String m;

    }
    static class m{
        private static String m;
        private String do1;
    }
    class at{
        private String a;
    }
}

class DirFiler implements FilenameFilter{
    private final Pattern pattern;
    public DirFiler(String regx){
        pattern = Pattern.compile(regx);
    }
    public boolean accept(File file, String name){
        return pattern.matcher(name).matches();
    }

}
class dict{
    public String do1(){
        return "哈哈哈哈";
    }
}

