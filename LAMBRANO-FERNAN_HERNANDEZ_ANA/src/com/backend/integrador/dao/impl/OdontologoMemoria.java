package com.backend.integrador.dao.impl;

import com.backend.integrador.dao.OdontologoDAO;
import com.backend.integrador.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoMemoria implements OdontologoDAO<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoMemoria.class);
    private List<Odontologo> odontologos;

    public OdontologoMemoria(List<Odontologo> odontologos) {
        this.odontologos = odontologos;
    }

    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        LOGGER.info("Odontologo guardado: " + odontologo);
        return odontologo;
    }

    public List<Odontologo> listarOdontologos() {
        LOGGER.info("Listado de los odontologos: \n" + odontologos);
        return odontologos;
    }
}