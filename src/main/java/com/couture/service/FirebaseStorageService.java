package com.couture.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Service;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "couture-328ee.appspot.com";

    final String rutaSuperiorStorage = "couture";

    final String rutaJsonFile = "firebase";

    final String archivoJsonFile = "couture-328ee-firebase-adminsdk-5hfb6-bb1dc31dfa";

}
