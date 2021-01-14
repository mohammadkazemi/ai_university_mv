package com.example.models;

import com.google.gson.annotations.SerializedName;

public class CreateEmployeeVoteResponseModel {

    @SerializedName("id")
    int id;
    @SerializedName("owner_id")
    int ownerId;
    @SerializedName("mizan_rezayat_girandegane_khedmat_arbab_rojo")
    int mizanRezayatGirandeganeKhedmatArbabRojo;
    @SerializedName("tedad_monaseb_karshenas_motenaseb_hajm_faaliyat")
    int tedadMonasebKarshenasMotenasebHajmFaaliyat;
    @SerializedName("makane_daftare_daneshgah")
    int makaneDaftareDaneshgah;
    @SerializedName("emkanate_refahi")
    int emkanateRefahi;
    @SerializedName("eraeee_tashilate_banki")
    int eraeeeTashilateBanki;
    @SerializedName("khadamate_refahi_sayere_daneshgah_ha")
    int khadamateRefahiSayereDaneshgahHa;
    @SerializedName("mizan_rezayat_samane_haye_refahi")
    int mizanRezayatSamaneHayeRefahi;
    @SerializedName("khadamate_bime_takmili")
    int khadamateBimeTakmili;
    @SerializedName("education_employee_comments")
    String educationEmployeeComments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getMizanRezayatGirandeganeKhedmatArbabRojo() {
        return mizanRezayatGirandeganeKhedmatArbabRojo;
    }

    public void setMizanRezayatGirandeganeKhedmatArbabRojo(int mizanRezayatGirandeganeKhedmatArbabRojo) {
        this.mizanRezayatGirandeganeKhedmatArbabRojo = mizanRezayatGirandeganeKhedmatArbabRojo;
    }

    public int getTedadMonasebKarshenasMotenasebHajmFaaliyat() {
        return tedadMonasebKarshenasMotenasebHajmFaaliyat;
    }

    public void setTedadMonasebKarshenasMotenasebHajmFaaliyat(int tedadMonasebKarshenasMotenasebHajmFaaliyat) {
        this.tedadMonasebKarshenasMotenasebHajmFaaliyat = tedadMonasebKarshenasMotenasebHajmFaaliyat;
    }

    public int getMakaneDaftareDaneshgah() {
        return makaneDaftareDaneshgah;
    }

    public void setMakaneDaftareDaneshgah(int makaneDaftareDaneshgah) {
        this.makaneDaftareDaneshgah = makaneDaftareDaneshgah;
    }

    public int getEmkanateRefahi() {
        return emkanateRefahi;
    }

    public void setEmkanateRefahi(int emkanateRefahi) {
        this.emkanateRefahi = emkanateRefahi;
    }

    public int getEraeeeTashilateBanki() {
        return eraeeeTashilateBanki;
    }

    public void setEraeeeTashilateBanki(int eraeeeTashilateBanki) {
        this.eraeeeTashilateBanki = eraeeeTashilateBanki;
    }

    public int getKhadamateRefahiSayereDaneshgahHa() {
        return khadamateRefahiSayereDaneshgahHa;
    }

    public void setKhadamateRefahiSayereDaneshgahHa(int khadamateRefahiSayereDaneshgahHa) {
        this.khadamateRefahiSayereDaneshgahHa = khadamateRefahiSayereDaneshgahHa;
    }

    public int getMizanRezayatSamaneHayeRefahi() {
        return mizanRezayatSamaneHayeRefahi;
    }

    public void setMizanRezayatSamaneHayeRefahi(int mizanRezayatSamaneHayeRefahi) {
        this.mizanRezayatSamaneHayeRefahi = mizanRezayatSamaneHayeRefahi;
    }

    public int getKhadamateBimeTakmili() {
        return khadamateBimeTakmili;
    }

    public void setKhadamateBimeTakmili(int khadamateBimeTakmili) {
        this.khadamateBimeTakmili = khadamateBimeTakmili;
    }

    public String getEducationEmployeeComments() {
        return educationEmployeeComments;
    }

    public void setEducationEmployeeComments(String educationEmployeeComments) {
        this.educationEmployeeComments = educationEmployeeComments;
    }
}
