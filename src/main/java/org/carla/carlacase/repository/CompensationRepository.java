package org.carla.carlacase.repository;

import java.util.List;
import org.carla.carlacase.domain.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompensationRepository extends JpaRepository<Compensation, String> {

  // Average compensation of roles where the role is some kind of engineer
  @Query(nativeQuery = true,
      value = """
          SELECT AVG(cast(c.annualbasepay as float)) as AvgEngineerSalary
          FROM compensation c
            JOIN employment emp ON emp.id = c.employment_id
            JOIN position p on emp.position_id = p.id
          WHERE p.title ILIKE '%engineer%'
                    """)
  Double findAvgEngineerSalary();

  // Average, min and max compensation per city
  @Query(nativeQuery = true,
      value = """
             SELECT com.location,
                 AVG(cast(c.annualbasepay as float)) as AvgSalary,
                 MIN(c.annualbasepay) as MinSalary,
                 MAX(c.annualbasepay) as MaxSalary
             FROM compensation c
                   JOIN employment empl on empl.id = c.employment_id
                   JOIN company com on com.id = empl.company_id
             GROUP BY com.location
                             """)
  List<CompensationSelectionModel> findAvgMinAndMaxSalaryByLocation();

  // min and max compensation by gender
  @Query(nativeQuery = true,
      value = """
            select emp.gender           as gender,
                    MAX(c.annualbasepay) as maxSalary,
                    MIN(c.annualbasepay) as minSalary
             from compensation c
                      join employment empl on empl.id = c.employment_id
                      join employee emp on emp.id = empl.employee_id
             where emp.gender = 'Male'
                or emp.gender = 'Female'
             group by emp.gender
                             """)
  List<CompensationSelectionModel> findAvgMinAndMaxSalaryByGender();



}
