package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Doctor;

public class DoctorDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("suvenduuuu");

	public static boolean saveDoctor(Doctor doctor) {
		boolean b = false;
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(doctor);
		et.commit();
		b = true;
		return b;

	}

	public static boolean deleteDoctor(int id) {
		boolean b = false;
		EntityManager em = emf.createEntityManager(); 
		Doctor d=em.find(Doctor.class, id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(d);
		et.commit();
		b = true;
		return b;
	}

	public static Doctor findById(Doctor id) {
		EntityManager em = emf.createEntityManager();
		Doctor d = em.find(Doctor.class, id);
		return d;

	}

	public static List<Doctor> findAllDoctors() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select d from  Doctor ");
		List<Doctor> d2 = q.getResultList();
		return d2;

	}

	public static List<Doctor> findBySpecialization(String specialization) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select d from Doctor where d.specialization=" + specialization + "");
		List<Doctor> dspecialization = q.getResultList();
		return dspecialization;

	}

	public static List<Doctor> findByName(String name) {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select d from Doctor where d.name=" + name + "");
		List<Doctor> dname = q.getResultList();
		return dname;

	}

	public static boolean updateDoctorName(int id, String name) {
		boolean b = false;
		EntityManager em = emf.createEntityManager();
		Doctor doctor = em.find(Doctor.class, id);
		doctor.setName(name);
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(doctor);
		et.commit();
		return b;

	}

	public static boolean updateDoctorSpecialization(int id, String specialization) {
		boolean f = false;
		EntityManager em = emf.createEntityManager();
		Doctor doctor = em.find(Doctor.class, id);
		doctor.setSpecialization(specialization);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(doctor);
		et.commit();
		f = true;
		return f;

	}

	public static boolean updateDoctorSalary(int id, double salary) {
		boolean f = false;
		EntityManager em = emf.createEntityManager();
		Doctor doctor = em.find(Doctor.class, id);
		doctor.setSal(salary);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(doctor);
		et.commit();
		f = true;

		return f;

	}

}
