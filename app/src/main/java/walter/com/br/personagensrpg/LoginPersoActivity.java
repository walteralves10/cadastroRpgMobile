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

public class LoginPersoActivity extends AppCompatActivity {

    private EditText nome;
    private EditText idade;
    private EditText sexo;
    private EditText personalidade;
    private EditText raca;
    private EditText classe;
    private EditText arma;
    private EditText cla;
    private Button salvar;
    private Button busca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_perso);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Voltar");

        salvar = (Button) findViewById(R.id.salvar);
        busca = (Button) findViewById(R.id.buscar);

        salvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());

                nome = (EditText) findViewById(R.id.campoNome);
                idade = (EditText) findViewById(R.id.campoIdade);
                sexo = (EditText) findViewById(R.id.campoSexo);
                personalidade = (EditText) findViewById(R.id.campoPersonalidade);
                raca = (EditText) findViewById(R.id.campoRaca);
                classe = (EditText) findViewById(R.id.campoClasse);
                arma = (EditText) findViewById(R.id.campoArma);
                cla = (EditText) findViewById(R.id.campoCla);

                String nomeString = nome.getText().toString();
                String idadeString = idade.getText().toString();
                String sexoString = sexo.getText().toString();
                String personalidadeString = personalidade.getText().toString();
                String racaString = raca.getText().toString();
                String classeString = classe.getText().toString();
                String armaString = arma.getText().toString();
                String claString = cla.getText().toString();
                String resultado;

                resultado = crud.inserePersonagem(nomeString,idadeString,sexoString,personalidadeString,racaString,classeString,armaString,claString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                clear((ViewGroup)findViewById(R.id.Inser));
            }
        });

        busca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ConsultaPersActivity.class);
                startActivity(intent);
            }
        });
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
