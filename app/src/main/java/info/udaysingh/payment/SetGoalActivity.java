package info.udaysingh.payment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeDirection;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SetGoalActivity extends AppCompatActivity implements PaymentResultListener{
    private CardStackView cardStackView;
    private CardStackAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);
        Button button_save = findViewById(R.id.button_save);
        final TextView textView_Offer_price = findViewById(R.id.textview_price);
        Checkout.preload(getApplicationContext());
        final Activity activity = this;

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final Checkout co = new Checkout();

                try {
                    JSONObject options = new JSONObject();
                    options.put("name", "Gray Hat Pvt. Ltd.");
                    options.put("description", "Adding to Your Savings");
                    //You can omit the image option to fetch the image from dashboard
                    

                    options.put("image", "https://rzp-mobile.s3.amazonaws.com/images/rzp.png");
                    options.put("currency", "INR");
                    options.put("amount", textView_Offer_price.getText().toString()+"00");

                    JSONObject preFill = new JSONObject();
                    preFill.put("email", "f71uday@gmail.com");
                    preFill.put("contact", "9479803953");

                    options.put("prefill", preFill);

                    co.open(activity, options);
                } catch (Exception e) {
                    Toast.makeText(activity, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                            .show();
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {
        try {
            Toast.makeText(this, "Payment Successful: " + s, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("Payment Activity", "Exception in onPaymentSuccess", e);
        }
    }

    @Override
    public void onPaymentError(int i, String s) {
        try {
            Toast.makeText(this, "Payment failed: " + i + " " + s, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("Payment Activity", "Exception in onPaymentError", e);
        }
    }
}
