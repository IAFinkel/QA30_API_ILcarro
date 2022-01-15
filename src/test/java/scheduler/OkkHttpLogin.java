package scheduler;

import com.google.gson.Gson;
import dto.Error;
import dto.RegRequestDto;
import dto.RegResponceDto;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkkHttpLogin {
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

    @Test
    public void loginTest() throws IOException {
        RegRequestDto requestDto = RegRequestDto.builder()
                .email("")
                .password("")
                .build();
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(gson.toJson(requestDto), JSON);
        Request request = new Request.Builder()
                .url("https://super-scheduler-app.herokuapp.com/api/login")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        if(response.isSuccessful()){
            String responceJson = response.body().string();
            RegResponceDto regResponceDto = gson.fromJson(responceJson, RegResponceDto.class);
            regResponceDto.getToken();
            regResponceDto.getStatus();
            Assert.assertTrue(response.isSuccessful());
        }
        else {
            String responceJson = response.body().string();
            Error error = gson.fromJson(responceJson, Error.class);
            System.out.println("Wrong email or password"+error.getMessage());
            System.out.println(error.getCode()+error.getMessage()+error.getDetails());
        }

    }

    @Test
    public void loginTestPositive() throws IOException {
        RegRequestDto requestDto = RegRequestDto.builder()
                .email("")
                .password("")
                .build();
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(gson.toJson(requestDto), JSON);
        Request request = new Request.Builder()
                .url("https://super-scheduler-app.herokuapp.com/api/login")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

            String responceJson = response.body().string();
            RegResponceDto regResponceDto = gson.fromJson(responceJson, RegResponceDto.class);
            regResponceDto.getToken();
            regResponceDto.getStatus();
            Assert.assertTrue(regResponceDto.isRegistration());
            Assert.assertEquals(regResponceDto.getStatus(),"Registration success");


    }

    @Test
    public void loginTestNegative() throws IOException {
        RegRequestDto requestDto = RegRequestDto.builder()
                .email("")
                .password("")
                .build();
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(gson.toJson(requestDto), JSON);
        Request request = new Request.Builder()
                .url("https://super-scheduler-app.herokuapp.com/api/login")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        String responceJson = response.body().string();
        Error error = gson.fromJson(responceJson, Error.class);

        Assert.assertEquals(error.getMessage(),"Wrong email or password");


    }


}
