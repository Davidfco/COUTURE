
package com.couture.service.impl;

import com.couture.dao.CamisaDao;
import com.couture.domain.Camisa;
import com.couture.service.CamisaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CamisaServiceImpl implements CamisaService {

    @Autowired
    private CamisaDao camisaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Camisa> getCamisas(boolean activos) {
        var lista = camisaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isDisponible());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Camisa getCamisa(Camisa camisa) {
        return camisaDao.findById(camisa.getIdCamisa()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Camisa camisa) {
        camisaDao.save(camisa);
    }

    @Override
    @Transactional
    public void delete(Camisa camisa) {
        camisaDao.delete(camisa);
    }
}