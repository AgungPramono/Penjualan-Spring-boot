//
// ProdukController.java
// Aplikasi-Penjualan-Web 
//
// Created by Agung Pramono on 30/10/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.penjualan.controller;

import com.agung.penjualan.dao.ProdukDao;
import com.agung.penjualan.entity.Produk;
import javax.validation.Valid;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
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
 *
 */
@Controller
@RequestMapping("/produk")
public class ProdukController {

    @Autowired
    private ProdukDao pd;
    
    @Value("classpath:/report/report_produk.jrxml")
    private Resource produkJrxml;
    private JasperReport produkJasper;
    
    @RequestMapping("list")
    public void daftarProduk(ModelMap mm,Pageable page){
        Page<Produk> result = pd.findAll(page);
        mm.addAttribute("daftarProduk", result);
    }
    
    
    
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public void tampilkanForm(@RequestParam(required = false, name = "id")Produk produk, ModelMap mm){
        if (produk != null) {
            mm.addAttribute("produk", produk);
        }else{
            mm.addAttribute("produk", new Produk());
        }
    }
    
    @RequestMapping(value = "/hapus")
    public String hapusProduk(@RequestParam(required = true, value = "id")String id){
        if (id != null) {
            pd.delete(id);
        }
        return "redirect:list";
    }
    
    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Produk produk,BindingResult hasilValidasi){
        if(hasilValidasi.hasErrors()){
            return "/produk/form";
        }
        pd.save(produk);
        return "redirect:list";
    }
    
}
