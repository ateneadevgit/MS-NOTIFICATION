package com.fusm.notification.repository;

import com.fusm.notification.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITemplateRepository extends JpaRepository<Template, Integer> {

    @Query(
            value = "select * from template " +
                    "order by id_template asc ",
            nativeQuery = true
    )
    List<Template> findTemplatesOrdered();

}
