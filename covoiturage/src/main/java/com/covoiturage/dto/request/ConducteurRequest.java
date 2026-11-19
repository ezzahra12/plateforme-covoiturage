
package com.covoiturage.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class conducteurRequest {

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


}
