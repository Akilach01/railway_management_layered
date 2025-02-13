package com.ijse.gdse.railway_management.railway_management_system.service;

import com.ijse.gdse.railway_management.railway_management_system.service.custom.impl.userServiceImpl;


public class serviceFactory {
    private static serviceFactory serviceFactory;

    private serviceFactory(){}

    public static serviceFactory getInstance(){
        return serviceFactory == null ? new serviceFactory() : serviceFactory;
    }

    public superService getService(serviceType type){
        switch (type) {
            case user:
                return new userServiceImpl();

            default:
                return null;
        }
    }

    public enum serviceType{
        user
    }



}
