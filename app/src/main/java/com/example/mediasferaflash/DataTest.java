package com.example.mediasferaflash;

public class DataTest {
    private String magazineNameN;
    private String magazineInfoN;
    private String magazineDiscriptionN;
    private int magazineCoverN;

    public DataTest(String magazineNameY, String magazineInfoY, String magazineDiscriptionY, int magazineCoverY) {
        this.magazineNameN = magazineNameY;
        this.magazineInfoN = magazineInfoY;
        this.magazineDiscriptionN = magazineDiscriptionY;
        this.magazineCoverN = magazineCoverY;
    }

    public DataTest() {
    }

    public DataTest(String magazineNameN, String magazineInfoN, int magazineCoverN) {
        this.magazineNameN = magazineNameN;
        this.magazineInfoN = magazineInfoN;
        this.magazineCoverN = magazineCoverN;
    }

    public DataTest(String magazineNameN, int magazineCoverN) {
        this.magazineNameN = magazineNameN;
        this.magazineCoverN = magazineCoverN;
    }

    public String getMagazineNameN() {
        return magazineNameN;
    }

    public void setMagazineNameN(String magazineNameN) {
        this.magazineNameN = magazineNameN;
    }

    public String getMagazineInfoN() {
        return magazineInfoN;
    }

    public void setMagazineInfoN(String magazineInfoN) {
        this.magazineInfoN = magazineInfoN;
    }

    public String getMagazineDiscriptionN() {
        return magazineDiscriptionN;
    }

    public void setMagazineDiscriptionN(String magazineDiscriptionN) {
        this.magazineDiscriptionN = magazineDiscriptionN;
    }

    public int getMagazineCoverN() {
        return magazineCoverN;
    }

    public void setMagazineCoverN(int magazineCoverN) {
        this.magazineCoverN = magazineCoverN;
    }
}