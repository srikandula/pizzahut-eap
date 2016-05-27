# Create pizzauser with password as techm123
CREATE USER 'pizzauser'@'localhost' IDENTIFIED BY 'techm123';
GRANT ALL PRIVILEGES ON *.* TO 'pizzauser'@'localhost'   WITH GRANT OPTION;
CREATE USER 'pizzauser'@'%' IDENTIFIED BY 'techm123';
GRANT ALL PRIVILEGES ON *.* TO 'pizzauser'@'%'  WITH GRANT OPTION;
FLUSH PRIVILEGES;

create database if not exists pizzahut;
use pizzahut;

#DROP TABLE menu_item;

CREATE TABLE menu_item(
   menu_id       INT NOT NULL,
   item_name     VARCHAR(255) NOT NULL,
   size          ENUM ('PAN','SMALL','MEDIUM','LARGE'),
   crest_type    ENUM ('THIN_CREST','NORMAL','DOUBLE_CHEESE','OTHERS'),
   cost          INT,
   veg_type      ENUM ('VEG','NON-VEG'),
   topings       VARCHAR(255),
   CONSTRAINT pk_menu_item PRIMARY KEY (menu_id)
);

INSERT INTO menu_item 
      (menu_id,  item_name,            size,      crest_type,      cost,     veg_type,  topings)    values 
      (1,       'Chicken Supreme',    'LARGE',   'THIN_CREST',     500,     'NON-VEG', 'chicken,onions,alapeno'),
      (2,       'Chicken Supreme',    'MEDIUM',  'NORMAL',         300,     'NON-VEG', 'chicken,onions,alapeno'),
      (3,       'Veg Supreme',        'LARGE',   'DOUBLE_CHEESE',  400,     'VEG',     'Paneer,onions,alapeno'),
      (4,       'Veg Supreme',        'MEDIUM',  'NORMAL',         200,     'VEG',     'Paneer,onions,alapeno');

