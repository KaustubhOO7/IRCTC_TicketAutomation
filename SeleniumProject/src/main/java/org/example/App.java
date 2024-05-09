package org.example;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Iterator;

//If the entered Captcha is wrong then, you can still fill the captcha and continue.

public class App {
    public static void main(String[] args) throws Exception
    {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofHours(1));

        driver.manage().window().maximize();
        driver.get("https://www.irctc.co.in/nget/train-search");

        //HamBurger click
        driver.findElement(By.className("fa")).click();

        //Login click
        driver.findElement(By.cssSelector("button[class = 'search_btn']")).click();

        //Filling Username and Password
        driver.findElement(By.cssSelector("input[placeholder = 'User Name']")).sendKeys("kstbsharma");
        driver.findElement(By.cssSelector("input[placeholder = 'Password']")).sendKeys("Kstb1999");

        //Captcha Value Catching
        WebElement element = driver.findElement(By.cssSelector(".captcha-img"));
        String imgUrl = element.getAttribute("src");

        //GetCaptcha Method
        String captcha = getCaptcha(imgUrl);

        //Sending Captcha
        driver.findElement(By.cssSelector("#captcha")).sendKeys(captcha);

        driver.findElement(By.cssSelector("form[class='ng-valid ng-dirty ng-touched'] button[type='submit']")).click();

        //Wait till upper window gets close
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[placeholder='User Name']")));

        //From
        driver.findElement(By.cssSelector(".ng-tns-c57-8.ui-inputtext.ui-widget.ui-state-default.ui-corner-all.ui-autocomplete-input.ng-star-inserted")).sendKeys("NEW DELHI - NDLS (NEW DELHI)");

        //To
        driver.findElement(By.cssSelector(".ng-tns-c57-9.ui-inputtext.ui-widget.ui-state-default.ui-corner-all.ui-autocomplete-input.ng-star-inserted")).sendKeys("RANCHI - RNC (HATIA/RANCHI)");

        //Date click
        driver.findElement(By.cssSelector(".ng-tns-c58-10.ui-inputtext.ui-widget.ui-state-default.ui-corner-all.ng-star-inserted")).click();

        Thread.sleep(1000);

        //Date Select. Change date by selecting appropriate css selector
        driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(6) a:nth-child(1)")).click();

        //Click for Tatkal
        driver.findElement(By.cssSelector(".ng-tns-c65-12.ui-dropdown.ui-widget.ui-state-default.ui-corner-all")).click();

        //Tatkal click
        driver.findElement(By.cssSelector("li[aria-label='TATKAL']")).click();

        //Search click
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //Change here also the train class
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='tbis-div'] div:nth-child(1) div:nth-child(1) app-train-avl-enq:nth-child(1) div:nth-child(1) div:nth-child(5) div:nth-child(1) table:nth-child(1) tr:nth-child(1) td:nth-child(1) div:nth-child(1) div:nth-child(2)")));

        //Wait till the Time to click on selecting class
        waitUntilSpecificTime(LocalTime.of(1,4,0), ZoneId.of("Asia/Kolkata"));

//------------From here user have to change the css locator according to the train----------

        //click on class selection
        driver.findElement(By.cssSelector("div[class='tbis-div'] div:nth-child(1) div:nth-child(1) app-train-avl-enq:nth-child(1) div:nth-child(1) div:nth-child(5) div:nth-child(1) table:nth-child(1) tr:nth-child(1) td:nth-child(1) div:nth-child(1) div:nth-child(2)")).click();

        //wait for seat availability and this css selector should match with the below selector
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".WL.col-xs-12")));

        //click on available seats
        driver.findElement(By.cssSelector(".WL.col-xs-12")).click();

