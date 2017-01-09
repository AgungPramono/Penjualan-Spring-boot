# Prototype Aplikasi Penjualan menggunakan SpringBoot

## Teknologi yang digunakan
	* SpringBoot
	* Spring Data JPA
	* Hibernate
	* Thymeleaf Template Engine
	* Css Bootstrap
	* MySQL
	* Font Awesome
	* Template Admin

## Langkah Menjalankan Project
	1. Buat database MySQL

		* nama database : penjualan
		* username = root(atau sesuaikan dg yang ada dikomputermu)
		* password = (sesuaikan dg yang ada dikomputermu)	

	2. Edit file konfigurasi application.properties	

	3. Langkah Menjalankan
		* buka terminal atau Command prompt, kemudian arahkan ke project ini
		* jalankan perintah dibawah untuk membuild project
		* kemudian jalankan perintah di bawah untuk menjalankan aplikasi
		``````
			mvn clean package spring-boot:run
		```````	
		* aplikasi siap di browse di localhost:8080/index
		* username : agung
		* password : 123

	4. Fitur Aplikasi

		* Cetak Laporan
		* Tabel Relasi

```
Copyright 2017 Agung Pramono.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership. The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License. You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations under
the License.
```		