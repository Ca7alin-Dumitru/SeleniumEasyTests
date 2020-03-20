package com.myserver.api.entities;

public class Profile {
    public static String getProfileGetSchema(){
        return "{\n" +
                "    \"type\": \"object\",\n" +
                "    \"properties\": {\n" +
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
                "        \"users\": {\n" +
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
                "        \"users\"\n" +
                "      ]\n" +
                "    }\n" +
                "    },\n" +
                "    \"required\": [\n" +
                "    \"_links\"\n" +
                "    ]\n" +
                "}";
    }

    public static String getProfileUsersGetSchema(){
        return "{\n" +
                "    \"type\": \"object\",\n" +
                "    \"properties\": {\n" +
                "    \"alps\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"properties\": {\n" +
                "        \"version\": {\n" +
                "          \"type\": \"string\"\n" +
                "        },\n" +
                "        \"descriptor\": {\n" +
                "          \"type\": \"array\",\n" +
                "          \"items\": [\n" +
                "            {\n" +
                "              \"type\": \"object\",\n" +
                "              \"properties\": {\n" +
                "                \"id\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"href\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"descriptor\": {\n" +
                "                  \"type\": \"array\",\n" +
                "                  \"items\": [\n" +
                "                    {\n" +
                "                      \"type\": \"object\",\n" +
                "                      \"properties\": {\n" +
                "                        \"name\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        },\n" +
                "                        \"type\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        }\n" +
                "                      },\n" +
                "                      \"required\": [\n" +
                "                        \"name\",\n" +
                "                        \"type\"\n" +
                "                      ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                      \"type\": \"object\",\n" +
                "                      \"properties\": {\n" +
                "                        \"name\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        },\n" +
                "                        \"type\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        }\n" +
                "                      },\n" +
                "                      \"required\": [\n" +
                "                        \"name\",\n" +
                "                        \"type\"\n" +
                "                      ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                      \"type\": \"object\",\n" +
                "                      \"properties\": {\n" +
                "                        \"name\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        },\n" +
                "                        \"type\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        }\n" +
                "                      },\n" +
                "                      \"required\": [\n" +
                "                        \"name\",\n" +
                "                        \"type\"\n" +
                "                      ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                      \"type\": \"object\",\n" +
                "                      \"properties\": {\n" +
                "                        \"name\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        },\n" +
                "                        \"type\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        }\n" +
                "                      },\n" +
                "                      \"required\": [\n" +
                "                        \"name\",\n" +
                "                        \"type\"\n" +
                "                      ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                      \"type\": \"object\",\n" +
                "                      \"properties\": {\n" +
                "                        \"name\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        },\n" +
                "                        \"type\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        }\n" +
                "                      },\n" +
                "                      \"required\": [\n" +
                "                        \"name\",\n" +
                "                        \"type\"\n" +
                "                      ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                      \"type\": \"object\",\n" +
                "                      \"properties\": {\n" +
                "                        \"name\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        },\n" +
                "                        \"type\": {\n" +
                "                          \"type\": \"string\"\n" +
                "                        }\n" +
                "                      },\n" +
                "                      \"required\": [\n" +
                "                        \"name\",\n" +
                "                        \"type\"\n" +
                "                      ]\n" +
                "                    }\n" +
                "                  ]\n" +
                "                }\n" +
                "              },\n" +
                "              \"required\": [\n" +
                "                \"id\",\n" +
                "                \"href\",\n" +
                "                \"descriptor\"\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"object\",\n" +
                "              \"properties\": {\n" +
                "                \"id\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"name\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"type\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"descriptor\": {\n" +
                "                  \"type\": \"array\",\n" +
                "                  \"items\": {}\n" +
                "                },\n" +
                "                \"rt\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                }\n" +
                "              },\n" +
                "              \"required\": [\n" +
                "                \"id\",\n" +
                "                \"name\",\n" +
                "                \"type\",\n" +
                "                \"descriptor\",\n" +
                "                \"rt\"\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"object\",\n" +
                "              \"properties\": {\n" +
                "                \"id\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"name\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"type\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"descriptor\": {\n" +
                "                  \"type\": \"array\",\n" +
                "                  \"items\": {}\n" +
                "                },\n" +
                "                \"rt\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                }\n" +
                "              },\n" +
                "              \"required\": [\n" +
                "                \"id\",\n" +
                "                \"name\",\n" +
                "                \"type\",\n" +
                "                \"descriptor\",\n" +
                "                \"rt\"\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"object\",\n" +
                "              \"properties\": {\n" +
                "                \"id\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"name\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"type\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"descriptor\": {\n" +
                "                  \"type\": \"array\",\n" +
                "                  \"items\": {}\n" +
                "                },\n" +
                "                \"rt\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                }\n" +
                "              },\n" +
                "              \"required\": [\n" +
                "                \"id\",\n" +
                "                \"name\",\n" +
                "                \"type\",\n" +
                "                \"descriptor\",\n" +
                "                \"rt\"\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"object\",\n" +
                "              \"properties\": {\n" +
                "                \"id\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"name\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"type\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"descriptor\": {\n" +
                "                  \"type\": \"array\",\n" +
                "                  \"items\": {}\n" +
                "                },\n" +
                "                \"rt\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                }\n" +
                "              },\n" +
                "              \"required\": [\n" +
                "                \"id\",\n" +
                "                \"name\",\n" +
                "                \"type\",\n" +
                "                \"descriptor\",\n" +
                "                \"rt\"\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"object\",\n" +
                "              \"properties\": {\n" +
                "                \"id\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"name\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"type\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"descriptor\": {\n" +
                "                  \"type\": \"array\",\n" +
                "                  \"items\": {}\n" +
                "                },\n" +
                "                \"rt\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                }\n" +
                "              },\n" +
                "              \"required\": [\n" +
                "                \"id\",\n" +
                "                \"name\",\n" +
                "                \"type\",\n" +
                "                \"descriptor\",\n" +
                "                \"rt\"\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"object\",\n" +
                "              \"properties\": {\n" +
                "                \"id\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"name\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"type\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                },\n" +
                "                \"descriptor\": {\n" +
                "                  \"type\": \"array\",\n" +
                "                  \"items\": {}\n" +
                "                },\n" +
                "                \"rt\": {\n" +
                "                  \"type\": \"string\"\n" +
                "                }\n" +
                "              },\n" +
                "              \"required\": [\n" +
                "                \"id\",\n" +
                "                \"name\",\n" +
                "                \"type\",\n" +
                "                \"descriptor\",\n" +
                "                \"rt\"\n" +
                "              ]\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      \"required\": [\n" +
                "        \"version\",\n" +
                "        \"descriptor\"\n" +
                "      ]\n" +
                "    }\n" +
                "    },\n" +
                "    \"required\": [\n" +
                "    \"alps\"\n" +
                "    ]\n" +
                "}";
    }

    public static String getProfileUsersOptionsSchema(){
        return "{\n" +
                "    \"type\": \"object\",\n" +
                "    \"properties\": {\n" +
                "    \"timestamp\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"status\": {\n" +
                "      \"type\": \"integer\"\n" +
                "    },\n" +
                "    \"error\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"message\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"path\": {\n" +
                "      \"type\": \"string\"\n" +
                "    }\n" +
                "    },\n" +
                "    \"required\": [\n" +
                "    \"timestamp\",\n" +
                "    \"status\",\n" +
                "    \"error\",\n" +
                "    \"message\",\n" +
                "    \"path\"\n" +
                "    ]\n" +
                "}";
    }
}
