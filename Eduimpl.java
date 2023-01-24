package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import controller.Studentedudetails;
import dto.Studentedu;
import dto.Teacherdetails;
public class Eduimpl 
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public void add(Studentedu e)
	{
		entityTransaction.begin();
		entityManager.persist(e);
		entityTransaction.commit();
	}
	public List<Studentedu> fetchall()
	{
	  Query query=entityManager.createQuery("select a from Studentedu a",Studentedu.class);	
	  return query.getResultList();
	}
	public Studentedu find(int id)
	{
		entityTransaction.begin();
		return entityManager.find(Studentedu.class,id);
	}
	public void delete(Studentedu studentedu)
	{
		entityManager.remove(studentedu);
		entityTransaction.commit();
	}
	public void updatesss(Studentedu s)
	{
      entityTransaction.begin();
      entityManager.merge(s);
      entityTransaction.commit();
   	}
	public void addstaff(Teacherdetails t)
	{
		entityTransaction.begin();
		entityManager.persist(t);
		entityTransaction.commit();
	}
	public Teacherdetails findstaff(String email)
	{
	  entityTransaction.begin();
	  return entityManager.find(Teacherdetails.class, email);
	}
	
}
