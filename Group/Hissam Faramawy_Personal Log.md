Hissam Faramwy
-

21901253
-

On this page I will keep a weekly record of what I have done for the CS102 group project. This page will be submitted together with the rest of the repository, in partial fulfillment of the CS102 course requirements.

1st Week ( 3/02/2020 - 9/02/2020 ) we formed our group and agreed to start thinking of good ideas

2nd Week ( 10/02/2020 - 16/02/2020 ) we discussed some ideas and agreed on a project idea after discussing how practical and applicable it is

3rd Week ( 17/02/2020 - 23/02/2020) we met to discuss how we are going to conducte our project and also prepared for the presentation.

4th Week ( 24/02/2020 - 01/03/2020 ) we did the presentation but the idea got rejected by Mr Davenport becasue it was not quiet applicible.

5th Week ( 2/03/2020 - 8/03/2020 ) We gathered to think of more ideas and I and other two members suggested 3 ideas in total and asked Mr Davenport for his opinion. He liked one of them but most of the members thought it is hard to actually build.

6th Week ( 9/03/2020 - 15/03/2020 ) Mr Davenport suggested his idea of Code Reviewer. And we accepted it.

7th Week ( 16/03/2020 - 22/03/2020 ) We started to thhink how should we start and built the UI design and agreed on it as an elementary design. Ahmed designed the UI and Onur created the acctual code for it.

8th Week ( 23/03/2020 - 29/03/2020 ) Corona epidimic forced us to stay home and we could not meet anymore. However, we did online meeting and it turned out that it was more efficient in many aspects. We specified the works and split them among us. I and took the responsibility of developing the comment related code.

9th Week ( 30/03/2020 - 5/04/2020 ) I start to create an outlined mechanism with which the user can select a segment of the code and make a comment on it. The elementry prototype of the mechanisme I developed required getting information from the JTextArea regarding the start and end indexes of the selected segment. After doing some research, I made the program able to get the indexes of the selected segment and communicate it with the highlighting buttons. The buttons was still not actually highlighting though.

10th Week ( 6/04/2020 - 12/04/2020 ) I made the buttons able to highlight with different colours. Also I made two new classes. Comment class to have all the properties of each comment, such as the acctual comment string, start and end indexes ( to easier highlight or un highlight the comment any time), the line number ( to later navigate the line of the comment), highlight color. The other class is CommentsModel class with commentsBag in to carry the comments and conduct Comment-related operations. Later on, Me and Onur created another class ( ShowCommentsPanel) that has a JList to show all the comments.

11th Week ( 13/04/2020 - 19/04/2020 ) I made the communication between the JList and the JTextArea and created a pointer method that takes the line number of the comment selected in the JList and point it out on the JTextArea ( pointing out was basicly adding the string ">>" beside the selected comment). I then implemented a new class ( TextLineNumber) to show the line numbers on the left of the JText area panel. 

12th Week ( 20/04/2020 - 26/04/2020 ) I made tweaks on the code to make it better performing and fixed some bugs, such as a bug of pointing the selectd line and then remove the pointer and add new one when another comment is selected from the JList.

13th Week ( 27/04/2020 - 3/05/2020 ) I and Onur started to render the delete button functioning. We found out that we were warking at that part at the same time, so we later met to see each others progress and sort of merged our work. Onur surprised me with new mechanism of pointing out the selected comment. It was making the highlight of the selected comment more bright so that it is destinguishable from other comments. We really liked that and decided to use it insted of the previous pointer ( ">>") mechanism. 

14th Week ( 2/03/2020 - 8/03/2020 ) I implemnted a new method that sorts the comment in order ( with respect to the line number) each time the user add a new comment. By the end of the week, I made a the program able to navigate the selected comment( that's it, scrolling down or up if the selected line number was not appearing at the shown part of the JTextArea). It took me too much time to figure out how to do this. But it was important for the user experience and was beautiful to see it working at the end. It paid off! 

15th Week ( 9/03/2020 - 16/03/2020 ) I fixed a bug that happens when a comment is selected from the ShowCommentPanel and a new Comment is added at the same time. Later on, I and Onur gathered to divide more work. He took the part of making the "Insert A Comment" Button actually function, and he finished it at the same day. I took the responsiblity of making the organization of the CommentShowPanel; that's it, to show the file-related comments, when a different file is selected. I finished that part by the end of the day. Also, I fixed a bug that makes the JText Area scroll down to the bottom of the text every time a different file is selected. Now it shows the Text from the top when alternating between files as well as when openning a new file. 

16th Week ( 17/03/2020 - /03/2020 ) During the last week and this week I and Ahemd had been meeting to fix some serious bugs. In about 4 days we finished fixing the following bugs ( Some of them ocurred after fixing aother bugs!): 

   -all comments of all files were mixed and shown in comments-show panel >> now the comments shown are changing according to the selected file
   
   -When saving files for the second time the program was saving the comments' indexes as 0 >> now it save them with their correct indexs
   
   -When opennig a saved file with certain conditions, the highlighting mechanisme was not acting as intended >> now the highlight mechanisme is working well.
   
There remained one last bug which occurs when opennig two saved files, and I fixed it at the end. What remained now is to put the last touches and record the project Demo! in this week and the previous one,  our team had lots of work. 
   
 
