package com.backend.integrador.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.backend.integrador.dao.H2Connection;
import com.backend.integrador.dao.OdontologoDAO;
import com.backend.integrador.entity.Odontologo;

public class OdontologoDAOH2  implements OdontologoDAO<Odontologo> {

    @Override
    public void guardarOdontologo(Odontologo odontologo) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/dh/ODONTOLOGOS", "sa", "sa");;
            connection.setAutoCommit(false);
            String sql = "INSERT INTO ODONTOLOGOS  (ID,NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, odontologo.getId());
            ps.setInt(2, odontologo.getNumeroMatricula());
            ps.setString(3, odontologo.getNombre());
            ps.setString(4, odontologo.getApellido());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<Odontologo>();;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM ODONTOLOGOS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Odontologo odontologo = new Odontologo();
                odontologo.setId(resultSet.getInt("ID"));
                odontologo.setNumeroMatricula(resultSet.getInt("NUMERO_MATRICULA"));
                odontologo.setNombre(resultSet.getString("NOMBRE"));
                odontologo.setApellido(resultSet.getString("APELLIDO"));
                odontologos.add(odontologo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return odontologos;
    }
}