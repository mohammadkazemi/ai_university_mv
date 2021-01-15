-- تعداد کاربران
select count(*) from users where is_student=true;
-- تعداد رای ها
select count(*) from votes;
-- میانگین رای تسلط استاد
select avg(tasalot) from votes
-- میانگین رای تناسب راهبردها و شیوه هاي آموزش با اهداف درس
select avg(tanasobe_rahbordha) from votes
-- میانگین رای جامع نگري و ژرف اندیشی استاد در ارائه مباحث
select avg(jame_negari_va_jarf_andishi) from votes
-- میانگین رای توانایی انتقال مطالب اساسی درس
select avg(tabanaii_enteghale_matalebe_darsi) from votes
-- میانگین رای دانش عمومی استاد در رشته تحصیلی
select avg(general_knowledge) from votes
-- میانگین رای استفاده از شیوه هاي ارزشیابی مناسب از دانشجو با توجه به اهداف درس
select avg(estefade_az_shiveye_arzheshyabi) from votes
-- میانگین رای داشتن طرح درس مناسب و جامعیت و پیوستگی در ارائه مطالب
select avg(dashtane_tarhe_dars_monaseb) from votes
-- میانگین رای کوشش براي طرح مباحث جدید و استفاده از منابع روز آمد
select avg(koshesh) from votes
-- میانگین رای شرکت دادن دانشجو در مباحث درس
select avg(sherkat_dadane_daneshjo) from votes
-- میانگین رای ایجاد انگیزه و رغبت در دانشجو جهت تحقیق و مطالعه
select avg(ijade_angize) from votes
-- میانگین رای نحوه مدیریت کلاس
select avg(nahve_ye_modiriyat) from votes
-- میانگین رای امکان ارتباط حضوری با استاد
select avg(emkane_ertebat_hozori) from votes
-- میانگین رای آداب و رفتار اجتماعی با دانشجویان و احترام متقابل
select avg(adab_va_moasherat) from votes
-- میانگین رای واکنش منطقی و معقول به پیشنهادها،انتقادها و دیدگاههاي دانشجویان
select avg(vakonesh_manteghi) from votes
-- میانگین رای گشاده روئی استاد و تکریم دانشجو
select avg(goshade_roii) from votes
-- میانگین کاراکتر مطالبی که دانشجویان برای نظر اضافه نوشتند
select avg(length(sayer)) from votes
-- میانگین کل نظر ها
with cte as (select
avg(tasalot) as "tasalot",
avg(general_knowledge) as "general_knowledge",
avg(jame_negari_va_jarf_andishi) as "jame_negari_va_jarf_andishi",
avg(tabanaii_enteghale_matalebe_darsi) as "tabanaii_enteghale_matalebe_darsi",
avg(dashtane_tarhe_dars_monaseb) as "dashtane_tarhe_dars_monaseb",
avg(koshesh) as "koshesh",
avg(tanasobe_rahbordha) as "tanasobe_rahbordha",
avg(estefade_az_shiveye_arzheshyabi) as "estefade_az_shiveye_arzheshyabi",
avg(sherkat_dadane_daneshjo) as "sherkat_dadane_daneshjo",
avg(ijade_angize) as "ijade_angize",
avg(nahve_ye_modiriyat) as "nahve_ye_modiriyat",
avg(emkane_ertebat_hozori) as "emkane_ertebat_hozori",
avg(adab_va_moasherat) as "adab_va_moasherat",
avg(vakonesh_manteghi) as "vakonesh_manteghi",
avg(goshade_roii) as "goshade_roii" from votes)
select (tasalot+
general_knowledge+
jame_negari_va_jarf_andishi+
tabanaii_enteghale_matalebe_darsi+
dashtane_tarhe_dars_monaseb+
koshesh+
tanasobe_rahbordha+
estefade_az_shiveye_arzheshyabi+
sherkat_dadane_daneshjo+
ijade_angize+
nahve_ye_modiriyat+
emkane_ertebat_hozori+
adab_va_moasherat+
vakonesh_manteghi+
goshade_roii)/15 from cte

