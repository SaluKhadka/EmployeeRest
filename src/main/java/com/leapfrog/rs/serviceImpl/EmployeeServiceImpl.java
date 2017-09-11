package com.leapfrog.rs.serviceImpl;

import com.leapfrog.rs.model.Employee;
import com.leapfrog.rs.service.EmployeeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    Session session;

    public EmployeeServiceImpl(){
        super();
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Override
    public List<Employee> getAll() {

       session.beginTransaction();
       List<Employee> list = session.createCriteria(Employee.class).list();
        session.close();
        return list;
    }

    @Override
    public Employee getById(int id) {
        Employee emp;
        emp =  (Employee) session.get(Employee.class, id);
        return emp;
    }

    @Override
    public void add(Employee employee) {

        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Employee update(Employee employee) {
        session.beginTransaction();
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    @Override
    public void delete(int id) {
        session.beginTransaction();
        Employee emp = (Employee) session.load(Employee.class, new Integer(id));
        session.delete(emp);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public int count() {
        List<Employee> list = getAll();
        return list.size();
    }
}
