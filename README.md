# CS-Capstone.github.io
## Welcome to Computer Science Capstone/Inventory Application
by Justin Fields



Site link - https://jfields82.github.io/CS-Capstone.github.io/ 

Computer Science Capstone page is to gained a wide exposure to concepts, languages, practices, and techniques relevant to computer science and related career fields. 


For the last 2 and a half years I was in rolled in the computer science program at Southern New Hampshire University. It’s been a very fun, challenging and great experience.

When I first started this program I was in my late 20s. I wasn’t too sure if I wanted to go back to school again since I’m in my late 20s finishing my bachelors degree. I felt like maybe I was a little too old but I was always interested in software engineering and computer science. That’s when I made the decision to get my degree in computer science I had a passion for it. I first got interested in computer science when I took a simple business class that focused on e-commerce businesses. They had us programming a simple website. These courses fun but very challenging help me too show my skills and strength and software development.

A few courses in particular like CS-360 Mobile architecture and programming and CS-340 Advanced programming concepts these two courses are the main parts of this project. I spent many hours to write the final application it is a user interface application. I picked the inventory application because it focused on design, architecture, storage and database. I used a few programming languages like Java and HTML/Javascript these are great languages when you’re working on applications that are for design and databases. I have a lot of familiarity using Java and HTML/Javascript.

In the computer science program at Southern New Hampshire University my future professional goals have changed I thought I would be more into algorithms and artificial intelligence. But when I took my second computer science class in object oriented analytics and design we learned about the different processes an example Scum and Waterfall.



###  Code Review




https://user-images.githubusercontent.com/12861265/138210749-bc70167f-bf6f-4e91-af31-fc27b151d077.mp4



Initializing and linking elements to the xml
page (activity_main)

Designs patterns I use is mvc.

Send a Toast message if the command was successful or wrong.



###  Software Design and Engineering
The artifact I picked was from my previous class CS 360 Mobile Architecture and Programming the project is an inventory app. Your able to store items and select items in the inventory app. The Java file was made a few months ago. Because of this I learned a lot of new things during my time in that class. Learning about variables help me create better databases. This is the reason I chose to pick this project. I wanted this artifact in my e-portfolio because this will show how familiar I am with Java programming a popular object-oriented programming language. This will also show that I am extremely comfortable and familiar with object-oriented software design patterns. The artifact was enhanced by renaming a few variables that were not entirely clear. Use only lowercase for database column names is a frequent practice. This will stop unexpected behaviors during data access. Example down below. This is my DatabaseHelper.java file. 


     @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Password TEXT)"); 
        } 
        
    

      public class DatabaseHelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME="register.db";
        public static final String TABLE_NAME="registration";
        public static final String COL_1="ID";
        public static final String COL_2="Name";
        public static final String COL_3="Password";
        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }
      
         
        
Also, I need to make these fields private and add Setter and Getters. Example down below. I also fix some of the errors in “super(context, DATABASE_NAME, null, 1)” they were spelling errors.

 I made sure to add more comments to the code so anyone who read the comments and files will be able to understand what I was doing. I also learn to make sure the code is well-structured and consistent in style.


 
###  Algorithms and Data Structure

The artifact I picked was from my previous class CS 260: Data Structures and Algorithms and CS 250: Software Development Lifecycle the project is an inventory app. Your able to store items and select items in the inventory app. The Java file was made a few months ago. Because of this I learned a lot of new things during my time in that class. Learning about “if and else” statement help me create better databases. This is the reason I chose to pick this project. I wanted this artifact in my e-portfolio because this will show how familiar I am with Java programming a popular object-oriented programming language. 

I improved the code by creating less “if and else” statements. Also getting rid of lines of code that can easy be stored in variables. Because of this my application run much faster. I then created a file for users who forgot their password. The user enters their email and when they entered their email, the program check for the email is there and will allow the user to change the password.

![image](https://user-images.githubusercontent.com/12861265/137578994-f56c3385-3034-4df4-89d8-9fff2559478f.png)


From the feedback I got back from my last module was needed to type in more comments. I also had to create a second database for password change for the emails that were store. This database was for password, usernames, and email. My database became more complex from the first database because I added an emails file.
Some challenges were when I was creating my Password change file. I had to find the right password function for the file to work. Then I remember there a function called `tools.context` so I use that function.

I added the function `tools:context=".PasswordChange">` and `android:layout_width="match_parent` to enable users to create a new password. Learning to create store variables is a short cut because in the past I would type lines of code that can take to much time and could slow down the program when running the program. This way the code has better data structures and is easier to read.



###  Databases

The artifact I picked was from my previous class CS 340: Advanced Programming Concept. The Java file was made a few months ago. Because of this I learned a lot of new things during my time in that class. Learning about Vector help me create better databases. 

![image](https://user-images.githubusercontent.com/12861265/137579190-31c84497-6d18-4b55-9195-5825123f6e1e.png)

This is the reason I chose to pick this project. I wanted this artifact in my e-portfolio because this will show how familiar I am with Java programming a popular object-oriented programming language. It was originally written in java programming. I use the concept from the class to add JavaScript to the application.  This was for the design of the project. Like the shape of the application and web based/browsers. I created an apk file to show up on any browser. Also creating a Database were username, password and forgetting password. My project shows my skills as a developer. I add the CRUD operation for interacting with the Database. I completed the Database artifact enhancement. 

![image](https://user-images.githubusercontent.com/12861265/137579215-009eb230-85fe-48ff-b284-089c695a54d9.png)

![image](https://user-images.githubusercontent.com/12861265/137579225-bf1285a3-f564-4a1f-9ec0-0c223fe0905a.png)



You can use the [editor on GitHub](https://github.com/jfields82/CS-Capstone.github.io/edit/gh-pages/index.md) to maintain and preview the content for your website in Markdown files.

Whenever you commit to this repository, GitHub Pages will run [Jekyll](https://jekyllrb.com/) to rebuild the pages in your site, from the content in your Markdown files.


For more details see [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/).

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in your [repository settings](https://github.com/jfields82/CS-Capstone.github.io/settings/pages). The name of this theme is saved in the Jekyll `_config.yml` configuration file.

### Support or Contact

Having trouble with Pages? Check out our [documentation](https://docs.github.com/categories/github-pages-basics/) or [contact support](https://support.github.com/contact) and we’ll help you sort it out.
