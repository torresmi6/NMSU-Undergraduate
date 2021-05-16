HOW TO

All Buttons have descriptive labels.
For Insertion methods, the Single insertion and Multi-Row insertion can access the file from anywhere.
These buttons automatically bring up the file chooser dialog box.

The Load Data method must use a file that is located in the secure_priv_use directory specified by MySQL.
Looks something like: C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/file_name.txt

The home button is accessible from any panel and will take you back to the home screen.

Retrieve All outputs the table in a new window. Closing this window does not affect the GUI. You must go back
to the original window to continue interacting with the GUI.


DATA INSERTION TIMES

Single Insertion
Dataset 1 (1,000 tuples): 175165 ms
Dataset 2 (100,000 tuples): 111920263 ms
Dataset 3 (1,000,000 tuples): 111032005 ms

Multi-Row Insertion
Dataset 1 (1,000 tuples): 1085 ms
Dataset 2 (100,000 tuples): 22962 ms
Dataset 3 (1,000,000 tuples): 213831 ms

File Load
Dataset 1 (1,000 tuples): 286 ms
Dataset 2 (100,000 tuples): 6614 ms
Dataset 3 (1,000,000 tuples): 288144 ms

The Load Data method was clearly the fastest at inserting data for all three datasets. If the datasets were much smaller,
I'm sure the other data insertion methods would have a chance at being faster.