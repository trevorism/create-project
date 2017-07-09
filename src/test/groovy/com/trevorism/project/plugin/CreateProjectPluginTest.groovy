package com.trevorism.project.plugin

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * @author tbrooks
 */
class CreateProjectPluginTest {

    @Test
    void testApply(){
        Project project = createProject()

        assert project.tasks.getByPath("createGroovySpringBootProject")
        assert project.tasks.getByPath("createGroovyProject")
        assert project.tasks.getByPath("createJavaGroovyCompositeProject")
        assert project.tasks.getByPath("createJavaProject")
        assert project.tasks.getByPath("createJavaWebProject")
        assert project.tasks.getByPath("createScalaProject")


    }

    static Project createProject(){
        Project project = ProjectBuilder.builder().withName("foo").build()
        project.with {
            apply plugin: 'com.trevorism.create-project'
        }
        return project
    }
}
