package org.jsp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertApp
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		System.out.println("Enter Name");
		String name = sc.next();
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Email");
		String email = sc.next();
		System.out.println("Enter Phone");
		long phone = sc.nextLong();
		System.out.println("Enter Password");
		String password = sc.next();
		User u = new User(0, name, username, email, phone, password);
		EntityTransaction et = em.getTransaction();
		et.begin();
		User mu = em.merge(u);
		et.commit();
		System.out.println(mu);
		System.out.println("User Inserted");
	}
}
