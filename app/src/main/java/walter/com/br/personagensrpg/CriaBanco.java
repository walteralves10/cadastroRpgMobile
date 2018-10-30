package walter.com.br.personagensrpg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper{

    public static final String NOME_BANCO = "rpg.db";

    public static final String TABELA_PERS = "personagem";
    public static final String ID = "_id";
    public static final String NOME = "nomePers";
    public static final String IDADE = "idadePers";
    public static final String SEXO = "sexoPers";
    public static final String PERSONALIDADE = "personalidadePers";
    public static final String RACA = "racaPers";
    public static final String CLASSE = "classePers";
    public static final String ARMA = "armaPers";
   // private static final String HISTORIA = "historiaPers";
    public static final String CLA = "claPers";
   // private static final String CIDADE_ORIGEM = "cidadeOrigemPers";

    public static final String TABELA_LOGIN = "login";
    public static final String USER_LOGIN = "userLog";
    public static final String SENHA_LOGIN = "senhaLog";

    public static final int VERSAO = 1;


    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA_PERS+"("
                +ID + " integer primary key autoincrement,"
                +NOME + " text,"
                +IDADE + " text,"
                +SEXO + " text,"
                +PERSONALIDADE + " text,"
                +RACA + " text,"
                +CLASSE + " text,"
                +ARMA + " text,"
                +CLA + " text"
                +")";

        String sqlTableLog = "CREATE TABLE "+TABELA_LOGIN+"("
                +USER_LOGIN + " text,"
                +SENHA_LOGIN + " text"
                +")";

        db.execSQL(sql);
        db.execSQL(sqlTableLog);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_LOGIN);
        onCreate(db);
    }
}
