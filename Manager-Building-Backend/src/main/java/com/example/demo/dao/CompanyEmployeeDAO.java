package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.CompanyEmployeeDTO;
import com.example.demo.utils.HibernateUtil;

@Repository
public class CompanyEmployeeDAO {

    public void insertCompanyEmployeeByCompanyId(Integer companyId,CompanyEmployeeDTO companyEmployeeDTO){
            Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            NativeQuery query = session.createSQLQuery("INSERT INTO company_employee(name,date_of_birth,phone_no,social_id,company_id, status) VALUES(':name',':dateOfBirth',':phoneNo',':socialId',':companyId', 'status');");
            query.setParameter("name", companyEmployeeDTO.getName());
            query.setParameter("dateOfBirth", companyEmployeeDTO.getDateOfBirth());
            query.setParameter("phoneNo", companyEmployeeDTO.getPhoneNo());
            query.setParameter("socialId", companyEmployeeDTO.getSocialId());
            query.setParameter("status", companyEmployeeDTO.getStatus()); 
            query.setParameter("companyId", companyId);
            query.executeUpdate();
            session.getTransaction().commit(); 
        }catch(Exception e){
            if(session.getTransaction() != null) session.getTransaction().rollback();
        }
    }
}
