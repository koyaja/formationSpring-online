package com.ga.formationonline.web;

import com.ga.formationonline.domaine.Personel;
import com.ga.formationonline.service.PersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ks
 * @created by koyajajacques on 25/01/2022.
 *
 * Afficher la list des personnels
 * Enregister les personels
 * Afficher un personel par index
 * Afficher un personel par numero matricule
 * Mise à jour
 * Supression
 *
 */
@RestController
@RequestMapping("/api/v1/personel")
public class PersonelRessource {

    @Autowired
    private  PersonelService personelService;

   /* public PersonelRessource(PersonelService personelService) {
        this.personelService = personelService;
    }*/

    @PostMapping
    public Personel addNewPerson( @RequestBody Personel personel) {
        return personelService.save(personel);
    }

    @GetMapping
   public List<Personel> getAllPersonel() {
        return personelService.getAll();
   }

   @GetMapping("/{id}")
    public Personel getPersonelById( @PathVariable(name = "id") Integer index ) {
        return  personelService.getPersonelByIndex(index-1);
   }

   @GetMapping("/search/q")
    public Personel getPersonelById( @RequestParam(name = "mat") String matricule ) {
        return  personelService.getPersonelByMatricule(matricule);
   }

   @PutMapping("/{uid}")
   public ResponseEntity<?> updatePersonel(@RequestBody Personel personel, @PathVariable Integer uid){
       System.out.println(personel);
     Personel person = personelService.updatePersonel(uid, personel);

     if(person != null){

         return ResponseEntity.ok(person);
     }
     return new ResponseEntity<Object>("L'utilisateur n'existe pas", HttpStatus.NOT_FOUND);
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){

        personelService.delete(id);
     return ResponseEntity.ok("suprimer avec succès");
   }


}
