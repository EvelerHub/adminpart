<%--
  Created by IntelliJ IDEA.
  User: Eveler
  Date: 02.04.2016
  Time: 7:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentallela Alela! | </title>

    <!-- Bootstrap core CSS -->

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">

    <!-- Datatables -->
    <link href="js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
    <link href="js/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="js/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="js/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- Custom styling plus plugins -->
    <link href="css/custom.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/maps/jquery-jvectormap-2.0.3.css"/>
    <link href="css/icheck/flat/green.css" rel="stylesheet"/>
    <link href="css/floatexamples.css" rel="stylesheet" type="text/css"/>
    <link href="css/load-animation.css" rel="stylesheet">

    <script src="js/jquery.min.js"></script>
    <script src="js/nprogress.js"></script>

    <!--[if lt IE 9]>
    <script src="../assets/js/ie8-responsive-file-warning.js"></script>
    <![endif]-->

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>


<body class="nav-md">

<div class="container body">

    <div class="main_container">

        <%@include file="fragments/leftcol.jspf"%>

        <!-- top navigation -->
        <%@include file="fragments/navbar.jspf"%>
        <!-- /top navigation -->


        <!-- page content -->
        <div class="right_col" role="main">

            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <div class="x_panel tile">
                        <div class="x_title">
                            <h2>Добавить новую учетную запись</h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li>
                                    <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li>
                                    <a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
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
                                <div class="clearfix"></div>
                            </div>
                            <div class="row">
                                <div class="col-lg-4 pull-right">
                                    <button class="btn btn-outline btn-primary btn-block" id="add-and-start">
                                        add &amp; start
                                    </button>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-6 col-sm-6 col-xs-12">
                    <div class="x_panel tile overflow_hidden">
                        <div class="x_title">
                            <h2>Статистика состояния</h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li>
                                    <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li>
                                    <a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="row" id="status-panel">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <div id="morris-donut-chart" style="max-height: 261px;"></div>
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <table class="tile_info" id="status-window">
                                        <thead>
                                        <tr>
                                            <th>status</th>
                                            <th>persent</th>
                                        </tr>
                                        </thead>
                                        <tbody id="status-legend">
                                            <%--should be rows--%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel tile">
                        <div class="x_title">
                            <h2>Таблица состояния учетных записей</h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li>
                                    <a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li>
                                    <a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <table class="table table-striped table-bordered" id="steam-table">
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
                            <!-- /.table-responsive -->
                        </div>
                    </div>
                </div>
            </div>

            <!-- footer content -->
            <footer>
                <div class="copyright-info">
                    <p class="pull-right">Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
                    </p>
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->
        </div>
        <!-- /page content -->

    </div>
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

<div id="custom_notifications" class="custom-notifications dsp_none">
    <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
    </ul>
    <div class="clearfix"></div>
    <div id="notif-group" class="tabbed_notifications"></div>
</div>

<script src="js/bootstrap.min.js"></script>

<!-- bootstrap progress js -->
<script src="js/progressbar/bootstrap-progressbar.min.js"></script>
<script src="js/nicescroll/jquery.nicescroll.min.js"></script>

<!-- Datatables-->
<script src="js/datatables/jquery.dataTables.min.js"></script>
<script src="js/datatables/dataTables.bootstrap.js"></script>
<script src="js/datatables/dataTables.buttons.min.js"></script>
<script src="js/datatables/buttons.bootstrap.min.js"></script>
<script src="js/datatables/jszip.min.js"></script>
<script src="js/datatables/pdfmake.min.js"></script>
<script src="js/datatables/vfs_fonts.js"></script>
<script src="js/datatables/buttons.html5.min.js"></script>
<script src="js/datatables/buttons.print.min.js"></script>
<script src="js/datatables/dataTables.fixedHeader.min.js"></script>
<script src="js/datatables/dataTables.keyTable.min.js"></script>
<script src="js/datatables/dataTables.responsive.min.js"></script>
<script src="js/datatables/responsive.bootstrap.min.js"></script>
<script src="js/datatables/dataTables.scroller.min.js"></script>

<!-- pace -->
<script src="js/pace/pace.min.js"></script>

<!-- moris js -->
<script src="js/moris/raphael-min.js"></script>
<script src="js/moris/morris.min.js"></script>

<script src="js/custom.js"></script>
<script src="js/sb-steam-data-manager.js"></script>


<script>
    NProgress.done();
</script>
</body>

</html>

