package com.reactive.shopreactive.common.message;

public class Descriptions {
    private static final String NOT_FOUND = "No se encontro ";
    private static final String BAD_REQUEST = "No se realizo peticion ";
    private static final String ERROR = "Error ";

    public static String notFound(String arg){
        return NOT_FOUND + arg;
    }

    public static String badRequest(String arg){
        return BAD_REQUEST + arg;
    }

    public static String error(String arg){
        return ERROR + arg;
    }
}
