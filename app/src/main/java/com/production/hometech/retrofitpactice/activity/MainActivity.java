package com.production.hometech.retrofitpactice.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.production.hometech.retrofitpactice.R;
import com.production.hometech.retrofitpactice.adapter.RvContactAdapter;
import com.production.hometech.retrofitpactice.helper.ApiClient;
import com.production.hometech.retrofitpactice.helper.ApiInterface;
import com.production.hometech.retrofitpactice.helper.DividerItemDecoration;
import com.production.hometech.retrofitpactice.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ProgressDialog mProgressDialog;
    ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);

        apiService =
                ApiClient.getClient().create(ApiInterface.class);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

    }

    public void GetJsonData(View view) {

        if (mProgressDialog != null) {
            mProgressDialog.show();
        }

        Call<Contact> contactCall = apiService.getContactList();
        contactCall.enqueue(new Callback<Contact>() {
            public static final String TAG = "Respoonse ";

            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {

                int statusCode = response.code();

                if (response.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, "response : " + statusCode, Toast.LENGTH_SHORT).show();
                    if (mProgressDialog != null) {
                        mProgressDialog.dismiss();
                    }
                }

                List<Contact.ContactsBean> contactList = response.body().getContacts();

                recyclerView.setAdapter(new RvContactAdapter(contactList, MainActivity.this));
//                Toast.makeText(MainActivity.this, "contact 2  = " + contactList.get(2).getName(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {

                Log.e(TAG, "onFailure: " + t.toString());


            }
        });

    }

}