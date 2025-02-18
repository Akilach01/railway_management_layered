package com.ijse.gdse.railway_management.railway_management_system.bo.custom.impl;

import com.ijse.gdse.railway_management.railway_management_system.dto.userDto;
import com.ijse.gdse.railway_management.railway_management_system.bo.custom.userBO;
import com.ijse.gdse.railway_management.railway_management_system.dao.*;
import com.ijse.gdse.railway_management.railway_management_system.entity.user;
import com.ijse.gdse.railway_management.railway_management_system.dao.*;


import java.util.ArrayList;

public class userBOImpl implements userBO {

   userDAO userDAO = (userDAO) DAOFactory.getInstance().getDao(DAOFActory.DaoType.user);

    @Override
    public ArrayList<userDto> getAll() throws Exception {
        ArrayList<user> users=userDAO.getAll();
        ArrayList<userDto> userDtos=new ArrayList<>();
        for (user user:users) {
            userDtos.add(new userDto(user.getU_id(), user.getName(), user.getContact_no(),
                    user.getGmail()));
        }
        return userDtos;
    }

    @Override
    public String getNextUserId() throws Exception {
        return userDAO.generateNewId();
    }

    @Override
    public boolean update(userDto userDto) throws Exception {
        return userDAO.update(new user(
                userDto.getU_id(),
                userDto.getName(),
                userDto.getContact_no(),
                userDto.getGmail()));
    }

    @Override
    public boolean save(userDto userDto) throws Exception {
        return userDAO.save(new user(
                userDto.getU_id(),
                userDto.getName(),
                userDto.getContact_no(),
                userDto.getGmail()));
    }

    @Override
    public boolean delete(String text) throws Exception {
        return userDAO.delete(text);

        
    }

}
