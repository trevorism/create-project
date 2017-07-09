package com.trevorism.project.plugin.create

import org.gradle.api.Project

import org.junit.Test

import static com.trevorism.project.plugin.CreateProjectPluginTest.createProject

/**
 * @author tbrooks
 */
class NewGroovySpringBootProjectTest {

    @Test
    void createNewProject(){
        Project project = createProject()

        def task = project.tasks.findByPath("createGroovySpringBootProject")
        assert task
        //task.execute()

    }
}
