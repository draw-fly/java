import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo extends Demo1{
    private int a;
    static void getname(){
        System.out.println("hahh");

    }
   static void pp(){


    }

    @Override
    public void mm() {
        super.mm();
    }

    public static void main(String[] args) {

        String name=new String("黄锋");
        String name1="黄锋";
        String name2="黄锋";
        String name3;
        System.out.println(name1.equals(name));
        System.out.println(name1==name2);
        System.out.println(name.hashCode());
        System.out.println(System.identityHashCode(name2));
        System.out.println(System.identityHashCode(name1));
        System.out.println(System.identityHashCode(name));
        Demo demo = new Demo();
        getname();
        List<Demo1> list=new ArrayList<>();
        LinkedList<Demo1> list1=new LinkedList<Demo1>();


    }

    }

