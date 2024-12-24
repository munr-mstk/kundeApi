package com.munirmustakoglu.kunde.controller.impl;

import com.munirmustakoglu.kunde.controller.IKundeController;
import com.munirmustakoglu.kunde.dto.DtoKunde;
import com.munirmustakoglu.kunde.dto.DtoKundeIU;
import com.munirmustakoglu.kunde.entities.Kunde;
import com.munirmustakoglu.kunde.services.IKundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/api/kunde")
public class KundeControllerImpl  implements IKundeController {

    @Autowired
    private IKundeService kundeService;  //Kunde service sınıfı buraya implemente edilmiş oldu.Doğru kullnımı service interfacei ile yakalanmasıdır.

    @PostMapping(path = "/save")
    @Override
    public DtoKunde saveKunde(@RequestBody DtoKundeIU dtoKundeIU) {
        return  kundeService.saveKunde(dtoKundeIU);  //İçindeki save kunde Adındaki metota git parametre olarak gelen değeri verdim.
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoKunde> getAllKundes() {
        return kundeService.getAllKundes();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoKunde getKundeById(@PathVariable(name = "id") Integer id) {
        return kundeService.getKundeById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteKunde(@PathVariable(name = "id") Integer id) {
        kundeService.deleteKunde(id);

    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoKunde updateKunde(@PathVariable(name = "id") Integer id, @RequestBody DtoKundeIU dtoKundeIU) {
        return kundeService.updateKunde(id, dtoKundeIU);
    }

}

