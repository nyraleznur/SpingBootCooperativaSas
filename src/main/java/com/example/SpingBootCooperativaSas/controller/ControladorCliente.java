package com.example.SpingBootCooperativaSas.controller;


import com.example.SpingBootCooperativaSas.entity.Cliente;
import com.example.SpingBootCooperativaSas.service.ServicioImpCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@Controller
//@RequestMapping("/cliente")
public class ControladorCliente {
    @Autowired
    private ServicioImpCliente sic;

    @GetMapping("cliente")
    public String listar(Model modelo){
        modelo.addAttribute("clientes",sic.listarClientes());
        return ("taclientes");
    }




    @GetMapping("cliente/nuevo")
    public String formularioregistro(Model modelo){
        modelo.addAttribute("clienteinsertar",new Cliente());
        return "frmcliente";
    }



    @PostMapping("cliente/guarda")
    public String insertar(Cliente cli){
        sic.guardarClientes(cli);
        return "redirect:/cliente";
    }


    @GetMapping("cliente/actualizar/{dato}")
    public  String  formularioActualizar(@PathVariable("dato") String dato,Model modelo){
        Cliente cliente=sic.consultaClientesPorId(dato);
        modelo.addAttribute("clienteactualizar",cliente);
        return "frmactualizar";
    }




    @PostMapping("cliente/actualizar")
    public String actualizar( Cliente cli){
        sic.actualizarClientes(cli);
        return "redirect:/cliente";
    }




    @GetMapping("cliente/eliminar/{id}")
    public String eliminarpoId(@PathVariable("id") String id){
        sic.eliminarClientesId(id);
        return ("redirect:/cliente");
    }







}
