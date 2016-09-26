/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adhib.arfan.belajar.hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author arfan
 */
@Entity
@Table(name = "tb_mahasiswa")
public class Mahasiswa implements Serializable {

    
    @Id
    @Column(name = "npm", length = 8)
    private String npm;

    @Column(name = "nama", length = 50)
    private String nama;

    @Column(name = "kelas", length = 8)
    private String kelas;

    @Enumerated(EnumType.STRING)
    @Column(name = "jenis_kelamin", length = 7)
    private JenisKelamin jenisKelamin;

    /**
     * @return the npm
     */
    public String getNpm() {
        return npm;
    }

    /**
     * @param npm the npm to set
     */
    public void setNpm(String npm) {
        this.npm = npm;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the kelas
     */
    public String getKelas() {
        return kelas;
    }

    /**
     * @param kelas the kelas to set
     */
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    /**
     * @return the jenisKelamin
     */
    public JenisKelamin getJenisKelamin() {
        return jenisKelamin;
    }

    /**
     * @param jenisKelamin the jenisKelamin to set
     */
    public void setJenisKelamin(JenisKelamin jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
}
