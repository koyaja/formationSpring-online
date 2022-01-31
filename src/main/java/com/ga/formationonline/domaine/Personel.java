package com.ga.formationonline.domaine;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
 * @author ks
 * @created by koyajajacques on 25/01/2022.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Personel implements Serializable {

    private String matricule;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Instant registerDate;

}
