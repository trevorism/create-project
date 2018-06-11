package com.trevorism.project.plugin.create

import com.trevorism.project.plugin.model.Dependency
import com.trevorism.project.plugin.model.Plugin
import com.trevorism.project.plugin.model.ProjectType
import com.trevorism.project.plugin.output.BuildFileBuilder
import org.gradle.api.Project

/**
 * @author tbrooks
 */
class NewScalaProject implements NewProject {

    private ProjectType programmingLanguage = ProjectType.SCALA

    @Override
    void createDirectories(Project project) {
        project.mkdir("src/main/$languageString")
        project.mkdir("src/main/resources")
        project.mkdir("src/test/$languageString")
        project.mkdir("src/test/resources")
    }

    @Override
    void copyInSampleFiles(Project project) {
        AddSampleFile(project, "src/main", "HelloScala.scala")
        AddSampleFile(project, "src/test", "HelloScalaTest.scala")
    }

    private AddSampleFile(Project project, String location, String filename) {
        File file = project.file("$location/$languageString/$filename")
        String mainText = NewScalaProject.class.getClassLoader().getResourceAsStream("$languageString/$filename").text
        if (file.length() == 0)
            file.text = mainText
    }

    @Override
    void updateBuildFile(Project project) {
        File file = project.file("build.gradle")
        file.text = buildScalaBuildFile()
    }

    @Override
    String getName() {
        "createScalaProject"
    }

    @Override
    String getDescription() {
        "Creates the folders, gradle.build file, and sample files for a new scala project"
    }

    private String buildScalaBuildFile(){
        def builder = new BuildFileBuilder()
                .buildscriptPlugin()
                .plugin(new Plugin(Plugin.IncludeType.PLUGIN, "scala"))
                .dependency(new Dependency("compile", "org.scala-lang:scala-library:2.12.6"))
                .dependency(new Dependency("testCompile", "org.scalatest:scalatest_2.12:3.0.5"))
                .dependency(new Dependency("testRuntime", "org.pegdown:pegdown:1.6.0"))

        builder.build()
    }

    private String getLanguageString(){
        programmingLanguage.name().toLowerCase()
    }
}