//--------------Till here--------------

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btnDefault train_Search ng-star-inserted']")));

        //click on Book Now
        driver.findElement(By.cssSelector("button[class='btnDefault train_Search ng-star-inserted']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Passenger Name']")));

        //Filling Details
        driver.findElement(By.cssSelector("input[placeholder='Passenger Name']")).sendKeys("Kaustubh Sharma");
        driver.findElement(By.cssSelector("input[placeholder='Age']")).sendKeys("25");
        driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid.ng-star-inserted")).sendKeys("Male");
        driver.findElement(By.cssSelector("select[formcontrolname='passengerBerthChoice']")).sendKeys("Upper");
        driver.findElement(By.cssSelector("#FOOD_0")).sendKeys("Veg");

        //Click on Add passenger
        driver.findElement(By.cssSelector("div[class='form-group col-xs-12 border-all'] span:nth-child(2)")).click();

        Thread.sleep(1500);

        driver.findElement(By.cssSelector(".ng-tns-c57-68.ui-inputtext.ui-widget.ui-state-default.ui-corner-all.ui-autocomplete-input.ng-star-inserted")).sendKeys("Mayank Sharma");
        driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid[maxlength='3']")).sendKeys("23");
        driver.findElement(By.cssSelector(".form-control.ng-untouched.ng-pristine.ng-invalid.ng-star-inserted")).sendKeys("Male");
        driver.findElement(By.cssSelector("div[class='Layer_7 col-sm-3 col-xs-6 ng-star-inserted'] select[class='form-control ng-untouched ng-pristine ng-valid ng-star-inserted']")).sendKeys("Upper");
        driver.findElement(By.cssSelector("#FOOD_1")).sendKeys("Veg");

        //Click on BHIM UPI
        driver.findElement(By.cssSelector("span[class='ui-radiobutton-icon ui-clickable']")).click();

        //Click on Continue1
        driver.findElement(By.cssSelector("button[class='train_Search btnDefault']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".captcha-img")));

        //Captcha Value Catching
        WebElement element1 = driver.findElement(By.cssSelector(".captcha-img"));
        String imgUrl1 = element1.getAttribute("src");

        //GetCaptcha Method
        String captcha1 = getCaptcha(imgUrl1);

        //Sending Captcha
        driver.findElement(By.cssSelector("#captcha")).sendKeys(captcha1);

        //Click on Continue2
        driver.findElement(By.cssSelector("button[class='btnDefault train_Search']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root:nth-child(2) > app-home:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-payment-options:nth-child(2) > div:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > app-payment:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > span:nth-child(1) > div:nth-child(3) > span:nth-child(2)")));

        driver.findElement(By.cssSelector("body > app-root:nth-child(2) > app-home:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-payment-options:nth-child(2) > div:nth-child(7) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > app-payment:nth-child(1) > div:nth-child(2) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > span:nth-child(1) > div:nth-child(3) > span:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div[class='col-pad col-sm-9 bank-box hidden-xs ng-star-inserted'] td[class='col-lg-12 col-md-12 col-pad col-sm-12 col-xs-12 pull-left'] span[class='col-pad']")).click();
    //    driver.findElement(By.cssSelector("button[class='btn btn-primary hidden-xs ng-star-inserted']")).click();

        //Done, Only do the Payment


    }

    private static void waitUntilSpecificTime(LocalTime specificTime, ZoneId zoneId) {
        LocalTime currentTime;
        do {
            currentTime = LocalTime.now(zoneId);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (currentTime.isBefore(specificTime));
    }

    public static String getPostDataString(JSONObject params) throws Exception
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while (itr.hasNext()) {

            String key = itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

    public static String getCaptcha(String imgUrl)
    {
        String result = null;
        try
        {
            String apiKey = "";
            String apiUrl = "https://api.ocr.space/parse/image";
            // Create URL object
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            connection.setRequestProperty("cache-control","no cache");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); // Set content type

            //Creating JSON Object for Storing data
            JSONObject postDataParams = new JSONObject();
            postDataParams.put("apikey", apiKey);
            postDataParams.put("isOverlayRequired", "true");
            postDataParams.put("language", "eng");
            postDataParams.put("base64Image", imgUrl);


            // Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(getPostDataString(postDataParams));
            wr.flush();
            wr.close();

            // Get response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println(response.toString());

            StringBuilder ans = new StringBuilder();
            for(int i = response.indexOf("LineText");i<response.length();i++)
            {
                if(response.charAt(i)==',') break;
                char ch = response.charAt(i);
                ans.append(ch);
            }
            ans.delete(0,11);
            ans.deleteCharAt(ans.length()-1);
            System.out.println(ans);
            result = ans.toString();
            reader.close();

        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }


}