-- حداقل میانگین رای بین میانگین های رای ها
with cte as (
select avg(tasalot)                             as "average", 'tasalot'                            as "nazar" from votes group by 2 union all
select avg(general_knowledge)                   as "average", 'general_knowledge'                  as "nazar" from votes group by 2 union all
select avg(jame_negari_va_jarf_andishi)         as "average", 'jame_negari_va_jarf_andishi'        as "nazar" from votes group by 2 union all
select avg(tabanaii_enteghale_matalebe_darsi)   as "average", 'tabanaii_enteghale_matalebe_darsi'  as "nazar" from votes group by 2 union all
select avg(dashtane_tarhe_dars_monaseb)         as "average", 'dashtane_tarhe_dars_monaseb'        as "nazar" from votes group by 2 union all
select avg(koshesh)                             as "average", 'koshesh'                            as "nazar" from votes group by 2 union all
select avg(tanasobe_rahbordha)                  as "average", 'tanasobe_rahbordha'                 as "nazar" from votes group by 2 union all
select avg(estefade_az_shiveye_arzheshyabi)     as "average", 'estefade_az_shiveye_arzheshyabi'    as "nazar" from votes group by 2 union all
select avg(sherkat_dadane_daneshjo)             as "average", 'sherkat_dadane_daneshjo'            as "nazar" from votes group by 2 union all
select avg(ijade_angize)                        as "average", 'ijade_angize'                       as "nazar" from votes group by 2 union all
select avg(nahve_ye_modiriyat)                  as "average", 'nahve_ye_modiriyat'                 as "nazar" from votes group by 2 union all
select avg(emkane_ertebat_hozori)               as "average", 'emkane_ertebat_hozori'              as "nazar" from votes group by 2 union all
select avg(adab_va_moasherat)                   as "average", 'adab_va_moasherat'                  as "nazar" from votes group by 2 union all
select avg(vakonesh_manteghi)                   as "average", 'vakonesh_manteghi'                  as "nazar" from votes group by 2 union all
select avg(goshade_roii)                        as "average", 'goshade_roii'                       as "nazar" from votes group by 2 ) ,
cte2 as (select min(average), nazar from cte group by 2 order by 1 limit 1 ),
cte3 as (select max(average), nazar from cte group by 2 order by 1 desc limit 1)
select * from cte2

-- حداکثر میانگین رای بین میانگین رای ها
with cte as (
select avg(tasalot)                             as "average", 'tasalot'                            as "nazar" from votes group by 2 union all
select avg(general_knowledge)                   as "average", 'general_knowledge'                  as "nazar" from votes group by 2 union all
select avg(jame_negari_va_jarf_andishi)         as "average", 'jame_negari_va_jarf_andishi'        as "nazar" from votes group by 2 union all
select avg(tabanaii_enteghale_matalebe_darsi)   as "average", 'tabanaii_enteghale_matalebe_darsi'  as "nazar" from votes group by 2 union all
select avg(dashtane_tarhe_dars_monaseb)         as "average", 'dashtane_tarhe_dars_monaseb'        as "nazar" from votes group by 2 union all
select avg(koshesh)                             as "average", 'koshesh'                            as "nazar" from votes group by 2 union all
select avg(tanasobe_rahbordha)                  as "average", 'tanasobe_rahbordha'                 as "nazar" from votes group by 2 union all
select avg(estefade_az_shiveye_arzheshyabi)     as "average", 'estefade_az_shiveye_arzheshyabi'    as "nazar" from votes group by 2 union all
select avg(sherkat_dadane_daneshjo)             as "average", 'sherkat_dadane_daneshjo'            as "nazar" from votes group by 2 union all
select avg(ijade_angize)                        as "average", 'ijade_angize'                       as "nazar" from votes group by 2 union all
select avg(nahve_ye_modiriyat)                  as "average", 'nahve_ye_modiriyat'                 as "nazar" from votes group by 2 union all
select avg(emkane_ertebat_hozori)               as "average", 'emkane_ertebat_hozori'              as "nazar" from votes group by 2 union all
select avg(adab_va_moasherat)                   as "average", 'adab_va_moasherat'                  as "nazar" from votes group by 2 union all
select avg(vakonesh_manteghi)                   as "average", 'vakonesh_manteghi'                  as "nazar" from votes group by 2 union all
select avg(goshade_roii)                        as "average", 'goshade_roii'                       as "nazar" from votes group by 2 ) ,
cte2 as (select min(average), nazar from cte group by 2 order by 1 limit 1 ),
cte3 as (select max(average), nazar from cte group by 2 order by 1 desc limit 1)
select * from cte3

