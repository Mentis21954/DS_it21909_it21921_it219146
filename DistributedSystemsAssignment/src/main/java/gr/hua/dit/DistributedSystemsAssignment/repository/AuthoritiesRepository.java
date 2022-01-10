package gr.hua.dit.DistributedSystemsAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.hua.dit.DistributedSystemsAssignment.entity.Authority;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authority,Integer>{

}
