package com.mayank_amr.schoolmanagementproduct.network


import com.mayank_amr.schoolmanagementproduct.assignment.data.repository.NewAssignmentResponse
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata.StudentAttendanceModel
import com.mayank_amr.schoolmanagementproduct.dumywork.responce.Movie
import com.mayank_amr.schoolmanagementproduct.profile.profiledata.User
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import java.io.File

/**
 * @Project Sample Chat
 * @Created_by Mayank Kumar on 08-09-2020 08:26 AM
 */

interface MyApi {

    /*------------------------** Admission **-----------------------------------------------------*/
    // This API call fun is for Student Admission Registration and return response in AdmissionRegistrationResponse object type.
//    @POST("registration")
//    suspend fun registerStudent(
//        @Header("Accept") accept_type: String,
//        @Field("name") studentName: String,
//        @Field("father_name") fatherName: String,
//        @Field("mobile") mobile: String,
//        @Field("student_class") studentClass: String,
//        @Field("gender") gender: String,
//        @Field("address") address: String,
//        @Field("tc") tc: String,
//        @Field("migration") migration: String,
//        @Field("dob") dob: String?,
//        @Field("photo") photo: String
//    ): Response<StudentRegistrationResponse>
    /*--------------------------------------------------------------------------------------------*/


    /*------------------------** Class Work **----------------------------------------------------*/
//    @GET("students")
//    suspend fun getAllStudents(): Response<StudentsResponse>
    /*--------------------------------------------------------------------------------------------*/


    /* -----------------------** Assignment **----------------------------------------------------*/
    @POST("assignment")
    suspend fun createNewAssignment(
        @Header("Accept") accept_type: String, //Custom header
        @Field("question") studentId: String,
        @Field("file") assignmentId: File,
        @Field("due_date") solutionFile: String, // Format : YYYY-MM-DD
    ): Response<NewAssignmentResponse>

//    @POST("solution")
//    suspend fun submitAssignment(
//        @Field("student_id") studentId: String,
//        @Field("assignment_id") assignmentId: String,
//        @Field("solution_file") solutionFile: String,
//        @Field("comment") comment: String
//    ): Response<StudentAssignment>
    /*--------------------------------------------------------------------------------------------*/


    /* -----------------------** Profile **----------------------------------------------------*/
    @GET("profile")
    suspend fun getProfile(): Response<User>
    /*--------------------------------------------------------------------------------------------*/


    /*----------------------** Dummy Work *-------------------------------------------------------*/
    @GET("movies")
    suspend fun getMovies(): Response<List<Movie>>
    /*--------------------------------------------------------------------------------------------*/


    /*----------------------** Attendance **------------------------------------------------------*/
    @GET("studentAttendance")
    suspend fun getStudentForAttendance(): Response<List<StudentAttendanceModel>>
    /*--------------------------------------------------------------------------------------------*/


    companion object {
        private const val BASE_URL = /*"http://school-erp.herokuapp.com/"*/
            "https://api.simplifiedcoding.in/course-apis/recyclerview/"

        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): MyApi {

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}





