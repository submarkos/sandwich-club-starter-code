package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject sandwichDetailsJSON = new JSONObject(json);

            JSONObject name = sandwichDetailsJSON.getJSONObject("name");

            String mainName = name.getString("mainName");
            List<String> alsoKnownAsList = makeListFromJSONArray(name.getJSONArray("alsoKnownAs"));

            String placeOfOrigin = sandwichDetailsJSON.getString("placeOfOrigin");
            String description = sandwichDetailsJSON.getString("description");
            String image = sandwichDetailsJSON.getString("image");
            List<String> ingredients = makeListFromJSONArray(sandwichDetailsJSON.getJSONArray("ingredients"));

            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static List<String> makeListFromJSONArray (JSONArray array) throws JSONException{
        List<String> list = new ArrayList<>();
        for(int i=0;i<array.length();i++){
            list.add(array.getString(i));
        }
        return list;
    }
}
