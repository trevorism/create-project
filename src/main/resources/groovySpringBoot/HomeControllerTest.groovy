
import org.junit.Test

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
