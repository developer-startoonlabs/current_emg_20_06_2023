package com.startemg.apps.pheezee.activities;

import static com.startemg.apps.pheezee.activities.PatientsView.json_phizioemail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.startemg.apps.pheezee.adapters.MyAdapterNew;
import com.startemg.apps.pheezee.pojos.ViewSessionReportData;
import com.startemg.apps.pheezee.pojos.ViewStatusSessionHistory;
import com.startemg.apps.pheezee.popup.ViewPopUpWindow;
import com.startemg.apps.pheezee.retrofit.GetDataService;
import com.startemg.apps.pheezee.retrofit.RetrofitClientInstance;
import com.startemg.apps.pheezee.room.Entity.PhizioPatients;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import startemg.apps.pheezee.R;

public class SortHistoryYear extends AppCompatActivity {

    String pt_name_arr[], pt_des_arr[];
    String car_name_arr[], car_des_arr[],car_col_arr[], car_id_arr[];
    RecyclerView recyclerView;
    List<String> titles,titles2,titles3,titles4;
    ArrayList<String> Imgurl;
    ImageView imageView, iv_back_app_info;

    Button btn_history, btn_today;
    GetDataService getDataService;
    String Session_count="-";
    String Report_count="-";
    String Report_collection="-";
    String Heldon_dates = "-";

    String Patient_ID = "-";

    String[] strArray = null;

    String[] strArray_two = null;

    String[] strArray_three = null;
    String[] strArray_four = null;

    String[] strArray_five = null;



    public static void ViewPopUpWindows(Context applicationContext, String patients, String json_phizioemails) {
        ViewPopUpWindow popUpWindow = new ViewPopUpWindow(applicationContext, patients, json_phizioemails);
        popUpWindow.openViewPopUpWindow();
    }

    public void viewPopUpWindow(PhizioPatients patient) {

//        repository.view_data(json_phizioemail,patient.getPatientid());
//        repository.view_data_last(json_phizioemail,patient.getPatientid());
//        repository.view_data_report(json_phizioemail,patient.getPatientid());
//        repository.view_data_goal(json_phizioemail,patient.getPatientid(),patient.getDateofjoin());

    }



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        new CountDownTimer(1000, 1000){
            public void onTick(long millisUntilFinished) {
                Intent intent = new Intent();
                intent.putExtra("et_phizio_email", json_phizioemail);
                String str1 = intent.getStringExtra("et_phizio_email");
                Intent intent1 = getIntent();
                String month_and_year = intent1.getStringExtra("month_and_year");
                ViewStatusSessionHistory data = new ViewStatusSessionHistory(str1, month_and_year, "Year");
                Call<ViewSessionReportData> view_report_data_history_data = getDataService.view_report_month_length(data);
                view_report_data_history_data.enqueue(new Callback<ViewSessionReportData>() {
                    @Override
                    public void onResponse(@NonNull Call<ViewSessionReportData> call, @NonNull Response<ViewSessionReportData> response) {
                        if (response.code() == 200) {
                            ViewSessionReportData res = response.body();
                            Session_count = res.getSession();
                            Report_count = res.getReport();
                            Report_collection = res.getReportCollection();
                            Heldon_dates = res.getHeldonDates();
                            Patient_ID = res.getPatientData();

                            Log.e("Kranthi_Status","Working");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ViewSessionReportData> call, @NonNull Throwable t) {
                        Log.e("Kranthi_Status","Not_Working");
                    }
                });

            }
            public void onFinish() {
                setContentView(R.layout.activity_sort_history_year);
                iv_back_app_info = findViewById(R.id.iv_back_app_info);
                btn_history = findViewById(R.id.btn_history);
                btn_today = findViewById(R.id.btn_today);

                btn_today.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent today = new Intent(SortHistoryYear.this, SortHistoryDate.class);
                        startActivity(today);
                    }
                });
//                btn_history.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent history = new Intent(SortHistoryYear.this, SortHistoryYear.class);
//                        startActivity(history);
//                    }
//                });
                iv_back_app_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent back_press = new Intent(SortHistoryYear.this, PhizioProfile.class);
                        startActivity(back_press);
                    }
                });
                Imgurl = new ArrayList<>();
                titles = new ArrayList<>();
                titles2 = new ArrayList<>();
                titles3 = new ArrayList<>();
                titles4 = new ArrayList<>();


                imageView = findViewById(R.id.imageView);
                recyclerView = findViewById(R.id.RecyclerView);

                strArray = Report_count.split(",");
                for (int i = 0; i< strArray.length; i++){
                    titles.add(strArray[i]);
                }

                strArray_two = Report_collection.split(",");
                for (int i = 0; i< strArray_two.length; i++){
                    titles2.add(strArray_two[i]);
                }

                strArray_four = Heldon_dates.split(",");
                for (int i = 0; i< strArray_four.length; i++){
                    titles3.add(strArray_four[i]);
                }

                strArray_five = Patient_ID.split(",");
                for (int i = 0; i< strArray_five.length; i++){
                    titles4.add(strArray_five[i]);
                }

                strArray_three = Session_count.split(",");
                for (int i = 0; i< strArray_three.length; i++){

                    if(strArray_three[i].equalsIgnoreCase("empty")){
                        Imgurl.add("https://drive.google.com/file/d/1udABunZs-amdbnRnss3RjCLC70jzm1K6/view?usp=share_link");
                    }else{
                        String temp = strArray_three[i];
                        temp = "https://s3.ap-south-1.amazonaws.com/pheezee/" + temp;
                        Imgurl.add(temp);
                    }
                }

                car_name_arr = strArray;
                car_des_arr = strArray_two;
                car_col_arr = strArray_four;
                car_id_arr = strArray_five;

                MyAdapterNew myAdapter = new MyAdapterNew(SortHistoryYear.this,car_name_arr,car_des_arr,car_col_arr,car_id_arr,Imgurl);
                recyclerView.setAdapter(myAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));



            }

        }.start();

    }
    @Override
    public void onBackPressed() {
        Intent back_press = new Intent(SortHistoryYear.this, PhizioProfile.class);
        startActivity(back_press);

    }
}