package com.munirmustakoglu.kunde.services.impl;

import com.munirmustakoglu.kunde.dto.DtoKunde;
import com.munirmustakoglu.kunde.dto.DtoKundeIU;
import com.munirmustakoglu.kunde.entities.Kunde;
import com.munirmustakoglu.kunde.repository.KundeRepository;
import com.munirmustakoglu.kunde.services.IKundeService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KundeServiceImpl implements IKundeService {

    @Autowired
    private KundeRepository kundeRepository;

    @Override
    public DtoKunde saveKunde(DtoKundeIU dtoKundeIU) {//bana dışarıdan gelern kundeyi sen al .kunde repositorynin save diye bir metodu var bu save metodunu kullanarak bunu kaydet...
        DtoKunde response=new DtoKunde();
        Kunde kunde = new Kunde();
        BeanUtils.copyProperties(dtoKundeIU, kunde);

        Kunde dbKunde = kundeRepository.save(kunde);
        BeanUtils.copyProperties(dbKunde,response);

        return response;

    }

    @Override
    public List<DtoKunde> getAllKundes() {
        List<DtoKunde> dtoList=new ArrayList<>();
        List<Kunde> kundeList= kundeRepository.findAll();
        for(Kunde kunde:kundeList){
            DtoKunde dto=new DtoKunde();
            BeanUtils.copyProperties(kunde,dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public DtoKunde getKundeById(Integer id) {
        DtoKunde dto =new DtoKunde();
      Optional<Kunde>optional= kundeRepository.findById(id);
      if (optional.isPresent()) {
          Kunde dbkunde=optional.get();

          BeanUtils.copyProperties(dbkunde,dto);
      }
      return dto;
    }

    @Override
    public void deleteKunde(Integer id) {
        DtoKunde dtoKunde=getKundeById(id);
        Optional<Kunde> optional=kundeRepository.findById(id);
        if (optional.isPresent()) {
            kundeRepository.delete(optional.get());
        }
   }

    @Override
    public DtoKunde updateKunde(Integer id, DtoKundeIU dtoKundeIU) {
        DtoKunde dto = new DtoKunde();
        Optional<Kunde> optional = kundeRepository.findById(id);
        if (optional.isPresent()) {
            Kunde dbkunde = optional.get();

            dbkunde.setFirstName(dtoKundeIU.getFirstName());
            dbkunde.setLastName(dtoKundeIU.getLastName());
            dbkunde.setBirthOfDate(dbkunde.getBirthOfDate());

            Kunde updatedKunde = kundeRepository.save(dbkunde);
            BeanUtils.copyProperties(updatedKunde, dto);

            return dto;
        }
        return null;


            }


}
