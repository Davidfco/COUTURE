
package com.couture.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

@Service
public interface FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "couture-328ee.appspot.com";
    
    //Esta es la ruta basica de este proyecto techshop
    final String rutaSuperiorStorage = "couture";
    
    //Ubicacion donde se encuentra el archivo de configuracion Json
    final String rutaJsonFile = "firebase";
    
    //Nombre del archivo json
    final String archivoJsonFile = "couture-328ee-firebase-adminsdk-5hfb6-bb1dc31dfa";
    
}
