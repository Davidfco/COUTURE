
package com.couture.dao;

import com.couture.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository <Usuario,Long> {
    
}
