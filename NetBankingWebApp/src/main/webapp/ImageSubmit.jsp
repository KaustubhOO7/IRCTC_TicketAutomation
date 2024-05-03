<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="ImageSubmit.css">
</head>
<body>

    <div class="main">
        <img src="Images/background.png">
        <h2>
            <b>Sirius Ventures</b>
         </h2>
        <form action="signatureImage" method="post" id="form" enctype="multipart/form-data" onsubmit="showMessage()">
            <div class="sign">
                <p>Primary Owner Signature</p>
                <input type="file" accept=".jpg" name="signature"/>
                <div class="message" id="message" style="display: none;">Image Saved </div>
                <div class="message1" id="message1">Maximun Upload size : 4MB</div>
                <button type="submit">UPLOAD</button>
            </div>
        </form>

    </div>
    <script>
        function showMessage()
        {
          document.getElementById("message").style.display = "block";
          document.getElementById("message1").style.display = "none";
        }
     </script>
</body>
</html>
