package com.example.nazarsanj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.models.CreateEmployeeVoteResponseModel;
import com.example.web.WebConsumer;
import com.example.web.WebService;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.nazarsanj.SubSystemActivity.neededUserIdForApi;

public class EmployeeActivity extends AppCompatActivity {

    private EditText
            mizan_rezayat_girandegane_khedmat_arbab_rojo_EditText,
            tedad_monaseb_karshenas_motenaseb_hajm_faaliyat_EditText,
            makane_daftare_daneshgah_EditText,
            emkanate_refahi_EditText,
            eraeee_tashilate_banki_EditText,
            khadamate_refahi_sayere_daneshgah_ha_EditText,
            mizan_rezayat_samane_haye_refahi_EditText,
            khadamate_bime_takmili_EditText,
            education_employee_comments_EditText;


    private boolean emptyVoteEditTexts = true;
    private Button submitVote;
    private HashMap<String, String> mMap = new HashMap<>();
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        mizan_rezayat_girandegane_khedmat_arbab_rojo_EditText = findViewById(R.id.mizan_rezayat_girandegane_khedmat_arbab_rojo_edit_txt);
        tedad_monaseb_karshenas_motenaseb_hajm_faaliyat_EditText = findViewById(R.id.tedad_monaseb_karshenas_motenaseb_hajm_faaliyat_edit_txt);
        makane_daftare_daneshgah_EditText = findViewById(R.id.makane_daftare_daneshgah_edit_txt);
        emkanate_refahi_EditText = findViewById(R.id.emkanate_refahi_edit_txt);
        eraeee_tashilate_banki_EditText = findViewById(R.id.eraeee_tashilate_banki_edit_txt);
        khadamate_refahi_sayere_daneshgah_ha_EditText = findViewById(R.id.khadamate_refahi_sayere_daneshgah_ha_edit_txt);
        mizan_rezayat_samane_haye_refahi_EditText = findViewById(R.id.mizan_rezayat_samane_haye_refahi_edit_txt);
        khadamate_bime_takmili_EditText = findViewById(R.id.khadamate_bime_takmili_edit_txt);
        education_employee_comments_EditText = findViewById(R.id.education_employee_comments_edit_txt);


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
                    WebService.getInstance().postEmployeeVoteData(mMap, userId, getApplicationContext(), new WebConsumer<CreateEmployeeVoteResponseModel>() {
                        @Override
                        public void success(CreateEmployeeVoteResponseModel createTeacherVoteResponseModel) {
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


        String mizan_rezayat_girandegane_khedmat_arbab_rojo_content = String.valueOf(mizan_rezayat_girandegane_khedmat_arbab_rojo_EditText.getText());
        String tedad_monaseb_karshenas_motenaseb_hajm_faaliyat_content = String.valueOf(tedad_monaseb_karshenas_motenaseb_hajm_faaliyat_EditText.getText());
        String makane_daftare_daneshgah_content = String.valueOf(makane_daftare_daneshgah_EditText.getText());
        String emkanate_refahi_content = String.valueOf(emkanate_refahi_EditText.getText());
        String eraeee_tashilate_banki_content = String.valueOf(eraeee_tashilate_banki_EditText.getText());
        String khadamate_refahi_sayere_daneshgah_ha_content = String.valueOf(khadamate_refahi_sayere_daneshgah_ha_EditText.getText());
        String mizan_rezayat_samane_haye_refahi_content = String.valueOf(mizan_rezayat_samane_haye_refahi_EditText.getText());
        String khadamate_bime_takmili_content = String.valueOf(khadamate_bime_takmili_EditText.getText());
        String education_employee_comments_content = String.valueOf(education_employee_comments_EditText.getText());


        mMap.put("mizan_rezayat_girandegane_khedmat_arbab_rojo", mizan_rezayat_girandegane_khedmat_arbab_rojo_content);
        mMap.put("tedad_monaseb_karshenas_motenaseb_hajm_faaliyat", tedad_monaseb_karshenas_motenaseb_hajm_faaliyat_content);
        mMap.put("makane_daftare_daneshgah", makane_daftare_daneshgah_content);
        mMap.put("emkanate_refahi", emkanate_refahi_content);
        mMap.put("eraeee_tashilate_banki", eraeee_tashilate_banki_content);
        mMap.put("khadamate_refahi_sayere_daneshgah_ha", khadamate_refahi_sayere_daneshgah_ha_content);
        mMap.put("mizan_rezayat_samane_haye_refahi", mizan_rezayat_samane_haye_refahi_content);
        mMap.put("khadamate_bime_takmili", khadamate_bime_takmili_content);
        mMap.put("education_employee_comments", education_employee_comments_content);


        ArrayList<String> mlst = new ArrayList<String>() {

            {
                add(mizan_rezayat_girandegane_khedmat_arbab_rojo_content);
                add(tedad_monaseb_karshenas_motenaseb_hajm_faaliyat_content);
                add(makane_daftare_daneshgah_content);
                add(emkanate_refahi_content);
                add(eraeee_tashilate_banki_content);
                add(khadamate_refahi_sayere_daneshgah_ha_content);
                add(mizan_rezayat_samane_haye_refahi_content);
                add(khadamate_bime_takmili_content);
                add(education_employee_comments_content);
            }
        };
        return mlst;
    }

}