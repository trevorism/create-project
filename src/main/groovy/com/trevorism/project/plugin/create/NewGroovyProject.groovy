package com.trevorism.project.plugin.create

import com.trevorism.project.plugin.model.Dependency
import com.trevorism.project.plugin.model.Plugin
import com.trevorism.project.plugin.model.ProjectType
import com.trevorism.project.plugin.output.BuildFileBuilder
import com.trevorism.project.plugin.request.LatestFromMavenCentral
import org.gradle.api.Project

/**
 * @author tbrooks
 */
class NewGroovyProject implements NewProject {

    private ProjectType programmingLanguage = ProjectType.GROOVY

    @Override
    void createDirectories(Project project) {
        project.mkdir("src/main/$languageString")
        project.mkdir("src/main/resources")
        project.mkdir("src/test/$languageString")
        project.mkdir("src/test/resources")
    }

    @Override
    void copyInSampleFiles(Project project) {
        addSampleFile(project, "src/main", "HelloGroovy.groovy")
        addSampleFile(project, "src/test", "HelloGroovyTest.groovy")
    }

    private addSampleFile(Project project, String location, String filename) {
        File file = project.file("$location/$languageString/$filename")
        String mainText = NewGroovyProject.class.getClassLoader().getResourceAsStream("$languageString/$filename").text
        if (file.length() == 0)
            file.text = mainText
    }

    @Override
    void updateBuildFile(Project project) {
        File file = project.file("build.gradle")
        file.text = buildGroovyBuildFile()
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
                .plugin(new Plugin(Plugin.IncludeType.PLUGIN, "groovy"))
                .dependency(new Dependency("compile", "org.codehaus.groovy:groovy-all:${LatestFromMavenCentral.latestGroovyVersion}"))
                .dependency(new Dependency("testCompile", "junit:junit:4.12"))

        builder.build()
    }


    private String getLanguageString(){
        programmingLanguage.name().toLowerCase()
    }
}
