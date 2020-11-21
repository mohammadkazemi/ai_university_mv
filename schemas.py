from typing import List, Optional

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


class VoteCreate(VoteBase):
    pass


class Vote(VoteBase):
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


class UserCreate(UserBase):
    password: str


class User(UserBase):
    id: int
    is_active: bool
    items: List[Vote] = []

    class Config:
        orm_mode = True
