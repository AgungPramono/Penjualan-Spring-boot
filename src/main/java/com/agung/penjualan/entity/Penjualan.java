/*
 *  Copyright (c) 2015 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  Penjualan.java
 * 
 *  Created on Dec 7, 2015, 4:30:06 PM
 */
package com.agung.penjualan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author agung
 */
@Entity
@Table(name = "tb_penjualan")
public class Penjualan extends BaseEntity{
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_transaksi", nullable = false)
    private Date tanggalTransaksi = new Date();

    @NotNull
    @Column(name="total_bayar",precision=19,scale=0,nullable=false)
    private BigDecimal totalBayar = BigDecimal.ZERO;
  
    @OneToMany(mappedBy = "penjualan",
            cascade = javax.persistence.CascadeType.ALL,
            orphanRemoval = true)
    private List<PenjualanDetail> daftarPenjualan = new ArrayList<PenjualanDetail>();

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public BigDecimal getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(BigDecimal totalBayar) {
        this.totalBayar = totalBayar;
    }

    public List<PenjualanDetail> getDaftarPenjualan() {
        return daftarPenjualan;
    }

    public void setDaftarPenjualan(List<PenjualanDetail> daftarPenjualan) {
        this.daftarPenjualan = daftarPenjualan;
    }
    
    
}
