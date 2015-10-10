# create-project
Gradle plugin for creating a new project.

Start with a blank build.gradle file in a directory.
Add:

> plugins {
>    id "com.trevorism.create-project" version "0.1"
> }

to the build.gradle file.

Then invoke one of the gradle tasks: (createJavaProject)

This plugin does three things:

1) Creates the proper default folder structure for your project.
2) Updates the build.gradle in order to build your project.
3) Provides a sample class and test class so that you can see working software in your IDE.

After executing the task,
> gradle clean build

Should run successfully.

Links:
https://plugins.gradle.org/plugin/com.trevorism.create-project
http://www.trevorism.com