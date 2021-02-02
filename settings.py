import os
from dotenv import load_dotenv, find_dotenv

"""
 در این فایل ما اطلاعات دیتابیس را از فایل 
 .env 
 میخوانیم و سپس کانکشن به دیتابیس را برای کتابخانه های 
 sqlalchemy 
 که مخصوص کار با دیتابیس است ایجاد میکنیم
"""


load_dotenv(find_dotenv())

DATABASE_USER = os.getenv("DATABASE_USER")
DATABASE_PASSWORD = os.getenv("DATABASE_PASSWORD")
DATABASE_PORT = os.getenv("DATABASE_PORT")
DATABASE_SCHEMA = os.getenv("DATABASE_SCHEMA")
DATABASE_URL = os.getenv("DATABASE_URL")


SQLALCHEMY_DATABASE_URL = f"postgresql://{DATABASE_USER}:{DATABASE_PASSWORD}@{DATABASE_URL}:" \
                          f"{DATABASE_PORT}/{DATABASE_SCHEMA}"
