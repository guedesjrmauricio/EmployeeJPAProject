package com.example.dao;

import com.example.model.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class EmployeeDAOImpl implements EmployeeDAO {
    
    @Override
    public void add(Employee emp) throws DAOException 
    {
        EntityManager em = getEntityManager();
        
        try
        {
            em.getTransaction().begin();
            em.persist( emp );
            em.getTransaction().commit();
        }
        catch( Exception e )
        {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void update(Employee emp) throws DAOException 
    {
        EntityManager em = getEntityManager();
        
        try
        {
            em.getTransaction().begin();
            em.merge( emp );
            em.getTransaction().commit();
        }
        catch( Exception e )
        {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void delete(int id) throws DAOException 
    {
        EntityManager em = getEntityManager();
        
        Employee emp = em.find(Employee.class, id);
        
        if( emp != null )
        {
            em.getTransaction().begin();
            em.remove( emp );
            em.getTransaction().commit();
        }
    }

    @Override
    public Employee findById(int id) throws DAOException 
    {
        EntityManager em = getEntityManager();
        
        Employee emp = em.find(Employee.class, id);
        
        return emp;
    }

    @Override
    public Employee[] getAllEmployees() throws DAOException 
    {
        EntityManager em = getEntityManager();
        
        TypedQuery<Employee> query = em.createQuery( "select e from Employee e", Employee.class );
        
        List<Employee> emps = query.getResultList();
       
        return (Employee[]) emps.toArray();
    }

    private EntityManager getEntityManager() 
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "EmployeePU" );
        EntityManager em = emf.createEntityManager();
        return em;
    }
  
}
