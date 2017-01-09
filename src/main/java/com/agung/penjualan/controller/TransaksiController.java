//
// TransaksiController.java
// Aplikasi-Penjualan-Web 
//
// Created by Agung Pramono on 01/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.penjualan.controller;

import com.agung.penjualan.dao.ProdukDao;
import com.agung.penjualan.dao.TransaksiDao;
import com.agung.penjualan.entity.Produk;
import com.agung.penjualan.entity.Transaksi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 */
@SessionAttributes(names = "daftarProduk")
@Controller
@RequestMapping("/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiDao td;
    
    @Autowired
    private ProdukDao pd;
    
    //konversi format tanggal
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
    
//    @ModelAttribute("pilihanProduk")
//    public void daftarProduk(ModelMap mm,Pageable page){
//        Page<Produk> resutl = pd.findAll(page);
//        mm.addAttribute("pilihanProduk", resutl);
//    }
    
    @ModelAttribute("pilihanProduk")
    public Iterable<Produk> pilihanProduk() {
        return pd.findAll();
    }
    
    @RequestMapping("list")
    public void daftarTransaksi(Pageable page, ModelMap mm) {
        mm.addAttribute("daftarTransaksi", td.findAll(page));
    }
    
    //@PreAuthorize("hasRole('EDIT_MATERI')")
    @RequestMapping(value = "formtrx", method = RequestMethod.GET)
    public void tampilkanForm(
            @RequestParam(name = "id", required = false) Transaksi transaksi,
            @RequestParam(name = "id_produk", required = false) Produk produk,
            @RequestParam(name = "action", required = false) String action,
            @SessionAttribute(name = "daftarProduk", required = false) List<Produk> daftarProduk,
            ModelMap mm) {

        if ("edit".equalsIgnoreCase(action)) {
            daftarProduk = new ArrayList<>();
        }
        
        if (transaksi != null) {
            mm.addAttribute("transaksi", transaksi);

            if("edit".equalsIgnoreCase(action)){
                daftarProduk = transaksi.getDaftarProduk();
            }
            
        } else {
            mm.addAttribute("transaksi", new Transaksi());
        }

        if (produk != null) {
            if("add".equalsIgnoreCase(action)) {
                daftarProduk.add(produk);
            } else if("remove".equalsIgnoreCase(action)) {
                daftarProduk.remove(produk);
            } 
        }
        mm.addAttribute("tanggalTransaksi", new Date());
        mm.addAttribute("daftarProduk", daftarProduk);
    }

    //@PreAuthorize("hasRole('EDIT_MATERI')")
    @RequestMapping(value = "formtrx", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Transaksi transaksi, 
            BindingResult hasilValidasi, 
            SessionStatus status,
            @SessionAttribute(name = "daftarProduk", required = false) List<Produk> daftarProduk
            ) {
        if(hasilValidasi.hasErrors()) {
            return "/transaksi/formtrx";
        }
        
        transaksi.setDaftarProduk(daftarProduk);
        td.save(transaksi);
        status.setComplete();
        
        return "redirect:list";
    }
}
