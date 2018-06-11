package com.trevorism.project.plugin.create

import com.trevorism.project.plugin.model.Dependency
import com.trevorism.project.plugin.model.Plugin
import com.trevorism.project.plugin.output.BuildFileBuilder
import org.gradle.api.Project

/**
 * @author tbrooks
 */
class NewJavaWebProject implements NewProject {

    @Override
    void createDirectories(Project project) {
        project.mkdir("src/main/java/webapi")
        project.mkdir("src/main/resources")
        project.mkdir("src/test/java/webapi")
        project.mkdir("src/test/resources")
        project.mkdir("src/main/webapp/WEB-INF")
    }

    @Override
    void copyInSampleFiles(Project project) {
        AddSampleFile(project, "src/main/java/webapi", "HelloEndpoint.java")
        AddSampleFile(project, "src/test/java/webapi", "HelloEndpointTest.java")
        AddSampleFile(project, "src/main/webapp", "index.html")
        AddSampleFile(project, "src/main/webapp/WEB-INF", "web.xml")
    }

    private AddSampleFile(Project project, String location, String filename) {
        File file = project.file("$location/$filename")
        String fileText = NewJavaWebProject.class.getClassLoader().getResourceAsStream("web/$filename").text
        if (file.length() == 0)
            file.text = fileText
    }

    @Override
    void updateBuildFile(Project project) {
        File file = project.file("build.gradle")
        file.text = buildJavaWebBuildFile()
    }

    @Override
    String getName() {
        "createJavaWebProject"
    }

    @Override
    String getDescription() {
        "Creates the folders, gradle.build file, and sample files for a new java web project, using jersey and jackson"
    }

    private String buildJavaWebBuildFile(){
        def builder = new BuildFileBuilder()
                .plugin(new Plugin(Plugin.IncludeType.PLUGIN, "java"))
                .plugin(new Plugin(Plugin.IncludeType.PLUGIN, "war"))
                .plugin(new Plugin(Plugin.IncludeType.FROM, "https://raw.github.com/akhikhl/gretty/master/pluginScripts/gretty.plugin"))
                .dependency(new Dependency("compile", "org.glassfish.jersey.containers:jersey-container-servlet:2.27"))
                .dependency(new Dependency("compile", "org.glassfish.jersey.media:jersey-media-json-jackson:2.27"))
                .dependency(new Dependency("compile", "com.fasterxml.jackson.jaxrs:jackson-jaxrs-json-provider:2.9.5"))
                .dependency(new Dependency("testCompile", "junit:junit:4.12"))

        builder.build()
    }

}