/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adhib.arfan.belajar.hibernate.controller;

import com.adhib.arfan.belajar.hibernate.configuration.HibernateUtil;
import com.adhib.arfan.belajar.hibernate.configuration.MahasiswaTableModel;
import com.adhib.arfan.belajar.hibernate.dao.MahasiswaInterface;
import com.adhib.arfan.belajar.hibernate.model.JenisKelamin;
import com.adhib.arfan.belajar.hibernate.model.Mahasiswa;
import com.adhib.arfan.belajar.hibernate.view.MahasiswaView;

/**
 *
 * @author arfan
 */
public class MahasiswaController {

    private MahasiswaView mahasiswaView;
    private MahasiswaTableModel mahasiswaTableModel;
    private MahasiswaInterface mahasiswaInterface = HibernateUtil.getMahasiswaInterface();

    public MahasiswaController(MahasiswaView mahasiswaView) {
        this.mahasiswaView = mahasiswaView;
    }

    public void tampilMahasiswa() {
        mahasiswaTableModel = new MahasiswaTableModel(mahasiswaInterface.getMahasiswas());
        this.mahasiswaView.getTableMahasiswa().setModel(mahasiswaTableModel);
    }

    public void simpanMahasiswa() {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getNama().getText());
        mahasiswa.setKelas(this.mahasiswaView.getKelas().getText());
        mahasiswa.setJenisKelamin(JenisKelamin.valueOf(this.mahasiswaView.getJenisKelamin().getSelectedItem().toString()));

        mahasiswaInterface.simpanMahasiswa(mahasiswa);

        tampilMahasiswa();
    }

    public void showMahasiswa() {
        int index = this.mahasiswaView.getTableMahasiswa().getSelectedRow();
        this.mahasiswaView.getNpm().setText((String) this.mahasiswaView.getTableMahasiswa().getValueAt(index, 0));
        this.mahasiswaView.getNama().setText((String) this.mahasiswaView.getTableMahasiswa().getValueAt(index, 1));
        this.mahasiswaView.getKelas().setText((String) this.mahasiswaView.getTableMahasiswa().getValueAt(index, 2));
        this.mahasiswaView.getJenisKelamin().setSelectedItem(this.mahasiswaView.getTableMahasiswa().getValueAt(index, 3));
    }

    public void updateMahasiswa() {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getNama().getText());
        mahasiswa.setKelas(this.mahasiswaView.getKelas().getText());
        mahasiswa.setJenisKelamin(JenisKelamin.valueOf(this.mahasiswaView.getJenisKelamin().getSelectedItem().toString()));

        mahasiswaInterface.updateMahasiswa(mahasiswa);

        tampilMahasiswa();
    }
    
    public void hapusMahasiswa(){
        Mahasiswa mahasiswa = mahasiswaInterface.geMahasiswa(this.mahasiswaView.getNpm().getText());
        
        if (mahasiswa != null){
            mahasiswaInterface.hapusMahasiswa(mahasiswa);
            
            tampilMahasiswa();
        }
    }
}
