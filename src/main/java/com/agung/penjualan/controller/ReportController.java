//
// ReportController.java
// Aplikasi-Penjualan-Web 
//
// Created by Agung Pramono on 31/10/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//
package com.agung.penjualan.controller;

import com.agung.penjualan.dao.ProdukDao;
import com.agung.penjualan.entity.Produk;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ProdukDao pd;

//    @RequestMapping(value = "/produk")
//    public void daftarProduk(ModelMap map){
//        map.addAttribute("dataDalamReport", pd.findAll());
//        map.addAttribute("tanggalCetak", new Date());
//        map.addAttribute("format","pdf");
//    }
    @RequestMapping("/produk")
    public ModelAndView generateReportProduk(ModelAndView m,
            @RequestParam(value = "format", required = false) String format) {

        Iterable<Produk> data = pd.findAll();
        m.addObject("dataDalamReport", data);
        m.addObject("format", "pdf");
        m.addObject("tanggalCetak", new Date());

        if (format != null && !format.isEmpty()) {
            m.addObject("format", format);
        }

        m.setViewName("report_produk");
        return m;
    }
}
