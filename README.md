# Google Form Automation

## Challenges Ahead!
In this Buildout, we will be automating the process of filling out a Google form using Selenium, TestNG, and Java.

## Important
- Create a TestNG method named `testCase01` and write the automation code there.

## Activity
The automation script will perform the following steps:

1. **Navigate to the Google Form**
   - Open the specified Google form URL.

2. **Fill in the First Text Box**
   - Enter `"Crio Learner"` in the first text box.

3. **Enter a Custom Message with Current Epoch Time**
   - Write `"I want to be the best QA Engineer! 1710572021"` in the second text box, where `1710572021` should be dynamically replaced with the current epoch time.

4. **Select Automation Testing Experience**
   - Choose the appropriate radio button indicating your experience in automation testing.

5. **Select Programming Tools**
   - Check the boxes for `Java`, `Selenium`, and `TestNG`.

6. **Provide Preferred Name**
   - Choose how you would like to be addressed from the dropdown list.

7. **Enter a Date (Current Date Minus 7 Days)**
   - Dynamically calculate the date as today’s date minus 7 days and fill it in the date field.

8. **Set Time to 07:30**
   - Enter the time `07:30` in the appropriate field. This can be in 24-hour format.

9. **Submit the Form**
   - Submit the form.

10. **Print Success Message**
    - Upon successful submission, capture the success message displayed on the form and print it to the console.

## Project Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Azhar041189/ME_QA_XGOOGLE_FORM.git
