package com.example.contacts;

import android.location.Address;

import org.json.JSONObject;

public class Contacting {
    private String id, nom, adresse, tel1, tel2, entreprise;

    public Contacting(JSONObject jObject) {
        this.id = jObject.optString("id");
        this.nom = jObject.optString("nom");
        this.adresse = jObject.optString("adresse");
        this.tel1 = jObject.optString("num1");
        this.tel2 = jObject.optString("num2");
        this.entreprise = jObject.optString("entreprise");
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel1() {
        return tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public String getEntreprise() {
        return entreprise;
    }
}
