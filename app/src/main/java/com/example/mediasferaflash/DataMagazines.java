package com.example.mediasferaflash;

public class DataMagazines {
    private String magazineName;
    private String magazineInfo;
    private String magazineDescription;
    private int magazineCover;

    public DataMagazines(String magazineName, String magazineInfo, String magazineDescription, int magazineCover) {
        this.magazineName = magazineName;
        this.magazineInfo = magazineInfo;
        this.magazineDescription = magazineDescription;
        this.magazineCover = magazineCover;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public String getMagazineInfo() {
        return magazineInfo;
    }

    public void setMagazineInfo(String magazineInfo) {
        this.magazineInfo = magazineInfo;
    }

    public String getMagazineDiscription() {
        return magazineDescription;
    }

    public void setMagazineDiscription(String magazineDiscription) {
        this.magazineDescription = magazineDiscription;
    }

    public int getMagazineCover() {
        return magazineCover;
    }

    public void setMagazineCover(int magazineCover) {
        this.magazineCover = magazineCover;
    }

//    private List<DataMagazines> dataMagazines;
//    private void initializeData(){
//        dataMagazines = new ArrayList<>();
//        dataMagazines.add(new DataMagazines("Magazine1", "01.01.2019", "Magazine1 discription", R.drawable.magazine1));
//        dataMagazines.add(new DataMagazines("Magazine2", "02.02.2019", "Magazine2 discription", R.drawable.magazine2));
//        dataMagazines.add(new DataMagazines("Magazine2", "03.03.2019", "Magazine3 discription", R.drawable.magazine3));
//    }
}