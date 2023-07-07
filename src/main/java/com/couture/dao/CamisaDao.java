package com.couture.dao;

import com.couture.domain.Camisa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamisaDao extends JpaRepository <Camisa,Long> {
    
}
