# PSU SWENG-888 ListView

## Description
For this assignment, you will be asked to develop an Android app that displays a list of items using ListView. The user should be able to click on an item to view its details in a separate activity. The app should use explicit intent to navigate between activities and pass information between them. When the user clicks on an item, a visual notification should be triggered, displaying the item's details in a Toast or Snackbar.

**Requirements**
- The app should have a main activity that displays a list of items using ListView. Each item should have a title and a subtitle.
- The app should use a data model class to represent each item in the list.
- The app should use an Adapter class to populate the ListView with the list items.
- The app should implement an OnClickListener to handle clicks on the list items.
- When the user clicks on an item, the app should use explicit intent to navigate to a second activity that displays the details of the item.
- The second activity should receive the data model object for the clicked item as an intent extra.
- The second activity should display the item's details, including the title, subtitle, and any other relevant information.
- When the user returns to the main activity from the second activity, the app should display a Toast/Snackbar indicating that the operation occurred successfully.

**Bonus Features**
- Add an image to each item in the list.
- Replace the Toast with a Snackbar.

**Deliverables**
- The source code for the Android app.
- A brief write-up explaining the key design decisions and challenges faced during the development process.
- A video demonstrating the app's functionality.




