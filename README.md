# LocationBuddy
A small project worked on by a group of friends using Java and Intellij

Using http://openweathermap.org/ 's API we are able to get real time temperature information about any city in the world. The DataPull class is the main file that does the API interaction. The program will have a main class for user interaction, and a variety of functionalities to choose from, each of which involving their own design pattern.


# Intellij vs Netbeans rundown

Things work a a bit differently in Intellij than Netbeans. As you guys are probably noticing, there's no immediate 'package' hierarchy
like there is in Netbeans. This is actually somewhat convenient for our cause. We're only dealing with one package, and therefore have no need to implement one.

All Java files belong in the "src" directory. You can extend classes and implement interfaces freely as long as all files here.

All modules will most likely branch outwards from our main data pulling file. I'll make sure to include easy-to-use methods for ease of access.
* Please make all new modules on a new branch, and submit a merge request when done. That way if anything goes wrong locally, our main program is still afloat.

In addition to easy VCS use, Intellij has Maven integration, allowing dependencies of any external libraries you guys want to be added really easily.
If you guys want to add a dependency, just go to File >> Project Structure >> Modules >> Dependencies >> Green plus button >> Libary >> Maven and search for whatever you want.

Like Netbeans, you can run your program on a local environment. Make sure to build before running if adding additional dependencies.

# The setup

You'll need Intellij and gitbash installed to work on this project.
For Intellij, make sure you've signed up for the student dev pack and have a registered and activated account.
Install gitbash https://git-scm.com/downloads here.
After installing Gitbash, download the Intellij Ultimate Edition from their website and log in with your account. At the main screan, click import from VCS and type in your information and select the LocationBuddy repo.
One that has been imported you're all ready to work on the project. Try to get used to how Intellij works, and I recommend you go into File>>Settings>> Apperance>>Themes and change it to Darcula. Huge improvement. 

# Using DataPull.java to get your information

For this file, please read the JAVADOC generated to get a clear understanding of what the api has to offer, and what information types are returned.
To read the javadoc: Download DataPull.html >> Right click >> Open with >> Google Chrome (or any web browser)

Here is a code snippet featuring how to make an object from the api, and how to use it.  

Setting up the object 
```
DataPull test = new DataPull("toronto");
```
List of opperations you can do with your weather object  
```
System.out.println (test.getCloudyPercent() + " " + test.getHumidity()+ " " + 
test.getMaxTemp()+ " " + test.getMinTemp()+ " " +   test.getPressure()+ " " + 
test.getSeaLevel() + " " + test.getTemp()+ " " + test.getWindDegree()+ " " + 
test.getWindSpeed()+ " " + test.getDesc()+ " " + test.getSunriseDate()+ " " + 
test.getSunsetDate());
```

Example getting the temperature of two places and comparing it
```
        DataPull tor = new DataPull("Toronto");
        DataPull ny = new DataPull("NewYork");

        double torTemp = tor.getTemp();
        double nyTemp = ny.getTemp();
        String torDesc = tor.getDesc();
        String nyDesc = ny.getDesc();
        System.out.println ("Toronto temp is: "+ torTemp + "degrees celsius  " + torDesc);
        System.out.println ("New York temp is: "+ nyTemp + "degrees celsius  " + nyDesc);

        if (torTemp > nyTemp)
        {
            System.out.println ("Toronto is hotter today!");
        }
        else
            System.out.println ("New York  is hotter today!");
```

Output
```
Toronto temp is: 2.708000000000027degrees celsius  broken clouds
New York temp is: 7.682999999999993degrees celsius  Sky is Clear
New York  is hotter today!
````
*Note you can probably cast the temp to int to truncate the value*
 This is basically a fully functional local java api I made for ease of access. Please make good use of it! Think of cool and interesting ways to use the data provided :).
