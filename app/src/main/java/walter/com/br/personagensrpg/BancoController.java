package walter.com.br.personagensrpg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String inserePersonagem(String nome, String idade, String sexo, String personalidade, String raca, String classe, String arma, String cla){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.NOME, nome);
        valores.put(CriaBanco.IDADE, idade);
        valores.put(CriaBanco.SEXO, sexo);
        valores.put(CriaBanco.PERSONALIDADE, personalidade);
        valores.put(CriaBanco.RACA, raca);
        valores.put(CriaBanco.CLASSE, classe);
        valores.put(CriaBanco.ARMA, arma);
        valores.put(CriaBanco.CLA, cla);

        resultado = db.insert(CriaBanco.TABELA_PERS, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public String insereLogin(String user, String senha){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.USER_LOGIN, user);
        valores.put(CriaBanco.SENHA_LOGIN, senha);

        resultado = db.insert(CriaBanco.TABELA_LOGIN, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregaLog(){
        Cursor cursor;
        String[] campos =  {banco.SENHA_LOGIN,banco.USER_LOGIN};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA_LOGIN, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaPers(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.NOME};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA_PERS, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}
