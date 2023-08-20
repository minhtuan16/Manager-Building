package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.SalaryDTO;
import com.example.demo.utils.HibernateUtil;


@Repository
public class SalaryDAO {
    public void createSalaryForService(Integer serviceId, SalaryDTO salaryDTO){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            NativeQuery query = session.createSQLQuery("INSERT INTO salary(salary_level,salary,service_id) VALUES(:salaryLevel,:salary,:serviceId)");
            query.setParameter("salaryLevel",salaryDTO.getSalaryLevel());
            query.setParameter("salary",salaryDTO.getSalary());
            query.setParameter("serviceId",serviceId);
            query.executeUpdate();
            session.getTransaction().commit();
        }catch(Exception e){
            if(session.getTransaction() != null) session.getTransaction().rollback();
        }
    }
}
