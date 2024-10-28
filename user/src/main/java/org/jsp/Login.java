package org.jsp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Login 
{
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		Query q = em.createQuery("select u from User u where username=:un and password=:pwd");
		q.setParameter("un", username);
		q.setParameter("pwd", password);
		User u =(User)q.getSingleResult();
		System.out.println(u);
	}
}
