import requests
import secrets

base_url = 'http://127.0.0.1:8000'
my_header = {'Content-Type': 'application/json'}

for i in range(5, 1001):
    tmp = {
        "email": f"user{i}@gmail.com",
        "name": f"user{i}",
        "password": "test"
    }

    tmp_vote = {
        "tasalot": secrets.randbelow(21),
        "general_knowledge": secrets.randbelow(21),
        "jame_negari_va_jarf_andishi": secrets.randbelow(21),
        "tabanaii_enteghale_matalebe_darsi": secrets.randbelow(21),
        "dashtane_tarhe_dars_monaseb": secrets.randbelow(21),
        "koshesh": secrets.randbelow(21),
        "tanasobe_rahbordha": secrets.randbelow(21),
        "estefade_az_shiveye_arzheshyabi": secrets.randbelow(21),
        "sherkat_dadane_daneshjo": secrets.randbelow(21),
        "ijade_angize": secrets.randbelow(21),
        "nahve_ye_modiriyat": secrets.randbelow(21),
        "emkane_ertebat_hozori": secrets.randbelow(21),
        "adab_va_moasherat": secrets.randbelow(21),
        "vakonesh_manteghi": secrets.randbelow(21),
        "goshade_roii": secrets.randbelow(21),
        "sayer": "i have nothing more to say"
    }

    resp = requests.post(base_url + '/users/', json=tmp, headers=my_header)
    print(resp.status_code)

    if resp.status_code == 200:
        requests.post(base_url + f'/users/{resp.json()["id"]}/votes/', json=tmp_vote,headers = my_header )
        if resp.status_code != 200:
            print('something going wrong')
            break
