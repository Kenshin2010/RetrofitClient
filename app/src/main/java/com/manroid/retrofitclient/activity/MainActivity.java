package com.manroid.retrofitclient.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.manroid.retrofitclient.R;
import com.manroid.retrofitclient.constant.Constant;
import com.manroid.retrofitclient.api.CountryApi;
import com.manroid.retrofitclient.result.Country;
import com.manroid.retrofitclient.result.CountryFromCode;
import com.manroid.retrofitclient.result.GeoNames;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /***
     * Variable declaration part
     ***/
    private Button mBtnGet, mBtnPost, mBtnMultipart,mBtnQuery;
    private Intent mIntent;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    /**
     * @see
     * */
    private void initViews() {
        mBtnGet = (Button) findViewById(R.id.btn_get);
        mBtnPost = (Button) findViewById(R.id.btn_post);
        mBtnMultipart = (Button) findViewById(R.id.btn_multipart);
        mBtnQuery=(Button)findViewById(R.id.btn_query);
        mBtnMultipart.setOnClickListener(this);
        mBtnPost.setOnClickListener(this);
        mBtnGet.setOnClickListener(this);
        mBtnQuery.setOnClickListener(this);
        mIntent = getIntent();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Please Wait....");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setCancelable(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get:
                if (mProgressDialog != null && !mProgressDialog.isShowing()) {
                    mProgressDialog.show();
                }
                getCountryDetails();
                break;

            case R.id.btn_post:
                if (mProgressDialog != null && !mProgressDialog.isShowing()) {
                    mProgressDialog.show();
                }
                getGeoNames();
                break;

            case R.id.btn_multipart:
                if (mProgressDialog != null && !mProgressDialog.isShowing()) {
                    mProgressDialog.show();
                    ;
                }
                File file = new File(Environment.getExternalStorageDirectory() + "/photo.png");
                uploadImage(file);
                break;

            case R.id.btn_query:
                if (mProgressDialog != null && !mProgressDialog.isShowing()) {
                    mProgressDialog.show();
                    ;
                }
                getCountryFromCode("ind");
                break;
            default:
                break;
        }
    }

    private void getCountryFromCode(String ind) {

        Retrofit retrofit=getRetrofitBuilder(Constant.COUNTRY_URL);
        CountryApi codeApi=retrofit.create(CountryApi.class);

        Call<List<CountryFromCode>> call=codeApi.getTasks(ind);
        call.enqueue(new Callback<List<CountryFromCode>>() {
            @Override
            public void onResponse(Call<List<CountryFromCode>> call, Response<List<CountryFromCode>> response) {

                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }

                Log.i("RetrofitActivity", "Response" + response.isSuccessful()+"\n size is::"+response.body().toString());

                for(int i=0;i<response.body().size();i++){
                    Log.i("RetrofitActivity","Response Cname is::"+response.body().get(i).getName());

                    String value="CName:"+response.body().get(i).getName()
                            +"\n Capital::"+response.body().get(i).getCapital()
                            +"\n Region::"+response.body().get(i).getSubregion();
                    mIntent = new Intent(MainActivity.this, ResultActivity.class);
                    mIntent.putExtra("response", value);
                    startActivity(mIntent);
                }

            }

            @Override
            public void onFailure(Call<List<CountryFromCode>> call, Throwable t) {
                Log.e("RetrofitActivity", "RetrofitActivity Error::" + t.getMessage());
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
                mIntent = new Intent(MainActivity.this, ResultActivity.class);
                mIntent.putExtra("response", t.getMessage());
                startActivity(mIntent);
            }
        });
    }


    /**
     * @see Retrofit GET
     */
    private void getCountryDetails() {
        Retrofit retrofit = getRetrofitBuilder(Constant.COUNTRY_URL);
        CountryApi countryApi = retrofit.create(CountryApi.class);
        Call<List<Country>> call = countryApi.getCountry();

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                Log.i("RetrofitActivity", "Response" + response.isSuccessful());
                String name = "";
                for (int i = 0; i < response.body().size(); i++) {
                    name = name.concat(response.body().get(i).getName() + "\n");
                    Log.i("RetrofitActivity", "RetrofitActivity Name::" + response.body().get(i).getName());
                }
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
                mIntent = new Intent(MainActivity.this, ResultActivity.class);
                mIntent.putExtra("response", name);
                startActivity(mIntent);
                Log.i("RetrofitActivity", "RetrofitActivity Res::" + response.isSuccessful());
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.e("RetrofitActivity", "RetrofitActivity Error::" + t.getMessage());
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
                mIntent = new Intent(MainActivity.this, ResultActivity.class);
                mIntent.putExtra("response", t.getMessage());
                startActivity(mIntent);
            }
        });
    }

    /**
     * @see Retrofit POST
     */
    private void getGeoNames() {
        Retrofit retrofit = getRetrofitBuilder(Constant.GEONAMES_URL);
        CountryApi geoNameApi = retrofit.create(CountryApi.class);
        Call<GeoNames> call = geoNameApi.createUser("44.1", "-9.9", "-22.4", "55.2", "de", "demo");
        call.enqueue(new Callback<GeoNames>() {
            @Override
            public void onResponse(Call<GeoNames> call, Response<GeoNames> response) {
                String name = "";
                Log.i("RetrofitActivity", "Geoname Response" + response.isSuccessful());
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
                GeoNames geoNames = response.body();
                for (int i = 0; i < geoNames.getGeonames().size(); i++) {
                    name = name.concat(geoNames.getGeonames().get(i).getName() + "\n");
                    Log.i("RetrofitActivity", "GEONAMES Name::" + geoNames.getGeonames().get(i).getName());
                }
                mIntent = new Intent(MainActivity.this, ResultActivity.class);
                mIntent.putExtra("response", name);
                startActivity(mIntent);
            }

            @Override
            public void onFailure(Call<GeoNames> call, Throwable t) {
                Log.e("RetrofitActivity", "Geoname Error::" + t.getMessage());
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                }
                mIntent = new Intent(MainActivity.this, ResultActivity.class);
                mIntent.putExtra("response", t.getMessage());
                startActivity(mIntent);
            }
        });
    }


    /**
     * @see Retrofit POST with MULTIPART
     */
    private void uploadImage(File fileUri) {
        Retrofit retrofit = getRetrofitBuilder(Constant.FILEUPLOAD_URL);
        CountryApi service =
                retrofit.create(CountryApi.class);
        File file = new File(fileUri.getPath());
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body =
                MultipartBody.Part.createFormData("uploaded_file", file.getName(), requestFile);
        String descriptionString = "hello, this is description speaking";
        RequestBody description =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), descriptionString);
        Call<ResponseBody> call = service.upload(body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call,
                                   Response<ResponseBody> response) {
                Log.v("RetrofitActivity", "Upload Res is::"
                        + response.isSuccessful()
                        + "\n Message is::" + response.message().toString());
                Toast.makeText(MainActivity.this, "Upload Success Status::"
                        + response.isSuccessful(), Toast.LENGTH_SHORT).show();
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.setCancelable(true);
                    mProgressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("RetrofitActivity", "Upload error:" + t.getMessage());
                if (mProgressDialog != null && mProgressDialog.isShowing()) {
                    mProgressDialog.setCancelable(true);
                    mProgressDialog.dismiss();
                }
            }
        });

    }

    private Retrofit getRetrofitBuilder(String baseUrl) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)//third, log at the end
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }


}
