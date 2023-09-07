package com.org.controller;

import java.util.List;
import java.util.Scanner;

import com.org.dao.DoctorDao;
import com.org.dto.Doctor;

public class DoctorController {
	public static void main(String[] args) {
		System.out.println("------Welcome DoctorManagement Console----");
		System.out.println("'a':->for Save Doctor");
		System.out.println("'b':->for delete Doctor");
		System.out.println("'c':->for findAllDoctor");
		System.out.println("'d':->for findDoctorbyName");
		System.out.println("'e':->for findDoctorbySpecialization");
		System.out.println("'f':->for updateDoctorName");
		System.out.println("'g':->for updateDoctorSpecialization");
		System.out.println("'h':->for updateDoctorSalary");
		System.out.println("---------------------------------------------");
		System.out.println("Enter your Choice-");
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0);
		DoctorDao doctorDao = new DoctorDao();
		switch (c) {
		case 'a':
			System.out.println("enter the name");
			String dname = sc.next();
			System.out.println("enter the doctor Id:");
			int did = sc.nextInt();
			System.out.println("enter the doctor sal");
			double sal = sc.nextDouble();
			System.out.println("enter the doctor specialization");
			String Specialization = sc.next();
			Doctor doctor = new Doctor();
			doctor.setName(dname);
			doctor.setId(did);
			doctor.setSal(sal);
			doctor.setSpecialization(Specialization);
			boolean b = doctorDao.saveDoctor(doctor);
			if (b == true) {
				System.out.println("Data saved Sucessfully");
			} else {
				System.out.println("something went wrong");
			}
			break;

		case 'b':
			System.out.println("Enter the id :");
			int id = sc.nextInt();
			boolean isDelete = doctorDao.deleteDoctor(id);
			if (isDelete == true) {
				System.out.println("Data deleted Sucessfully");

			} else {
				System.out.println("something went wrong");
			}
			break;
		case 'c':
			List<Doctor> d = doctorDao.findAllDoctors();
			for (Doctor d1 : d) {
				System.out.println(d1);
			}
			break;
		case 'd':
			System.out.println("Enter Doctor name:");
			String dname1 = sc.next();
			List<Doctor> name = doctorDao.findByName(dname1);
			for (Doctor s : name) {
				System.out.println(s.getName());

			}
			break;

		case 'e':
			System.out.println("Enter Doctor specialization");
			String doctorSpecialization = sc.next();
			List<Doctor> dspecialization = doctorDao.findBySpecialization(doctorSpecialization);
			for (Doctor d1 : dspecialization) {
				System.out.println(d1.getSpecialization());
			}
			break;
		case 'f':
			System.out.println("enter the ID:");
			int id1 = sc.nextInt();
			System.out.println("enter the name");
			String name1 = sc.next();
			boolean b1 = doctorDao.updateDoctorName(id1, name1);
			if (b1 == true) {
				System.out.println("Name updated Suceesfully");
			} else {
				System.out.println("something went wrong");
			} 
			break; 
		case 'g': 
			System.out.println("enter the ID:");
			int id2 = sc.nextInt();
			System.out.println("enter specialization"); 
			String dspecialz=sc.next(); 
		boolean b2	=doctorDao.updateDoctorSpecialization(id2, dspecialz); 
		if(b2==true) {
			System.out.println("Specialization updated Sucessfully");
		} 
		else {
			System.out.println("something went wrong"); 
		} 
		break; 
		case 'h': 
			System.out.println("enter the ID:");
			int id3 = sc.nextInt(); 
			System.out.println("enter the employee Salary"); 
			double sal1=sc.nextDouble(); 
	boolean b3=doctorDao.updateDoctorSalary(id3, sal1); 
	if(b3==true) {
		System.out.println("salary updated Suceesfully");
	} 
	else {
		System.out.println("somethong went wrong");
	} 
	break;
	default:
		System.out.println("condition not match");
			
			
			

		}

	}

}
