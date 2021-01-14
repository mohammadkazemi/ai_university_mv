package com.example.nazarsanj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.models.CreateTeacherVoteResponseModel;
import com.example.web.WebConsumer;
import com.example.web.WebService;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.nazarsanj.SubSystemActivity.neededUserIdForApi;

public class TeacherActivity extends AppCompatActivity {

    private EditText
            rezayatmandi_emkanat_refahi_edittxt,
            rezayatmandi_emkanat_eghamati_edittxt,
            rezayatmandi_tashilate_baki_edittxt,
            rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha_edittxt,
            rezayatmandi_samane_refahi_edittxt,
            rezayatmandi_emkanat_bime_edittxt,
            rezayatmandi_personel_amozesh_amore_amozeshi_edari_edittxt,
            rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah_edittxt,
            nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashilt_takmili_edittxt,
            tashkil_monazam_jalasat_goroh_elmi_edittxt,
            moshakhas_aaza_goroh_elmi_takhasos_edittxt,
            eltela_monazam_mosavabat_goroh_elmi_edittxt,
            dastres_aaza_goroh_elmi_edittxt,
            moshakhas_nahve_ertebat_aaza_goroh_elmi_edittxt,
            mizan_tajdid_nazar_sarfasl_taghirat_tahavolat_edittxt,
            teacher_comments_edittxt;

    private boolean emptyVoteEditTexts = true;
    private Button submitVote;
    private HashMap<String, String> mMap = new HashMap<>();
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
//        its not the right way to for variable naming in java but ...
        rezayatmandi_emkanat_refahi_edittxt = findViewById(R.id.rezayatmandi_emkanat_refahi_edittxt);
        rezayatmandi_emkanat_eghamati_edittxt = findViewById(R.id.rezayatmandi_emkanat_eghamati_edittxt);
        rezayatmandi_tashilate_baki_edittxt = findViewById(R.id.rezayatmandi_tashilate_baki_edittxt);
        rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha_edittxt = findViewById(R.id.rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha_edittxt);
        rezayatmandi_samane_refahi_edittxt = findViewById(R.id.rezayatmandi_samane_refahi_edittxt);
        rezayatmandi_emkanat_bime_edittxt = findViewById(R.id.rezayatmandi_emkanat_bime_edittxt);
        rezayatmandi_personel_amozesh_amore_amozeshi_edari_edittxt = findViewById(R.id.rezayatmandi_personel_amozesh_amore_amozeshi_edari_edittxt);
        rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah_edittxt = findViewById(R.id.rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah_edittxt);
        nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashilt_takmili_edittxt = findViewById(R.id.nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashilt_takmili_edittxt);
        tashkil_monazam_jalasat_goroh_elmi_edittxt = findViewById(R.id.tashkil_monazam_jalasat_goroh_elmi_edittxt);
        moshakhas_aaza_goroh_elmi_takhasos_edittxt = findViewById(R.id.moshakhas_aaza_goroh_elmi_takhasos_edittxt);
        eltela_monazam_mosavabat_goroh_elmi_edittxt = findViewById(R.id.eltela_monazam_mosavabat_goroh_elmi_edittxt);
        dastres_aaza_goroh_elmi_edittxt = findViewById(R.id.dastres_aaza_goroh_elmi_edittxt);
        moshakhas_nahve_ertebat_aaza_goroh_elmi_edittxt = findViewById(R.id.moshakhas_nahve_ertebat_aaza_goroh_elmi_edittxt);
        mizan_tajdid_nazar_sarfasl_taghirat_tahavolat_edittxt = findViewById(R.id.mizan_tajdid_nazar_sarfasl_taghirat_tahavolat_edittxt);
        teacher_comments_edittxt = findViewById(R.id.teacher_comments_edittxt);
        submitVote = findViewById(R.id.submit_vote);
        userId = neededUserIdForApi;


        submitVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> data = getInputData();
                checkEmptyInput(data);
                if (emptyVoteEditTexts) {
                    Toast.makeText(getApplicationContext(), "فرم را کامل کنید", Toast.LENGTH_SHORT).show();
                } else {
                    emptyVoteEditTexts = true;
                    WebService.getInstance().postTeacherVoteData(mMap, userId, getApplicationContext(), new WebConsumer<CreateTeacherVoteResponseModel>() {
                        @Override
                        public void success(CreateTeacherVoteResponseModel createTeacherVoteResponseModel) {
                            Toast.makeText(getApplicationContext(), "رای شما با موفقیت ثبت شد", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void error(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "ارور", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


    }


    private void checkEmptyInput(ArrayList<String> data) {
        emptyVoteEditTexts = false;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals("")) {
                emptyVoteEditTexts = true;
                break;
            }
        }
    }


    private ArrayList<String> getInputData() {


        String rezayatmandi_emkanat_refahi_content = String.valueOf(rezayatmandi_emkanat_refahi_edittxt.getText());
        String rezayatmandi_emkanat_eghamati_content = String.valueOf(rezayatmandi_emkanat_eghamati_edittxt.getText());
        String rezayatmandi_tashilate_baki_content = String.valueOf(rezayatmandi_tashilate_baki_edittxt.getText());
        String rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha_content = String.valueOf(rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha_edittxt.getText());
        String rezayatmandi_samane_refahi_content = String.valueOf(rezayatmandi_samane_refahi_edittxt.getText());
        String rezayatmandi_emkanat_bime_content = String.valueOf(rezayatmandi_emkanat_bime_edittxt.getText());
        String rezayatmandi_personel_amozesh_amore_amozeshi_edari_content = String.valueOf(rezayatmandi_personel_amozesh_amore_amozeshi_edari_edittxt.getText());
        String rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah_content = String.valueOf(rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah_edittxt.getText());
        String nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashilt_takmili_content = String.valueOf(nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashilt_takmili_edittxt.getText());
        String tashkil_monazam_jalasat_goroh_elmi_content = String.valueOf(tashkil_monazam_jalasat_goroh_elmi_edittxt.getText());
        String moshakhas_aaza_goroh_elmi_takhasos_content = String.valueOf(moshakhas_aaza_goroh_elmi_takhasos_edittxt.getText());
        String eltela_monazam_mosavabat_goroh_elmi_content = String.valueOf(eltela_monazam_mosavabat_goroh_elmi_edittxt.getText());
        String dastres_aaza_goroh_elmi_content = String.valueOf(dastres_aaza_goroh_elmi_edittxt.getText());
        String moshakhas_nahve_ertebat_aaza_goroh_elmi_content = String.valueOf(moshakhas_nahve_ertebat_aaza_goroh_elmi_edittxt.getText());
        String mizan_tajdid_nazar_sarfasl_taghirat_tahavolat_content = String.valueOf(mizan_tajdid_nazar_sarfasl_taghirat_tahavolat_edittxt.getText());
        String teacher_comments_content = String.valueOf(teacher_comments_edittxt.getText());


        mMap.put("rezayatmandi_emkanat_refahi", rezayatmandi_emkanat_refahi_content);
        mMap.put("rezayatmandi_emkanat_eghamati", rezayatmandi_emkanat_eghamati_content);
        mMap.put("rezayatmandi_tashilate_baki", rezayatmandi_tashilate_baki_content);
        mMap.put("rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha", rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha_content);
        mMap.put("rezayatmandi_samane_refahi", rezayatmandi_samane_refahi_content);
        mMap.put("rezayatmandi_emkanat_bime", rezayatmandi_emkanat_bime_content);
        mMap.put("rezayatmandi_personel_amozesh_amore_amozeshi_edari", rezayatmandi_personel_amozesh_amore_amozeshi_edari_content);
        mMap.put("rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah", rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah_content);
        mMap.put("nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashilt_takmili", nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashilt_takmili_content);
        mMap.put("tashkil_monazam_jalasat_goroh_elmi", tashkil_monazam_jalasat_goroh_elmi_content);
        mMap.put("moshakhas_aaza_goroh_elmi_takhasos", moshakhas_aaza_goroh_elmi_takhasos_content);
        mMap.put("eltela_monazam_mosavabat_goroh_elmi", eltela_monazam_mosavabat_goroh_elmi_content);
        mMap.put("dastres_aaza_goroh_elmi", dastres_aaza_goroh_elmi_content);
        mMap.put("moshakhas_nahve_ertebat_aaza_goroh_elmi", moshakhas_nahve_ertebat_aaza_goroh_elmi_content);
        mMap.put("mizan_tajdid_nazar_sarfasl_taghirat_tahavolat", mizan_tajdid_nazar_sarfasl_taghirat_tahavolat_content);
        mMap.put("teacher_comments", teacher_comments_content);

        ArrayList<String> mlst = new ArrayList<String>() {

            {
                add(rezayatmandi_emkanat_refahi_content);
                add(rezayatmandi_emkanat_eghamati_content);
                add(rezayatmandi_tashilate_baki_content);
                add(rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha_content);
                add(rezayatmandi_samane_refahi_content);
                add(rezayatmandi_emkanat_bime_content);
                add(rezayatmandi_personel_amozesh_amore_amozeshi_edari_content);
                add(rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah_content);
                add(nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashilt_takmili_content);
                add(tashkil_monazam_jalasat_goroh_elmi_content);
                add(moshakhas_aaza_goroh_elmi_takhasos_content);
                add(eltela_monazam_mosavabat_goroh_elmi_content);
                add(dastres_aaza_goroh_elmi_content);
                add(moshakhas_nahve_ertebat_aaza_goroh_elmi_content);
                add(mizan_tajdid_nazar_sarfasl_taghirat_tahavolat_content);
                add(teacher_comments_content);
            }
        };
        return mlst;
    }

}
