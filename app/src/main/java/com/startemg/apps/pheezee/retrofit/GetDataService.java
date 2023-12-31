package com.startemg.apps.pheezee.retrofit;

import com.startemg.apps.pheezee.pojos.AddPatientData;
import com.startemg.apps.pheezee.pojos.CalbrationData;
import com.startemg.apps.pheezee.pojos.CommentSessionUpdateData;
import com.startemg.apps.pheezee.pojos.ConfirmEmailAndPackageId;
import com.startemg.apps.pheezee.pojos.CurrentData;
import com.startemg.apps.pheezee.pojos.DeletePatientData;
import com.startemg.apps.pheezee.pojos.DeletePhiziouserData;
import com.startemg.apps.pheezee.pojos.DeleteSessionData;
import com.startemg.apps.pheezee.pojos.DeviceDeactivationStatus;
import com.startemg.apps.pheezee.pojos.DeviceDeactivationStatusResponse;
import com.startemg.apps.pheezee.pojos.DeviceDetailsData;
import com.startemg.apps.pheezee.pojos.DeviceLocationStatus;
import com.startemg.apps.pheezee.pojos.FirmwareData;
import com.startemg.apps.pheezee.pojos.FirmwareUpdateCheck;
import com.startemg.apps.pheezee.pojos.FirmwareUpdateCheckResponse;
import com.startemg.apps.pheezee.pojos.ForgotPassword;
import com.startemg.apps.pheezee.pojos.GetReportData;
import com.startemg.apps.pheezee.pojos.GetReportDataResponse;
import com.startemg.apps.pheezee.pojos.HealthData;
import com.startemg.apps.pheezee.pojos.LoginData;
import com.startemg.apps.pheezee.pojos.LoginResult;
import com.startemg.apps.pheezee.pojos.MmtData;
import com.startemg.apps.pheezee.pojos.MobileToken;
import com.startemg.apps.pheezee.pojos.NormativeData;
import com.startemg.apps.pheezee.pojos.NormativeDataCamp;
import com.startemg.apps.pheezee.pojos.NormativeReferance;
import com.startemg.apps.pheezee.pojos.NormativeReferanceComp;
import com.startemg.apps.pheezee.pojos.NormativeRom;
import com.startemg.apps.pheezee.pojos.Overallresponse;
import com.startemg.apps.pheezee.pojos.PatientDetailsData;
import com.startemg.apps.pheezee.pojos.PatientImageData;
import com.startemg.apps.pheezee.pojos.PatientImageUploadResponse;
import com.startemg.apps.pheezee.pojos.PatientStatusData;
import com.startemg.apps.pheezee.pojos.PatientStatusDataMonth;
import com.startemg.apps.pheezee.pojos.PhizioDetailsData;
import com.startemg.apps.pheezee.pojos.PhizioEmailData;
import com.startemg.apps.pheezee.pojos.PhizioSessionReportData;
import com.startemg.apps.pheezee.pojos.ResponseData;
import com.startemg.apps.pheezee.pojos.SceduledSessionNotSaved;
import com.startemg.apps.pheezee.pojos.SerialData;
import com.startemg.apps.pheezee.pojos.SessionData;
import com.startemg.apps.pheezee.pojos.SessionDetailsResult;
import com.startemg.apps.pheezee.pojos.SessionStatusView;
import com.startemg.apps.pheezee.pojos.SesssionPrintSummary;
import com.startemg.apps.pheezee.pojos.SignUpData;
import com.startemg.apps.pheezee.pojos.ViewData;
import com.startemg.apps.pheezee.pojos.ViewDataGoal;
import com.startemg.apps.pheezee.pojos.ViewDataLast;
import com.startemg.apps.pheezee.pojos.ViewDataReport;
import com.startemg.apps.pheezee.pojos.ViewSessionReportData;
import com.startemg.apps.pheezee.pojos.ViewSessionReportDataSort;
import com.startemg.apps.pheezee.pojos.ViewStatusSessionHistory;
import com.startemg.apps.pheezee.pojos.ViewSummaryDetails;
import com.startemg.apps.pheezee.pojos.WarrantyData;
import com.startemg.apps.pheezee.room.Entity.MqttSync;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 *
 */
public interface GetDataService {
    @GET
    Call<ResponseBody> getReport(@Url String url);


    @POST("/api/login/phizio")
    Call<List<LoginResult>> login(@Body LoginData object);

    @POST("/api/phizio/update/patientStatus")
    Call<String> updatePatientStatus(@Body PatientStatusData object);

    @POST("/api/phizio/updatepatientdetails")
    Call<String> updatePatientDetails(@Body PatientDetailsData patient);

    @POST("/api/phizio/addpatient")
    Call<ResponseData> addPatient(@Body AddPatientData patientData);

    @POST("/api/phizio/deletepatient")
    Call<String> deletePatient(@Body DeletePatientData data);


    @POST("/api/forgot/password")
    Call<String> forgotPassword(@Body ForgotPassword object);

    @POST("/api/phizioprofile/update/password")
    Call<String> updatePassword(@Body LoginData data);

    @POST("/api/phizioprofile/update/app_version")
    Call<String> updateApp_version(@Body LoginData data);

    @POST("/api/getheldon")
    Call<String> getHeldon(@Body PatientStatusData object);

    @POST("/api/getsession_report_count")
    Call<PhizioSessionReportData> getsession_report_count(@Body PatientStatusData object);

    @POST("/api/getsession_report_count_month")
    Call<PhizioSessionReportData> getsession_report_count_month(@Body PatientStatusDataMonth object);

