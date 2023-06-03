-- insert 4 types of devises: laptop, pc, monitor and hdd
insert into product_type (id, name, code)
values ('c30e6790-910a-4619-a2cc-45920e166dc7', 'Настольные Компьютеры', 'PC');
insert into product_type (id, name, code)
values ('368cdeb6-8c25-4377-abdc-6b8c67b227e8', 'Ноутбуки', 'LAPTOP');
insert into product_type (id, name, code)
values ('3ce5ceab-713e-4282-b64c-8aaa07908e79', 'Мониторы', 'Monitor');
insert into product_type (id, name, code)
values ('e98b56be-b041-4467-a872-044002135347', 'Жесткие диска', 'HDD');

-- insert attributes for every product type: form-factor, diagonal, volume
insert into attributes (id, name, code, product_type_id)
values ('534bd87f-a47f-4046-9b59-7e9db88f8aca', 'Форм-фактор', 'Form-factor', 'c30e6790-910a-4619-a2cc-45920e166dc7');
insert into attributes (id, name, code, product_type_id)
values ('82acfa9b-2f7d-4747-9fa3-b7ac0be47f00', 'Диагональ', 'Diagonal', '368cdeb6-8c25-4377-abdc-6b8c67b227e8');
insert into attributes (id, name, code, product_type_id)
values ('ca778b09-2df0-4e5b-becb-2da70714c90f', 'Диагональ', 'Diagonal', '3ce5ceab-713e-4282-b64c-8aaa07908e79');
insert into attributes (id, name, code, product_type_id)
values ('bcb5976d-4d57-4fb1-a20d-5d84b63d5071', 'Объем', 'Volume', 'e98b56be-b041-4467-a872-044002135347');

-- insert 3 PC: 2 desktop and 1 nettop
insert into product (id, serial_number, manufacturer, price, stock, product_type_id)
values ('b7fcb548-ef2e-46d2-a451-b39165697ab7', '90PF02Q1-M11030', 'ASUS', 162019.0, 4, 'c30e6790-910a-4619-a2cc-45920e166dc7');
insert into attribute_value(id, attribute_id, product_id, val)
values ('92ef9cb1-da5a-4a1b-acae-412c42559399', '534bd87f-a47f-4046-9b59-7e9db88f8aca', 'b7fcb548-ef2e-46d2-a451-b39165697ab7', 'Десктоп');
insert into product (id, serial_number, manufacturer, price, stock, product_type_id)
values ('6a11f837-658e-4edf-b316-5f20575eff1a', '210-BCST-2', 'DELL', 65131.64, 2, 'c30e6790-910a-4619-a2cc-45920e166dc7');
insert into attribute_value(id, attribute_id, product_id, val)
values ('f0a253d4-07bd-4536-8b77-ebb2345fcbfe', '534bd87f-a47f-4046-9b59-7e9db88f8aca', '6a11f837-658e-4edf-b316-5f20575eff1a', 'Десктоп');
insert into product (id, serial_number, manufacturer, price, stock, product_type_id)
values ('4ed6e139-882c-4c5b-84a5-4cb77de5d234', 'PN41-S1-BP278MV', 'ASUS', 30601.79, 5, 'c30e6790-910a-4619-a2cc-45920e166dc7');
insert into attribute_value(id, attribute_id, product_id, val)
values ('b95d7ee4-26f7-4a79-a371-3d628511edbc', '534bd87f-a47f-4046-9b59-7e9db88f8aca', '4ed6e139-882c-4c5b-84a5-4cb77de5d234', 'Неттоп');

-- insert two laptops
insert into product (id, serial_number, manufacturer, price, stock, product_type_id)
values ('4b567f14-a165-4ac0-b845-fa184c232d1a', '90NR0BK3-M002W0', 'ASUS', 315018.94, 1, '368cdeb6-8c25-4377-abdc-6b8c67b227e8');
insert into attribute_value(id, attribute_id, product_id, val)
values ('4fd33a8b-df1c-4e30-b6e3-c09ccbc2ce25', '82acfa9b-2f7d-4747-9fa3-b7ac0be47f00', '4b567f14-a165-4ac0-b845-fa184c232d1a', '14inch');
insert into product (id, serial_number, manufacturer, price, stock, product_type_id)
values ('07849cab-6b36-4b6f-8a49-794d5d35048f', '210-BDRB-11', 'DELL', 79515.32, 2, '368cdeb6-8c25-4377-abdc-6b8c67b227e8');
insert into attribute_value(id, attribute_id, product_id, val)
values ('2840a38b-d550-450b-b9a0-4f37a47175a8', '82acfa9b-2f7d-4747-9fa3-b7ac0be47f00', '07849cab-6b36-4b6f-8a49-794d5d35048f', '13inch');

-- insert two monitors
insert into product (id, serial_number, manufacturer, price, stock, product_type_id)
values ('5078c772-e5d7-439a-9d31-f74109853b4a', 'XV272UZbmiipruzx', 'ACER', 54132.35, 1, '3ce5ceab-713e-4282-b64c-8aaa07908e79');
insert into attribute_value(id, attribute_id, product_id, val)
values ('20a21a86-e098-425f-ab07-652ac7ee0cec', 'ca778b09-2df0-4e5b-becb-2da70714c90f', '5078c772-e5d7-439a-9d31-f74109853b4a', '27inch');
insert into product (id, serial_number, manufacturer, price, stock, product_type_id)
values ('83cb3017-6186-4cd7-9249-c3ebe7f720df', 'Q32P2', 'AOC', 32515.32, 2, '3ce5ceab-713e-4282-b64c-8aaa07908e79');
insert into attribute_value(id, attribute_id, product_id, val)
values ('ca20fcd7-43d4-472d-97a2-7074943049da', 'ca778b09-2df0-4e5b-becb-2da70714c90f', '83cb3017-6186-4cd7-9249-c3ebe7f720df', '32.5inch');

-- insert two hdds
insert into product (id, serial_number, manufacturer, price, stock, product_type_id)
values ('79a36e2c-10a8-4e5d-9fec-db99c28da8a3', 'HDWT840UZSVA', 'Toshiba', 8639.2, 10, 'e98b56be-b041-4467-a872-044002135347');
insert into attribute_value(id, attribute_id, product_id, val)
values ('f41b3430-6fd0-46ea-b2ed-5b0ba580cbb1', 'bcb5976d-4d57-4fb1-a20d-5d84b63d5071', '79a36e2c-10a8-4e5d-9fec-db99c28da8a3', '4TB');
insert into product (id, serial_number, manufacturer, price, stock, product_type_id)
values ('fe2ccf68-2950-42ff-947f-a8912c2337e7', 'ST18000VE002', 'Gb Seagate SkyHawk', 31683.71, 4, 'e98b56be-b041-4467-a872-044002135347');
insert into attribute_value(id, attribute_id, product_id, val)
values ('f2ce772b-3470-480c-a0c3-06cccf069e52', 'bcb5976d-4d57-4fb1-a20d-5d84b63d5071', 'fe2ccf68-2950-42ff-947f-a8912c2337e7', '18TB');