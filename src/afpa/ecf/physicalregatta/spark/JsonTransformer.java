/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.spark;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.ResponseTransformer;

/**
 *
 * @author lionel
 */
public class JsonTransformer implements ResponseTransformer{

    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    
    @Override
    public String render(Object model) throws Exception {
        return gson.toJson(model);
    }
    
}