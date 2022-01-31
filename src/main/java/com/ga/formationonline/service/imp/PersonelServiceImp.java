package com.ga.formationonline.service.imp;

import com.ga.formationonline.domaine.Personel;
import com.ga.formationonline.service.PersonelService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ks
 * @created by koyajajacques on 25/01/2022.
 */
@Service
public class PersonelServiceImp implements PersonelService {

   List<Personel> personelList = new ArrayList<Personel>();

    public PersonelServiceImp() {
        Personel p1 = new Personel();
        p1.setMatricule("222228888");
        p1.setFirstName("John");
        p1.setLastName("Toto");
        personelList.add(p1);
        Personel p2 = new Personel("M455455","Tom","Jery",null,null);
        personelList.add(p2);
        Personel p3 = Personel
                .builder()
                .matricule("M8998877")
                .lastName("Jacques")
                .firstName("Bienvenu")
                .build();
        personelList.add(p3);
    }

    @Override
    public Personel save(Personel personel) {
        personel.setRegisterDate(Instant.now());
        // TODO
        personelList.add(personel);
        return personel;
    }

    @Override
    public List<Personel> getAll() {
        return personelList;
    }
    @Override
    public Personel getPersonelByIndex(Integer index) {
     return personelList.get(index);
    }

    @Override
    public Personel getPersonelByMatricule(String matricule) {
       Personel sp = new Personel();
        System.out.println("--------------MAT------------------"+matricule);

        for(Personel p:personelList){
            if(p.getMatricule().equalsIgnoreCase(matricule)){
                sp = p;
                System.out.println("--------------------------------"+p);
            }
        }

        return sp;
    }

    @Override
    public Personel updatePersonel(Integer id, Personel personel) {
       Personel updatePersonel = personelList.get(id);
       System.out.println("updatePerson  "+updatePersonel);
       if(updatePersonel != null){
           updatePersonel.setFirstName(personel.getFirstName());
           updatePersonel.setLastName(personel.getLastName());
           //personelList.add(id);
           // personelList.set(id,updatePersonel);
           return updatePersonel;
       }

        return null;
    }

    @Override
    public void delete(Integer id) {
       Personel personel = personelList.get(id);
        personelList.remove(personel);

    }

}
