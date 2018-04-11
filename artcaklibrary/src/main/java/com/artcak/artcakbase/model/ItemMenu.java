package com.artcak.artcakbase.model;

public class ItemMenu {
    private int gambar_id;
    private String gambar_url;
    private String judul;

    public int getGambar_id() {
        return gambar_id;
    }

    public void setGambar_id(int gambar_id) {
        this.gambar_id = gambar_id;
    }

    public String getGambar_url() {
        return gambar_url;
    }

    public void setGambar_url(String gambar_url) {
        this.gambar_url = gambar_url;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public ItemMenu(String judul, int gambar_id){
        this.gambar_id = gambar_id;
        this.judul = judul;
    }

    public ItemMenu(String judul, int gambar_id, String gambar_url){
        this.gambar_id = gambar_id;
        this.judul = judul;
        this.gambar_url = gambar_url;
    }
}
