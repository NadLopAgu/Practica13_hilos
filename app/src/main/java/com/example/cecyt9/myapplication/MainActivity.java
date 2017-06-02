package com.example.cecyt9.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.*;


public class MainActivity extends Activity {
    private EditText entrada;
    private TextView salida;
    private ProgressBar pbarProgreso;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = (EditText) findViewById(R.id.entrada);
        salida = (TextView) findViewById(R.id.salida);
        pbarProgreso = (ProgressBar) findViewById(R.id.progressBar1);
    }

    public void calcularOperacion(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + "! = ");
//      int res = factorial(n);
//        salida.append(res + "\n");
        MiThread rs = new MiThread(n);
        rs.run();
    }
    public void calcularOperacion2(View view) {
        int n = Integer.parseInt(entrada.getText().toString());
        salida.append(n + "f = ");
//      int res = factorial(n);
//        salida.append(res + "\n");
        MiThread2 rs = new MiThread2(n);
        rs.run();
    }

    public int factorial(int n) {
        int res = 1;
        int aux = 100 / n;
        pbarProgreso.setMax(100);
        pbarProgreso.setProgress(0);
        for (int i = 1; i <= n; i++) {
            res *= i;
            SystemClock.sleep(1000);
            pbarProgreso.incrementProgressBy(aux);
        }

        return res;

    }

    class MiThread extends Thread {
        private int n, res;

        public MiThread(int n) {

            this.n = n;
        }


        @Override
        public void run() {
            res = factorial(n);
            salida.append(res + "\n");
        }

    class MiThread2 extends Thread {
        private int n, res;

        public MiThread2(int n) {
            this.n = n;
        }


        @Override
        public void run() {
            res = fibonacci(n);
            salida.append(res + "\n");
        }
    }


    public int fibonacci(int n){
        int res = 0;
        int aux = 100 / n;
        pbarProgreso.setMax(100);
        pbarProgreso.setProgress(0);
        if(n == 0){
            res = 0;
        }else
            for (int i = 0; i < n; i++) {
                res += auxfibonacci(i);
                pbarProgreso.incrementProgressBy(aux);
            }
        return res;
    }

    public int auxfibonacci(int n)
    {
        if (n>1){
            return auxfibonacci(n-1) + auxfibonacci(n-2);  //función recursiva
        }
        else if (n==1) {  // caso base
            return 1;
        }
        else if (n==0){  // caso base
            return 0;
        }
        else{ //error
            System.out.println("Debes ingresar un tamaño mayor o igual a 1");
            return -1;
        }
    }
}
