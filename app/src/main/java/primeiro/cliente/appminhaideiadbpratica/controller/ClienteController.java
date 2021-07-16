package primeiro.cliente.appminhaideiadbpratica.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import primeiro.cliente.appminhaideiadbpratica.API.AppUtil;
import primeiro.cliente.appminhaideiadbpratica.datamodel.ClienteDataModel;
import primeiro.cliente.appminhaideiadbpratica.datasource.AppDataBase;
import primeiro.cliente.appminhaideiadbpratica.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;


    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "Conectado");
    }


    @Override
    public boolean incluir(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.nome, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.email, obj.getEmail());

        return insert(ClienteDataModel.tabela, dadoDoObjeto);


    }

    @Override
    public boolean alterar(Cliente obj) {

        dadoDoObjeto = new ContentValues();


        dadoDoObjeto.put(ClienteDataModel.id, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.nome, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.email, obj.getEmail());


        return update(ClienteDataModel.tabela, dadoDoObjeto);
    }

    @Override
    public boolean deletar(int id) {

        return deleteById(ClienteDataModel.tabela, id);
    }

    @Override
    public List<Cliente> listar() {
       /* List<Cliente> lista = new ArrayList<>();

        lista.add(new Cliente());
        lista.add(new Cliente());
        lista.add(new Cliente());
        lista.add(new Cliente());
        lista.add(new Cliente());
        lista.add(new Cliente());

        Cliente novo = new Cliente();
        novo.setId(1);
        novo.setNome("etiene");
        novo.setEmail("etiene@etiene.com.br");

        lista.add(novo);

        int totalClientes = lista.size();*/

        return getAllClientes(ClienteDataModel.tabela);
    }
}
