package com.example.user.pmipenggolongandarah.mDatas;

/**
 * Created by USER on 14/08/2017.
 */

public class StokDarah {
    private String golongan_darah;
    private String jumlah;
    private String stokdarahmasuk;
    private String stokdarahkeluar;

    public StokDarah() {}

    public StokDarah(String golongan_darah, String jumlah, String stokdarahmasuk, String stokdarahkeluar) {
        this.golongan_darah = golongan_darah;
        this.jumlah = jumlah;
        this.stokdarahmasuk = stokdarahmasuk;
        this.stokdarahkeluar = stokdarahkeluar;
    }

    public String getGolongan_darah() {
        return golongan_darah;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getStokdarahmasuk() {
        return stokdarahmasuk;
    }

    public String getStokdarahkeluar() {
        return stokdarahkeluar;
    }
}
