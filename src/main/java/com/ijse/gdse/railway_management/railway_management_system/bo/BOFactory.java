package com.ijse.gdse.railway_management.railway_management_system.bo;

import com.ijse.gdse.railway_management.railway_management_system.bo.custom.impl.*;


public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return BOFactory == null ? new BOFactory(): boFactory();
    }

    public superBO getBO(BOType type){
        switch (type) {
            case user:
                return new userBOImpl();
            case admin:
                return new adminBOImpl();
            case booking:
                return new bookingBOImpl();
            case login:
                return new loginBOImpl();
            case payment:
                return new paymentBOImpl();
            case schedule:
                return new scheduleBOImpl();
            case train:
                return new trainBOImpl();

            default:
                return null;
        }
    }

    public enum BOType{
        user,admin,booking,login,payment,schedule,train
    }

}
