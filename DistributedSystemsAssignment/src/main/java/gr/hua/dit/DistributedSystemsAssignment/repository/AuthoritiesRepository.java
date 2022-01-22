package gr.hua.dit.DistributedSystemsAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import gr.hua.dit.DistributedSystemsAssignment.entity.Authority;

@RepositoryRestResource(path="authorities")
public interface AuthoritiesRepository extends JpaRepository<Authority,Integer>{

}
