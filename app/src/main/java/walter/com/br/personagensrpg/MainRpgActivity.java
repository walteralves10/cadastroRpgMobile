package walter.com.br.personagensrpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainRpgActivity extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private Button btnMain;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rpg);

        email = (EditText) findViewById(R.id.campoEmail);
        senha = (EditText) findViewById(R.id.campoSenha);
        btnMain = (Button) findViewById(R.id.enviar);
        btnCadastrar = (Button) findViewById(R.id.cadastrar);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(email.getText().toString().equals("root") && senha.getText().toString().equals("root")){

                    Toast.makeText(MainRpgActivity.this,
                            "Login efetuado com sucesso!",
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getBaseContext(), LoginPersoActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainRpgActivity.this,
                            "email:"+ email.getText() + "\nsenha:" + senha.getText(),
                            Toast.LENGTH_SHORT).show();
                }


                //----------------------------------------------------------------------

            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CadastrarActivity.class);
                startActivity(intent);

            }
        });

    }
}
