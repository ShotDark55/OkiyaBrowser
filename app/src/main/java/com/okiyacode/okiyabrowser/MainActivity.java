package com.okiyacode.okiyabrowser;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    EditText editTextUrl;
    WebView webView;

    private void setup() {
        btnGo = findViewById(R.id.GoID);
        editTextUrl = findViewById(R.id.urlID);
        webView = findViewById(R.id.webViewID);

//        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setup();

        btnGo.setOnClickListener(View -> {
            if (!editTextUrl.getText().toString().startsWith("https://")) {
                webView.loadUrl("https://" + editTextUrl.getText().toString());
            }


        });
    }
}