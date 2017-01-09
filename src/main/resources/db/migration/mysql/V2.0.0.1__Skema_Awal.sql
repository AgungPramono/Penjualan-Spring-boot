/*drop table schema_version;drop table tb_produk;drop table tb_distributor;drop table tb_kasir;drop table tb_transaksi;*/

CREATE TABLE tb_produk (
  id varchar(255) NOT NULL,
  create_date datetime DEFAULT NULL,
  harga decimal(19,0) NOT NULL,
  kode_produk varchar(150) NOT NULL,
  nama_produk varchar(150) NOT NULL,
  jumlah bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_e4mx9rtvg4tr7vihpy96crm68 (kode_produk)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tb_distributor (
  id varchar(255) NOT NULL,
  create_date datetime DEFAULT NULL,
  alamat_distributor varchar(150) NOT NULL,
  kode_distributor varchar(50) NOT NULL,
  nama_distributor varchar(150) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_tdc88h2kvggdhvdi8kl1njnbd (kode_distributor)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tb_kasir (
  id varchar(255) NOT NULL,
  create_date datetime DEFAULT NULL,
  alamat_kasir varchar(150) DEFAULT NULL,
  jenis_kelamin varchar(10) NOT NULL,
  kode_kasir varchar(150) NOT NULL,
  nama_kasir varchar(150) NOT NULL,
  password varchar(200) NOT NULL,
  user_name varchar(150) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_2t9t4jo5i271tdwjlx2tu7699 (kode_kasir)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table tb_transaksi(
    id VARCHAR(36),
    create_date datetime DEFAULT NULL,
    kode_transaksi VARCHAR(10) NOT NULL,
    tanggal_transaksi DATE NOT NULL,
    CONSTRAINT pk_kelas PRIMARY KEY (id),
    CONSTRAINT uk_kode UNIQUE(kode_transaksi)
)Engine=InnoDB;

create table transaksi_detail_produk (
    id_transaksi VARCHAR(36) NOT NULL,
    id_produk VARCHAR(36) NOT NULL,
    CONSTRAINT transaksi_detail_produk PRIMARY KEY (id_transaksi, id_produk),
    CONSTRAINT uk_transaksi_produk UNIQUE(id_transaksi, id_produk),
    CONSTRAINT fk_produk FOREIGN KEY (id_produk) 
        REFERENCES tb_produk(id),
    CONSTRAINT fk_transaksi_detail_produk FOREIGN KEY (id_transaksi) 
        REFERENCES tb_transaksi(id)
) Engine=InnoDB ;

