import requests
import secrets

base_url = 'http://127.0.0.1:8000'
# base_url = 'http://85.208.184.49:1399'
my_header = {'Content-Type': 'application/json'}

# creating teacher
for i in range(1, 50):
    tmp_teacher = {"email": f"user{i}@gmail.com",
                   "name": f"user{i}",
                   "password": "test",
                   "is_student": False,
                   "is_teacher": True,
                   "is_education_employee": False
                   }
    resp = requests.post(base_url + '/user/', json=tmp_teacher, headers=my_header)
    print(resp.status_code)

    if 200 <= resp.status_code < 300:
        # create voet for users
        tmp_teacher_vote = {
            "rezayatmandi_emkanat_refahi": secrets.randbelow(20),  # میزان رضایتمندی از امکانات رفاهی
            "rezayatmandi_emkanat_eghamati": secrets.randbelow(20),  # میزان رضایتمندی از امکانات اقامتی و سیاحتی
            "rezayatmandi_tashilate_baki": secrets.randbelow(20),  # میزان رضایتمندی از ارائه تسهیلات بانکی
            "rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha": secrets.randbelow(20),
            # میزان رضایتمندی از خدمات رفاهی در سایر دانشگاه های کشور)اسکان(
            "rezayatmandi_samane_refahi": secrets.randbelow(20),  # میزان رضایتمندی از سامانه های رفاهی
            "rezayatmandi_emkanat_bime": secrets.randbelow(20),  # میزان رضایت مندی از خدمات امور بیمه تکمیل درمان
            "rezayatmandi_personel_amozesh_amore_amozeshi_edari": secrets.randbelow(20),
            # میزان تسلط پرسنل اداره آموزش و تحصیلات تکمیلی بر امور آموزشی و اداری
            "rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah": secrets.randbelow(20),
            # میزان بهره برداری از وسایل اداری ، دستگاه ها و تجهیزات آزمایشگاهی، کارگاهی و….
            "nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashilt_takmili": secrets.randbelow(20),
            # نحوه پاسخگویی به سوالات و درخواست های تلفنی توسط اداره آموزش و تحصیلات تکمیلی
            "tashkil_monazam_jalasat_goroh_elmi": secrets.randbelow(20),  # تشکیل منظم جلسات گروه علمی
            "moshakhas_aaza_goroh_elmi_takhasos": secrets.randbelow(20),  # مشخص بودن اعضاء گروه علمی و تخصص آنها
            "eltela_monazam_mosavabat_goroh_elmi": secrets.randbelow(20),  # اطلاع رسانی منظم از مصوبات گروه علمی
            "dastres_aaza_goroh_elmi": secrets.randbelow(20),  # در دسترس بودن مدیر گروه علمی
            "moshakhas_nahve_ertebat_aaza_goroh_elmi": secrets.randbelow(20),
            # مشخص بودن نحوه ارتباط با اعضاء گروه علمی و مدیر گروه
            "mizan_tajdid_nazar_sarfasl_taghirat_tahavolat": secrets.randbelow(20),
            # میزان تجدید نظر مستمر در برنامه ها و سرفصل ها با توجه به آخرین پیشرفت ها و تغییرات و تحولات علمی
            "teacher_comments": "i have nothing to say"  # نظر متنی
        }
        resp = requests.post(base_url + f'/users/{resp.json()["id"]}/teacher_votes/', json=tmp_teacher_vote,
                             headers=my_header)
        if resp.status_code != 200:
            print("something going wrong in creating teacher")
            break

# creating student
for i in range(51, 1001):

    tmp_student_user = {"email": f"user{i}@gmail.com",
                        "name": f"user{i}",
                        "password": "test",
                        "is_student": True,
                        "is_teacher": False,
                        "is_education_employee": False
                        }

    resp = requests.post(base_url + '/user/', json=tmp_student_user, headers=my_header)
    print(resp.status_code)

    if 200 <= resp.status_code < 300:
        tmp_vote = {
            "tasalot": secrets.randbelow(20),
            "general_knowledge": secrets.randbelow(20),
            "jame_negari_va_jarf_andishi": secrets.randbelow(20),
            "tabanaii_enteghale_matalebe_darsi": secrets.randbelow(20),
            "dashtane_tarhe_dars_monaseb": secrets.randbelow(20),
            "koshesh": secrets.randbelow(20),
            "tanasobe_rahbordha": secrets.randbelow(20),
            "estefade_az_shiveye_arzheshyabi": secrets.randbelow(20),
            "sherkat_dadane_daneshjo": secrets.randbelow(20),
            "ijade_angize": secrets.randbelow(20),
            "nahve_ye_modiriyat": secrets.randbelow(20),
            "emkane_ertebat_hozori": secrets.randbelow(20),
            "adab_va_moasherat": secrets.randbelow(20),
            "vakonesh_manteghi": secrets.randbelow(20),
            "goshade_roii": secrets.randbelow(20),
            "sayer": "i have nothing more to say"
        }

        resp = requests.post(base_url + f'/user/{i}/votes/', json=tmp_vote, headers=my_header)
        if resp.status_code != 200:
            print('something going wrong in creating vote for student')
            break

# creating education employee
for i in range(1001, 1151):
    tmp_education_employee_user = {"email": f"user{i}@gmail.com",
                                   "name": f"user{i}",
                                   "password": "test",
                                   "is_student": False,
                                   "is_teacher": False,
                                   "is_education_employee": True
                                   }

    resp = requests.post(base_url + '/user/', json=tmp_education_employee_user, headers=my_header)
    print(resp.status_code)

    if 200 <= resp.status_code < 300:
        tmp_education_employee_vote = {
            "mizan_rezayat_girandegane_khedmat_arbab_rojo": secrets.randbelow(20),
            # میزان رضایتمندی از پاسخگویی مناسب به گیرندگان خدمت و ارباب رجوع
            "tedad_monaseb_karshenas_motenaseb_hajm_faaliyat": secrets.randbelow(20),
            # تناسب تعداد کارشناسان متخصص رفاه با حجم فعالیت های واحد
            "makane_daftare_daneshgah": secrets.randbelow(20),  # مکان دفتر اموررفاه دانشگاه درستاد مرکزی
            "emkanate_refahi": secrets.randbelow(20),
            # میزان رضایتمندی از امکانات اقامتی و سیاحتی # میزان رضایتمندی از امکانات رفاهی
            "eraeee_tashilate_banki": secrets.randbelow(20),  # میزان رضایتمندی از ارائه تسهیلات بانکی
            "khadamate_refahi_sayere_daneshgah_ha": secrets.randbelow(20),
            # میزان رضایتمندی از خدمات رفاهی در سایر دانشگاه های کشور)اسکان(
            "mizan_rezayat_samane_haye_refahi": secrets.randbelow(20),  # میزان رضایتمندی از سامانه های رفاهی
            "khadamate_bime_takmili": secrets.randbelow(20),  # میزان رضایت مندی از خدمات امور بیمه تکمیل درمان
            "education_employee_comments": "i have nothing to say"  # نظر متنی
        }

        resp = requests.post(base_url + f'/user/{i}/education_employee_votes/', json=tmp_education_employee_vote,
                             headers=my_header)
        if resp.status_code != 200:
            print('something going wrong in creating vote for education employee')
            break
