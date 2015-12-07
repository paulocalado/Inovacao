package com.example.paulo.inovacao.database;

/**
 * Created by Paulo on 05/12/2015.
 */
public class Script {

    public static String getCreateDiarista(){



        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(" CREATE TABLE IF NOT EXISTS DIARISTA ( ");
        sqlBuilder.append(" _id     INTEGER    NOT NULL ");
        sqlBuilder.append("PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("NOME     VARCHAR(255), ");
        sqlBuilder.append("LOGIN    VARCHAR(20), ");/*Sempre dar espaço no final de cada parâmetro*/
        sqlBuilder.append("SENHA    VARCHAR (20), ");
        sqlBuilder.append("IDADE    VARCHAR (255), ");
        sqlBuilder.append("REGIAO   VARCHAR(40) ");
        sqlBuilder.append("SERVICO  VARCHAR(255) ");
        sqlBuilder.append("  ); ");

        return sqlBuilder.toString();

    }
}
