# CS441-Project-5
Objective: This is CS441-Project-5 for summing up numbers that user inputed. All inputs would be display in recycle view and could be deleted by swiping it right or left. 

This application only has one activity which containts a edditable text area with two buttons and two textviews and a recycle view area. Users could input any number in the edditable text area which all inputs would be added to an arraylist and being display in recycle view. I have created an recycle adapter which includes a itemTouchHelper which give the functionality to swipe delete items. By swping items in the recycle view will also delete the number as an object in Arraylist where the sum funciton would call again and notifydatachange function for update adapter would also get called. In addition to add button, a clear button would clear out the list and update the view as well. I also create an pair of save load function by implementing Gson provided by google which convert arraylist to Json and save in data stoage. The load function would recover the Json data to arraylist which is being display in recycle view. The save function would be call in while the app on pause and the load function would be called while the app is on create stage. By doing this, the data could be save and recover automatically. 

Timeline:
7/11: Inital project
7/12: Added basic layout
7/13: Change some layout setting
7/14: Create recycle view and recycle adapter
7/15: Added add and clear functions, the app now can add and delete items list in recycleview while a sum of all number would be displayed accrodingly.
7/16: Added swpie delete and save&recover feature to the app.
7/17: Wrap up the project,update README
