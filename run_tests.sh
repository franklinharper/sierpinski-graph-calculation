# Compile
javac -nowarn \
      -cp src/:lib/junit-jupiter-api-5.0.0-M3.jar:lib/opentest4j-1.0.0-M1.jar \
      src/com/franklinharper/sierpinskigraphcalculation/*.java
# Run tests
java -jar lib/junit-platform-console-standalone-1.0.0-M4.jar \
  --class-path src \
  --scan-class-path