    @POST("/api/getsession_number_count")
    Call<PhizioSessionReportData> getsession_number_count(@Body PatientStatusData object);

    @POST("/api/getoveralletails")
    Call<Overallresponse> getOverall_list(@Body PatientStatusData object);

    @POST("/api/getsessiondetails")
    Call <List<SessionDetailsResult>> getSessiondetails(@Body PatientStatusData object);

    @POST("/api/confirm/email")
    Call<String> confirmEmail(@Body ConfirmEmailAndPackageId object);

    @POST("/api/signup/phizio")
    Call<String> signUp(@Body SignUpData data);

    @POST("/api/phizio/update/patientProfilePic")
    Call<PatientImageUploadResponse> uploadPatientProfilePicture(@Body PatientImageData data);

    @POST("/api/phizioprofile/update")
    Call<String> updatePhizioDetails(@Body PhizioDetailsData data);

    @POST("/api/phizio/profilepic/upload")
    Call<PatientImageUploadResponse> updatePhizioProfilePic(@Body PatientImageData data);

    @POST("/api/phizio/cliniclogo/upload")
    Call<PatientImageUploadResponse> updatePhizioClinicLogoPic(@Body PatientImageData data);

    @POST("/api/patient/generate/report_v2")
    Call<GetReportDataResponse> getReportData(@Body GetReportData data);


    @POST("/api/patient/entireEmgData")
    Call<ResponseData> insertSessionData(@Body SessionData data);

    @POST("/api/phizio/patient/deletepatient/sesssion")
    Call<ResponseData> deletePatientSession(@Body DeleteSessionData data);

    @POST("/api/phizio/patient/updateMmtGrade")
    Call<ResponseData> updateMmtData(@Body MmtData data);

    @POST("/api/phizio/patient/updateCommentSection")
    Call<String> updateCommentData(@Body CommentSessionUpdateData data);

    @POST("/api/sync/data")
    Call<List<Integer>> syncDataToServer(@Body List<MqttSync> sync);

    @POST("/api/firmware/log")
    Call<Boolean> sendFirmwareLog(@Body FirmwareData log);

    @POST("/api/firmware/update/check")
    Call<FirmwareUpdateCheckResponse> checkFirmwareUpdateAndGetLink(@Body FirmwareUpdateCheck check);

    @POST("/api/insert/pheezee/health/status")
    Call<Boolean> sendHealthStatusOfDevice(@Body HealthData data);

    @POST("/api/update/device/location")
    Call<Boolean> sendDeviceLocationUpdate(@Body DeviceLocationStatus data);

    @POST("/api/insert/pheezee/device")
    Call<Boolean> sendDeviceDetailsToTheServer(@Body DeviceDetailsData data);

    @POST("/api/update/device/email/used")
    Call<Boolean> sendEmailUsedWithDevice(@Body PhizioEmailData data);

    @POST("/api/get/device/status")
    Call<DeviceDeactivationStatusResponse> getDeviceStatus(@Body DeviceDeactivationStatus status);

    @POST("/api/phizio/device/mobileToken")
    Call<Boolean> sendMobileTokenToTheServer(@Body MobileToken token);

    @POST("/api/sceduled/session/not/saved")
    Call<Boolean> sendSceduledSessionNotSaved(@Body SceduledSessionNotSaved sceduledSessionNotSaved);

    @POST("/api/delete-phiziouser")
    Call<String> deletePhiziouser(@Body DeletePhiziouserData data);

    @POST("/api/phizio/calbirations")
    Call<String> cal(@Body CalbrationData data);

    @POST("/api/get-warranty-details")
    Call<String> warrantyDetails(@Body WarrantyData data);

    @POST("/api/get-serial-number")
    Call<String> serialnumber(@Body SerialData data);

    @POST("/api/normative")
    Call<String> normative(@Body NormativeData data);

    @POST("/api/normative-referance")
    Call<String> normative_referance(@Body NormativeReferance data);

    @POST("/api/normative-rom")
    Call<String> normative_rom(@Body NormativeRom data);

    @POST("/api/normative_referance_comp")
    Call<String> normative_referance_comp(@Body NormativeReferanceComp data);

    @POST("/api/normative_data_camp")
    Call<String> normative_data_camp(@Body NormativeDataCamp data);

    @POST("/api/current_data")
    Call<String> current_session_data(@Body CurrentData data);

    @POST("/api/view_data_value")
    Call<String> view_data(@Body ViewData data);

    @POST("/api/view_data_value_last")
    Call<String> view_data_last(@Body ViewDataLast data);

    @POST("/api/view_data_value_report")
    Call<String> view_data_report(@Body ViewDataReport data);

    @POST("/api/view_data_value_goal")
    Call<String> view_data_goal(@Body ViewDataGoal data);

    @POST("/api/patient/generate/report_testing")
    Call<ViewSessionReportData> view_report_data_history (@Body ViewStatusSessionHistory data);


    @POST("/api/print_value")
    Call<SesssionPrintSummary> session_print (@Body SessionStatusView data);

    @POST("/api/patient/generate/report_today")
    Call<ViewSessionReportData> view_report_data_history_report (@Body ViewSessionReportDataSort data);

    @POST("/api/view_report_Summary")
    Call<ViewSummaryDetails> view_summary_report (@Body ViewSessionReportDataSort data);


    @POST("/api/patient/generate/report_today_arr")
    Call<ViewSessionReportData> view_report_data_history_report_array (@Body ViewSessionReportDataSort data);

    @POST("/api/patient/generate/report_history")
    Call<ViewSessionReportData> view_report_month_length (@Body ViewStatusSessionHistory data);


}
