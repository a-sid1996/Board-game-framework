package resources;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
public class NewJsonFile {
   
   public static void EnterData(String name, String type,String x, String y, String cost, String house, String rent) throws IOException
   {
      //Creating a JSONObject object
     
      //Inserting key-value pairs into the json object
      FileWriter file = new FileWriter("C:/Users/kjagani/OneDrive - Laurentide Controls/desktop/Testing.json");
      for(int i = 0; i < 2;i ++) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("a_name", name);
      jsonObject.put("b_type", type);
      jsonObject.put("c_x", x );
      jsonObject.put("d_y", y);
      jsonObject.put("e_cost", cost);
      jsonObject.put("f_rent", house);
      jsonObject.put("g_house",rent);
      try {
         
         file.write(jsonObject.toJSONString());
        
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("JSON file created: "+jsonObject);
   }
      file.close();  
   }
}
