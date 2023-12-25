Spring: stock java maven project, dependency for spring, annotation for main class, SpringAppllication.run(//main activity, // args)

## Maven
create from cli. 
- group id - package name
- artifact id - project name

`mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false`
- `mvn validate` if project valid, broken xml etc
- `mvn dependency:resolve` downloads dependencies only
- `mvn dependency:get -Dartifact=groupId:artifactId:version` download single dependency
- `mvn test`
- `mvn clean` delete target dir
- `mvn package` will compile and package, create jar in target
- `mvn install` will compile and package, but also put the package in your local repository