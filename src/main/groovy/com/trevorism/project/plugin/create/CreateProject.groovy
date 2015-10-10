package com.trevorism.project.plugin.create

import org.gradle.api.Project

/**
 * @author tbrooks
 */
interface CreateProject {

    void createDirectories(Project project)

    void copyInSampleFiles(Project project)

    void updateBuildFile(Project project)
}