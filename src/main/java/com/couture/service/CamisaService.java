
package com.couture.service;

import com.couture.domain.Camisa;
import java.util.List;

public interface CamisaService {

    public List<Camisa> getCamisas(boolean activos);

    public void save(Camisa camisa);

    public void delete(Camisa camisa);

    public Camisa getCamisa(Camisa camisa);

}
