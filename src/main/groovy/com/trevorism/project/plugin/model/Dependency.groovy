package com.trevorism.project.plugin.model

import groovy.transform.Immutable

/**
 * @author tbrooks
 */

@Immutable
class Dependency {
    String configuration
    String specification

    @Override
    String toString() {
        return "$configuration '$specification'"
    }
}
