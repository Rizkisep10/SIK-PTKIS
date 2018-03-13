package com.septian.sikptkis.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by septian on 3/12/2018.
 */

public class Jurusan {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_univ")
    @Expose
    private Integer idUniv;
    @SerializedName("id_fak")
    @Expose
    private Integer idFak;
    @SerializedName("nama")
    @Expose
    private String nama;
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

    public Integer getIdFak() {
        return idFak;
    }

    public void setIdFak(Integer idFak) {
        this.idFak = idFak;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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
