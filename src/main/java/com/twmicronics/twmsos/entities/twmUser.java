package com.twmicronics.twmsos.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Data
public class twmUser implements Serializable {
    
    @Id
    @Length(min = 2, max = 30)
    private String username;
    
    @Length(min = 2, max = 30)
    @NotNull(message = "Veuillez spécifier votre premier nom")
    private String firstName;
    
    @Column(nullable = true)
    @Length(min = 0, max = 30)
    private String lastName;
    
    @NotNull(message = "Le mot de passe doit être spécifié")
    @Column(unique = true)
    @Length(min = 4)
    private String password;
    
    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", 
            message = "Adresse mail invalide, veuillez le vérifier")
    private String email;
    
    @Pattern(regexp = "^[0-9]{9}$", 
            message = "Numéro de téléphone invalide")
    @Column(nullable = true, unique = true, length = 9)
    private String telephone;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastConnexion;
    
    @Column(columnDefinition = "int(1) unsigned not null default 1")
    private int state;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<twmRole> role;
}
