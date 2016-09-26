/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adhib.arfan.belajar.hibernate.dao;

import com.adhib.arfan.belajar.hibernate.model.Mahasiswa;
import java.util.List;

/**
 *
 * @author arfan
 */
public interface MahasiswaInterface {

    public List<Mahasiswa> getMahasiswas();

    public void simpanMahasiswa(Mahasiswa mahasiswa);

    public void updateMahasiswa(Mahasiswa mahasiswa);
    
    public Mahasiswa geMahasiswa(String npm);
    
    public void hapusMahasiswa(Mahasiswa mahasiswa);
    
}
