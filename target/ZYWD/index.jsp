<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css"/>

</head>
<body>
<div class="container">
    <span>当前登录用户: ${user.user}</span>
    <div class="input-group">
        <span class="input-group-addon">账户名</span>
        <input type="text" id="user" class="form-control" placeholder="请输入账户名">
        <div class="input-group-btn">
            <input type="button" class="btn btn-success" id="btnsearch" value="查询">
        </div>
    </div><br>
    <div class="table-responsive">
        <table id="userlist" class="table table-striped table-bordered table-hover table-condensed text-center">
            <thead>
            <tr>
                <th class="text-center">编号</th>
                <th class="text-center">用户名</th>
                <th class="text-center">密码</th>
                <th class="text-center">操作</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript">
    function reload() {
        $("tbody").html("");
        $.get("user/queryAll.action",
            function (data) {
                for (var i = 0; i < data.length; i++) {
                    $("tbody").html($("tbody").html() +
                        "<tr>" +
                        "<td>" + data[i].uid + "</td>" +
                        "<td>" + data[i].user + "</td>" +
                        "<td>" + data[i].password + "</td>" +
                        "<td>" + "<a href='update.jsp'>" + "编辑" + "</a> " + "<a href='delete'>" + "删除" + "</a>" + "</td>"+
                        "</tr>"
                    );
                }
            }
        );
    }

    $(window).ready(function () {
        reload();
    });

    //查询条件
    $("#btnsearch").click(function () {

        $('#userlist').bootstrapTable("refresh");
    })
</script>
</body>
</html>
