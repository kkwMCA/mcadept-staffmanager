package com.example.demo.REPOS;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.POJOS.FilePOJO;

@Repository
public interface FileRepo extends JpaRepository<FilePOJO,String>{
    
    List<FilePOJO> findByCreator(String creator);

    // @Query("SELECT c.creator FROM Creator c")
    // List<String> findAllCreator();

    @Query("SELECT f FROM FilePOJO f WHERE f.contentType LIKE 'image%'")
    List<FilePOJO> getImages();

    @Query("SELECT f FROM FilePOJO f WHERE f.creator=:id")
    List<FilePOJO> getData(@Param("id") String id);
}
