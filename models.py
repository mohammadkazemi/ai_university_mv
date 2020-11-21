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
    votes = relationship("Vote", back_populates="owner")


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

    owner = relationship("User", back_populates="votes")
