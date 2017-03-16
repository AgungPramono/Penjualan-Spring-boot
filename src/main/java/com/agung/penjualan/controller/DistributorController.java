//
// DistributorController.java
// Aplikasi-Penjualan-Web
//
// Created by Agung Pramono on 30/10/2016
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.penjualan.controller;

import com.agung.penjualan.dao.DistributorDao;
import com.agung.penjualan.entity.Distributor;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Agung Pramono
 */
@Controller
@RequestMapping("/distributor")
public class DistributorController {

    @Autowired
    private DistributorDao dd;

    @RequestMapping("list")
    public void daftarProduk(ModelMap mm,Pageable page){
        Page<Distributor> result = dd.findAll(page);
        mm.addAttribute("daftarDistributor", result);
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public void tampilkanFormDistributor(@RequestParam(required = false, name = "id")Distributor distributor, ModelMap mm){
        if (distributor != null) {
            mm.addAttribute("distributor", distributor);
        }else{
            mm.addAttribute("distributor", new Distributor());
        }
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String prosesFormDistributor(@ModelAttribute @Valid Distributor distributor,BindingResult hasilValidasi){
        if (hasilValidasi.hasErrors()) {
            return "/distributor/form";
        }

        dd.save(distributor);
        return "redirect:list";
    }

    @RequestMapping(value = "/hapus", method = RequestMethod.DELETE)
    public String hapusDistributor(@RequestParam(required = true, value = "id")String id){
        if (id != null) {
            dd.delete(id);
        }
        return "redirect:list";
    }
}
