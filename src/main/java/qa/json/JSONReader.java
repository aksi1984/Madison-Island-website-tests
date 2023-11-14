package qa.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import qa.utils.*;

import java.io.*;


public class JSONReader {

    private static final String filePath = "./src/main/resources/data.json";
    private static JSONObject jsonObject;

    private static JSONArray getJSONArray(String key, String node) {

        Object object = jsonObject.get(key);
        JSONObject jsonObject1 = (JSONObject) object;

        return jsonObject1.getJSONArray(node);
    }

    public static void read() throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(filePath);
        Object object = parser.parse(reader);

        jsonObject = new JSONObject(object.toString());
    }

    public static String[] get(String key, String node) {

        JSONArray jsonArray = getJSONArray(key, node);

        String[] data = new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            data[i] = jsonArray.getString(i);
        }

        return data;
    }

    public static NewsletterData[] getNewsletterData(String node) {

        JSONArray jsonArray = getJSONArray("newsletter", node);

        NewsletterData[] newsletterData = new NewsletterData[jsonArray.length()];

        for(int i = 0; i < jsonArray.length(); i++) {

            newsletterData[i] = new NewsletterData(
                    jsonArray.getJSONObject(i).getString("email"),
                    jsonArray.getJSONObject(i).getString("message")
            );
        }

        return newsletterData;
    }

    public static Pair<String, String>[] get(String key, String node, Pair<String, String> params) {

        JSONArray jsonArray = getJSONArray(key, node);

        Pair<String, String>[] data = new Pair[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            data[i] = new Pair<>(
                    jsonArray.getJSONObject(i).getString(params.getFirst()),
                    jsonArray.getJSONObject(i).getString(params.getSecond())
            );
        }

        return data;
    }

    public static Credentials[] getCredentials(String node) {

        JSONArray jsonArray = getJSONArray("credentials", node);

        Credentials[] credentials = new Credentials[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            credentials[i] = new Credentials(
                    jsonArray.getJSONObject(i).getString("email"),
                    jsonArray.getJSONObject(i).getString("password")
            );
        }

        return credentials;
    }

    public static ProductData[] get(String node) {

        JSONArray jsonArray = getJSONArray("addingToShoppingCart", node);

        ProductData[] data = new ProductData[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            data[i] = new ProductData(
                    jsonArray.getJSONObject(i).getString("category"),
                    jsonArray.getJSONObject(i).getString("productType"),
                    jsonArray.getJSONObject(i).getString("name"),
                    jsonArray.getJSONObject(i).getString("color"),
                    jsonArray.getJSONObject(i).getString("size"),
                    jsonArray.getJSONObject(i).getString("quantity")
            );
        }

        return data;
    }

    public static EstimateShippingData[] getEstimatedShippingData(String node) {

        JSONArray jsonArray = getJSONArray("estimateShippingForm", node);

        EstimateShippingData[] data = new EstimateShippingData[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            data[i] = new EstimateShippingData(
                jsonArray.getJSONObject(i).getString("stateType"),
                    jsonArray.getJSONObject(i).getString("country"),
                    jsonArray.getJSONObject(i).getString("state"),
                    jsonArray.getJSONObject(i).getString("city"),
                    jsonArray.getJSONObject(i).getString("postcode")
            );
        }

        return data;
    }
}