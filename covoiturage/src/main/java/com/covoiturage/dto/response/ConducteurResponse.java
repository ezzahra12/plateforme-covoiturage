
package com.covoiturage.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConducteurResponse {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String numeroPermis;
}
