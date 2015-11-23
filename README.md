# gems
A fan site for the television show Steven Universe

## Description

This is a website based on the TV show Steven Universe. Gems can be selected and fused together to make new gems. 

## Setup

In order to install Gems, you'll need to have [Java] (https://www.learnhowtoprogram.com/lessons/java-setup), [Gradle] (https://www.learnhowtoprogram.com/lessons/setting-up-a-project-with-gradle) and [Postgres] (https://www.learnhowtoprogram.com/lessons/installing-postgres) installed on your computer.

Databases are stored in the ``gem.sql`` and ``gem_test.sql`` files. To use them locally, type in ``psql [database_name] < [sqlfile]`` into your command line. You'll need to create the databases gem and gem_test inside of psql prior to running the psql command. 

In order to run the application, you'll need to type ``gradle run`` on your command line. All additional libraries will be installed after running gradle. The local version of this application can be found at ``localhost:4567``.
 
## Technologies Used

Technologies used to create this application include:

* Gradle
* Spark 
* Java 
* HTML and CSS with Bootstrap styling

### Legal

Copyright (c) 2015 Ashley Sullins, Ariel Spear, Kallen Millner, Stephany Garcia, and Colleen Minor

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED.
