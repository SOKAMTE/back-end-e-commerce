package com.twmicronics.twmsos.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author paulinlenasaein
 */
@Entity
@Data
public class twmPromotion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    private twmProduit produit;
    
    @NotNull(message = "Le prix promo du produit doit être spécifié")
    private Double prixPromo;
    
    @Column(nullable = false)
    @Length(min = 10)
    private String descriptPromo;
    
    @NotNull(message = "La durée de la promotion en jour doit être spécifié")
    @Column(columnDefinition = "int unsigned not null default 0")
    private int dureePromo;
    
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    
    @Column(columnDefinition = "int(1) unsigned not null default 0")
    private int state;
}
