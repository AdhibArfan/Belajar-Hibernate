/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adhib.arfan.belajar.hibernate.configuration;

import com.adhib.arfan.belajar.hibernate.dao.MahasiswaInterface;
import com.adhib.arfan.belajar.hibernate.dao.MahasiswaInterfaceImpl;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author arfan
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final MahasiswaInterface MAHASISWA_INTERFACE;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            MAHASISWA_INTERFACE = new MahasiswaInterfaceImpl(sessionFactory);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @return the MAHASISWA_INTERFACE
     */
    public static MahasiswaInterface getMahasiswaInterface() {
        return MAHASISWA_INTERFACE;
    }
}
