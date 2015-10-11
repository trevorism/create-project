package com.trevorism.project.plugin.create

import com.trevorism.project.plugin.model.ProgrammingLanguage

/**
 * @author tbrooks
 */
class NewProjectFactory {

    static NewProject createNewProject(ProgrammingLanguage language) {
        switch (language) {
            case ProgrammingLanguage.JAVA:
                return new NewJavaProject()
            case ProgrammingLanguage.GROOVY:
                return new NewGroovyProject()
            case ProgrammingLanguage.SCALA:
                return new NewScalaProject()
        }
    }
}
