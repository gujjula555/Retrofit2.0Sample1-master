package com.iayon.retrofit20tutorial;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import models.Item;
import rest.Advataise;
import rest.ApiServiceProvider;
import rest.AtmListItems;
import rest.BankListItems;
import rest.BankResult;
import rest.Branch;
import rest.Loca;
import rest.RestClient;
import rest.Resultss;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;


public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter;
    List<Item> Users;
   /* private final Action1<Throwable> errorAction = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {

            String message = String.format("Error: %s", throwable.getMessage());
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listView);
        Users = new ArrayList<Item>();


        final ProgressDialog dialog = ProgressDialog.show(this, "", "loading...");
        dialog.show();
       RestClient.GitApiInterface apiService = ApiServiceProvider.initializeRetrofit(getApplicationContext());
        Map<String, String> map = new ArrayMap<>();
//put something inside the map, could be null
        map.put("City", "Bahrain");
       // RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject()).toString());

        apiService.syncContacts("Bahrain").observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<BankResult>() {
            @Override
            public void call(BankResult responseBody) {
                dialog.dismiss();
                Log.i("MainActivity", responseBody.toString());

                List<BankListItems> list = responseBody.getBankresu();


                for (BankListItems bankListItems : list) {
                    Log.d("BankListItems LogoUrl: ", bankListItems.getLogo_url());
                    Log.d("BankListItems name: ", bankListItems.getBank_name());
                    Log.d("BankListItems Id: ", bankListItems.getBankid());
                    Log.d("BankListItems AccosiatedUrl: ", bankListItems.getAssociated_bank_url());
                    Log.d("BankListItems weburl: ", bankListItems.getWeb_url());
                    Log.d("BankListItems queckpayurl: ", bankListItems.getQuick_pay_url());
                    Log.d("BankListItems city: ", bankListItems.getCity());
                    for (Branch branch : bankListItems.getList()) {
                        Log.d("Branch name: ", branch.getName());
                        Log.d("Branch Address: ", branch.getAdress());
                        Log.d("Branch Id: ", branch.getBranchid());
                        Log.d("Branch Pone: ", branch.getPhone());
                        Loca loc = branch.getLocati();
                        Log.d("Branch Lon: ", String.valueOf(loc.getLon()));
                        Log.d("Branch Lat: ", String.valueOf(loc.getLat()));
                        for (String openall : branch.getOpen_all_day()) {
                            Log.d("Branch oenall: ", openall);
                        }
                        for (String openMorn : branch.getOpen_morning()) {
                            Log.d("Branch openmaoring: ", openMorn);
                        }
                        for (String clos : branch.getClosed()) {
                            Log.d("Branch close: ", clos);
                        }
                        for (Branch.WorkingHours b : branch.getWorkingHours()) {
                            Branch.OpenTime openTime = b.getOpenTime();
                            Log.d("Branchbegin time: ", openTime.getBegin_time());
                            Log.d("Branch beignname: ", openTime.getEnd_time());
                            Branch.OpenTime openTime2 = b.getOpenTime1();
                            Log.d("Branch endname: ", openTime2.getBegin_time());
                            Log.d("Branch endname: ", openTime2.getEnd_time());

                        }
                    }


                    for (AtmListItems listItems : bankListItems.getAtmList()) {
                        Log.d("Atm name: ", listItems.getName());
                        Log.d("Atm Address: ", listItems.getAdress());
                        Log.d("Atm Id: ", listItems.getAtmid());
                        Loca loc = listItems.getLocati();
                        Log.d("Atm Lon: ", String.valueOf(loc.getLon()));
                        Log.d("Atm Lat: ", String.valueOf(loc.getLat()));


                    }

                }


            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                String message = String.format("Error: %s", throwable.getMessage());
                Log.d("error responce: Bank ", message);
                dialog.dismiss();
            }
        });


        apiService.getData().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Resultss>() {
            @Override
            public void call(Resultss responseBody) {
                Log.i("MainActivity", responseBody.toString());

                List<Advataise> list = responseBody.getResults();

                for (Advataise adv : list) {
                    Log.d("Advataise id: ", adv.getPostad_id());
                    Log.d("Advataise name: ", adv.getBank());
                    Log.d("Advataise title: ", adv.getTitle());
                    Log.d("Advataise weburl: ", adv.getWeb_url());
                    Log.d("Advataise arbic title: ", adv.getArabic_title());
                    Log.d("Advataise pub date: ", adv.getPub_date());
                    Log.d("Advataise text: ", adv.getText());
                    Log.d("Advataise notification: ", adv.getNotification_image_url());
                    for (String image : adv.getImage_urls()) {
                        Log.d("Advataise imageurls: ", image);
                    }


                }

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                String message = String.format("Error: %s", throwable.getMessage());
                Log.d("error responce:Ads ", message);
                dialog.dismiss();
            }
        });


/*

        RestClient restClient = new RestClient();
        RestClient.GitApiInterface service = restClient.getClient();




        Call<BankResult> caa = service.syncCont("Bahrain");






        caa.enqueue(new Callback<BankResult>() {
            @Override
            public void onResponse( Response<BankResult> response) {
                Log.i("MainActivity", response.toString());

                List<BankListItems> list = response.body().getBankresu();


                for (BankListItems bankListItems : list) {
                    Log.d("BankListItems LogoUrl: ", bankListItems.getLogo_url());
                    Log.d("BankListItems name: ", bankListItems.getBank_name());
                    Log.d("BankListItems Id: ", bankListItems.getBankid());
                    Log.d("BankListItems AccosiatedUrl: ", bankListItems.getAssociated_bank_url());
                    Log.d("BankListItems weburl: ", bankListItems.getWeb_url());
                    Log.d("BankListItems queckpayurl: ", bankListItems.getQuick_pay_url());
                    Log.d("BankListItems city: ", bankListItems.getCity());
                    for (Branch branch : bankListItems.getList()) {
                        Log.d("Branch name: ", branch.getName());
                        Log.d("Branch Address: ", branch.getAdress());
                        Log.d("Branch Id: ", branch.getBranchid());
                        Log.d("Branch Pone: ", branch.getPhone());
                        Loca loc = branch.getLocati();
                        Log.d("Branch Lon: ", String.valueOf(loc.getLon()));
                        Log.d("Branch Lat: ", String.valueOf(loc.getLat()));
                        for (String openall : branch.getOpen_all_day()) {
                            Log.d("Branch oenall: ", openall);
                        }
                        for (String openMorn : branch.getOpen_morning()) {
                            Log.d("Branch openmaoring: ", openMorn);
                        }
                        for (String clos : branch.getClosed()) {
                            Log.d("Branch close: ", clos);
                        }
                        for (Branch.WorkingHours b : branch.getWorkingHours()) {
                            Branch.OpenTime openTime = b.getOpenTime();
                            Log.d("Branchbegin time: ", openTime.getBegin_time());
                            Log.d("Branch beignname: ", openTime.getEnd_time());
                            Branch.OpenTime openTime2 = b.getOpenTime1();
                            //Log.d("Branch endname: ", null);

                            Log.d("Branch endname: ",""+ openTime2.getBegin_time());
                            Log.d("Branch endname: ", ""+openTime2.getEnd_time());

                        }
                    }


                    for (AtmListItems listItems : bankListItems.getAtmList()) {
                        Log.d("Atm name: ", listItems.getName());
                        Log.d("Atm Address: ", listItems.getAdress());
                        Log.d("Atm Id: ", listItems.getAtmid());
                        Loca loc = listItems.getLocati();
                        Log.d("Atm Lon: ", String.valueOf(loc.getLon()));
                        Log.d("Atm Lat: ", String.valueOf(loc.getLat()));


                    }

                }

            }

            @Override
            public void onFailure( Throwable t) {

            }
        });



        Call<Resultss> ca = service.getDat();
        ca.enqueue(new Callback<Resultss>() {
            @Override
            public void onResponse( Response<Resultss> response) {
                Log.i("MainActivity", response.toString());

                List<Advataise> list = response.body().getResults();

                for (Advataise adv : list) {
                    Log.d("Advataise id: ", adv.getPostad_id());
                    Log.d("Advataise name: ", adv.getBank());
                    Log.d("Advataise title: ", adv.getTitle());
                    Log.d("Advataise weburl: ", adv.getWeb_url());
                    Log.d("Advataise arbic title: ", adv.getArabic_title());
                    Log.d("Advataise pub date: ", adv.getPub_date());
                    Log.d("Advataise text: ", adv.getText());
                    Log.d("Advataise notification: ", adv.getNotification_image_url());
                    for (String image : adv.getImage_urls()) {
                        Log.d("Advataise imageurls: ", image);
                    }


                }


            }

            @Override
            public void onFailure( Throwable t) {

            }
        });


    }
*/}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
