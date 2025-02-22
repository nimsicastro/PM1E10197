package com.example.pm1e197.configuracion;

public class Operaciones {

    public static final String NameDatabase = "PM01DB";


    public static String tblPaises = "paises";
    public static final String codigo ="codigo";
    public static final String p_pais="pais";

    public static final String CreateTablePaises = "CREATE TABLE " + tblPaises + "(codigo INTEGER PRIMARY KEY,"+"pais TEXT )";
    public static final String DropTablePaises = "DROP TABLE " + tblPaises;

    public static final String contactostabla = "contactos";

    public static final String id = "id";
    public static final String nombreCompleto = "nombreCompleto";
    public static final String telefono = "telefono";
    public static final String notaContacto = "notaContacto";
    public static final String foto = "foto";
    public static final String pais = "pais";


    public static final String createTableContact = "CREATE TABLE " + contactostabla +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombreCompleto TEXT, telefono INTEGER, notaContacto TEXT, foto BLOB, pais TEXT)";

    public static final String dropTableContact = "DROP TABLE IF EXIST" + contactostabla;
}
