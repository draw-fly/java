package thinking;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Java02 {
    private int a;
    private static Java02 java02 = new Java02(1);

    public  Java02(int a) {
        this.a = a;
    }

    /*第二章一切都是对象
    数据存储到什么地方：
    （1）寄存器    位于处理器内部，数量极其有限，按需分配，无法在程序中感觉得寄存器的存在（c/c++ 可以建议寄存器的分配方式）
    （2）堆栈      位于通用RAM（随机访问存储器/内存）通过堆栈指针获得CPU的直接支持，向下移动从新分配内存，向上移动释放内存，需要了解数据项的生命周期---对象引用
    （3）堆        通用内存池（位于RAM）存放java对象，不需要了解其生命周期，灵活性比较高，但需要耗费更多的分配时间
    （4）常量存储    存储在代码内部
    （5）非RAM存储   流对象和持久化对象


    基本数据类型:boolean    -
               char       16-bit      Character
               byte       8 bits      Byte
               short      16 bits     Short
               int        32 bits     Integer
               long       64 bits     Long
               float      32 bits     Float
               double     64 bits     Double
               void       -           Void



    * */
public static void main(String[] args) {
    BigDecimal bigDecimal = new BigDecimal("58.66");
    BigInteger bigInteger = new BigInteger("58");
    BigInteger bigInteger1 = new BigInteger("42");
    System.out.println(bigDecimal);
    System.out.println(bigInteger);
//    System.out.println(new Java02().a);
    System.out.println(Java02.java02);
    System.out.println(new Java02(2));
    System.out.println(new Java02(3));
    System.out.println(new Java02(4));
    System.out.println(Java02.java02);
    demo("123", "1234", "12345");
}
    public static void demo(String... a){
        System.out.println(a[1]);
    }



}
