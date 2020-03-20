package com.myserver.api.entities;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String userName;
    private String userPass;
    private String email;

    public User(){ }

    public User(String firstName, String lastName, Integer age, String userName, String userPass, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userName = userName;
        this.userPass = userPass;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getUsersGetSchema(){
        return "{\n" +
                "    \"type\": \"object\",\n" +
                "    \"properties\": {\n" +
                "    \"_embedded\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"properties\": {\n" +
                "        \"users\": {\n" +
                "          \"type\": \"array\",\n" +
                "          \"items\": [\n" +
                "            {\n" +
                "              \"type\": \"object\",\n" +
                "              \"properties\": {\n" +
                "                \"firstName\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"lastName\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"age\": {\n" +
                "                  \"type\": \"integer\"\n" +
                "                },\n" +
                "                \"userName\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"userPass\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"email\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"_links\": {\n" +
                "                  \"type\": \"object\",\n" +
                "                  \"properties\": {\n" +
                "                    \"self\": {\n" +
                "                      \"type\": \"object\",\n" +
                "                      \"properties\": {\n" +
                "                        \"href\": {\n" +
                "                          \"type\": \"string\",\n" +
                "                          \"pattern\": \"/users/[0-9]{1,}\"\n" +
                "                        }\n" +
                "                      },\n" +
                "                      \"required\": [\n" +
                "                        \"href\"\n" +
                "                      ]\n" +
                "                    },\n" +
                "                    \"user\": {\n" +
                "                      \"type\": \"object\",\n" +
                "                      \"properties\": {\n" +
                "                        \"href\": {\n" +
                "                          \"type\": \"string\",\n" +
                "                          \"pattern\": \"/users/[0-9]{1,}\"\n" +
                "                        }\n" +
                "                      },\n" +
                "                      \"required\": [\n" +
                "                        \"href\"\n" +
                "                      ]\n" +
                "                    }\n" +
                "                  },\n" +
                "                  \"required\": [\n" +
                "                    \"self\",\n" +
                "                    \"user\"\n" +
                "                  ]\n" +
                "                }\n" +
                "              },\n" +
                "              \"required\": [\n" +
                "                \"firstName\",\n" +
                "                \"lastName\",\n" +
                "                \"age\",\n" +
                "                \"userName\",\n" +
                "                \"userPass\",\n" +
                "                \"email\",\n" +
                "                \"_links\"\n" +
                "              ]\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      \"required\": [\n" +
                "        \"users\"\n" +
                "      ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"properties\": {\n" +
                "        \"self\": {\n" +
                "          \"type\": \"object\",\n" +
                "          \"properties\": {\n" +
                "            \"href\": {\n" +
                "              \"type\": \"string\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"required\": [\n" +
                "            \"href\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"profile\": {\n" +
                "          \"type\": \"object\",\n" +
                "          \"properties\": {\n" +
                "            \"href\": {\n" +
                "              \"type\": \"string\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"required\": [\n" +
                "            \"href\"\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      \"required\": [\n" +
                "        \"self\",\n" +
                "        \"profile\"\n" +
                "      ]\n" +
                "    }\n" +
                "    },\n" +
                "    \"required\": [\n" +
                "    \"_embedded\",\n" +
                "    \"_links\"\n" +
                "    ]\n" +
                "}";
    }

    public static String getUsersGetArraySchema(){
        return "{\n" +
                "  \"type\": \"object\",\n" +
                "  \"properties\": {\n" +
                "    \"firstName\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"lastName\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"age\": {\n" +
                "      \"type\": \"integer\"\n" +
                "    },\n" +
                "    \"userName\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"userPass\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"email\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"properties\": {\n" +
                "        \"self\": {\n" +
                "          \"type\": \"object\",\n" +
                "          \"properties\": {\n" +
                "            \"href\": {\n" +
                "              \"type\": \"string\",\n" +
                "              \"pattern\": \"/users/[0-9]{1,}\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"required\": [\n" +
                "            \"href\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"user\": {\n" +
                "          \"type\": \"object\",\n" +
                "          \"properties\": {\n" +
                "            \"href\": {\n" +
                "              \"type\": \"string\",\n" +
                "              \"pattern\": \"/users/[0-9]{1,}\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"required\": [\n" +
                "            \"href\"\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      \"required\": [\n" +
                "        \"self\",\n" +
                "        \"user\"\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  \"required\": [\n" +
                "    \"firstName\",\n" +
                "    \"lastName\",\n" +
                "    \"age\",\n" +
                "    \"userName\",\n" +
                "    \"userPass\",\n" +
                "    \"email\",\n" +
                "    \"_links\"\n" +
                "  ]\n" +
                "}";
    }

    public static String getUsersIdGetSchema(){
        return "{\n" +
                "    \"type\": \"object\",\n" +
                "    \"properties\": {\n" +
                "    \"firstName\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"lastName\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"age\": {\n" +
                "      \"type\": \"integer\"\n" +
                "    },\n" +
                "    \"userName\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"userPass\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"email\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"properties\": {\n" +
                "        \"self\": {\n" +
                "          \"type\": \"object\",\n" +
                "          \"properties\": {\n" +
                "            \"href\": {\n" +
                "              \"type\": \"string\",\n" +
                "              \"pattern\": \"/users/[0-9]{1,}\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"required\": [\n" +
                "            \"href\"\n" +
                "          ]\n" +
                "        },\n" +
                "        \"user\": {\n" +
                "          \"type\": \"object\",\n" +
                "          \"properties\": {\n" +
                "            \"href\": {\n" +
                "              \"type\": \"string\",\n" +
                "              \"pattern\": \"/users/[0-9]{1,}\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"required\": [\n" +
                "            \"href\"\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      \"required\": [\n" +
                "        \"self\",\n" +
                "        \"user\"\n" +
                "      ]\n" +
                "    }\n" +
                "    },\n" +
                "    \"required\": [\n" +
                "    \"firstName\",\n" +
                "    \"lastName\",\n" +
                "    \"age\",\n" +
                "    \"userName\",\n" +
                "    \"userPass\",\n" +
                "    \"email\",\n" +
                "    \"_links\"\n" +
                "    ]\n" +
                "}";
    }
}
