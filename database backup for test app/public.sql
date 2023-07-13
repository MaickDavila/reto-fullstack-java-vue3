/*
 Navicat Premium Data Transfer

 Source Server         : PostgreSQL Local
 Source Server Type    : PostgreSQL
 Source Server Version : 150002 (150002)
 Source Host           : localhost:5432
 Source Catalog        : sprint-database
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 150002 (150002)
 File Encoding         : 65001

 Date: 13/07/2023 11:56:36
*/


-- ----------------------------
-- Sequence structure for client_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."client_id_seq";
CREATE SEQUENCE "public"."client_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for product_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."product_id_seq";
CREATE SEQUENCE "public"."product_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sale_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sale_id_seq";
CREATE SEQUENCE "public"."sale_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for sale_item_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sale_item_id_seq";
CREATE SEQUENCE "public"."sale_item_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS "public"."client";
CREATE TABLE "public"."client" (
  "id" int8 NOT NULL DEFAULT nextval('client_id_seq'::regclass),
  "dni" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(255) COLLATE "pg_catalog"."default",
  "last_names" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "names" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "phone" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO "public"."client" VALUES (1, '71128047', 'maickdaviilajesus@gmail.com', 'Davila Jesus', 'Maick', '966784559');
INSERT INTO "public"."client" VALUES (3, '71128049', 'otro@pereira.com', 'Otro ', 'Usuario', '98282723');
INSERT INTO "public"."client" VALUES (2, '71128048', 'milagros@pereira.com', 'Pereira Paredes', 'Milagros', '92442422');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS "public"."product";
CREATE TABLE "public"."product" (
  "id" int8 NOT NULL DEFAULT nextval('product_id_seq'::regclass),
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "price" float8 NOT NULL
)
;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO "public"."product" VALUES (1, 'Coca Cola 500ml', 2.5);
INSERT INTO "public"."product" VALUES (2, 'Inka Cola 500ml', 2.5);

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS "public"."sale";
CREATE TABLE "public"."sale" (
  "id" int8 NOT NULL DEFAULT nextval('sale_id_seq'::regclass),
  "date" date NOT NULL,
  "client_id" int8 NOT NULL,
  "total" numeric(10,2)
)
;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO "public"."sale" VALUES (2, '2023-07-13', 1, 30.00);
INSERT INTO "public"."sale" VALUES (1, '2023-07-12', 2, 17.50);

-- ----------------------------
-- Table structure for sale_item
-- ----------------------------
DROP TABLE IF EXISTS "public"."sale_item";
CREATE TABLE "public"."sale_item" (
  "id" int8 NOT NULL DEFAULT nextval('sale_item_id_seq'::regclass),
  "quantity" int4 NOT NULL,
  "product_id" int8 NOT NULL,
  "sale_id" int8 NOT NULL
)
;

-- ----------------------------
-- Records of sale_item
-- ----------------------------
INSERT INTO "public"."sale_item" VALUES (1, 2, 1, 1);
INSERT INTO "public"."sale_item" VALUES (2, 5, 2, 1);
INSERT INTO "public"."sale_item" VALUES (3, 10, 1, 2);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."client_id_seq"
OWNED BY "public"."client"."id";
SELECT setval('"public"."client_id_seq"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."product_id_seq"
OWNED BY "public"."product"."id";
SELECT setval('"public"."product_id_seq"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."sale_id_seq"
OWNED BY "public"."sale"."id";
SELECT setval('"public"."sale_id_seq"', 2, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."sale_item_id_seq"
OWNED BY "public"."sale_item"."id";
SELECT setval('"public"."sale_item_id_seq"', 3, true);

-- ----------------------------
-- Primary Key structure for table client
-- ----------------------------
ALTER TABLE "public"."client" ADD CONSTRAINT "client_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table product
-- ----------------------------
ALTER TABLE "public"."product" ADD CONSTRAINT "product_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sale
-- ----------------------------
ALTER TABLE "public"."sale" ADD CONSTRAINT "sale_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sale_item
-- ----------------------------
ALTER TABLE "public"."sale_item" ADD CONSTRAINT "sale_item_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table sale
-- ----------------------------
ALTER TABLE "public"."sale" ADD CONSTRAINT "fkon0o9ba5ajsnwivekhl1tfjiy" FOREIGN KEY ("client_id") REFERENCES "public"."client" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table sale_item
-- ----------------------------
ALTER TABLE "public"."sale_item" ADD CONSTRAINT "fkar9qqr4n69xw1shum20oflleo" FOREIGN KEY ("sale_id") REFERENCES "public"."sale" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."sale_item" ADD CONSTRAINT "fkih76x9f1o1asbp51c70hin53n" FOREIGN KEY ("product_id") REFERENCES "public"."product" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
