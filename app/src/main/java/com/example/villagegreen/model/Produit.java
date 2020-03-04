package com.example.villagegreen.model;

public class Produit {

    public Produit() {
    }
        private int pro_id;
        private String pro_ref;
        private int fou_id;
        private String pro_lib;
        private String pro_des;
        private Double pro_priV;
        private int ru2_id;
        private String pro_pho;

    public Produit(String pro_lib, String pro_des, int thumbnail) {
        this.pro_lib = pro_lib;
        this.pro_des = pro_des;
    }


        public int getPro_id() {
            return pro_id;
        }

        public void setPro_id(int pro_id) {
            this.pro_id = pro_id;
        }

        public String getPro_ref() {
            return pro_ref;
        }

        public void setPro_ref(String pro_ref) {
            this.pro_ref = pro_ref;
        }

        public int getFou_id() {
            return fou_id;
        }

        public void setFou_id(int fou_id) {
            this.fou_id = fou_id;
        }

        public String getPro_lib() {
            return pro_lib;
        }

        public void setPro_lib(String pro_lib) {
            this.pro_lib = pro_lib;
        }

        public String getPro_des() {
            return pro_des;
        }

        public void setPro_des(String pro_des) {
            this.pro_des = pro_des;
        }

        public Double getPro_priV() {
            return pro_priV;
        }

        public void setPro_priV(Double pro_priV) {
            this.pro_priV = pro_priV;
        }

        public int getRu2_id() {
            return ru2_id;
        }

        public void setRu2_id(int ru2_id) {
            this.ru2_id = ru2_id;
        }

        public String getPro_pho() {
            return pro_pho;
        }

        public void setPro_pho(String pro_pho) {
            this.pro_pho = pro_pho;
        }
}
