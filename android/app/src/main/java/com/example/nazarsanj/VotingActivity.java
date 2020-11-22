package com.example.nazarsanj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.models.CreateVoteResponseModel;
import com.example.web.WebConsumer;
import com.example.web.WebService;

import java.util.ArrayList;
import java.util.HashMap;

public class VotingActivity extends AppCompatActivity {

    private EditText
            nazarat_va_pishnahadat_et_EditText,
            tasalot_et_EditText,
            general_knowledge_et_EditText,
            jame_negari_et_EditText,
            tavanaii_enteghal_et_EditText,
            dashtane_tarhe_dars_et_EditText,
            koshesh_et_EditText,
            tanasobe_rahbord_et_EditText,
            shive_ye_arzeshyabi_et_EditText,
            shekat_dadane_et_EditText,
            ijand_angize_et_EditText,
            nahve_ye_modiriyat_et_EditText,
            ertebate_hozori_et_EditText,
            adab_v_raftar_et_EditText,
            vakonesh_manteghi_et_EditText,
            goshade_roii_et_EditText;
    private boolean emptyVoteEditTexts = true;
    private Button submitVote;
    private HashMap<String, String> mMap = new HashMap<>();
    private String userId;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                userId = null;
            } else {
                userId = extras.getString("neededUserId");
            }
        } else {
            userId = (String) savedInstanceState.getSerializable("neededUserId");
        }


        nazarat_va_pishnahadat_et_EditText = findViewById(R.id.nazarat_va_pishnahadat_et);
        tasalot_et_EditText = findViewById(R.id.tasalot_et);
        general_knowledge_et_EditText = findViewById(R.id.general_knowledge_et);
        jame_negari_et_EditText = findViewById(R.id.jame_negari_et);
        tavanaii_enteghal_et_EditText = findViewById(R.id.tavanaii_enteghal_et);
        dashtane_tarhe_dars_et_EditText = findViewById(R.id.dashtane_tarhe_dars_et);
        koshesh_et_EditText = findViewById(R.id.koshesh_et);
        tanasobe_rahbord_et_EditText = findViewById(R.id.tanasobe_rahbord_et);
        shive_ye_arzeshyabi_et_EditText = findViewById(R.id.shive_ye_arzeshyabi_et);
        shekat_dadane_et_EditText = findViewById(R.id.shekat_dadane_et);
        ijand_angize_et_EditText = findViewById(R.id.ijand_angize_et);
        nahve_ye_modiriyat_et_EditText = findViewById(R.id.nahve_ye_modiriyat_et);
        ertebate_hozori_et_EditText = findViewById(R.id.ertebate_hozori_et);
        adab_v_raftar_et_EditText = findViewById(R.id.adab_v_raftar_et);
        vakonesh_manteghi_et_EditText = findViewById(R.id.vakonesh_manteghi_et);
        goshade_roii_et_EditText = findViewById(R.id.goshade_roii_et);


        submitVote = findViewById(R.id.submit_vote);





        submitVote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> data = getInputData();
                checkEmptyInput(data);
                if (emptyVoteEditTexts){
                    Toast.makeText(getApplicationContext(), "فرم را کامل کنید", Toast.LENGTH_SHORT).show();
                }else{
                    emptyVoteEditTexts = true;
                    WebService.getInstance().postVoteData(mMap, userId, getApplicationContext(), new WebConsumer<CreateVoteResponseModel>() {
                        @Override
                        public void success(CreateVoteResponseModel createVoteResponseModel) {
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
            if (data.get(i).equals("")){
                emptyVoteEditTexts = true;
                break;
            }
        }


    }

    private ArrayList<String> getInputData() {
        String nazarat_va_pishnahadat_et_EditTextValue = String.valueOf(nazarat_va_pishnahadat_et_EditText.getText());
        String tasalot_et_EditTextValue = String.valueOf(tasalot_et_EditText.getText());
        String general_knowledge_et_EditTextValue = String.valueOf(general_knowledge_et_EditText.getText());
        String jame_negari_et_EditTextValue = String.valueOf(jame_negari_et_EditText.getText());
        String tavanaii_enteghal_et_EditTextValue = String.valueOf(tavanaii_enteghal_et_EditText.getText());
        String dashtane_tarhe_dars_et_EditTextValue = String.valueOf(dashtane_tarhe_dars_et_EditText.getText());
        String koshesh_et_EditTextValue = String.valueOf(koshesh_et_EditText.getText());
        String tanasobe_rahbord_et_EditTextValue = String.valueOf(tanasobe_rahbord_et_EditText.getText());
        String shive_ye_arzeshyabi_et_EditTextValue = String.valueOf(shive_ye_arzeshyabi_et_EditText.getText());
        String shekat_dadane_et_EditTextValue = String.valueOf(shekat_dadane_et_EditText.getText());
        String ijand_angize_et_EditTextValue = String.valueOf(ijand_angize_et_EditText.getText());
        String nahve_ye_modiriyat_et_EditTextValue = String.valueOf(nahve_ye_modiriyat_et_EditText.getText());
        String ertebate_hozori_et_EditTextValue = String.valueOf(ertebate_hozori_et_EditText.getText());
        String adab_v_raftar_et_EditTextValue = String.valueOf(adab_v_raftar_et_EditText.getText());
        String vakonesh_manteghi_et_EditTextValue = String.valueOf(vakonesh_manteghi_et_EditText.getText());
        String goshade_roii_et_EditTextValue = String.valueOf(goshade_roii_et_EditText.getText());

        mMap.put("tasalot", tasalot_et_EditTextValue);
        mMap.put("general_knowledge", general_knowledge_et_EditTextValue);
        mMap.put("jame_negari_va_jarf_andishi", jame_negari_et_EditTextValue);
        mMap.put("tabanaii_enteghale_matalebe_darsi", tavanaii_enteghal_et_EditTextValue);
        mMap.put("dashtane_tarhe_dars_monaseb", dashtane_tarhe_dars_et_EditTextValue);
        mMap.put("koshesh", koshesh_et_EditTextValue);
        mMap.put("tanasobe_rahbordha", tanasobe_rahbord_et_EditTextValue);
        mMap.put("estefade_az_shiveye_arzheshyabi", shive_ye_arzeshyabi_et_EditTextValue);
        mMap.put("sherkat_dadane_daneshjo", shekat_dadane_et_EditTextValue);
        mMap.put("ijade_angize", ijand_angize_et_EditTextValue);
        mMap.put("nahve_ye_modiriyat", nahve_ye_modiriyat_et_EditTextValue);
        mMap.put("emkane_ertebat_hozori", ertebate_hozori_et_EditTextValue);
        mMap.put("adab_va_moasherat", adab_v_raftar_et_EditTextValue);
        mMap.put("vakonesh_manteghi", vakonesh_manteghi_et_EditTextValue);
        mMap.put("goshade_roii", goshade_roii_et_EditTextValue);
        mMap.put("sayer", nazarat_va_pishnahadat_et_EditTextValue);

        ArrayList<String> mlst = new ArrayList<String>(){
            {
                add(nazarat_va_pishnahadat_et_EditTextValue);
                add(tasalot_et_EditTextValue);
                add(general_knowledge_et_EditTextValue);
                add(jame_negari_et_EditTextValue);
                add(tavanaii_enteghal_et_EditTextValue);
                add(dashtane_tarhe_dars_et_EditTextValue);
                add(koshesh_et_EditTextValue);
                add(tanasobe_rahbord_et_EditTextValue);
                add(shive_ye_arzeshyabi_et_EditTextValue);
                add(shekat_dadane_et_EditTextValue);
                add(ijand_angize_et_EditTextValue);
                add(nahve_ye_modiriyat_et_EditTextValue);
                add(ertebate_hozori_et_EditTextValue);
                add(adab_v_raftar_et_EditTextValue);
                add(vakonesh_manteghi_et_EditTextValue);
                add(goshade_roii_et_EditTextValue);
            }
        };
        return mlst;
    }
}