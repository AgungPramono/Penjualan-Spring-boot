/*
 *  Copyright (c) 2015 Agung Pramono <agungpermadi13@gmail.com || www.github.com/agung pramono>.
 *  All rights reserved.
 * 
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 * 
 *  Kasir.java
 * 
 *  Created on Dec 7, 2015, 4:31:23 PM
 */
package com.agung.penjualan.entity;

import com.agung.penjualan.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author agung
 */
@Entity
@Table(name = "tb_kasir")
public class Kasir extends BaseEntity{
    
    @Column(name = "kode_kasir",nullable = false,unique = true,length = 150)
    private String kodeKasir;
    @Column(name = "nama_kasir",nullable = false,length = 150)
    private String namaKasir;
    @Column(name = "alamat_kasir",nullable = true,length = 150)
    private String alamatKasir;
    @Column(name = "jenis_kelamin",nullable = false,length = 10)
    private String jenisKelamin;
    @Column(name = "user_name",nullable = false,length = 150)
    private String userName;
    @Column(name = "password",nullable = false,length = 200)
    private String password;

    public String getKodeKasir() {
        return kodeKasir;
    }

    public void setKodeKasir(String kodeKasir) {
        this.kodeKasir = kodeKasir;
    }

    public String getNamaKasir() {
        return namaKasir;
    }

    public void setNamaKasir(String namaKasir) {
        this.namaKasir = namaKasir;
    }

    public String getAlamatKasir() {
        return alamatKasir;
    }

    public void setAlamatKasir(String alamatKasir) {
        this.alamatKasir = alamatKasir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
