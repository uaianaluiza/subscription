package com.manager.subscription.repositorys;

import com.manager.subscription.models.Shareholder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareholderRepository extends JpaRepository<Shareholder, Integer> {

    Shareholder findById(int id);
    List<Shareholder> findAll();

}