-- نمایی از میانگین رای ها ۰
select avg(tasalot)                             , 'tasalot'                            as "nazar" from votes group by 2 union all
select avg(general_knowledge)                   , 'general_knowledge'                  as "nazar" from votes group by 2 union all
select avg(jame_negari_va_jarf_andishi)         , 'jame_negari_va_jarf_andishi'        as "nazar" from votes group by 2 union all
select avg(tabanaii_enteghale_matalebe_darsi)   , 'tabanaii_enteghale_matalebe_darsi'  as "nazar" from votes group by 2 union all
select avg(dashtane_tarhe_dars_monaseb)         , 'dashtane_tarhe_dars_monaseb'        as "nazar" from votes group by 2 union all
select avg(koshesh)                             , 'koshesh'                            as "nazar" from votes group by 2 union all
select avg(tanasobe_rahbordha)                  , 'tanasobe_rahbordha'                 as "nazar" from votes group by 2 union all
select avg(estefade_az_shiveye_arzheshyabi)     , 'estefade_az_shiveye_arzheshyabi'    as "nazar" from votes group by 2 union all
select avg(sherkat_dadane_daneshjo)             , 'sherkat_dadane_daneshjo'            as "nazar" from votes group by 2 union all
select avg(ijade_angize)                        , 'ijade_angize'                       as "nazar" from votes group by 2 union all
select avg(nahve_ye_modiriyat)                  , 'nahve_ye_modiriyat'                 as "nazar" from votes group by 2 union all
select avg(emkane_ertebat_hozori)               , 'emkane_ertebat_hozori'              as "nazar" from votes group by 2 union all
select avg(adab_va_moasherat)                   , 'adab_va_moasherat'                  as "nazar" from votes group by 2 union all
select avg(vakonesh_manteghi)                   , 'vakonesh_manteghi'                  as "nazar" from votes group by 2 union all
select avg(goshade_roii)                        , 'goshade_roii'                       as "nazar" from votes group by 2







-- تعداد کاربران
select count(*) from users where is_teacher = true
-- تعداد رای ها
select count(*) from teacher_vote

