package com.backend.integrador.dao;

import java.util.List;

public interface OdontologoDAO<T> {
    void guardarOdontologo(T odontologo);

    List<T> listarOdontologos();
}