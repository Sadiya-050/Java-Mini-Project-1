# Mini Coding Project - 1: Date Calculation and Conversion

**Author:** Sadiya Maheen Siddiqui  
**Version:** 1.0  
**Class:** BE 2nd Year, CSE  
**Roll Number:** 100523733050  

## Project Description
This project performs date-related calculations based on the user's input. The user provides two dates (either **Date of Birth (DOB)** and a reference date or **Age** and a reference date) along with the date format and a delimiter, and the program calculates either the age of a person or their date of birth, depending on the input type.

## Features:
- **Date of Birth Calculation (DOB):**  
  Given an age and a reference date, this feature calculates the user's date of birth.

- **Age Calculation:**  
  Given a date of birth and a reference date, this feature calculates the user's age in years, months, and days.

## Exception Handling:
The program includes custom exception handling using a `UserDefinedException` class. If the user inputs incorrect values or if there are any errors, appropriate error messages are displayed, and the program exits.

## Inputs:
The program expects **exactly 4 command-line arguments**:
1. The first argument should specify the type of calculation, either **DOB** (for Date of Birth) or **AGE** (for Age).
2. The second argument should specify a reference date in the format `DD-MM-YYYY` (or other formats based on user input).
3. The third argument should specify the **date format** (`DD`, `MM`, `YY`) used for the first date input.
4. The fourth argument is the **delimiter** used in the date inputs (e.g., `-` or `/`).

## Example Command Line Inputs:

### 1. **Calculate Age:**
Command:
"DOB=28-02-2001", "27-02-2024", "DD-MM-YYYY", "-"
**Output:**
`Your Age: 23 years, 11 months, 0 days`

3. **Calculate Date of Birth:**
"AGE=27-10-0019", "27-10-2024", "DD-MM-YYYY", "-"

**Output:**  
`Your DOB: 27-10-2001`

## Key Methods:
- **ThrowException:** A helper method to throw and handle custom exceptions.
- **checkDateOrder:** Checks if the given date is after the reference date.
- **calculateDOB:** Calculates the user's date of birth from the given age and reference date.
- **calculateAge:** Calculates the user's age from the given date of birth and reference date.

## Exception Handling:
If the program encounters any invalid input (e.g., incorrect date format, missing arguments, or logical errors such as a reference date earlier than the given date of birth), a custom exception is thrown, and an error message is displayed.
