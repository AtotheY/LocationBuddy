# LocationBuddy
A small project worked on by a group of friends using Java and Intellij

We are probably going to get a small amount of information via API (weather information for a city) then have functions for that information.
This ensures we will have enough to implement different classes and interfaces.


# Intellij vs Netbeans rundown

Things work a a bit differently in Intellij than Netbeans. As you guys are probably noticing, there's no immediate 'package' hierarchy
like there is in Netbeans. This is actually somewhat convenient for our cause. We're only dealing with one package, and therefore have no need to implement one.

All Java files belong in the "src" directory. You can extend classes and implement interfaces freely as long as all files here.

All modules will most likely branch outwards from our main data pulling file. I'll make sure to include easy-to-use methods for ease of access.
* Please make all new modules on a new branch, and submit a merge request when done. That way if anything goes wrong locally, our main program is still afloat.

In addition to easy VCS use, Intellij has Maven integration, allowing dependencies of any external libraries you guys want to be added really easily.
If you guys want to add a dependency, just go to File >> Project Structure >> Modules >> Dependencies >> Green plus button >> Libary >> Maven and search for whatever you want.

Like Netbeans, you can run your program on a local environment. Make sure to build before running if adding additional dependencies.