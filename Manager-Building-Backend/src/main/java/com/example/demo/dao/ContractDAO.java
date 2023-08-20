package com.example.demo.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ContractDTO;
import com.example.demo.utils.HibernateUtil;

@Repository
public class ContractDAO {

    public void createContract(Integer companyId, Integer floorId, ContractDTO contractDTO){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            NativeQuery query = session.createSQLQuery("INSERT INTO contract(description,expired_date,is_canceled,rented_area,rented_date,company_id,floor_id,position) VALUES(:description,:expiredDate,:isCanceled,:rentedArea,:rentedDate,:companyId,:floorId,:position)");
//            NativeQuery query = session.createSQLQuery("INSERT INTO contract(description,expired_date,is_canceled,rented_area,rented_date,company_id,floor_id,position) VALUES(:description,:expiredDate,:isCanceled,:rentedArea,:rentedDate,:companyId,:floorId,:position)");
            query.setParameter("companyId", companyId);
            query.setParameter("floorId",floorId);
            query.setParameter("expiredDate",contractDTO.getExpiredDate());
            query.setParameter("rentedDate",contractDTO.getRentedDate());
            query.setParameter("description",contractDTO.getDescription());
            query.setParameter("isCanceled",contractDTO.getIsCanceled()); 
            query.setParameter("rentedArea",contractDTO.getRentedArea());
            query.setParameter("position",contractDTO.getPosition());
            query.executeUpdate();

            session.getTransaction().commit();

        }catch(Exception e){
//        	e.printStackTrace();
            if(session.getTransaction() != null) session.getTransaction().rollback();
        }
    }
}
