package com.backend.integrador.dao.impl;

import com.backend.integrador.dao.OdontologoDAO;
import com.backend.integrador.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public abstract class Odontologo1 implements OdontologoDAO<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(Odontologo1.class);
    private List<Odontologo> odontologos;

    public Odontologo1(List<Odontologo> odontologos) {
        this.odontologos = odontologos;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        LOGGER.info("Odontologo guardado: " + odontologo);
        return odontologo;
    }
    @Override
    public List<Odontologo> listarodontologos() {
        LOGGER.info("Listado de los odontologos: \n" + odontologos);
        return odontologos;
    }
}