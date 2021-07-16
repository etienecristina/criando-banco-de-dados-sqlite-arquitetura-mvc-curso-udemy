package primeiro.cliente.appminhaideiadbpratica.view;

import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import primeiro.cliente.appminhaideiadbpratica.API.AppUtil;
import primeiro.cliente.appminhaideiadbpratica.R;
import primeiro.cliente.appminhaideiadbpratica.controller.ClienteController;
import primeiro.cliente.appminhaideiadbpratica.model.Cliente;
import primeiro.cliente.appminhaideiadbpratica.model.Produto;

public class MainActivity extends AppCompatActivity {

    Cliente obj;
    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(AppUtil.TAG, "OnCreate: Appminhaideia database");

        clienteController = new ClienteController(getApplicationContext());



        for (int i = 0; i < 49; i++) {

            obj = new Cliente();
            obj.setNome("Etiene33" + i);
            obj.setEmail(i + "_etiene@etiene.com.br33");

            clienteController.incluir(obj);
        }

        for(Cliente obj: clienteController.listar());
        {
            Log.i("retorno: ", "onCreate: "+ obj.getId()+" "+obj.getNome()+" "+obj.getEmail());
        }



        /*
        if (clienteController.incluir(obj)) {
            Toast.makeText(MainActivity.this, "Cliente " + obj.getNome() + "incluído com sucesso", Toast.LENGTH_LONG).show();
            Log.i(AppUtil.TAG, "Cliente " + obj.getNome() + "incluído com sucesso...");

        } else {
            Toast.makeText(MainActivity.this, "Cliente " + obj.getNome() + " não incluído com sucesso", Toast.LENGTH_LONG).show();
            Log.e(AppUtil.TAG, "Cliente " + obj.getNome() + " não incluído com sucesso...");
        }

        if (clienteController.deletar(obj.getId())) {
            Toast.makeText(MainActivity.this, "Cliente " + obj.getNome() + " deletado com sucesso", Toast.LENGTH_LONG).show();
            Log.i(AppUtil.TAG, "Cliente " + obj.getNome() + "deletado com sucesso...");

        } else {
            Toast.makeText(MainActivity.this, "Cliente " + obj.getNome() + " não deletado com sucesso", Toast.LENGTH_LONG).show();
            Log.e(AppUtil.TAG, "Cliente " + obj.getNome() + " não deletado com sucesso...");
        }


        if (clienteController.alterar(obj)) {
            Toast.makeText(MainActivity.this, "Cliente " + obj.getNome() + " alterado com sucesso", Toast.LENGTH_LONG).show();
            Log.i(AppUtil.TAG, "Cliente " + obj.getNome() + "alterado com sucesso...");

        } else {
            Toast.makeText(MainActivity.this, "Cliente " + obj.getNome() + " não alterado com sucesso", Toast.LENGTH_LONG).show();
            Log.e(AppUtil.TAG, "Cliente " + obj.getNome() + " não alterado com sucesso...");
        }

        clienteController.listar();*/
    }
}