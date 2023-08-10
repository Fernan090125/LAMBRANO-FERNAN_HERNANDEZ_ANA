package com.backend.integrador.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.backend.integrador.dao.H2Connection;
import com.backend.integrador.dao.OdontologoDAO;
import com.backend.integrador.entity.Odontologo;
import org.apache.log4j.Logger;

public class OdontologoDAOH2  implements OdontologoDAO<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);



    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologoObject = null;

        try {
            connection = DriverManager.getConnection("jdbc:h2:~/dh/ODONTOLOGOS", "sa", "sa");;
            connection.setAutoCommit(false);
            String sql = "INSERT INTO ODONTOLOGOS  (NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.execute();

            ResultSet key = ps.getGeneratedKeys();
            odontologo = new Odontologo(odontologo.getNumeroMatricula(), odontologo.getNombre(), odontologo.getApellido());
            while (key.next()){
                odontologoObject.setId(key.getInt("id"));
            }

            connection.commit();
            LOGGER.info("Se ha registrado el odontologo: " + odontologo);


        } catch (Exception exception){
            LOGGER.error(exception.getMessage());
            if(connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Se ha presentado un problema");
                    LOGGER.error(exception.getMessage());
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage());
                    exception.printStackTrace();
                }
            }

        } finally {
            try{
                connection.close();
            } catch (Exception exception){
                LOGGER.error("No se terminó la conexion. "+ exception.getMessage());
            }
        }

        return odontologoObject;
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList();
        String sql = "SELECT * FROM ODONTOLOGOS";

        try {
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                odontologos.add(this.crearObjetoOdontologo(rs));
            }
            LOGGER.info("Listado de todos los odontologos: " + odontologos);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologos;
    }
    private Odontologo crearObjetoOdontologo(ResultSet rs) throws SQLException {

        int id = rs.getInt("id");
        String numero_matricula = rs.getString("numero_matricula");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");

        return new Odontologo(id, numero_matricula, nombre, apellido);
    }
}

