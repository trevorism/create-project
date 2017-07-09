package com.trevorism.project.plugin.create

import com.trevorism.project.plugin.model.Dependency
import com.trevorism.project.plugin.model.Plugin
import com.trevorism.project.plugin.output.BuildFileBuilder
import com.trevorism.project.plugin.request.LatestFromMavenCentral
import org.gradle.api.Project

/**
 * @author tbrooks
 */
class NewGroovySpringBootProject implements NewProject {


    @Override
    void createDirectories(Project project) {
        project.mkdir("src/main/$languageString")
        project.mkdir("src/main/resources")
        project.mkdir("src/test/$languageString")
        project.mkdir("src/test/resources")
    }

    @Override
    void copyInSampleFiles(Project project) {
        addSampleFile(project, "src/main", "Application.groovy")
        addSampleFile(project, "src/main", "HomeController.groovy")
        addSampleFile(project, "src/main", "SwaggerConfig.groovy")
        addSampleFile(project, "src/test", "HomeControllerTest.groovy")
    }

    private addSampleFile(Project project, String location, String filename) {
        File file = project.file("$location/$languageString/$filename")
        String mainText = NewGroovySpringBootProject.class.getClassLoader().getResourceAsStream("$languageString/$filename").text
        if (file.length() == 0)
            file.text = mainText
    }

    private getLanguageString(){
        "groovySpringBoot"
    }

    @Override
    void updateBuildFile(Project project) {
        File file = project.file("build.gradle")
        file.text = buildGroovySpringBootBuildFile()
    }

    String buildGroovySpringBootBuildFile() {
        def springBootVersion = "1.5.4.RELEASE"
        def swaggerVersion = "2.7.0"

        def builder = new BuildFileBuilder()
                .plugin(new Plugin(Plugin.IncludeType.PLUGIN, "groovy"))
                .plugin(new Plugin(Plugin.IncludeType.PLUGIN, "war"))
                .dependency(new Dependency("compile", "org.codehaus.groovy:groovy-all:${LatestFromMavenCentral.latestGroovyVersion}"))
                .dependency(new Dependency("compile", "org.springframework.boot:spring-boot-starter-web:$springBootVersion"))
                .dependency(new Dependency("compile", "org.springframework.boot:spring-boot-starter-tomcat:$springBootVersion"))
                .dependency(new Dependency("compile", "org.springframework.boot:spring-boot-starter-actuator:$springBootVersion"))
                .dependency(new Dependency("compile", "io.springfox:springfox-swagger-ui:$swaggerVersion"))
                .dependency(new Dependency("compile", "io.springfox:springfox-swagger2:$swaggerVersion"))
                .dependency(new Dependency("testCompile", "org.springframework.boot:spring-boot-starter-test:$springBootVersion"))
                .dependency(new Dependency("testCompile", "junit:junit:4.12"))

        builder.build()

    }

    @Override
    String getName() {
        return "createGroovySpringBootProject"
    }

    @Override
    String getDescription() {
        return "Creates a groovy based spring boot application"
    }
}
