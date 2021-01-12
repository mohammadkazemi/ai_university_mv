from typing import List
from pydantic import BaseModel


class VoteBase(BaseModel):
    tasalot: int
    general_knowledge: int
    jame_negari_va_jarf_andishi: int
    tabanaii_enteghale_matalebe_darsi: int
    dashtane_tarhe_dars_monaseb: int
    koshesh: int
    tanasobe_rahbordha: int
    estefade_az_shiveye_arzheshyabi: int
    sherkat_dadane_daneshjo: int
    ijade_angize: int
    nahve_ye_modiriyat: int
    emkane_ertebat_hozori: int
    adab_va_moasherat: int
    vakonesh_manteghi: int
    goshade_roii: int
    sayer: str


class TeacherVoteBase(BaseModel):
    rezayatmandi_emkanat_refahi: int  # میزان رضایتمندی از امکانات رفاهی
    rezayatmandi_emkanat_eghamati: int  # میزان رضایتمندی از امکانات اقامتی و سیاحتی
    rezayatmandi_tashilate_baki: int  # میزان رضایتمندی از ارائه تسهیلات بانکی
    rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha: int  # میزان رضایتمندی از خدمات رفاهی در سایر دانشگاه های کشور)اسکان(
    rezayatmandi_samane_refahi: int  # میزان رضایتمندی از سامانه های رفاهی
    rezayatmandi_emkanat_bime: int  # میزان رضایت مندی از خدمات امور بیمه تکمیل درمان
    rezayatmandi_personel_amozesh_amore_amozeshi_edari: int  # میزان تسلط پرسنل اداره آموزش و تحصیلات تکمیلی بر امور آموزشی و اداری
    rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah: int  # میزان بهره برداری از وسایل اداری ، دستگاه ها و تجهیزات آزمایشگاهی، کارگاهی و….
    nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashilt_takmili: int  # نحوه پاسخگویی به سوالات و درخواست های تلفنی توسط اداره آموزش و تحصیلات تکمیلی
    tashkil_monazam_jalasat_goroh_elmi: int  # تشکیل منظم جلسات گروه علمی
    moshakhas_aaza_goroh_elmi_takhasos: int  # مشخص بودن اعضاء گروه علمی و تخصص آنها
    eltela_monazam_mosavabat_goroh_elmi: int  # اطلاع رسانی منظم از مصوبات گروه علمی
    dastres_aaza_goroh_elmi: int  # در دسترس بودن مدیر گروه علمی
    moshakhas_nahve_ertebat_aaza_goroh_elmi: int  # مشخص بودن نحوه ارتباط با اعضاء گروه علمی و مدیر گروه
    mizan_tajdid_nazar_sarfasl_taghirat_tahavolat: int  # میزان تجدید نظر مستمر در برنامه ها و سرفصل ها با توجه به آخرین پیشرفت ها و تغییرات و تحولات علمی
    teacher_comments: str  # نظر متنی


class EducationEmployeeVoteBase(BaseModel):
    mizan_rezayat_girandegane_khedmat_arbab_rojo: int  # میزان رضایتمندی از پاسخگویی مناسب به گیرندگان خدمت و ارباب رجوع
    tedad_monaseb_karshenas_motenaseb_hajm_faaliyat: int  # تناسب تعداد کارشناسان متخصص رفاه با حجم فعالیت های واحد
    makane_daftare_daneshgah: int  # مکان دفتر اموررفاه دانشگاه درستاد مرکزی
    emkanate_refahi: int  # میزان رضایتمندی از امکانات اقامتی و سیاحتی # میزان رضایتمندی از امکانات رفاهی
    eraeee_tashilate_banki: int  # میزان رضایتمندی از ارائه تسهیلات بانکی
    khadamate_refahi_sayere_daneshgah_ha: int  # میزان رضایتمندی از خدمات رفاهی در سایر دانشگاه های کشور)اسکان(
    mizan_rezayat_samane_haye_refahi: int  # میزان رضایتمندی از سامانه های رفاهی
    khadamate_bime_takmili: int  # میزان رضایت مندی از خدمات امور بیمه تکمیل درمان
    education_employee_comments: str  # نظر متنی


class VoteCreate(VoteBase):
    pass


class TeacherVoteCreate(TeacherVoteBase):
    pass


class EducationEmployeeVoteCreate(EducationEmployeeVoteBase):
    pass


class Vote(VoteBase):
    id: int
    owner_id: int

    class Config:
        orm_mode = True


class TeacherVote(TeacherVoteBase):
    id: int
    owner_id: int

    class Config:
        orm_mode = True


class EducationEmployeeVote(EducationEmployeeVoteBase):
    id: int
    owner_id: int

    class Config:
        orm_mode = True


class UserLogin(BaseModel):
    email: str
    password: str


class UserBase(BaseModel):
    email: str
    name: str
    is_student: bool
    is_teacher: bool
    is_education_employee: bool


class UserCreate(UserBase):
    password: str


class User(UserBase):
    id: int
    is_active: bool
    # items: List[Vote] = []
    items = []

    class Config:
        orm_mode = True
