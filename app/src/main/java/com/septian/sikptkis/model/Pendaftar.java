package com.septian.sikptkis.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by septian on 3/13/2018.
 */

public class Pendaftar {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_univ")
    @Expose
    private Integer idUniv;
    @SerializedName("nama_mahasiswa")
    @Expose
    private String namaMahasiswa;
    @SerializedName("nim")
    @Expose
    private String nim;
    @SerializedName("jurusan_mahasiswa")
    @Expose
    private String jurusanMahasiswa;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("semester")
    @Expose
    private String semester;
    @SerializedName("ipk")
    @Expose
    private String ipk;
    @SerializedName("prestasi_akademik")
    @Expose
    private String prestasiAkademik;
    @SerializedName("pendapatan_orangtua")
    @Expose
    private String pendapatanOrangtua;
    @SerializedName("tanggungan_orangtua")
    @Expose
    private String tanggunganOrangtua;
    @SerializedName("kendaraan_pribadi")
    @Expose
    private String kendaraanPribadi;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(Integer idUniv) {
        this.idUniv = idUniv;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusanMahasiswa() {
        return jurusanMahasiswa;
    }

    public void setJurusanMahasiswa(String jurusanMahasiswa) {
        this.jurusanMahasiswa = jurusanMahasiswa;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getIpk() {
        return ipk;
    }

    public void setIpk(String ipk) {
        this.ipk = ipk;
    }

    public String getPrestasiAkademik() {
        return prestasiAkademik;
    }

    public void setPrestasiAkademik(String prestasiAkademik) {
        this.prestasiAkademik = prestasiAkademik;
    }

    public String getPendapatanOrangtua() {
        return pendapatanOrangtua;
    }

    public void setPendapatanOrangtua(String pendapatanOrangtua) {
        this.pendapatanOrangtua = pendapatanOrangtua;
    }

    public String getTanggunganOrangtua() {
        return tanggunganOrangtua;
    }

    public void setTanggunganOrangtua(String tanggunganOrangtua) {
        this.tanggunganOrangtua = tanggunganOrangtua;
    }

    public String getKendaraanPribadi() {
        return kendaraanPribadi;
    }

    public void setKendaraanPribadi(String kendaraanPribadi) {
        this.kendaraanPribadi = kendaraanPribadi;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }
}
