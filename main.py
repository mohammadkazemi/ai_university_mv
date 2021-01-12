from typing import List

import uvicorn

from fastapi import Depends, FastAPI, HTTPException
from sqlalchemy.orm import Session

from . import crud, models, schemas
from .database import SessionLocal, engine

models.Base.metadata.create_all(bind=engine)

app = FastAPI()


# Dependency
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()


@app.post("/user/", response_model=schemas.User)
def create_user(user: schemas.UserCreate, db: Session = Depends(get_db)):
    db_user = crud.get_user_by_email(db, email=user.email)
    if db_user:
        raise HTTPException(status_code=400, detail="Email already registered")
    return crud.create_user(db=db, user=user)


@app.post("/login/", response_model=schemas.User)
def login_user(user: schemas.UserLogin, db: Session = Depends(get_db)):
    db_user = crud.get_user_by_email(db, email=user.email)
    if not db_user:
        raise HTTPException(status_code=400, detail="This email is not registered")
    return db_user


@app.get("/users/", response_model=List[schemas.User])
def read_users(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    users = crud.get_users(db, skip=skip, limit=limit)
    return users


@app.get("/users/{user_id}", response_model=schemas.User)
def read_user(user_id: int, db: Session = Depends(get_db)):
    db_user = crud.get_user(db, user_id=user_id)
    if db_user is None:
        raise HTTPException(status_code=404, detail="User not found")
    return db_user


@app.post("/user/{user_id}/votes/", response_model=schemas.Vote)
def create_vote_for_user(user_id: int, vote: schemas.VoteCreate, db: Session = Depends(get_db)):
    return crud.create_vote_for_user(db=db, vote=vote, user_id=user_id)


# todo solving this problem response turn into warning
@app.post("/user/{user_id}/teacher_votes/", response_model=schemas.TeacherVote)
def create_teacher_vote(user_id: int, teacher_vote: schemas.TeacherVoteCreate, db: Session = Depends(get_db)):
    return crud.create_teacher_vote(db=db, teacher_vote=teacher_vote, user_id=user_id)


# todo solving this problem response turn into warning
@app.post("/user/{user_id}/education_employee_votes/", response_model=schemas.EducationEmployeeVote)
def create_education_employee_vote(user_id: int, education_employee_vote: schemas.EducationEmployeeVoteCreate,
                                   db: Session = Depends(get_db)):
    return crud.create_education_employee_vote(db=db, education_employee_vote=education_employee_vote, user_id=user_id)


@app.get("/votes/", response_model=List[schemas.Vote])
def read_votes(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    votes = crud.get_votes(db, skip=skip, limit=limit)
    return votes

# if __name__ == '__main__':
    # uvicorn.run(app, host="localhost", port=8000)
