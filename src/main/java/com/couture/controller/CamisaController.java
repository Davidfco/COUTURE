
package com.couture.controller;

import com.couture.domain.Camisa;
import com.couture.service.CamisaService;
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

@Controller
@Slf4j
@RequestMapping("/")
public class CamisaController {
    
    @Autowired
    private CamisaService camisaService;

    @GetMapping("/")
    public String inicio(Model model) {
        var camisas = camisaService.getCamisas(false);
        model.addAttribute("camisas", camisas);
        model.addAttribute("totalCamisas", camisas.size());
        return "/";
    }
    
    @GetMapping("/")
    public String camisaNuevo(Camisa camisa) {
        return "/";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/")
    public String camisaGuardar(Camisa camisa,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            camisaService.save(camisa);
            camisa.setImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "camisa", 
                            camisa.getIdCamisa()));
        }
        camisaService.save(camisa);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{idCamisa}")
    public String camisaEliminar(Camisa camisa) {
        camisaService.delete(camisa);
        return "redirect:/";
    }

    @GetMapping("/modificar/{idCamisa}")
    public String camisaModificar(Camisa camisa, Model model) {
        camisa = camisaService.getCamisa(camisa);
        model.addAttribute("camisa", camisa);
        return "/";
    }
}
