package runner;

import java.util.List;

import model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class HibernateExampleRunner {

	public static void main(String[] args) {
//		testSave();
//		listUsers();
//		UpdateUser();
//		deleteUser();

	}

	public static void testSave(){
		User user = new User();
		user.setName("apple");
		user.setPassword("123456");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
	}
	
	public static void listUsers(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> users = session.createQuery("from User").list();
		for(User user : users){
			System.out.println("User: "+user.getName()+", "+user.getPassword());
		}
		session.close();
		HibernateUtil.shutdown();
	}
	
	public static void UpdateUser(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String queryString = "from User where name = :uname";
		Query query = session.createQuery(queryString);
		query.setString("uname", "apple");
		List<User> users = query.list();
		for(User user : users){
			System.out.println("Existing password: "+user.getPassword());
			user.setPassword("ChangedPWD");
			session.update(user);
		}
		
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
	}
	
	public static void deleteUser(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String queryString = "from User where name = :uname";
		Query query = session.createQuery(queryString);
		query.setString("uname", "apple");
		List<User> users = query.list();
		for(User user : users){
			System.out.println("Deleting a user");
			session.delete(user);
		}
		
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
	}
	
}
