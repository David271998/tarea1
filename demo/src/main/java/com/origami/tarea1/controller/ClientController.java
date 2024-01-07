package com.origami.tarea1.controller;

import com.origami.tarea1.model.ClientModel;
import com.origami.tarea1.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/cliente")
public class ClientController
{

    @Autowired
    private ClientServices clienteService;

    @PostMapping("/buscar")
    public ResponseEntity<ClientModel> buscarCliente(@RequestBody ClientModel data) {
        return clienteService.buscarCliente(data);
    }
}
