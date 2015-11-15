package webapi;

import api.Endpoint;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloEndpointTest {
    @Test
    public void testGetHello(){
        HelloEndpoint endpoint = new HelloEndpoint();
        assertEquals("Endpoint Hello World", endpoint.getHello());
    }
}
