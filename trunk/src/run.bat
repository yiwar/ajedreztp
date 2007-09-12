@ECHO OFF
@REM $LastChangedDate$
@REM $LastChangedRevision$
ECHO **********************************************************
ECHO * Ligia Tatiana Gonzalez Leyva (calvinahobbes@gmail.com) *
ECHO *       Tecnologia de la Programacion 2006/2007          *
ECHO *                EL JUEGO DEL AJEDREZ                    *
ECHO **********************************************************
ECHO.
@REM Script MS-DOS para ejecutar la aplicación Ajedrez.java
@REM Si el compilador javac está en el path la línea 1 puede ser omitida.
@REM Puede que en diferentes instalaciones sea necesario modificar susodicha línea.

@SET PATH=c:\programacion\java\jdk1.6.0_01\bin
@del *.class
javac Ajedrez.java
java Ajedrez
@ECHO.
@Pause
