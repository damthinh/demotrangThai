package com.example.demo_trang_thai.reposetory;

import com.example.demo_trang_thai.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReponsetoryStatus extends JpaRepository<Status, Long> {
    @Query(value = "SELECT * FROM  Status where name = ?1",nativeQuery = true)
    Optional<Status> findByName(String name);
//    List<Status> findByPriority_level(String priority_level);
@Query("select priority_level from Status where priority_level = ?1")
    Optional<Status> findByPriority_level(String priority_level);
    @Query(value = "select * from Status order by Status.priority_level",nativeQuery = true)
    List<Status> findStatus();
    @Query(value = "SELECT * FROM  Status where name = ?1",nativeQuery = true)
    Status getByName(String name);

    @Query(value = "SELECT * FROM  Status where id = ?1",nativeQuery = true)
    Status getById(Long id_status);

    @Query(value = "select * from status where  id != ?1 and name =  ?2 ",nativeQuery = true)
        Optional<Status> findByNameOtherId( Long id,String name);
    @Query(value = "select * from status where  id != ?1 and priority_level =  ?2 ",nativeQuery = true)
    Optional<Status> findByPriority_levelOtherId( Long id,String priority_level);
//    @Query()
//    Status g
}
