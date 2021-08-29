# Text Formatter using Java 8

This is an example implementation of a basic text formatter as per this [assignment](assignment.md)

## prerequisites:

JDK 1.8 or above

Maven 3.6.3 or above

###Execute tests:

> mvn test

###Compile the project:

> mvn compiler:compile

###Package into executable jar:

> mvn package

###Run the jar:
_Run the jar with below command, first param is the alignment and second param is the width_

java -jar formatter-1.0.jar `alignment` `width`

#### alignment:
_left_

_right_

_center_

#### width
Any integer value

#### Sample commands
>java -jar formatter-1.0.jar **left** **10**

>java -jar formatter-1.0.jar **left** **20**

>java -jar formatter-1.0.jar **right** **10**

>java -jar formatter-1.0.jar **right** **20**

>java -jar formatter-1.0.jar **center** **10**

>java -jar formatter-1.0.jar **center** **20**
