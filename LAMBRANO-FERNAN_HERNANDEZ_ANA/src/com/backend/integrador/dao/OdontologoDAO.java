package com.backend.integrador.dao;
import java.util.List;
public interface OdontologoDAO<T>{
    T guardar(T t);
    List<T> listarOdontologos();
}
