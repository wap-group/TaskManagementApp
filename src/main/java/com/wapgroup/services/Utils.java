package com.wapgroup.services;

import com.google.common.base.Splitter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class Utils {

    public static Map<String, String> getParameterMap(HttpServletRequest request) {

        BufferedReader br = null;
        Map<String, String> dataMap = null;

        try{

            InputStreamReader reader = new InputStreamReader(
                                            request.getInputStream());
            br = new BufferedReader(reader);
            String data = br.readLine();

            dataMap = Splitter.on('&')
                    .trimResults()
                    .withKeyValueSeparator(
                            Splitter.on('=')
                                    .limit(2)
                                    .trimResults())
                    .split(data);
            return reformat(dataMap);

        }catch(IOException ioe){
            System.out.println("IOException " + ioe);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }

        return null;
    }

    private static Map<String, String> reformat(Map<String, String> x){
        Map<String, String> updated = new HashMap<>();

        for(Map.Entry<String, String> entry: x.entrySet()){
            updated.put(entry.getKey(), entry.getValue());
        }
        updated.replace("email", addAtSymbol(x.get("email")));
        updated.replace("street", addSpace(x.get("street")));
        updated.replace("city", addSpace(x.get("city")));
        updated.replace("state", addSpace(x.get("state")));
        updated.replace("roles", addSpace(x.get("roles")));

        return Collections.unmodifiableMap(updated);
    }

    private static String addAtSymbol(String y){

        return (y.replaceAll("(%)", "@")).replaceAll("(40)", "");
    }

    private static String addSpace(String y){

        return y.replaceAll("(\\+)", " ");
    }

}
