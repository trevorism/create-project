package com.trevorism.project.plugin.create

import com.trevorism.project.plugin.model.Dependency
import com.trevorism.project.plugin.model.ProgrammingLanguage
import com.trevorism.project.plugin.output.BuildFileBuilder
import org.gradle.api.Project

/**
 * @author tbrooks
 */
class CreateJavaProject implements CreateProject {

    private ProgrammingLanguage programmingLanguage = ProgrammingLanguage.JAVA

    @Override
    void createDirectories(Project project) {
        project.mkdir("src/main/java")
        project.mkdir("src/main/resources")
        project.mkdir("src/test/java")
        project.mkdir("src/test/resources")
    }

    @Override
    void copyInSampleFiles(Project project) {
        String mainText = CreateJavaProject.class.getClassLoader().getResourceAsStream("java/Hello.java").text
        project.file("src/main/java/Hello.java").text = mainText

        String testText = CreateJavaProject.class.getClassLoader().getResourceAsStream("java/HelloTest.java").text
        project.file("src/test/java/HelloTest.java").text = testText
    }

    @Override
    void updateBuildFile(Project project) {
        File file = project.file("build.gradle")
        file.text += buildJavaBuildFile()
    }

    private String buildJavaBuildFile(){
        def builder = new BuildFileBuilder()
                .plugin(programmingLanguage)
                .dependency(new Dependency("testCompile", "junit:junit:4.12"))

        builder.build()
    }
}
