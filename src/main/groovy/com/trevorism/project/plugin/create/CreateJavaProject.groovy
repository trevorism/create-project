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
        AddSampleFile(project, "src/main", "HelloJava.java")
        AddSampleFile(project, "src/test", "HelloJavaTest.java")
    }

    private AddSampleFile(Project project, String location, String filename) {
        File file = project.file("$location/$languageString/$filename")
        String mainText = CreateJavaProject.class.getClassLoader().getResourceAsStream("$languageString/$filename").text
        if (file.length() == 0)
            file.text = mainText
    }

    @Override
    void updateBuildFile(Project project) {
        File file = project.file("build.gradle")
        String buildText = buildJavaBuildFile()
        if(!file.text.contains(buildText))
            file.text += buildText
    }

    private String buildJavaBuildFile(){
        def builder = new BuildFileBuilder()
                .plugin(programmingLanguage)
                .dependency(new Dependency("testCompile", "junit:junit:4.12"))

        builder.build()
    }

    private String getLanguageString(){
        programmingLanguage.name().toLowerCase()
    }
}
