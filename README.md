## Calculate.java JUnit Test
### Installation on Eclipse:

0. Download all of the files by clicking "Download ZIP" in the top right corner of this page.
1. Right click A **DUMMY PROJECT**, **NOT THE CALCULATE LIBRARY** (Access Calculator project is fine) --> New --> JUnit Test Case
2. Select "New JUnit Jupiter Test"
3. Name it the same name as the CalculateTester version you are using (Generally `CalculateTester[PART]_[VERSION].java`)
4. Leave the rest of the options alone. Hit "Finish"
5. If a popup about JUnit5 not being on the build path pops up, make sure "Add JUnit5..." is selected under "perform the following action". Then click ok.
6. Copy and paste the CalculateTester code, replacing anything automatically generated
7. Right click CalculateTester then go to Build Path --> Configure Build Path. Go to the projects tab and add the Calculate project if it isn't already there. Click Apply and Close
8. Click run. If a JUnit windows doesn't pop up, click the small arrow next to the run button and select CalculateTester
9. You should get some errors. Now nagivate to your workspace/Dummy Project/bin folder and place the csv files here
10. Now run the CalculateTester file again. All tests should now work and if your project is correct, it should pass.

### Updating:

0. Download all of the new files by clicking "Download ZIP" in the top right corner of this page.
1. Take note of the name of the updated file
2. In eclipse, right click the old CalculateTester then go to --> Refactor --> Rename
3. Rename it to the name in step 1. Check the "update references" options, uncheck the rest. Save.
4. Copy the updated code and paste it into the CalculateTester file, replacing everything that was there.
5. Nagivate to your workspace/Dummy Project/bin folder and place the new csv files here. Overwrite the files if asked

### Removal:

1. Right-click --> delete the CalculateTester.java
2. Then right click the project then go to Build Path --> Configure Build Path. Go to the Libraries tab and delete the JUnit library. Click Apply and Close
3. Delete the csv files from the project bin folder.

### Tips:
- As of now, the software will expect `NaN` to be returned if the output is not a number (i.e. dividing by zero)
- Fractions are NOT to be reduced to simplist form for Mixed Number <---> Improper fraction methods (i.e. denominator should not change)
- Negative signs go with the number if there is no term before it, or if there is a term before it, make it a minus sign with a space in between, i.e. `-2x - 3`
- When there is a variable, do not include a coefficient of 1 or -1, rather dropping it or adding the - as appropriate
- 0 is 0, no 0/5 or an empty string or something, just return 0.
- For stuff that returns strings, be wary of spaces before/after that shouldn't be there
- Do NOT round; the checker automatically rounds as needed to take into account floating point number rounding
- For the purposes of this checker, Mixed numbers will only have a negative in the whole number part if at all, and it applies to the entire mixed number. However, if the whole number part is 0, the numerator may have a negative that needs to be respected. Otherwise you can assume it is positive. i.e. -3_2/3 --> -3 - 2/3 --> -11/3, not -3 + 2/3. You may also get -7/8 or something, which should just translate right back to -7/8.
	- If you want to get fancy, you can always do input validation

### Last words:
- This is NOT "official" by the teacher, and as such may not test the things correctly. Follow instructions over what my tests say
- The tests will still run even if you didn't fully complete a part, just all of the tests for that method will fail and you may need to click "ok" to ignore the warning.
- I make mistakes, *please* feel free to ping me if there is a mistake somewhere
- To keep things clean, only the latest version will be posted, though if you need an older version, use the git history feature to find it

### Current status:
Part 1: Done!
Part 2: Done!
Part 3: Not started yet
Part 4: Not started yet
Part 5: Not started yet
