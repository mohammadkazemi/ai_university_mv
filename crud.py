from sqlalchemy.orm import Session
import models, schemas

    """[گرفتن اطلاعات یوزر از دیتا بس با ادی او ]
    """
def get_user(db: Session, user_id: int):
    return db.query(models.User).filter(models.User.id == user_id).first()

    """[گرفتن تمام یوزر ها از دیتا بیس]
    """
def get_users(db: Session, skip: int = 0, limit: int = 1000):
    return db.query(models.User).offset(skip).limit(limit).all()

    """[گرفتن یوزر با ایمیل]
    """
def get_user_by_email(db: Session, email: str):
    return db.query(models.User).filter(models.User.email == email).first()

    """[اضافه کردن یوزر به  دیتا بیس]
    """
def create_user(db: Session, user: schemas.UserCreate):
    fake_hashed_password = user.password + "not_really_hashed"
    db_user = models.User(email=user.email, hashed_password=fake_hashed_password,
                          name=user.name,
                          is_student=user.is_student,
                          is_teacher=user.is_teacher,
                          is_education_employee=user.is_education_employee)
    db.add(db_user)
    db.commit()
    db.refresh(db_user)
    return db_user

    """[اضافه کردن رای دانشجو به دیتابیس]
    """
def create_vote_for_user(db: Session, vote: schemas.VoteCreate, user_id: int):
    db_vote = models.Vote(**vote.dict(), owner_id=user_id)
    db.add(db_vote)
    db.commit()
    db.refresh(db_vote)
    return db_vote

    """[اضافه کردن رای معلم به دیتابیس]
    """
def create_teacher_vote(db: Session, teacher_vote: schemas.TeacherVoteCreate, user_id: int):
    db_teacher_vote = models.TeacherVote(**teacher_vote.dict(), owner_id=user_id)
    db.add(db_teacher_vote)
    db.commit()
    db.refresh(db_teacher_vote)
    return db_teacher_vote

    """[اضافه کردن رای کادر اموزشی به دیتابیس]
    """
def create_education_employee_vote(db: Session, education_employee_vote: schemas.EducationEmployeeVoteCreate,
                                   user_id: int):
    db_education_employee_vote = models.EducationEmployeeVote(**education_employee_vote.dict(), owner_id=user_id)
    db.add(db_education_employee_vote)
    db.commit()
    db.refresh(db_education_employee_vote)
    return db_education_employee_vote

    """[گرفتن تمام رای ها از دیتابیس]
    """
def get_votes(db: Session, skip: int = 0, limit: int = 1000):
    return db.query(models.Vote).offset(skip).limit(limit).all()
