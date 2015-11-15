package com.trevorism.project.plugin

import com.trevorism.project.plugin.create.NewProject
import com.trevorism.project.plugin.create.NewProjectFactory
import com.trevorism.project.plugin.model.ProjectType
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

/**
 * @author tbrooks
 */
class CreateProjectPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        ProjectType.values().each { ProjectType language ->
            createTaskForProject(project, NewProjectFactory.createNewProject(language))
        }
    }

    private createTaskForProject(Project project, NewProject createProject) {
        Task task = project.tasks.create(createProject.name)
        task.group = "Create project"
        task.description = createProject.description

        task.doLast {
            createProject.createDirectories(project)
            createProject.copyInSampleFiles(project)
            createProject.updateBuildFile(project)
        }
    }


}
