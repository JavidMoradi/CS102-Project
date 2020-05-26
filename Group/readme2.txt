+ Instructor's Name: David Davenport
+ TA's Name: Pouya Ghahramanian

+ Project Group Number: g3E
+ Project Title: JHub

+ Project Description: Jhub is a desktop application that enables lab assistants to review the codes of students, and give better feedback. Students can also check their works, and their mistakes by using this program. Jhub is an Integrated Review Environment (IRE) and only implied for giving/taking feedback on one or many java classes. Our program also employs a user-Friendly interface that improves the user experience by providing complete access to all the features with just one click. Moreover, to avoid losing any work, an autosaving feature was implemented.
+ Project's Current Status: 90% Working.

+ Whats Working and What's Not Working: Mostly everything is working, but there are still some bugs present:
  - in some situations the comment-handling mechanism misbehaves, and some peculiarities start arising.
  - In some rare occasions, changing files from within the program results in the embedded comments and highlights to be displayed as       text.
  - When renaming the buttons, the names in the ErrorSettingsPanel don't change.

+ Group Members And Their Respective Parts
  - Ahmet Salman: Mainly worked on the FileOptionsPanel, which is the file-managment mechanism aspect of the project, which includes,       but not limited to, the "Save", "Open", "Close", and "New" File.
  - Atasagun Samed Şanap: Worked on HomeOptionsPanel, NewCommentPanel, ErrorSettingsPanel, ErrorSettingFrame
  - Hissam Faramawy: TextLineNumber, Comment, CommentModel, CommentShowPanel, EditorAreaPanel
  - Javid Moradi: HomeOptionsPanel, GUI Design
  - Onuralp Avcı:
  - Tuna Öğüt: Worked on managing multiple files, which is FileExplorerPanel and FileOptionsPanel, I contributed with some methods to       CommentsModel.

+ Software Details:
  - We built a traditional desktop computer application, thus we didn't use any sort of external technologies such as mySQL, or Android     Studio.
  - First of all, JDK 14 must be used for the GUI of our program to be displayed correctly.
  - Import the Following Libraries:
    * org.apache.commons:commons-lang3:3.9.
    * com.jtattoo:JTattoo:1.6.13.
  // This is all what's needed for the code to execute properly, (HOPEFULLY!).
  
  
  
 + Notes:
 - An external class ( TextLineNumber ) was implemented from an online source to aid us in some aspects of the development process, we added our modifications on top of the base version.
 
 + Works Cited:
 - // To Be Written
