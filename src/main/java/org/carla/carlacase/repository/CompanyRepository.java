package org.carla.carlacase.repository;


import org.carla.carlacase.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
