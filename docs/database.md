
# Schema

## Tables

# Users

| Column name | Data type                    |
|-------------|------------------------------|
| id          | int(5) AUTO_INCREMENT PK     |
| first_name  | varchar(255) NOT NULL        |
| last_name   | varchar(255) NOT NULL        |
| email       | varchar(255) UNIQUE NOT NULL |
| password    | varchar(255) NOT NULL        |
| created_at  | timestamp                    |
| updated_at  | timestamp                    |


# Roles

| Column name | Data type                 |
|-------------|---------------------------|
| id          | int(5) AUTO_INCREMENT  PK |
| name        | varchar(255) NOT NULL     |


# User_roles

| Column name | Data type                               |
|-------------|-----------------------------------------|
| user_id     | int(5) FK(user_id) REFERENCES users(id) |
| role_id     | int(5) FK(role_id) REFERENCES roles(id) |



# Hotels

| Column name | Data type                |
|-------------|--------------------------|
| id          | int(5) AUTO_INCREMENT PK |
| name        | varchar(255) NOT NULL    |
| stars       | int(5)                   |
| address     | varchar(255) NOT NULL    |
| city        | varchar(255) NOT NULL    |
| country     | varchar(255) NOT NULL    |
| description | text                     |
| created_at  | timestamp                |
| updated_at  | timestamp                |


# Rooms

| Column name     | Data type                                         |
|-----------------|---------------------------------------------------|
| id              | int(5) AUTO_INCREMENT PK                          |
| number          | int(5)  NOT NULL                                  |
| price_per_night | decimal(10,2) NOT NULL                            |
| description     | text                                              |
| capacity        | int(5) NOT NULL                                   |
| room_category   | varchar(255) NOT NULL                             |
| room_type_id    | int(5) FK(room_type_id) REFERENCES room_types(id) |
| hotel_id        | int(5) FK(hotel_id) REFERENCES hotels(id)         |
| created_at      | timestamp                                         |
| updated_at      | timestamp                                         |




# Room_types

| Column name | Data type    |
|-------------|--------------|
| id          | int(5)  PK   |
| name        | varchar(255) |


# Bookings

| Column name     | Data type                               |
|-----------------|-----------------------------------------|
| id              | int(5) AUTO_INCREMENT PK                |
| reference       | VARCHAR(50) UNIQUE NOT NULL             |
| check_in_date   | date                                    |
| check_out_date  | date                                    |
| subtotal        | decimal(10,2) NOT NULL                  |
| total           | decimal(10,2) NOT NULL                  |
| total_guests    | int(5) NOT NULL                         |
| discount_amount | decimal(10,2) DEFAULT NULL              |
| discount_code   | varchar(255)  DEFAULT NULL              |
| currency        | varchar(3)  DEFAULT DKK                 |
| total_nights    | int(5)  NOT NULL                        |
| status          | varchar(255) DEFAULT PENDING            |
| room_id         | int(5) FK(room_id) REFERENCES rooms(id) |
| user_id         | int(5) FK(user_id) REFERENCES users(id) |
| created_at      | timestamp                               |
| updated_at      | timestamp                               |


# Offers

| Column name   | Data type                                            |
|---------------|------------------------------------------------------|
| id            | int(5) AUTO_INCREMENT PK                             |
| code          | varchar(255) NOT NULL                                |
| max_users     | int(5) NOT NULL                                      |
| use_count     | int(5) NOT NULL                                      |
| valid_from    | date                                                 |
| valid_to      | date                                                 |
| active        | tiny int                                             |
| value         | decimal(10,2) NOT NULL                               |
| created_at    | timestamp                                            |
| updated_at    | timestamp                                            |
| offer_type_id | int(5)  FK(offer_type_id) REFERENCES offer_types(id) |


# Offer_types

| Column name | Data type             |
|-------------|-----------------------|
| id          | int(5)   PK           |
| type        | varchar(255) NOT NULL |


# booking_offers

| Column name    | Data type                                     |
|----------------|-----------------------------------------------|
| booking_id     | int(5) FK(booking_id) REFERENCES bookings(id) |
| offer_id       | int(5) FK(offer_id) REFERENCES offers(id)     |
| applied_amount | decimal(10,2) NOT NULL                        |


## Relationships

# One to many

- user -> bookings
- hotel -> rooms
- user_role -> users
- Booking -> rooms
- room_type -> rooms
- offer_type -> offers

# Many to many
 
- Offer -> rooms
- User -> offers

# One to one


## Constraints

- Users UNIQUE(email) NOT NULL
- Rooms UNIQUE(hotel_id, number)
- Rooms CHECK ( room_category IN ( 'ADULT', 'KIDS','MIXED') )
- Bookings CHECK ( status IN ( 'PENDING', 'CONFIRMED', 'CANCELLED', 'COMPLETED') )
- Bookings CHECK (check_out_date > check_in_date)
- Offers CHECK (value >= 0)


## Indexes

- Bookings (room_id, check_in_date, check_out_date)
- Users (email)
- Offers (code)