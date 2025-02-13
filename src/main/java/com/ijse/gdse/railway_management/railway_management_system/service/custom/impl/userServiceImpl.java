package com.ijse.gdse.railway_management.railway_management_system.service.custom.impl;

import com.ijse.gdse.railway_management.railway_management_system.dto.userDto;
import com.ijse.gdse.railway_management.railway_management_system.service.custom.userService;

import java.util.ArrayList;

public class userServiceImpl implements userService {

   userDAO userDAO = (userDAO) DAOFactory.getInstance().getDao(DaoType.user);

    @Override
    public ArrayList<userDto> getAll() throws Exception {
        ArrayList<userDto> userDtos = new ArrayList<>();
        ArrayList<userEntity> users = userDAO.getAll();
        for (userEntity user : users) {
            userDtos.add(new userDto(user.getu_id(), user.getName(), user.getcontact(),
                    user.getgmail()));
        }
        return userDtos;
    }

    @Override
    public String getNextUserId() throws Exception {
        return userDAO.generateNewId();
    }

    @Override
    public boolean updateUser(userDto userDto) throws Exception {
        return userDAO.update(new userEntity(
                userDto.getu_iD(),
                userDto.getName(),
                userDto.getcontact(),
                userDto.getgmail()));
    }

    @Override
    public boolean saveuser(userDto userDto) throws Exception {
        return customerDao.save(new userEntity(
                userDto.getu_iD(),
                userDto.getName(),
                userDto.getcontact(),
                userDto.getgmail()));
    }

    @Override
    public boolean deleteuser(String text) throws Exception {
        return userDAO.delete(text);
    }

}
