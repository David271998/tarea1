package com.origami.tarea1.services;

import com.origami.tarea1.model.ClientModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientServices {
    public ResponseEntity<ClientModel> buscarCliente(ClientModel data) {
        System.out.println("DATA: "+data.toString());
        try {
            ClientModel cl = null;
            switch (data.getTipoDoc()) {
                case "C"://cedula
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                case "P"://pasaporte
                  if(data.getIdentificacion().equals("12345678")){
                      cl = ClientModel.builder()
                              .identificacion("12345678")
                              .tipoDoc("C")
                              .primerApellido("BORBOR")
                              .segundoApellido("MURILLO")
                              .primerNombre("DAVID")
                              .segundoNombre("GABRIEL")
                              .telefono("0985779864")
                              .direccion("SANTA ELENA")
                              .build();
                  }
                    break;
                default:
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            }

            return new ResponseEntity<>(cl, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
