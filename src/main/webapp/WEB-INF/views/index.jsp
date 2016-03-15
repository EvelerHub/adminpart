<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin</title>

    <!-- Bootstrap Core CSS -->
    <link href="/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS --> <!-- for tables -->
    <link href="/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS --> <!-- for tables -->
    <link href="/bower_components/datatables-responsive/css/responsive.dataTables.scss" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="/dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="/dist/css/load-animation.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="steam.html">Admin page loot-pro</a>
        </div>
        <!-- /.navbar-header -->
        <ul class="nav navbar-top-links navbar-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li>
                        <a href="#">
                            <i class="fa fa-user fa-fw"></i>
                            User Profile
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-gear fa-fw"></i>
                            Settings
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="login.html">
                            <i class="fa fa-sign-out fa-fw"></i>
                            Logout
                        </a>
                    </li>
                </ul>
                <!-- /.dropdown-user -->
            </li>
            <!-- /.dropdown -->
        </ul>
        <!-- /.navbar-top-links -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="steam.html" class="active">
                            <i class="fa fa-steam-square fa-fw"></i>
                            Учетные записи Steam
                        </a>
                    </li>
                    <li>
                        <a href="another.html">
                            <i class="fa fa-steam-square fa-fw"></i>
                            Маркет CS-GO
                        </a>
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <div id="page-wrapper">
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        Добавить новую учетную запись
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <div id="data-input-fields">
                                    <div class="form-group input-group">
                                        <span class="input-group-addon min-width-addons">
                                            <i class="fa fa-user"></i>
                                        </span>
                                        <input class="form-control" placeholder="login">
                                    </div>
                                    <div class="form-group input-group">
                                        <span class="input-group-addon min-width-addons">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                        <input class="form-control" placeholder="password">
                                    </div>
                                    <div class="form-group input-group">
                                        <span class="input-group-addon min-width-addons">
                                            <i class="fa fa-steam"></i>
                                        </span>
                                        <input class="form-control" placeholder="steam key">
                                    </div>
                                    <div class="form-group input-group">
                                        <span class="input-group-addon min-width-addons">
                                            <i class="fa fa-truck"></i>
                                        </span>
                                        <input class="form-control" placeholder="market key">
                                    </div>
                                    <div class="form-group input-group">
                                        <span class="input-group-addon min-width-addons">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                        <input class="form-control" placeholder="two factor code">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-4 pull-right">
                                <button type="submit" class="btn btn-outline btn-primary btn-block" id="add-and-start">
                                    add & start
                                </button>
                            </div>
                        </div>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-6 -->
            <div class="col-lg-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <i class="fa fa-bar-chart-o fa-fw"></i> Статистика учетных запесей
                    </div>
                    <div class="panel-body">
                        <div id="morris-donut-chart" style="max-height: 279px;"></div>
                    </div>
                    <!-- /.panel-body -->
                </div>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        Таблица состояния учетных записей
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="dataTable_wrapper">
                            <table class="table table-striped table-bordered table-hover" id="steam-table">
                                <thead>
                                <tr>
                                    <th>id</th>
                                    <th>login</th>
                                    <th>date added</th>
                                    <th>update status date</th>
                                    <th>status</th>
                                </tr>
                                </thead>
                                <tbody id="steam-table-body">
                                <%-- would be some rows --%>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

    <div class="modal fade" tabindex="-1" role="dialog" id="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Редактирование</h4>
                </div>
                <!-- /.modal-header -->
                <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <table class="table">
                                <tbody id="modal-data-fields">
                                <%-- would be some files --%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div id="modal-data-input-fields">
                                <%-- would be some input-fields --%>
                            </div>

                        </div>
                    </div>
                </div>
                <!-- /.modal-body -->
                <div class="modal-footer">
                    <div class="row">
                        <div class="col-lg-3">
                            <button type="button" class="btn btn-outline btn-primary btn-block" id="update">
                                update
                            </button>
                        </div>
                        <div class="col-lg-3">
                            <button type="button" class="btn btn-outline btn-primary btn-block" id="delete">
                                delete
                            </button>
                        </div>
                        <div class="col-lg-3">
                            <button type="button" class="btn btn-outline btn-primary btn-block" id="start">
                                start
                            </button>
                        </div>
                        <div class="col-lg-3">
                            <button type="button" class="btn btn-outline btn-primary btn-block" id="stop">
                                stop
                            </button>
                        </div>
                    </div>
                </div>
                <!-- /.modal-footer -->
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="/bower_components/jquery/dist/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Metis MeJavaScript -->
<script src="/bower_components/metisMenu/dist/metisMenu.min.js"></script>

<!-- DataTablipt --> <!-- from tables-->
<script src="/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
<script src="/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>

<!-- Morris Charts JavaScript -->
<script src="/bower_components/raphael/raphael-min.js"></script>
<script src="/bower_components/morrisjs/morris.js"></script>
<script src="/js/morris-data.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/dist/js/sb-admin-2.js"></script>
<script src="/dist/js/sb-data-manager.js"></script>

</body>
</html>
