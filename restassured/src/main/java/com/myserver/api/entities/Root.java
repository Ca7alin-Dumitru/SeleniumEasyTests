package com.myserver.api.entities;

public class Root {

    public static String getRootGetSchema(){
        return "{\n" +
                "    \"type\": \"object\",\n" +
                "    \"properties\": {\n" +
                "        \"_links\": {\n" +
                "            \"type\": \"object\",\n" +
                "            \"properties\": {\n" +
                "                \"users\": {\n" +
                "                    \"type\": \"object\",\n" +
                "                    \"properties\": {\n" +
                "                        \"href\": {\n" +
                "                            \"type\": \"string\",\n" +
                "                            \"pattern\": \"/users\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"required\": [\"href\"]\n" +
                "                },\n" +
                "                \"profile\": {\n" +
                "                    \"type\": \"object\",\n" +
                "                    \"properties\": {\n" +
                "                        \"href\": {\n" +
                "                            \"type\": \"string\",\n" +
                "                            \"pattern\": \"/profile\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    \"required\": [\"href\"]\n" +
                "                }\n" +
                "            },\n" +
                "            \"required\": [\"users\", \"profile\"]\n" +
                "        }\n" +
                "    },\n" +
                "    \"required\": [\"_links\"] }";
    }
}
