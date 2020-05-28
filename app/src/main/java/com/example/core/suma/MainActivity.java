package com.example.core.suma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.core.suma.Modelo.Suma;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView numero1, numero2, total;
    Button calcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero1 = (TextView) findViewById(R.id.txtNumero1);
        numero2 = (TextView) findViewById(R.id.txtNumero2);
        total = (TextView) findViewById(R.id.txtSuma);
        total.setKeyListener(null);
        calcular=(Button)this.findViewById(R.id.btnSuma);
        calcular.setOnClickListener(OkListener);
    }
    private View.OnClickListener OkListener =new View.OnClickListener(){
        public void onClick(View v) {
            calcularSuma();
        }
    };
    private void calcularSuma() {
        Suma suma = new Suma();
        try{
            suma.setNumero1(Integer.parseInt(numero1.getText().toString()));
            suma.setNumero2(Integer.parseInt(numero2.getText().toString()));
            suma.setSuma(suma.getNumero1()+suma.getNumero2());
            total.setText(""+suma.getSuma());

        }catch (Exception e){
            Toast.makeText(this,"Rellene ambos numeros a sumar",Toast.LENGTH_LONG).show();
        }
    }
}
