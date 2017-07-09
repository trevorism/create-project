# create-project : Gradle plugin for creating a new project

Start with a blank build.gradle file in a directory. Add:

> plugins {
>    id "com.trevorism.create-project" version "0.7"
> }

to the build.gradle file.

Then invoke one of the gradle tasks:

* createJavaProject - Creates a new java project
* createGroovyProject - Creates a new groovy project
* createJavaGroovyCompositeProject - Creates a new project with both java and groovy
* createScalaProject - Creates a new scala project
* createJavaWebProject - Creates a new java web project, with the jersey and jackson libraries.
* createGroovySpringBootProject - Creates a new groovy web project, with spring boot.

This plugin does three things:

* Creates the proper default folder structure for your project.
* Updates the build.gradle in order to build your project.
* Provides a sample class and test class so that you can see working software in your IDE.

After executing the create-project task,
> gradle clean build

should run successfully, building the sample file and executing the sample test.

Plugin Information -- https://plugins.gradle.org/plugin/com.trevorism.create-project

About me -- http://www.trevorism.com