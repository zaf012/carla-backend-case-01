package org.carla.carlacase.repository;


import org.carla.carlacase.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, String> {

}
