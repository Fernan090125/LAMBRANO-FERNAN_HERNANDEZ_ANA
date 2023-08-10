package com.backend.integrador;

import java.sql.Connection;
import java.sql.DriverManager;

import com.backend.integrador.dao.OdontologoDAO;
import com.backend.integrador.dao.impl.OdontologoDAOH2;
import com.backend.integrador.entity.Odontologo;
import com.backend.integrador.service.OdontologoService;

public class Application {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/dh/ODONTOLOGOS;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
