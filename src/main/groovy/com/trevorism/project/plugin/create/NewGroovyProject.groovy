package com.trevorism.project.plugin.create

import com.trevorism.project.plugin.model.Dependency
import com.trevorism.project.plugin.model.ProgrammingLanguage
import com.trevorism.project.plugin.output.BuildFileBuilder
import com.trevorism.project.plugin.request.LatestFromMavenCentral
import org.gradle.api.Project

/**
 * @author tbrooks
 */
class NewGroovyProject implements NewProject {

    private ProgrammingLanguage programmingLanguage = ProgrammingLanguage.GROOVY

    @Override
    void createDirectories(Project project) {
        project.mkdir("src/main/$languageString")
        project.mkdir("src/main/resources")
        project.mkdir("src/test/$languageString")
        project.mkdir("src/test/resources")
    }

    @Override
    void copyInSampleFiles(Project project) {
        AddSampleFile(project, "src/main", "HelloGroovy.groovy")
        AddSampleFile(project, "src/test", "HelloGroovyTest.groovy")
    }

    private AddSampleFile(Project project, String location, String filename) {
        File file = project.file("$location/$languageString/$filename")
        String mainText = NewGroovyProject.class.getClassLoader().getResourceAsStream("$languageString/$filename").text
        if (file.length() == 0)
            file.text = mainText
    }

    @Override
    void updateBuildFile(Project project) {
        File file = project.file("build.gradle")
        String buildText = buildGroovyBuildFile()
        if(!file.text.contains(buildText))
            file.text += buildText
    }

    @Override
    String getName() {
        "createGroovyProject"
    }

    @Override
    String getDescription() {
        "Creates the folders, gradle.build file, and sample files for a new groovy project"
    }

    private String buildGroovyBuildFile(){
        def builder = new BuildFileBuilder()
                .plugin(programmingLanguage)
                .dependency(new Dependency("compile", "org.codehaus.groovy:groovy-all:${LatestFromMavenCentral.latestGroovyVersion}"))
                .dependency(new Dependency("testCompile", "junit:junit:4.12"))

        builder.build()
    }


    private String getLanguageString(){
        programmingLanguage.name().toLowerCase()
    }
}
