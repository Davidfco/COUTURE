
package com.couture.service;

import com.couture.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    public List<Usuario> getUsuarios(boolean activos);

    public void save(Usuario usuario);

    public void delete(Usuario usuario);

    public Usuario getUsuario(Usuario usuario);
}
