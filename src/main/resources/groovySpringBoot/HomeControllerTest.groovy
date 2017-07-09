package com.trevorism.event.web

import org.junit.Test

/**
 * @author tbrooks
 */
class HomeControllerTest {
    @Test
    void testGetEndpoints() {
        assert new HomeController().endpoints
    }

    @Test
    void testPing() {
        assert "pong" == new HomeController().ping()
    }

    @Test
    void testHelp() {
        assert new HomeController().help()
    }
}
