package com.trevorism.project.plugin.create

import com.trevorism.project.plugin.model.ProjectType

import static com.trevorism.project.plugin.model.ProjectType.*

/**
 * @author tbrooks
 */
class NewProjectFactory {

    static NewProject createNewProject(ProjectType language) {
        switch (language) {
            case JAVA:
                return new NewJavaProject()
            case GROOVY:
                return new NewGroovyProject()
            case GROOVY_SPRING_BOOT:
                return new NewGroovySpringBootProject()
            case SCALA:
                return new NewScalaProject()
            case JAVA_GROOVY:
                return new NewJavaGroovyCompositeProject()
            case JAVA_WEB:
                return new NewJavaWebProject()
        }
    }
}
