##A small tool for formatting text

Create a Java application which reads a text from standard in and writes the formatted output to
the console. Alignment and output width is given as program arguments.

Implement at least 3 of the following formatting algorithms:


● left align

● right align

● center

● justify

● hard


The application must be written in a way that makes it possible to implement remaining
algorithms without any considerable changes to existing code.


The project must be built with maven or gradle and produce an "executable" jar file called
formatter.jar, e.g. java -jar target/formatter.jar. It is not allowed to include any runtime
dependencies. It is allowed to use junit dependency for tests.

###Examples:

#### Input 1:
"This text should be left aligned "

#### Output 1:
######"Left align width 10:

"This text \nshould be \nleft \naligned "

######Left align width 20:

"This text should be \nleft aligned "

#### Input 2:
"This text should be right aligned ";

#### Output 2:
######Right align width 10:

" This text\n should be\n right\n aligned"

######Right align with 20:

" This text should be\n right aligned"

#### Input 3:
"This text should be center aligned "

#### Output 3:
######Center align width 10:

"This text \nshould be \n center \n aligned "

######Center align width 20:

"This text should be \n center aligned "
