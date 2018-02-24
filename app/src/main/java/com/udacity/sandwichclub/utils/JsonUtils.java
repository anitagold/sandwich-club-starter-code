package com.udacity.sandwichclub.utils;

import java.util.ArrayList;
import java.util.List;

import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;
        try {
            //make the jsonObject and the nameObject
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject = jsonObject.getJSONObject("name");

            //create the sandwich attributes
            String mainName = nameObject.getString("mainName");

            JSONArray alsoKnownAs = nameObject.getJSONArray("alsoKnownAs");

            String placeOfOrigin = jsonObject.getString("placeOfOrigin");

            String description = jsonObject.getString("description");

            String image = jsonObject.getString("image");

            JSONArray ingredients = jsonObject.getJSONArray("ingredients");

            //make the complete sandwich object from attributes
            //the alsoKnownAs JSONArray needs to convert into List<String>
            List<String> alsoKnownAsList = new ArrayList<>();
            for (int i=0; i<alsoKnownAs.length(); i++) {
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }

            //the ingredients JSONArray needs to convert into List<String>
            List<String> ingredientsList = new ArrayList<>();
            for (int i=0; i<ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }

            sandwich = new Sandwich(mainName,alsoKnownAsList,placeOfOrigin,description,image,ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }
}
