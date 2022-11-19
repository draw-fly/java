package com;

import java.util.Locale;

public class ServiceProxy implements ISomeService{
    private ISomeService service;

    public ServiceProxy(ISomeService service) {
        super();
        this.service = service;

    }
    public ServiceProxy(){

    }

    @Override
    public  String doFirst(){
        String result = service.doFirst();
        result = result.toUpperCase();
        return result;


    }
    @Override
    public void doSecond(){

        service.doSecond();


    }
}
