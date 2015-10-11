package com.trevorism.project.plugin.create

import org.gradle.api.Project

/**
 * @author tbrooks
 */
interface NewProject {

    void createDirectories(Project project)

    void copyInSampleFiles(Project project)

    void updateBuildFile(Project project)

    String getName()

    String getDescription()
}