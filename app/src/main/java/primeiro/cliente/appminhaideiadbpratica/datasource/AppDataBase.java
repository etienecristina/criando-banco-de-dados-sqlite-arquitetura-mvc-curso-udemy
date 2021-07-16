package primeiro.cliente.appminhaideiadbpratica.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import primeiro.cliente.appminhaideiadbpratica.API.AppUtil;
import primeiro.cliente.appminhaideiadbpratica.datamodel.ClienteDataModel;
import primeiro.cliente.appminhaideiadbpratica.datamodel.ProdutoDataModel;
import primeiro.cliente.appminhaideiadbpratica.model.Cliente;


public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_Name = "AppMinhaIdeia.sqlite";
    public static final int DB_Version = 1;

    SQLiteDatabase db;

    public AppDataBase(Context context) {

        super(context, DB_Name, null, DB_Version);

        Log.d(AppUtil.TAG, "Criando banco de dados");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ClienteDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate: Tabela Cliente criada... " + ClienteDataModel.criarTabela());

        db.execSQL(ProdutoDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate: Tabela Produto criada..." + ProdutoDataModel.criarTabela());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    /**
     * MÉTODO PARA INCLUIR DADOS NO BANCO DE DADOS;
     */
    public boolean insert(String tabela, ContentValues dados) {

        db = getWritableDatabase();
        boolean retorno = false;

        try {
            retorno = db.insert(tabela, null, dados) > 0;

        } catch (Exception e) {
            Log.d(AppUtil.TAG, "Insert... " + ClienteDataModel.criarTabela());
        }
        return retorno;

    }

    /**
     * MÉTODO PARA DELETAR DADOS NO BANCO DE DADOS;
     */
    public boolean deleteById(String tabela, int id) {

        db = getWritableDatabase();
        boolean retorno = false;

        try {
            retorno = db.delete(tabela, "id = ?", new String[]{String.valueOf(id)}) > 0;

        } catch (Exception e) {
            Log.d(AppUtil.TAG, "Delete... " + e.getMessage());
        }
        return retorno;

    }

    /**
     * MÉTODO PARA ALTERAR DADOS NO BANCO DE DADOS;
     */


    public boolean update(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;


        try {
            retorno = db.update(tabela, dados, "id = ?", new String[]{String.valueOf(dados.get("id"))}) > 0;


        } catch (Exception e) {


            Log.d(AppUtil.TAG, "update: " + e.getMessage());


        }


        return retorno;
    }

    public List<Cliente> getAllClientes(String tabela) {

        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM " + tabela;
        Cliente obj;

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                obj = new Cliente();

                obj.setId(cursor.getInt(cursor.getColumnIndex(ClienteDataModel.id)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(ClienteDataModel.nome)));
                obj.setEmail(cursor.getString(cursor.getColumnIndex(ClienteDataModel.email)));

                clientes.add(obj);

                Log.i("Listar", "getAllClientes: "+obj.getNome());
            } while (cursor.moveToNext());
        }

        return clientes;
    }
}
