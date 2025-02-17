package com.ijse.gdse.railway_management.railway_management_system.dao.custom.impl;

import com.ijse.gdse.railway_management.railway_management_system.dao.custom.userDAO;
import com.ijse.gdse.railway_management.railway_management_system.dto.userDto;
import com.ijse.gdse.railway_management.railway_management_system.entity.user;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class userDAOImpl implements userDAO {


    public String handleRegisterUser(userDto userDto) throws Exception{
        String sql = "insert into user values(?,?,?,?)";
        Boolean resp = crudUtil.execute(sql,userDto.getU_id(),userDto.getName(),userDto.getContact_no(),userDto.getGmail());
        return resp == Boolean.TRUE ? "success" : "fail";
    }
    public String generateNewId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT u_id FROM user ORDER BY u_id DESC LIMIT 1";
        ResultSet res = crudUtil.execute(sql);
        if (res.next()) {
            String lastId = res.getString("u_id");
            String subString = lastId.substring(1);

            int i = Integer.parseInt(subString);
            i = i + 1;
            String newu_id = String.format("u%03d", i);

            return newu_id;
        }
        return "u001";

    }

    @Override
    public boolean save(user dto) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO user VALUES (?, ?, ?, ?, ?)";
        return crudUtil.execute(query, dto.getU_id(), dto.getName(), dto.getGmail(), dto.getContact_no());
    }

    @Override
    public ArrayList<user> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM user";
        ResultSet res = crudUtil.execute(sql);
        ArrayList<user> userList = new ArrayList<>();

        while (res.next()) {
            user user = new user(
                    res.getString("u_id"),
                    res.getString("name"),
                    res.getInt("contact_no"),
                    res.getString("gmail")
            );
           userList.add(user);
        }

        return userList;
    }

    }

    @Override
    public boolean update(user dto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE user SET name = ?, gmail = ?, contact_no = ? WHERE u_Id = ?";
        return crudUtil.execute(sql,dto.getU_id(), dto.getName(), dto.getGmail(), dto.getContact_no());

    }

    @Override
    public boolean exist(String u_id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String u_id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM user WHERE u_Id = ?";
        return crudUtil.execute(sql, u_id);
    }


}
