package com.example.demo.springboot;
/**
 * 杨亚磊
 * 试题 B: 山
 *
 * 本题总分：5 分
 * 【问题描述】
 * 这天小明正在学数数。
 * 他突然发现有些正整数的形状像一座“山”，比如 123565321、145541，它
 * 们左右对称（回文）且数位上的数字先单调不减，后单调不增。
 * 小明数了很久也没有数完，他想让你告诉他在区间 [2022, 2022222022] 中有
 * 多少个数的形状像一座“山”。
 * 【答案提交】
 * 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 * 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 *
 * 答案：3138
 */
public class Mount {
    public static void main(String[] args) {
        long l = 2022;
        int num = 0;
        for(;l <= 2022222022L;++l) {
            if(isShan(l)) {
                //验证代码!!!很重要！！！
                //输出几十个数，看一看效果，就能知道代码有没有写错！
                //System.out.println(l);
                num++;
                System.out.println(l);
            }
        }
        System.out.println(num);
    }
    //思路分析
    //1.编写一个单独的方法isShan判断一个数是不是‘山’
    //  1.1将这个数 ->字符串 ->字符数组
    //  1.2遍历数组判断是否 左右对称 和  前半部分是否单调不减
    //2.写一个循环依次将[2022, 2022222022]通过isshan判断并计数
    public static boolean isShan(long a) {
        String s = String.valueOf(a);
        char[] chars = s.toCharArray();
        //注意：for() 循环到数组中间元素得前一个元素
        //这里如果是 四位数如4554长度是4  数组元素从0开始
        //故只需要访问chars[0] 和chars[1]就行
        //i < chars.length/2需要体会，可以用笔 举例子
        for (int i = 0; i < chars.length/2; i++) {
            //注意：if()需要实现 是否 前半部分是否单调不减(可以等) 和 左右对称
            if(chars[i] > chars[i+1]
                    || chars[i] != chars[chars.length-1-i]) {
                return false;
            }
        }
        return true;
    }
}