package com.ga.formationonline.service;

import com.ga.formationonline.domaine.Personel;

import java.util.List;

/**
 * @author ks
 * @created by koyajajacques on 25/01/2022.
 */
public interface PersonelService {

    Personel save(Personel personel);
    List<Personel> getAll();
    Personel getPersonelByIndex(Integer index);

    Personel getPersonelByMatricule(String matricule);

    Personel updatePersonel(Integer id, Personel personel);

    void delete(Integer id);
}
