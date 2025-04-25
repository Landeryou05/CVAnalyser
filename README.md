CVAnalyser
==========

Prerequisites
-------------
To be able to run this program, please ensure you have the following prerequisites.
- Java 11 or Newer
- Apache Maven
- Internet Connection

Git Cloning
-----------
To clone this repository, run the following command in your terminal:

    git clone https://github.com/Landeryou05/CVAnalyser.git

Dependencies
------------
This project uses **Stanford CoreNLP** for Natural Language Processing (NLP).  
This project also uses **Apache Tika** for converting text in a range of documents, such as PDF, DOCX, etc to a string format.
The required dependencies have been included in `pom.xml`.

To ensure all dependencies are correctly installed, run:

    mvn clean install

Manually Installing CoreNLP (if needed)
---------------------------------------
If the above command does not work, you may need to manually install Stanford CoreNLP:

1. Download CoreNLP from the official site:  
   https://stanfordnlp.github.io/CoreNLP/
2. Extract the `.zip` file and place it inside your project directory.
3. Add the required `.jar` files to your environment.

Running the Program
-------------------
This entry point of the program is through the 'Main.java' class.
