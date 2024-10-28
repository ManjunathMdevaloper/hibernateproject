package org.jsp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		System.out.println("Enter id");
		int id = sc.nextInt();
		User user = em.find(User.class, id);
		if(user != null)
		{
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(user);
			et.commit();
			System.out.println("Deleted Sucessfully");
		}else {
			System.out.println("Invalid Id");
		}
	}
}
