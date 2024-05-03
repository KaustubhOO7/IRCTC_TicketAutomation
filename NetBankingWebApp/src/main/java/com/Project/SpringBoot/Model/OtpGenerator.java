package com.Project.SpringBoot.Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class OtpGenerator 
{
	public void sendSMS(String otp,String number)
    {
        try
        {
           String api = "eI0mwH5OKFrg68RDxNSZ3ClQphYvMa7GLPTkdcti4u1VAEzfU9bfw8jWoZ5liXAyHsJOIFSpuaY7ekDQ";
           otp = URLEncoder.encode(otp,"UTF-8");

           String myUrl = "https://www.fast2sms.com/dev/bulkV2?authorization=" + api + "&variables_values=" + otp + "&route=otp&numbers=" + number;


            URL url = new URL(myUrl);
            HttpURLConnection con =(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent","Mozilla/5.0");
            con.setRequestProperty("cache-control","no cache");

            int code = con.getResponseCode();
            System.out.println("Response Code "+code);

            StringBuffer response = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while(true)
            {
                String line = br.readLine();
                if(line==null) break;

                response.append(line);
            }
            System.out.println(response);

        }
        catch (Exception e)
        {
            System.out.println("Error while sending SMS:");
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args)
	{
		
	}

}
