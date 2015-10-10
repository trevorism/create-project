package com.trevorism.project.plugin

import com.trevorism.project.plugin.create.CreateJavaProject
import com.trevorism.project.plugin.create.CreateProject
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

/**
 * @author tbrooks
 */
class CreateProjectPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        CreateProject createProject = new CreateJavaProject()

        Task task = project.tasks.create("createJavaProject")
        task.group = "Create project"
        task.description = "Creates the folders, gradle.build file, and sample files for a new java project."

        task.doLast{
            createProject.createDirectories(project)
            createProject.copyInSampleFiles(project)
            createProject.updateBuildFile(project)
        }

    }



}