-- رضایت مندی از امکانات رفاهی -- rezayatmandi_emkanat_refahi
select avg(rezayatmandi_emkanat_refahi) as "average" from teacher_vote
-- رضایت مندی از امکانات اقامتی -- rezayatmandi_emkanat_eghamati
select avg(rezayatmandi_emkanat_eghamati) as "average" from teacher_vote
-- رضایت مندی از امکانات بانکی -- rezayatmandi_tashilate_baki
select avg(rezayatmandi_tashilate_baki) as "average" from teacher_vote
-- رضایت مندی از خدمات رفاهی سایر دانشگاه ها -- rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha
select avg(rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha) as "average" from teacher_vote
-- رضایت مندی از سامانه ی رفاهی -- rezayatmandi_samane_refahi
select avg(rezayatmandi_samane_refahi) as "average" from teacher_vote
-- رضایت مندی از امکانات بیمه -- rezayatmandi_emkanat_bime
select avg(rezayatmandi_emkanat_bime) as "average" from teacher_vote
-- رضایت مندی از پرسنل امور اموزشی اداری -- rezayatmandi_personel_amozesh_amore_amozeshi_edari
select avg(rezayatmandi_personel_amozesh_amore_amozeshi_edari) as "average" from teacher_vote
-- رضایت مندی از امکانات دستگاه ها و تجهیزات ازمایشگاهی -- rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah
select avg(rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah) as "average" from teacher_vote
-- رضایت مندی از نحوی ی پاسخگویی به سوالات و درخواست های تلفنی از اداره ی اموزش -- nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashil
select avg(nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashil) as "average" from teacher_vote
-- رضایت مندی از تشکیل منظم جلسات گروه علمی -- tashkil_monazam_jalasat_goroh_elmi
select avg(tashkil_monazam_jalasat_goroh_elmi) as "average" from teacher_vote
-- مشخص بودن اعضاء گروه علمی و تخصص آنها moshakhas_aaza_goroh_elmi_takhasos
select avg(moshakhas_aaza_goroh_elmi_takhasos) as "average" from teacher_vote
-- اطلاع رسانی منظم از مصوبات گروه علمی eltela_monazam_mosavabat_goroh_elmi
select avg(eltela_monazam_mosavabat_goroh_elmi) as "average" from teacher_vote
-- dastres_aaza_goroh_elmi در دسترس بودن مدیر گروه علمی
select avg(dastres_aaza_goroh_elmi) as "average" from teacher_vote
-- مشخص بودن نحوه ارتباط با اعضاء گروه علمی و مدیر گروه moshakhas_nahve_ertebat_aaza_goroh_elmi
select avg(moshakhas_nahve_ertebat_aaza_goroh_elmi) as "average" from teacher_vote
-- میزان تجدید نظر مستمر در برنامه ها و سرفصل ها با توجه به آخرین پیشرفت ها و تغییرات و تحولات علمیmizan_tajdid_nazar_sarfasl_taghirat_tahavolat
select avg(mizan_tajdid_nazar_sarfasl_taghirat_tahavolat) as "average" from teacher_vote
-- teacher_comments نظرات استاد
select avg(length(teacher_comments)) from teacher_vote
-- حداقل میانگین رای بین میانگین های رای ها
with cte as (
select avg(rezayatmandi_emkanat_refahi) as "average", 'rezayatmandi_emkanat_refahi' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_emkanat_eghamati) as "average", 'rezayatmandi_emkanat_eghamati' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_tashilate_baki) as "average", 'rezayatmandi_tashilate_baki' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha) as "average", 'rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_samane_refahi) as "average", 'rezayatmandi_samane_refahi' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_emkanat_bime) as "average", 'rezayatmandi_emkanat_bime' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_personel_amozesh_amore_amozeshi_edari) as "average", 'rezayatmandi_personel_amozesh_amore_amozeshi_edari' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah) as "average", 'rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah' as "nazar" from teacher_vote group by 2 union all
select avg(nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashil) as "average", 'nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashil' as "nazar" from teacher_vote group by 2 union all
select avg(tashkil_monazam_jalasat_goroh_elmi) as "average", 'tashkil_monazam_jalasat_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(moshakhas_aaza_goroh_elmi_takhasos) as "average", 'moshakhas_aaza_goroh_elmi_takhasos' as "nazar" from teacher_vote group by 2 union all
select avg(eltela_monazam_mosavabat_goroh_elmi) as "average", 'eltela_monazam_mosavabat_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(dastres_aaza_goroh_elmi) as "average", 'dastres_aaza_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(moshakhas_nahve_ertebat_aaza_goroh_elmi) as "average", 'moshakhas_nahve_ertebat_aaza_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(mizan_tajdid_nazar_sarfasl_taghirat_tahavolat) as "average", 'mizan_tajdid_nazar_sarfasl_taghirat_tahavolat' as "nazar" from teacher_vote group by 2  ) ,
cte2 as (select min(average), nazar from cte group by 2 order by 1 limit 1 ),
cte3 as (select max(average), nazar from cte group by 2 order by 1 desc limit 1)
select * from cte2;

-- حداکثر میانگین رای بین میانگین رای ها
with cte as (
select avg(rezayatmandi_emkanat_refahi) as "average", 'rezayatmandi_emkanat_refahi' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_emkanat_eghamati) as "average", 'rezayatmandi_emkanat_eghamati' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_tashilate_baki) as "average", 'rezayatmandi_tashilate_baki' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha) as "average", 'rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_samane_refahi) as "average", 'rezayatmandi_samane_refahi' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_emkanat_bime) as "average", 'rezayatmandi_emkanat_bime' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_personel_amozesh_amore_amozeshi_edari) as "average", 'rezayatmandi_personel_amozesh_amore_amozeshi_edari' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah) as "average", 'rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah' as "nazar" from teacher_vote group by 2 union all
select avg(nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashil) as "average", 'nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashil' as "nazar" from teacher_vote group by 2 union all
select avg(tashkil_monazam_jalasat_goroh_elmi) as "average", 'tashkil_monazam_jalasat_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(moshakhas_aaza_goroh_elmi_takhasos) as "average", 'moshakhas_aaza_goroh_elmi_takhasos' as "nazar" from teacher_vote group by 2 union all
select avg(eltela_monazam_mosavabat_goroh_elmi) as "average", 'eltela_monazam_mosavabat_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(dastres_aaza_goroh_elmi) as "average", 'dastres_aaza_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(moshakhas_nahve_ertebat_aaza_goroh_elmi) as "average", 'moshakhas_nahve_ertebat_aaza_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(mizan_tajdid_nazar_sarfasl_taghirat_tahavolat) as "average", 'mizan_tajdid_nazar_sarfasl_taghirat_tahavolat' as "nazar" from teacher_vote group by 2  ) ,
cte2 as (select min(average), nazar from cte group by 2 order by 1 limit 1 ),
cte3 as (select max(average), nazar from cte group by 2 order by 1 desc limit 1)
select * from cte3;

