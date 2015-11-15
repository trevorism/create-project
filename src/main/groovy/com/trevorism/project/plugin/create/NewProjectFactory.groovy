package com.trevorism.project.plugin.create

import com.trevorism.project.plugin.model.ProjectType

/**
 * @author tbrooks
 */
class NewProjectFactory {

    static NewProject createNewProject(ProjectType language) {
        switch (language) {
            case ProjectType.JAVA:
                return new NewJavaProject()
            case ProjectType.GROOVY:
                return new NewGroovyProject()
            case ProjectType.SCALA:
                return new NewScalaProject()
            case ProjectType.JAVA_GROOVY:
                return new NewJavaGroovyCompositeProject()
            case ProjectType.JAVA_WEB:
                return new NewJavaWebProject()
        }
    }
}
