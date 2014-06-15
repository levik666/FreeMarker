<html>
<head>
    <title>FreeMarker Tutorial</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        body, input {font-family: Calibri, Arial; margin: 0px; padding: 0px;}
        #header h2 {color: white; background-color: #3275A8; height: 40px; padding: 5px 0 0 5px;}
        .data {margin-bottom:5px;border:1px solid #eee;border-collapse:collapse;width:400px;max-width:100%;font-family:Calibri}
        .data th {padding:3px;border:1px solid #888;height:30px;background-color:#B2D487;text-align:center;vertical-align:middle;color:#444444}
        .data tr {border:1px solid #888}
        .data tr.odd {background-color:#eee}
        .data td {padding:2px;border:1px solid #888}
        #content { padding: 5px; margin: 5px; text-align: center}
        fieldSet { width: 300px; padding: 5px; margin-bottom: 0px; }
        legend { font-weight: bold; }
    </style>
</head>
<body>
    <div id="header">
        <h2>FreeMarker Tutorial</h2>
     <div>
    </div>
        <div id="content">
              <fieldSet>
                <legend>Add User</legend>
              <form name="user" action="user" method="post">
                FirstName: <input type="text" name="firstName" />	<br/>
                LastName: <input type="text" name="lastName" />	<br/>
                <input type="submit" value="   Save   " />
              </form>
              </fieldSet>
              <br/>
              <table class="data">
                <tr>
                    <th>FirstName</th>  <th>LastName</th>
                </tr>
                <#list users as user>
                <tr>
                    <td>${user.firstName}</td> <td>${user.lastName}</td>
                </tr>
                </#list>
              </table>
        </div>
    </body>
</html>  