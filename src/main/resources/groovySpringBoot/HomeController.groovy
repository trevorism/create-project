
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.View
import org.springframework.web.servlet.view.RedirectView

/**
 * @author tbrooks
 */
@RestController
@RequestMapping
class HomeController {

    @ApiOperation(value = "getEndpoints", httpMethod = "GET")
    @ApiResponse(code = 200, message = "Success", response = ArrayList)
    @RequestMapping
    List<String> getEndpoints() {
        ["ping", "help"]
    }

    @ApiOperation(value = "ping", httpMethod = "GET")
    @ApiResponse(code = 200, message = "Success", response = String)
    @RequestMapping("ping")
    String ping(){
        return "pong"
    }

    @ApiOperation(value = "help", httpMethod = "GET")
    @ApiResponse(code = 200, message = "Success", response = View)
    @RequestMapping("help")
    View help(){
        return new RedirectView("/swagger-ui.html", true)
    }
}
