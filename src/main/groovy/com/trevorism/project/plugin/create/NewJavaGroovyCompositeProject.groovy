package com.trevorism.project.plugin.create

import org.gradle.api.Project

/**
 * @author tbrooks
 */
class NewJavaGroovyCompositeProject implements NewProject {

    private NewProject newJavaProject = new NewJavaProject()
    private NewProject newGroovyProject = new NewGroovyProject()

    @Override
    void createDirectories(Project project) {
        newJavaProject.createDirectories(project)
        newGroovyProject.createDirectories(project)
    }

    @Override
    void copyInSampleFiles(Project project) {
        newJavaProject.copyInSampleFiles(project)
        newGroovyProject.copyInSampleFiles(project)
    }

    @Override
    void updateBuildFile(Project project) {
        newGroovyProject.updateBuildFile(project)
        File file = project.file("build.gradle")
        file.text += "\nsourceSets.main.java.srcDirs = []\n" +
                "sourceSets.main.groovy.srcDirs += [\"src/main/java\"]"
    }

    @Override
    String getName() {
        return "createJavaGroovyCompositeProject"
    }

    @Override
    String getDescription() {
        return "Creates the folders, gradle.build file, and sample files for a new project with both java and groovy"
    }
}
