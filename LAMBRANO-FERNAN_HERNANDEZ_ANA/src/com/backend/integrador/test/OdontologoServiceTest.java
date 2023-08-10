package com.backend.integrador.test;

import com.backend.integrador.dao.impl.OdontologoDAOH2;
import com.backend.integrador.entity.Odontologo;
import com.backend.integrador.service.OdontologoService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OdontologoServiceTest {
    OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());

    public OdontologoServiceTest() {
    }
    @Test
    void deberiaHaberUnaListaNoVacia() {
        List<Odontologo> odontologos = this.odontologoService.listarOdontologos();
        Assertions.assertFalse(odontologos.isEmpty());
        Assertions.assertTrue(odontologos.size() >= 1);
    }
}