-- نمایی دیگر از میانگین رای ها
select avg(rezayatmandi_emkanat_refahi) , 'rezayatmandi_emkanat_refahi'as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_emkanat_eghamati) , 'rezayatmandi_emkanat_eghamati' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_tashilate_baki) , 'rezayatmandi_tashilate_baki' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha) , 'rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_samane_refahi) , 'rezayatmandi_samane_refahi' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_emkanat_bime) , 'rezayatmandi_emkanat_bime' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_personel_amozesh_amore_amozeshi_edari) , 'rezayatmandi_personel_amozesh_amore_amozeshi_edari' as "nazar" from teacher_vote group by 2 union all
select avg(rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah) , 'rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah' as "nazar" from teacher_vote group by 2 union all
select avg(nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashil) , 'nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashil' as "nazar" from teacher_vote group by 2 union all
select avg(tashkil_monazam_jalasat_goroh_elmi) , 'tashkil_monazam_jalasat_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(moshakhas_aaza_goroh_elmi_takhasos) , 'moshakhas_aaza_goroh_elmi_takhasos' as "nazar" from teacher_vote group by 2 union all
select avg(eltela_monazam_mosavabat_goroh_elmi) , 'eltela_monazam_mosavabat_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(dastres_aaza_goroh_elmi) , 'dastres_aaza_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(moshakhas_nahve_ertebat_aaza_goroh_elmi) , 'moshakhas_nahve_ertebat_aaza_goroh_elmi' as "nazar" from teacher_vote group by 2 union all
select avg(mizan_tajdid_nazar_sarfasl_taghirat_tahavolat) , 'mizan_tajdid_nazar_sarfasl_taghirat_tahavolat' as "nazar" from teacher_vote group by 2

















