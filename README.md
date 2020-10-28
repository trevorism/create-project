# create-project 
![Jenkins](https://img.shields.io/jenkins/build/http/trevorism-build.eastus.cloudapp.azure.com/create-project)
![Jenkins Coverage](https://img.shields.io/jenkins/coverage/jacoco/http/trevorism-build.eastus.cloudapp.azure.com/create-project)
![GitHub last commit](https://img.shields.io/github/last-commit/trevorism/create-project)
![GitHub language count](https://img.shields.io/github/languages/count/trevorism/create-project)
![GitHub top language](https://img.shields.io/github/languages/top/trevorism/create-project)

Gradle plugin for creating a new project

## Usage

Start with a blank build.gradle file in a directory. Add:

> plugins {
>    id "com.trevorism.create-project" version "0.9.0"
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

`gradle clean build`

should run successfully, building the sample file and executing the sample test.

## Plugin Information 

https://plugins.gradle.org/plugin/com.trevorism.create-project

## License

[MIT](https://github.com/trevorism/create-project/blob/master/LICENSE)

## About
 
https://trevorism.com