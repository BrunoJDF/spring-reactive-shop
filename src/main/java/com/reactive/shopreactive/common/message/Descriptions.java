package com.reactive.shopreactive.common.message;

public class Descriptions {
    private static final String NOT_FOUND = "No se encontro ";
    private static final String BAD_REQUEST = "No se realizo peticion ";
    private static final String ERROR = "Error ";

    public static String notFound(Class<?> arg){
        return NOT_FOUND + arg.getName();
    }

    public static String badRequest(Class<?> arg){
        return BAD_REQUEST + arg.getName();
    }

    public static String error(Class<?> arg){
        return ERROR + arg.getName();
    }
}
