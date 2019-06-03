package store.theimitation.theimitationstore;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import store.theimitation.dto.Product;

public class ProductDescr extends AppCompatActivity {
    private Button sendOnWhatsApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_descr);

        sendOnWhatsApp=(Button) findViewById(R.id.sendOnWhatsApp);
        sendOnWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"fsdfsdf",Toast.LENGTH_LONG).show();
                        onClickWhatsApp();
            }

        }

        );
    }

    public void onClickWhatsApp() {

        PackageManager pm=getPackageManager();
        try {

            Intent sendIntent = new Intent(ProductDescr.this, ProductDescr.class);
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);

        } catch (Exception e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }

    }
}
