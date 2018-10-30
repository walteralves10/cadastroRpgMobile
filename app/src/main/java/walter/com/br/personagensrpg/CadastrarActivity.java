package walter.com.br.personagensrpg;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarActivity extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private Button salvar;
    private Button buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        salvar = (Button) findViewById(R.id.salvar);
        buscar = (Button) findViewById(R.id.buscarLog);

        salvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());

                user = (EditText) findViewById(R.id.campoUser);
                pass = (EditText) findViewById(R.id.campoPass);


                String userString = user.getText().toString();
                String passString = pass.getText().toString();

                String resultado;

                resultado = crud.insereLogin(userString,passString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                clear((ViewGroup)findViewById(R.id.Cadis));
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ConsultaLoginActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Voltar");     //Titulo para ser exibido na sua Action Bar em frente à seta


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, MainRpgActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    public void clear(ViewGroup group) {

        int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = group.getChildAt(i);
            if (view instanceof ViewGroup) {
                clear((ViewGroup) view);
                continue;
            }
            if (view instanceof EditText) {
                ((EditText)view).setText("");
                continue;
            }
        }

    }

}
