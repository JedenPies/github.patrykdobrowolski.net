create database if not exists blog;

use blog;

create table if not exists uzytkownicy(
	id    int not null auto_increment primary key,
	email varchar(255) not null,
	haslo varchar(255) not null)
	ENGINE = InnoDB;
	
create table if not exists wpisy(
	id int not null auto_increment primary key,
	data datetime not null,
	tytul varchar(255) not null,
	tresc blob not null)
	ENGINE = InnoDB;
