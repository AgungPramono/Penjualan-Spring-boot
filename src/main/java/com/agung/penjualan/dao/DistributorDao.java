//
// DistributorDao.java
// Aplikasi-Penjualan-Web 
//
// Created by Agung Pramono on 30/10/2016 
// Copyright (c) 2016 Java Development. All rights reserved.
//

package com.agung.penjualan.dao;

import com.agung.penjualan.entity.Distributor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 */
public interface DistributorDao extends PagingAndSortingRepository<Distributor, String>{

}
