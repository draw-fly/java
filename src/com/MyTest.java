package com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyTest {

    public static List<Ingredient> filterBytype(List<Ingredient> list, Ingredient.Type type){
        return list.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }




    public static void main(String[] args) {
        ISomeService service = new SomeServiceImpl();

//        ServiceProxy serviceProxy = new ServiceProxy(service);
//        String s = serviceProxy.doFirst();
//        System.out.println(s);
//        serviceProxy.doSecond();
//        动态代理
        ISomeService service1 = (ISomeService)Proxy.newProxyInstance(
                service.getClass().getClassLoader(),//目标的类加载器
                service.getClass().getInterfaces(),//目标类所实现的所有接口
                new InvocationHandler() {          //内部匿名类
                    // proxy: 代理对象
                    // method: 目标方法
                    // args : 目标方法的参数类表
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = method.invoke(service, args);
                        return ((String) result).toUpperCase();
                    }
                }

        );
        String result = service1.doFirst();
        System.out.println(result);
        System.out.printf("haha:%d%d",'a'-2,'0'-21);
        Ingredient.Type[] types = Ingredient.Type.values();
        List<Ingredient> list = Arrays.asList(new Ingredient("黄锋","123", Ingredient.Type.ace), new
                Ingredient("吕橙", "123", Ingredient.Type.mvp), new Ingredient("hahahh","123", Ingredient.Type.ace), new Ingredient("黄锋","123", Ingredient.Type.ace));

        for(Ingredient.Type type : types){
            List<Ingredient> list1 = filterBytype(list,type);
            list1.forEach((element->{
                System.out.println(element+"美美");
            }));
            for( Ingredient ingredient : list1){
                System.out.println(ingredient+"哈哈哈哈哈");
            }

//            System.out.println(list1.);
        }
    }
}
