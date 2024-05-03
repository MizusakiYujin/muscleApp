CREATE TABLE training_recode (
    id SERIAL NOT NULL ,
    training_name varchar(50),
    weight varchar(6),
    rep varchar(3),
    create_date DATE,
    primary key (id)
);