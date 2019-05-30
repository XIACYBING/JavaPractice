<html>
    <head>
        <title>showUser</title>
        <meta charset="UTF-8"></meta>
    </head>
    <body>
        <table>
            <tr>
                <th>uid</th>
                <th>name</th>
            </tr>
            <#list list as user>
                <tr>
                    <td>${user.uid}</td>
                    <td>${user.name}</td>
                </tr>
            </#list>
        </table>
    </body>
</html>