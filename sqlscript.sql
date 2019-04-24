 drop database if exists kitapkurdu ;
create database if not exists kitapkurdu;

use  kitapkurdu;

create table yazar(
	id int primary key auto_increment,
	adi varchar(20),
	dogum_tarihi date,
	dogum_yeri varchar(20),
	biyografi varchar(140) 
);

create table grup(
	id int primary key auto_increment,
	adi varchar(20) not null
);
create table dosya(
	id int primary key auto_increment,
	adi varchar(500),
	dosya_yolu varchar(500)
);
create table yayin_evi(
	id int primary key auto_increment,
	adi varchar(20),
	adres varchar(80),
	aciklama varchar(100)
);
create table kategori(
	id int primary key auto_increment,
	adi varchar(20)
);
create table tur(
	id int primary key auto_increment,
	adi varchar(20)
);
create table depo(
	id int primary key auto_increment,
	adi varchar(20),
	adres varchar(80),
	kapasite int
);
create table raf(
	id int primary key auto_increment,
	numara int,
	depo_id int,
	FOREIGN KEY (depo_id) REFERENCES depo(id) ON DELETE SET NULL
);
create table kolon(
	id int primary key auto_increment,
	numara int,
	raf_id int,
	FOREIGN KEY (raf_id) REFERENCES raf(id) ON DELETE SET NULL
);

create table kisi(
	id int primary key auto_increment,
	adi varchar(20),
	tc int unique,
	depo_id int,
	FOREIGN KEY (depo_id) REFERENCES depo(id) ON DELETE SET NULL
);

create table kisi_grup(
	kisi_id int,
	grup_id int,
	unique (kisi_id,grup_id),
	FOREIGN KEY (grup_id) REFERENCES grup(id)  ON DELETE SET NULL,
	FOREIGN KEY (kisi_id) REFERENCES kisi(id)  ON DELETE SET NULL
);	

create table yayin(
	id int primary key auto_increment,
	adi varchar(20),
	yazar_id int,
	sayfa_sayisi int,
	kategori_id int,
	tur_id int,
	yayin_evi_id int,
	kolon_id int,
	adet int,
	kapak_id int,

    	FOREIGN KEY (kapak_id) REFERENCES dosya(id) ON DELETE SET NULL,
    	FOREIGN KEY (yazar_id) REFERENCES yazar(id) ON DELETE SET NULL,
	FOREIGN KEY (kategori_id) REFERENCES kategori(id) ON DELETE SET NULL,
	FOREIGN KEY (tur_id) REFERENCES tur(id) ON DELETE SET NULL,
	FOREIGN KEY (yayin_evi_id) REFERENCES yayin_evi(id) ON DELETE SET NULL,
	FOREIGN KEY (kolon_id) REFERENCES kolon(id) ON DELETE SET NULL
);

create table kullanici(
	id int primary key auto_increment,
	kullanici_adi varchar(20) unique,
	type int not null,
	sifre varchar(20),
	adi varchar(20)
);

