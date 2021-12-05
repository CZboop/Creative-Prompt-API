CREATE TABLE prompts( id BIGSERIAL PRIMARY KEY,
                        title TEXT NOT NULL,
                        discipline TEXT NOT NULL,
                        info TEXT NOT NULL,
                        minsToComplete INT NOT NULL);