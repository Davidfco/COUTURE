
package com.couture.controller;

import com.couture.domain.Usuario;
import com.couture.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.couture.service.UsuarioService;

@Controller
@Slf4j
@RequestMapping("/")
public class UsuarioController {
    
    @Autowired
private UsuarioService usuarioService;

@GetMapping("/")
public String inicio(Model model) {
    var usuarios = usuarioService.getUsuarios(false);
    model.addAttribute("usuarios", usuarios);
    model.addAttribute("totalUsuarios", usuarios.size());
    return "/";
}

@GetMapping("/")
public String usuarioNuevo(Usuario usuario) {
    return "/";
}

@Autowired
private FirebaseStorageServiceImpl firebaseStorageService;

@PostMapping("/")
public String usuarioGuardar(Usuario usuario,
        @RequestParam("imagenFile") MultipartFile imagenFile) {        
    if (!imagenFile.isEmpty()) {
        usuarioService.save(usuario);
        usuario.setRutaImagen(
                firebaseStorageService.cargaImagen(
                        imagenFile, 
                        "usuario", 
                        usuario.getIdUsuario()));
    }
    usuarioService.save(usuario);
    return "redirect:/";
}

@GetMapping("/eliminar/{idUsuario}")
public String usuarioEliminar(Usuario usuario) {
    usuarioService.delete(usuario);
    return "redirect:/";
}

@GetMapping("/modificar/{idUsuario}")
public String usuarioModificar(Usuario usuario, Model model) {
    usuario = usuarioService.getUsuario(usuario);
    model.addAttribute("usuario", usuario);
    return "/";
}

}
