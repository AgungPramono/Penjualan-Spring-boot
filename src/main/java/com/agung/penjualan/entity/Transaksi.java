//
// Transaksi.java
// Aplikasi-Penjualan-Web 
//
// Created by Agung Pramono on 01/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.penjualan.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 */
@Entity
@Table(name = "tb_transaksi")
public class Transaksi extends BaseEntity{

    @NotNull @NotEmpty @Size(min = 3, max = 10)
    @Column(unique = true, nullable = false)
    private String kodeTransaksi;
    
    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    private Date tanggalTransaksi;
    
    @ManyToMany
    @JoinTable(
            name = "transaksi_detail_produk",
            joinColumns = @JoinColumn(name = "id_transaksi"),
            inverseJoinColumns = @JoinColumn(name = "id_produk")
    )
    private List<Produk> daftarProduk = 
            new ArrayList<>();

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(String kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public List<Produk> getDaftarProduk() {
        return daftarProduk;
    }

    public void setDaftarProduk(List<Produk> daftarProduk) {
        this.daftarProduk = daftarProduk;
    }
    
    
}
