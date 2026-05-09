## Story
As a user
I want to book an available room,
So that I get my dream room

## Acceptance criteria

- User sees confirmation page on success
- Invalid input show validation error
- The room should not be able for booking in the same time period when a booking is finalized
- Check-out date must be after check-in date
- Past dates are not allowed

## Story

As a user,
I want to see more details about a room,
so that I can decide what room is the best

## Acceptance criteria
- User can see a mould when clicking a "show more button"


## Story

As a user,
I want to an overview of all my booking,
so that I can easily see what I have booked

## Acceptance criteria

- User can see all his/her booking
- User can se both previous, currently and upcoming bookings
- User are available to only see his/her own booking
- User are shown error messages if tying to access other users booking.
- Unauthenticated users are redirected to login page

## Story

As a user,
I want to search available rooms,
so that I can find a room matching my needs.

## Acceptance criteria

- User can search by date
- User can filter by room type
- User only sees available rooms
- Invalid dates show validation error


## Story

As an admin,
I would like to be able to create new rooms,
so user have a bigger pool of rooms to select from.

## Acceptance criteria

- Admin sees confirmation page/messages on success
- Invalid input show validation error
- The room should be available for booking
- Non-admin users are redirected to home page
- Unauthenticated users are redirected to login page
- Room must have room number
- Room must have room type (standard, suite, deluxe suite)
- Room must have how many guest it is suitable for
- Room must have price per night
- Room must be for adult, kids or mixed
- Room can have description
- A room must belong to a hotel
- All the rooms in have unique numbers
- Trying to use existing room number will result in validation error

## Story

As an admin,
I am able to edit a room,
So that users always sees correct information

## Acceptance criteria

- Admin sees confirmation page/messages on success
- Invalid input show validation error
- The updated at timestamp should reflect
- Non-admin users are redirected to home page
- Unauthenticated users are redirected to login page
- The room number is not editable
- Trying to edit the room number will result in validation error

## Story

As a user,
I want to authenticate,
so that I can access protected functionality.

## Acceptance criteria

- User can log in with valid credentials
- Invalid credentials show error
- Session is created on successful login
- User role determines access level

## Story

As an admin,
I can create coupons/offers,
So that users can get the best price

## Acceptance criteria

- Invalid input show validation error
- Admin sees confirmation message on success
- The created at timestamp should reflect
- Non-admin users are redirected to home page
- Unauthenticated users are redirected to login page


## Story

As the system,
I must validate coupon constraints,
so invalid coupons cannot be created.

## Acceptance criteria

- Coupons/offers codes needs to be unique
- Coupons/offers need to within valid date range
- The valid from date can be in the future
- The valid from date can not be before the current date
- The valid to date cannot come before the valid from date
- Voupons/offers can not have negative discount amount
- Trying to use existing coupons/offers code will result in validation error
- Voupons/offers can be on of the following (gift card, percentage, fixed)
- Gift card are valid for 3 years
- Coupons/offers can be limited to all or a group of users
- Coupons/offers can be limited to  all or a group of rooms


## Story

As a user,
I can use coupons/offers,
so that I can get a discount

## Acceptance criteria

- Invalid coupons/offers show validation error
- User sees confirmation message on success
- Total amount and subtotal should reflect when the coupons/offers is applied
- User can only use one coupon/offer when booking
- Expired coupons cannot be applied
- Inactive coupons are rejected
- Discount cannot reduce total below zero

## Story

As an admin
I can edit coupons/offers,
so users get the most out of it

## Acceptance criteria

- Invalid input show validation error
- Admin sees confirmation message on success
- The updated at timestamp should reflect
- Non-admin users are redirected to home page
- Unauthenticated users are redirected to login page


## Story

As an admin,
I can remove/delete a coupons/offers,
so it easy to know witch are active

## Acceptance criteria

- The discount is not applied
- User sees validation error when trying to use the coupon/offer
- The coupons/offers is set to not active or expired in the admin GUI

## Story

As an admin
I can create newsletters,
so users are updated with offers and new rooms

## Acceptance criteria

- Admin sees confirmation message on success
- Non-admin users are redirected to home page
- Unauthenticated users are redirected to login page
- Email is sent to all how subscribed for the newsletters

## Story

As a user,
I want the system to prevent double bookings,
so that two users cannot reserve the same room simultaneously.

## Acceptance criteria

- Only one booking can exist for overlapping periods
- Concurrent requests cannot create duplicate bookings
- User sees availability error if room becomes unavailable
- Failed bookings are rolled back