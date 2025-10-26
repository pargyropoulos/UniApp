UniApp Project - HOU - Computer Science - 2024-25

Watch the demo (in greek) on YouTube: [YouTube](https://youtu.be/VmBKeNo13hw?si=O9Eo70cj0K7m5mZZ)
<br>

View the html documentation: [html docs](https://grecotron.gr/UniApp/docs/html/)

![image](https://github.com/user-attachments/assets/b799ca47-36af-4b1b-a003-371a41057ed7)
![image](https://github.com/user-attachments/assets/fc990a64-cbf9-491f-acad-c551cc4fca23)


The code utilizes the mediating-controller MVC architectural pattern...
![mediating_mvc](https://github.com/user-attachments/assets/ff190a8f-d873-4f77-9c77-f295b3a79079)


...and extensively employs the Observer behavioural pattern to enhance decoupling.
![image](https://github.com/user-attachments/assets/1c92ad83-ac9c-4eb5-bcaf-0f2d9b7dc471)

Project's Structure:
```
│   Main.java
│   
├───constants
│       ColorConstants.java
│       
├───controller
│       AboutController.java
│       MainController.java
│       SearchController.java
│       SettingsController.java
│       StatisticsController.java
│       UniGridController.java
│       UniRecDialogController.java
│       
├───HTTP
│       WebData.java
│       WebDataFetcher.java
│       
├───META-INF
│       persistence.xml
│       
├───model
│   │   SearchModel.java
│   │   StatisticsModel.java
│   │   UniGridModel.java
│   │   
│   ├───SettingsModel
│   │       ISettingsModel.java
│   │       SettingsDAO.java
│   │       SettingsModel.java
│   │       
│   └───uniRecModel
│           SchoolDepartmentPair.java
│           UniRecDAO.java
│           UniRecDialogModel.java
│           
├───repository
│   ├───entities
│   │       Country.java
│   │       Department.java
│   │       School.java
│   │       University.java
│   │       
│   ├───exceptions
│   │       IllegalOrphanException.java
│   │       NonexistentEntityException.java
│   │       PreexistingEntityException.java
│   │       
│   └───service
│           CountryJpaController.java
│           DepartmentJpaController.java
│           Emf.java
│           SchoolJpaController.java
│           UniversityJpaController.java
│           UniversityService.java
│           
├───utils
│       CustomEvent.java
│       CustomEventSource.java
│       ICustomEventListener.java
│       PDFExporter.java
│       
└───view
    │   AboutView.form
    │   AboutView.java
    │   MainView.form
    │   MainView.java
    │   SearchDialogView.form
    │   SearchDialogView.java
    │   StatisticsView.form
    │   StatisticsView.java
    │   UniGridView.form
    │   UniGridView.java
    │   UniRecDialogView.form
    │   UniRecDialogView.java
    │   Utils.java
    │   
    ├───img
    │       add.png
    │       cancel.png
    │       delete.png
    │       eap.jpg
    │       edit.png
    │       error.png
    │       info.png
    │       logout.png
    │       okIcon.png
    │       pdf.png
    │       save.png
    │       search.png
    │       settings.png
    │       stats.png
    │       uni.png
    │       
    └───settingsForm
            ISettingsView.java
            SettingsView.form
            SettingsView.java
```
![GitHub watchers](https://img.shields.io/github/watchers/pargyropoulos/UniApp?style=social)
![GitHub stars](https://img.shields.io/github/stars/pargyropoulos/UniApp?style=social)
            
