//
// TransaksiDao.java
// Aplikasi-Penjualan-Web 
//
// Created by Agung Pramono on 01/11/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.penjualan.dao;

import com.agung.penjualan.entity.Transaksi;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 */
public interface TransaksiDao extends PagingAndSortingRepository<Transaksi, String>{

}
