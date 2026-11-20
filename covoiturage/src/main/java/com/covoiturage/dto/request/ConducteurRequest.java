
package com.covoiturage.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ConducteurRequest {

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telephone;

    @NotBlank
    private String numeroPermis;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }
}
