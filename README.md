# Single Activity Android Application

## GitHub Repo:
https://github.com/coreyan1234/cs4520-assignment1-starter-code.git

## Description
This application allows users to login and view a list of products (equipments or foods). Use these credentials to login:

Username: admin

Password: admin

## Project Structure
1. Classes
   - Product
     - Represents the products we can process from the database
   - ProductsAdapter
     - Serves as the connection/middleman between the dataset and the ProductListFragment
2. Activity
   - MainActivity
     - Creates and sets up the initial content view
     - XML
       - Contains instructions for the general layout as well as the navHostFragment so that it keeps track of the navigation between fragments
3. Fragment
   - LoginFragment
     - Screen to display the login interface
   - ProductListFragment
     - Screen to display the list of products
     - Uses a RecyclerView
4. Misc
   - nav_graph.xml
     - Contains the navigation flow between screens/fragments
