package com.trevorism.project.plugin.create

import com.trevorism.project.plugin.model.Dependency
import com.trevorism.project.plugin.model.Plugin
import com.trevorism.project.plugin.model.ProjectType
import com.trevorism.project.plugin.output.BuildFileBuilder
import org.gradle.api.Project

/**
 * @author tbrooks
 */
class NewJavaProject implements NewProject {

    private ProjectType programmingLanguage = ProjectType.JAVA

    @Override
    void createDirectories(Project project) {
        project.mkdir("src/main/$languageString")
        project.mkdir("src/main/resources")
        project.mkdir("src/test/$languageString")
        project.mkdir("src/test/resources")
    }

    @Override
    void copyInSampleFiles(Project project) {
        addSampleFile(project, "src/main", "HelloJava.java")
        addSampleFile(project, "src/test", "HelloJavaTest.java")
    }

    private addSampleFile(Project project, String location, String filename) {
        File file = project.file("$location/$languageString/$filename")
        String mainText = NewJavaProject.class.getClassLoader().getResourceAsStream("$languageString/$filename").text
        if (file.length() == 0)
            file.text = mainText
    }

    @Override
    void updateBuildFile(Project project) {
        File file = project.file("build.gradle")
        file.text = buildJavaBuildFile()
    }

    @Override
    String getName() {
        "createJavaProject"
    }

    @Override
    String getDescription() {
        "Creates the folders, gradle.build file, and sample files for a new java project"
    }

    private String buildJavaBuildFile(){
        def builder = new BuildFileBuilder()
                .plugin(new Plugin(Plugin.IncludeType.PLUGIN, "java"))
                .dependency(new Dependency("testImplementation", "junit:junit:4.13.1"))

        builder.build()
    }

    private String getLanguageString(){
        programmingLanguage.name().toLowerCase()
    }
}
