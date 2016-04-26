package test2.brett.com.test.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Created by Brett on 4/25/16.
 */
public class NewsDeserializer implements JsonDeserializer<News> {
    @Override
    public News deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jObj = json.getAsJsonObject();
        JsonElement jElement = jObj.get("multimedia");
        List<Multimedia> multimedia = Collections.emptyList();
        if(jElement.isJsonArray()) {
            multimedia = context.deserialize(jElement.getAsJsonArray(), new TypeToken<List<Multimedia>>(){}.getType());
        }
        //assuming there is an appropriate constructor
        return new News(jObj.getAsJsonPrimitive("title").getAsString(), multimedia);
    }
}