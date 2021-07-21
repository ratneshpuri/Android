package com.example.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameField=findViewById(R.id.name_field);
        String name=nameField.getText().toString();

        CheckBox whippedCreamCheckBox=findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox=findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate=chocolateCheckBox.isChecked();

        int price=calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage=createOrderSummary(name,price,hasWhippedCream,hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) { //if there is activity on the device to handle the intent then it's safe to send the intent and we call start activity to start using the intent
            startActivity(intent);
        }
    }


    /**
     *Calculate price method
     */
    private int calculatePrice(boolean hasWhippedCream,boolean hasChocolate){
        int basePrice=5;
        if (hasWhippedCream){
            basePrice+=1;
        }
        if(hasChocolate){
            basePrice+=2;
        }
        return quantity*basePrice;
    }
    /**
     * Creates the summary of the order
     * @param price of the order
     * @param hasWhippedCream tells whether the whipped cream has been added or not
     * @param hasChololate tells whether chocolate has been added or not
     */
    private String createOrderSummary(String nameField, int price, boolean hasWhippedCream, boolean hasChololate){
        String priceMessage=getString(R.string.order_summary_name,nameField) ;
        priceMessage+="\n"+getString(R.string.order_summary_whipped_cream,hasWhippedCream) ;
        priceMessage+="\n"+getString(R.string.order_summary_chocolate,hasChololate) ;
        priceMessage+="\n "+getString(R.string.order_summary_quantity,quantity);
        priceMessage+="\n"+getString(R.string.order_summary_total,price) ;
        priceMessage+="\n"+getString(R.string.order_summary_thank_you) ;
        return priceMessage;
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view){
        if (quantity==100){
            Toast.makeText(this,"Above limit!!!",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity+1;
        display(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view){
        if (quantity==1){
            Toast.makeText(this,"Below limit!!!",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity-1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}
