/*
 *  Copyright (c) 2015 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  Produk.java
 * 
 *  Created on Nov 13, 2015, 8:47:05 AM
 */
package com.agung.penjualan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author agung
 */
@Entity
@Table(name = "tb_produk")
public class Produk extends BaseEntity {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 10)
    @Column(nullable = false, unique = true, name = "kode_produk", length = 150)
    private String kodeProduk;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    @Column(name = "nama_produk", nullable = false, length = 150)
    private String namaProduk;

    @NotNull
    @Min(1)
    @Column(name = "jumlah", nullable = true, length = 255)
    private Long jumlahProduk;

    @NotNull
    @Min(0)
    @Column(nullable = false, scale = 0, precision = 19)
    private BigDecimal harga = BigDecimal.ZERO;

    @ManyToMany(mappedBy = "daftarProduk")
    private List<Transaksi> daftarTransaksi = new ArrayList<>();

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public Long getJumlahProduk() {
        return jumlahProduk;
    }

    public void setJumlahProduk(Long jumlahProduk) {
        this.jumlahProduk = jumlahProduk;
    }

    @Override
    public String toString() {
        return getKodeProduk();
    }

}
