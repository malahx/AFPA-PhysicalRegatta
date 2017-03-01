package afpa.ecf.physicalregatta.jersey;

import afpa.ecf.physicalregatta.Utils;
import afpa.ecf.physicalregatta.model.Challenge;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "routes" path)
 */
@Path("currentchallenge")
public class CurrentChallenge {
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRegattas() {
        
        Challenge challenge = Utils.getCurrentChallenge();
        String json = Utils.GSON.toJson(challenge);
        return json;
    }
}
