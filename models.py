from sqlalchemy import Boolean, Column, ForeignKey, Integer, String
from sqlalchemy.orm import relationship
from .database import Base


class User(Base):
    __tablename__ = "users"
    id = Column(Integer, primary_key=True, index=True, autoincrement=True)
    name = Column(String)
    email = Column(String, unique=True, index=True)
    hashed_password = Column(String)
    is_active = Column(Boolean, default=True)
    is_student = Column(Boolean, default=True)
    is_teacher = Column(Boolean)
    is_education_employee = Column(Boolean)

    votes = relationship("Vote", back_populates="vote_owner")
    teacher_vote = relationship("TeacherVote", back_populates="teacher_owner")
    education_employee_vote = relationship("EducationEmployeeVote", back_populates="education_employee_owner")


class Vote(Base):
    __tablename__ = "votes"

    id = Column(Integer, primary_key=True, index=True, autoincrement=True)
    owner_id = Column(Integer, ForeignKey("users.id"))
    tasalot = Column(Integer)
    general_knowledge = Column(Integer)
    jame_negari_va_jarf_andishi = Column(Integer)
    tabanaii_enteghale_matalebe_darsi = Column(Integer)
    dashtane_tarhe_dars_monaseb = Column(Integer)
    koshesh = Column(Integer)
    tanasobe_rahbordha = Column(Integer)
    estefade_az_shiveye_arzheshyabi = Column(Integer)
    sherkat_dadane_daneshjo = Column(Integer)
    ijade_angize = Column(Integer)
    nahve_ye_modiriyat = Column(Integer)
    emkane_ertebat_hozori = Column(Integer)
    adab_va_moasherat = Column(Integer)
    vakonesh_manteghi = Column(Integer)
    goshade_roii = Column(Integer)
    sayer = Column(String)

    vote_owner = relationship("User", back_populates="votes")


class TeacherVote(Base):
    __tablename__ = "teacher_vote"
    id = Column(Integer, primary_key=True, index=True, autoincrement=True)
    owner_id = Column(Integer, ForeignKey("users.id"))
    #     میزان رضایتمندی از امکانات رفاهی
    rezayatmandi_emkanat_refahi = Column(Integer)
    # میزان رضایتمندی از امکانات اقامتی و سیاحتی
    rezayatmandi_emkanat_eghamati = Column(Integer)
    # میزان رضایتمندی از ارائه تسهیلات بانکی
    rezayatmandi_tashilate_baki = Column(Integer)
    # میزان رضایتمندی از خدمات رفاهی در سایر دانشگاه های کشور)اسکان(
    rezayatmandi_khadamate_refahi_sayyere_daneshgah_ha = Column(Integer)
    # میزان رضایتمندی از سامانه های رفاهی
    rezayatmandi_samane_refahi = Column(Integer)
    # میزان رضایت مندی از خدمات امور بیمه تکمیل درمان
    rezayatmandi_emkanat_bime = Column(Integer)
    # میزان تسلط پرسنل اداره آموزش و تحصیلات تکمیلی بر امور آموزشی و اداری
    rezayatmandi_personel_amozesh_amore_amozeshi_edari = Column(Integer)
    # میزان بهره برداری از وسایل اداری ، دستگاه ها و تجهیزات آزمایشگاهی، کارگاهی و….
    rezayatmandi_emkanat_edari_dastghah_tajhizate_azmayesh_kargah = Column(Integer)
    # نحوه پاسخگویی به سوالات و درخواست های تلفنی توسط اداره آموزش و تحصیلات تکمیلی
    nahve_pasokhgoii_soalat_darkhast_telephoni_edare_amozesh_tashilt_takmili = Column(Integer)
    # تشکیل منظم جلسات گروه علمی
    tashkil_monazam_jalasat_goroh_elmi = Column(Integer)
    # مشخص بودن اعضاء گروه علمی و تخصص آنها
    moshakhas_aaza_goroh_elmi_takhasos = Column(Integer)
    # اطلاع رسانی منظم از مصوبات گروه علمی
    eltela_monazam_mosavabat_goroh_elmi = Column(Integer)
    # در دسترس بودن مدیر گروه علمی
    dastres_aaza_goroh_elmi = Column(Integer)
    # مشخص بودن نحوه ارتباط با اعضاء گروه علمی و مدیر گروه
    moshakhas_nahve_ertebat_aaza_goroh_elmi = Column(Integer)
    # میزان تجدید نظر مستمر در برنامه ها و سرفصل ها با توجه به آخرین پیشرفت ها و تغییرات و تحولات علمی
    mizan_tajdid_nazar_sarfasl_taghirat_tahavolat = Column(Integer)
    teacher_comments = Column(String)
    teacher_owner = relationship("User", back_populates="teacher_vote")


class EducationEmployeeVote(Base):
    __tablename__ = "education_employee_vote"
    id = Column(Integer, primary_key=True, index=True, autoincrement=True)
    owner_id = Column(Integer, ForeignKey("users.id"))
    # میزان رضایتمندی از پاسخگویی مناسب به گیرندگان خدمت و ارباب رجوع
    mizan_rezayat_girandegane_khedmat_arbab_rojo = Column(Integer)
    # تناسب تعداد کارشناسان متخصص رفاه با حجم فعالیت های واحد
    tedad_monaseb_karshenas_motenaseb_hajm_faaliyat = Column(Integer)
    # مکان دفتر اموررفاه دانشگاه درستاد مرکزی
    makane_daftare_daneshgah = Column(Integer)
    # میزان رضایتمندی از امکانات رفاهی
    # میزان رضایتمندی از امکانات اقامتی و سیاحتی
    emkanate_refahi = Column(Integer)
    # میزان رضایتمندی از ارائه تسهیلات بانکی
    eraeee_tashilate_banki = Column(Integer)
    # میزان رضایتمندی از خدمات رفاهی در سایر دانشگاه های کشور)اسکان(
    khadamate_refahi_sayere_daneshgah_ha = Column(Integer)
    # میزان رضایتمندی از سامانه های رفاهی
    mizan_rezayat_samane_haye_refahi = Column(Integer)
    # میزان رضایت مندی از خدمات امور بیمه تکمیل درمان
    khadamate_bime_takmili = Column(Integer)
    # نظر متنی
    education_employee_comments = Column(String)
    education_employee_owner = relationship("User", back_populates="education_employee_vote")
