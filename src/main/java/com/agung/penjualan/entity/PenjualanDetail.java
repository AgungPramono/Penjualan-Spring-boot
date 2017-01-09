/*
 *  Copyright (c) 2015 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  PenjualanDetail.java
 * 
 *  Created on Dec 7, 2015, 4:30:22 PM
 */
package com.agung.penjualan.entity;

import com.agung.penjualan.entity.Produk;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author agung
 */
@Entity
@Table(name = "tb_penjualan_detail")
public class PenjualanDetail extends BaseEntity{
    
    @ManyToOne
    @JoinColumn(name = "id_produk", nullable = false)
    private Produk produk;
    
    @ManyToOne
    @JoinColumn(name = "id_penjualan",nullable = false)
    private Penjualan penjualan;
    
    @Column(name = "quantity" , nullable = false)
    private Integer quantity;
    
    @Column(name = "harga", precision = 19, scale = 0, nullable = false)
    private BigDecimal harga;
    
    @Column(name = "subtotal",precision = 19, scale = 0, nullable = false)
    private BigDecimal subTotal = BigDecimal.ZERO;

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
    
    
}
