/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adhib.arfan.belajar.hibernate.dao;

import com.adhib.arfan.belajar.hibernate.model.Mahasiswa;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author arfan
 */
public class MahasiswaInterfaceImpl implements MahasiswaInterface {

    private SessionFactory sessionFactory;

    public MahasiswaInterfaceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Mahasiswa> getMahasiswas() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<Mahasiswa> mahasiswas = session.createCriteria(Mahasiswa.class).list();
            session.getTransaction().commit();
            return mahasiswas;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void simpanMahasiswa(Mahasiswa mahasiswa) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(mahasiswa);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void updateMahasiswa(Mahasiswa mahasiswa) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(mahasiswa);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Mahasiswa geMahasiswa(String npm) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Mahasiswa mahasiswa = (Mahasiswa) session.get(Mahasiswa.class, npm);
            session.getTransaction().commit();
            return mahasiswa;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            return null;
        }finally{
            session.close();
        }
    }

    @Override
    public void hapusMahasiswa(Mahasiswa mahasiswa) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(mahasiswa);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }


}
