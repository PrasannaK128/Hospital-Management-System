package com.HMSApp.Hospital.Management.System.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMSApp.Hospital.Management.System.doclogin.entity.medicins;
@Repository
public interface medicineRepository extends JpaRepository<medicins, Long> {

}
