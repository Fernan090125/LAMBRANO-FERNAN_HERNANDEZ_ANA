package com.backend.integrador.service;

import java.util.List;

import com.backend.integrador.dao.OdontologoDAO;
import com.backend.integrador.entity.Odontologo;

public class OdontologoService {
    private OdontologoDAO<Odontologo> odontologoIDao;

    public OdontologoService(OdontologoDAO<Odontologo> odontologoIDao) {

        this.odontologoIDao = odontologoIDao;
    }

    public void registrarOdontologo(Odontologo odontologo){

        odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologos(){

        return odontologoIDao.listarOdontologos();
    }

}