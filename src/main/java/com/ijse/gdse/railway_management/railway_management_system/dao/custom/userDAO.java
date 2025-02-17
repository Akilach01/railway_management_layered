package com.ijse.gdse.railway_management.railway_management_system.dao.custom;

import com.ijse.gdse.railway_management.railway_management_system.dao.crudDAO;
import com.ijse.gdse.railway_management.railway_management_system.dto.userDto;
import com.ijse.gdse.railway_management.railway_management_system.entity.user;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public interface userDAO extends crudDAO {

     String handleRegisterUser(userDto userDto) throws Exception;

     boolean save(user dto) throws SQLException, ClassNotFoundException;
      ArrayList<user> getAll() throws SQLException;
      boolean update(user dto) throws SQLException, ClassNotFoundException;
      boolean delete(String u_id) throws SQLException, ClassNotFoundException;
}
