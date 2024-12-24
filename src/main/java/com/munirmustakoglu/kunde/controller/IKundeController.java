package com.munirmustakoglu.kunde.controller;

import com.munirmustakoglu.kunde.dto.DtoKunde;
import com.munirmustakoglu.kunde.dto.DtoKundeIU;
import com.munirmustakoglu.kunde.entities.Kunde;

import java.util.List;

public interface IKundeController {

    public DtoKunde saveKunde(DtoKundeIU dtoKundeIU );


    public List<DtoKunde> getAllKundes();

    public DtoKunde getKundeById(Integer id);

    public void deleteKunde(Integer id);

    public DtoKunde updateKunde(Integer id, DtoKundeIU dtoKundeIU);
}