-- تعداد کاربران
select count(*) from users where is_education_employee = true;
-- تعداد رای ها
select count(*) from education_employee_vote;
-- میزان رضایتمندی از پاسخگویی مناسب به گیرندگان خدمت و ارباب رجوع-- mizan_rezayat_girandegane_khedmat_arbab_rojo
select avg(mizan_rezayat_girandegane_khedmat_arbab_rojo) as "average" from education_employee_vote;
-- تناسب تعداد کارشناسان متخصص رفاه با حجم فعالیت های واحد-- tedad_monaseb_karshenas_motenaseb_hajm_faaliyat
select avg(tedad_monaseb_karshenas_motenaseb_hajm_faaliyat) as "average" from education_employee_vote;
-- مکان دفتر اموررفاه دانشگاه درستاد مرکزی-- makane_daftare_daneshgah
select avg(makane_daftare_daneshgah) as "average" from education_employee_vote;
-- میزان رضایتمندی از امکانات رفاهی-- emkanate_refahi
select avg(emkanate_refahi) as "average" from education_employee_vote;
-- eraeee_tashilate_banki-- میزان رضایتمندی از ارائه تسهیلات بانکی
select avg(eraeee_tashilate_banki) as "average" from education_employee_vote;
-- khadamate_refahi_sayere_daneshgah_ha-- میزان رضایتمندی از خدمات رفاهی در سایر دانشگاه های کشور)اسکان(
select avg(khadamate_refahi_sayere_daneshgah_ha) as "average" from education_employee_vote;
-- mizan_rezayat_samane_haye_refahi-- میزان رضایتمندی از سامانه های رفاهی
select avg(mizan_rezayat_samane_haye_refahi) as "average" from education_employee_vote;
-- khadamate_bime_takmili-- میزان رضایت مندی از خدمات امور بیمه تکمیل درمان
select avg(khadamate_bime_takmili) as "average" from education_employee_vote;
-- میانگین تعداد کاراکتر نظرات کارد اموزشی
select avg(length(education_employee_comments)) from education_employee_vote
-- حداقل میانگین رای بین میانگین های رای ها
with cte as (
select avg(mizan_rezayat_girandegane_khedmat_arbab_rojo) as "average" , 'mizan_rezayat_girandegane_khedmat_arbab_rojo' as "nazar" from education_employee_vote group by 2 union all
select avg(tedad_monaseb_karshenas_motenaseb_hajm_faaliyat) as "average" , 'tedad_monaseb_karshenas_motenaseb_hajm_faaliyat' as "nazar" from education_employee_vote group by 2 union all
select avg(makane_daftare_daneshgah) as "average" , 'makane_daftare_daneshgah' as "nazar" from education_employee_vote group by 2 union all
select avg(emkanate_refahi) as "average" , 'emkanate_refahi' as "nazar" from education_employee_vote group by 2 union all
select avg(eraeee_tashilate_banki) as "average" , 'eraeee_tashilate_banki' as "nazar" from education_employee_vote group by 2 union all
select avg(khadamate_refahi_sayere_daneshgah_ha) as "average" , 'khadamate_refahi_sayere_daneshgah_ha' as "nazar" from education_employee_vote group by 2 union all
select avg(mizan_rezayat_samane_haye_refahi) as "average" , 'mizan_rezayat_samane_haye_refahi' as "nazar" from education_employee_vote group by 2 union all
select avg(khadamate_bime_takmili) as "average" , 'khadamate_bime_takmili' as "nazar" from education_employee_vote group by 2 ) ,
cte2 as (select min(average), nazar from cte group by 2 order by 1 limit 1 ),
cte3 as (select max(average), nazar from cte group by 2 order by 1 desc limit 1)
select * from cte2;
-- حداکثر میانگین رای بین میانگین رای ها
with cte as (
select avg(mizan_rezayat_girandegane_khedmat_arbab_rojo) as "average" , 'mizan_rezayat_girandegane_khedmat_arbab_rojo' as "nazar" from education_employee_vote group by 2 union all
select avg(tedad_monaseb_karshenas_motenaseb_hajm_faaliyat) as "average" , 'tedad_monaseb_karshenas_motenaseb_hajm_faaliyat' as "nazar" from education_employee_vote group by 2 union all
select avg(makane_daftare_daneshgah) as "average" , 'makane_daftare_daneshgah' as "nazar" from education_employee_vote group by 2 union all
select avg(emkanate_refahi) as "average" , 'emkanate_refahi' as "nazar" from education_employee_vote group by 2 union all
select avg(eraeee_tashilate_banki) as "average" , 'eraeee_tashilate_banki' as "nazar" from education_employee_vote group by 2 union all
select avg(khadamate_refahi_sayere_daneshgah_ha) as "average" , 'khadamate_refahi_sayere_daneshgah_ha' as "nazar" from education_employee_vote group by 2 union all
select avg(mizan_rezayat_samane_haye_refahi) as "average" , 'mizan_rezayat_samane_haye_refahi' as "nazar" from education_employee_vote group by 2 union all
select avg(khadamate_bime_takmili) as "average" , 'khadamate_bime_takmili' as "nazar" from education_employee_vote group by 2 ) ,
cte2 as (select min(average), nazar from cte group by 2 order by 1 limit 1 ),
cte3 as (select max(average), nazar from cte group by 2 order by 1 desc limit 1)
select * from cte3;
-- نمایی دیگر از میانگین رای ها
select avg(mizan_rezayat_girandegane_khedmat_arbab_rojo) , 'mizan_rezayat_girandegane_khedmat_arbab_rojo' as "nazar" from education_employee_vote group by 2 union all
select avg(tedad_monaseb_karshenas_motenaseb_hajm_faaliyat) , 'tedad_monaseb_karshenas_motenaseb_hajm_faaliyat' as "nazar" from education_employee_vote group by 2 union all
select avg(makane_daftare_daneshgah) , 'makane_daftare_daneshgah' as "nazar" from education_employee_vote group by 2 union all
select avg(emkanate_refahi) , 'emkanate_refahi' as "nazar" from education_employee_vote group by 2 union all
select avg(eraeee_tashilate_banki) , 'eraeee_tashilate_banki' as "nazar" from education_employee_vote group by 2 union all
select avg(khadamate_refahi_sayere_daneshgah_ha) , 'khadamate_refahi_sayere_daneshgah_ha' as "nazar" from education_employee_vote group by 2 union all
select avg(mizan_rezayat_samane_haye_refahi) , 'mizan_rezayat_samane_haye_refahi' as "nazar" from education_employee_vote group by 2 union all
select avg(khadamate_bime_takmili) , 'khadamate_bime_takmili' as "nazar" from education_employee_vote group by 2