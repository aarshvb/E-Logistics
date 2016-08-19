<%-- 
    Document   : registration
    Created on : Feb 20, 2016, 7:46:49 AM
    Author     : aarsh
--%>

<%@page import="Logic.Function"%>
<%@page import="java.sql.Connection"%>
<%@page import="bean.workorderBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | General Form Elements</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="admincss/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="admincss/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="admincss/dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <%
        Connection con=Function.getConnection();
     
        workorderBean wb =new workorderBean();
        String workkey=wb.workorderkey(con);
        
    %>

    <script lang="javascript">
        
        function CreateItemTable()
        {
            var table = document.getElementById("item");
            
            var noofrow=table.rows.length;
            alert(noofrow);
            var tbody;
            //table.innerHTML="";
            if(noofrow==0)
            {
            var thead = document.createElement("thead");
            var row = thead.insertRow(0);   
            var th = document.createElement("th");
            th.innerHTML = "Check";
            row.appendChild(th);        

            var th1 = document.createElement("th");
            th1.innerHTML = "Iteam Name";
            row.appendChild(th1);

            var th2 = document.createElement("th"); 
            th2.innerHTML = "Quantity";
            row.appendChild(th2);


            var th3 = document.createElement("th");
            th3.innerHTML = "unit";
            row.appendChild(th3);

            table.appendChild(thead);
            
            tbody = document.createElement("tbody");
            tbody.setAttribute("id","itembody");
            table.appendChild(tbody);
        }
        //else
        //{
            tbody=document.getElementById("itembody");
            var row = tbody.insertRow(noofrow-1);
            var cell1 = row.insertCell(0);
              
            var element6 = document.createElement("input");
            element6.setAttribute("type", "checkbox");
            element6.setAttribute("name", "chk"+noofrow);
           // element6.setAttribute("value", val[0]);
            cell1.appendChild(element6);//checkbox
            
             var cell3 = row.insertCell(1);
               
             var element2 = document.createElement("input");
             element2.setAttribute("type", "textbox");
             element2.setAttribute("value", "");
             element2.setAttribute("name", "item"+noofrow);
             cell3.appendChild(element2);
             
            var cell4 = row.insertCell(2);
               
             var element3 = document.createElement("input");
             element3.setAttribute("type", "textbox");
             element3.setAttribute("value", "");
             element3.setAttribute("name", "qty"+noofrow);
             cell4.appendChild(element3);
             
            var cell5 = row.insertCell(3);
               
            var element=document.createElement("select");
            element.setAttribute("name","unit"+noofrow);
            var option=document.createElement("option");
            option.setAttribute("value","kg");
            option.innerHTML="kg";
            element.appendChild(option);
            
            var option=document.createElement("option");
            option.setAttribute("value","pound");
            option.innerHTML="pound";
            element.appendChild(option);
            
            
            cell5.appendChild(element);
            
           
             
        //}                     
        table.appendChild(tbody);

        }
    </script>
  </head>
  <body class="hold-transition skin-blue sidebar-mini" onload="getUserType();" >
    <div class="wrapper">
        <jsp:include page="headercss.jsp"></jsp:include>
   <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="admincss/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p>Alexander Pierce</p>
              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- search form -->
          <form method="get" class="sidebar-form" >
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="../../index.html"><i class="fa fa-circle-o"></i> Dashboard v1</a></li>
                <li><a href="../../index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-files-o"></i>
                <span>Layout Options</span>
                <span class="label label-primary pull-right">4</span>
              </a>
              <ul class="treeview-menu">
                <li><a href="../layout/top-nav.html"><i class="fa fa-circle-o"></i> Top Navigation</a></li>
                <li><a href="../layout/boxed.html"><i class="fa fa-circle-o"></i> Boxed</a></li>
                <li><a href="../layout/fixed.html"><i class="fa fa-circle-o"></i> Fixed</a></li>
                <li><a href="../layout/collapsed-sidebar.html"><i class="fa fa-circle-o"></i> Collapsed Sidebar</a></li>
              </ul>
            </li>
            <li>
              <a href="../widgets.html">
                <i class="fa fa-th"></i> <span>Widgets</span> <small class="label pull-right bg-green">new</small>
              </a>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-pie-chart"></i>
                <span>Charts</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="../charts/chartjs.html"><i class="fa fa-circle-o"></i> ChartJS</a></li>
                <li><a href="../charts/morris.html"><i class="fa fa-circle-o"></i> Morris</a></li>
                <li><a href="../charts/flot.html"><i class="fa fa-circle-o"></i> Flot</a></li>
                <li><a href="../charts/inline.html"><i class="fa fa-circle-o"></i> Inline charts</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-laptop"></i>
                <span>UI Elements</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="../UI/general.html"><i class="fa fa-circle-o"></i> General</a></li>
                <li><a href="../UI/icons.html"><i class="fa fa-circle-o"></i> Icons</a></li>
                <li><a href="../UI/buttons.html"><i class="fa fa-circle-o"></i> Buttons</a></li>
                <li><a href="../UI/sliders.html"><i class="fa fa-circle-o"></i> Sliders</a></li>
                <li><a href="../UI/timeline.html"><i class="fa fa-circle-o"></i> Timeline</a></li>
                <li><a href="../UI/modals.html"><i class="fa fa-circle-o"></i> Modals</a></li>
              </ul>
            </li>
            <li class="treeview active">
              <a href="#">
                <i class="fa fa-edit"></i> <span>Forms</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li class="active"><a href="general.html"><i class="fa fa-circle-o"></i> General Elements</a></li>
                <li><a href="advanced.html"><i class="fa fa-circle-o"></i> Advanced Elements</a></li>
                <li><a href="editors.html"><i class="fa fa-circle-o"></i> Editors</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-table"></i> <span>Tables</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="../tables/simple.html"><i class="fa fa-circle-o"></i> Simple tables</a></li>
                <li><a href="../tables/data.html"><i class="fa fa-circle-o"></i> Data tables</a></li>
              </ul>
            </li>
            <li>
              <a href="../calendar.html">
                <i class="fa fa-calendar"></i> <span>Calendar</span>
                <small class="label pull-right bg-red">3</small>
              </a>
            </li>
            <li>
              <a href="../mailbox/mailbox.html">
                <i class="fa fa-envelope"></i> <span>Mailbox</span>
                <small class="label pull-right bg-yellow">12</small>
              </a>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-folder"></i> <span>Examples</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="../examples/invoice.html"><i class="fa fa-circle-o"></i> Invoice</a></li>
                <li><a href="../examples/profile.html"><i class="fa fa-circle-o"></i> Profile</a></li>
                <li><a href="../examples/login.html"><i class="fa fa-circle-o"></i> Login</a></li>
                <li><a href="../examples/register.html"><i class="fa fa-circle-o"></i> Register</a></li>
                <li><a href="../examples/lockscreen.html"><i class="fa fa-circle-o"></i> Lockscreen</a></li>
                <li><a href="../examples/404.html"><i class="fa fa-circle-o"></i> 404 Error</a></li>
                <li><a href="../examples/500.html"><i class="fa fa-circle-o"></i> 500 Error</a></li>
                <li><a href="../examples/blank.html"><i class="fa fa-circle-o"></i> Blank Page</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-share"></i> <span>Multilevel</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
                <li>
                  <a href="#"><i class="fa fa-circle-o"></i> Level One <i class="fa fa-angle-left pull-right"></i></a>
                  <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i> Level Two</a></li>
                    <li>
                      <a href="#"><i class="fa fa-circle-o"></i> Level Two <i class="fa fa-angle-left pull-right"></i></a>
                      <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                        <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                      </ul>
                    </li>
                  </ul>
                </li>
                <li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
              </ul>
            </li>
            <li><a href="../../documentation/index.html"><i class="fa fa-book"></i> <span>Documentation</span></a></li>
            <li class="header">LABELS</li>
            <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
            <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
            <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            General Form Elements
            <small>Preview</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li><a href="#">Forms</a></li>
            <li class="active">General Elements</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-12">
              <!-- general form elements -->
              <div class="box box-primary">
                <div class="box-header with-border">
                  <h3 class="box-title">Work Order</h3>
                </div><!-- /.box-header -->
                <!-- form start -->
            <script lang="javascipt">
            function GetXmlHttpObject()
            {
                var xmlHttp=null;
                try
                {
                 
                    xmlHttp=new XMLHttpRequest();
                }
                catch(e)
                {
                    try
                    {
                        xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
                    }
                    catch(e)
                    {
                        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                    }
                }
                return xmlHttp;
                
            }
            function getUserType()
            {
            xmlHttp=GetXmlHttpObject();
            if(xmlHttp==null)
            {
                alert("somethings wrong");
                return;
            }
            var url="vendordd.jsp";
            xmlHttp.open("GET",url,true);
            xmlHttp.onreadystatechange=displayUserType;
            xmlHttp.send(null);
            }
            
            function displayUserType()
            {
                alert("xmlhttp.readystate:"+xmlHttp.readyState);
                 
                if(xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
                {
                    alert("in ready state 4");
                    if(xmlHttp.status==200)
                    {
                        alert("xmlHttp.status:"+xmlHttp.status);
                        var newStatus=xmlHttp.responseText;
                        alert("new status:"+newStatus);
                    newStatus=newStatus.substring(newStatus.indexOf("[")+1,newStatus.indexOf("]"));    
                    var data=newStatus.split(",");
                    var optn=document.getElementById("usertypeid");
                    for(var i=0;i<data.length;i++)
                        {
                            var id=data[i].substring(0,data[i].indexOf(":"));
                            var name=data[i].substring(data[i].indexOf(":")+1);
                            optn[i]=new Option(name,id);
                        }
                    }
                }
                else
                    {
                        alert("error:"+xmlHttp.status);
                    }
            }
            
            function getLocation()
            {
            var id=document.getElementById("usertypeid").value;
            xmlHttp=GetXmlHttpObject();
            if(xmlHttp==null)
            {
                alert("somethings wrong");
                return;
            }
            var url="locationdd.jsp?id="+id;
            xmlHttp.open("GET",url,true);
            xmlHttp.onreadystatechange=displayLocation;
            xmlHttp.send(null);
            }
            
            function displayLocation()
            {
                alert("xmlhttp.readystate:"+xmlHttp.readyState);
                 
                if(xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
                {
                    alert("in ready state 4");
                    if(xmlHttp.status==200)
                    {
                        alert("xmlHttp.status:"+xmlHttp.status);
                        var newStatus=xmlHttp.responseText;
                        alert("new status:"+newStatus);
                    newStatus=newStatus.substring(newStatus.indexOf("[")+1,newStatus.indexOf("]"));    
                    var data=newStatus.split(",");
                    var optn=document.getElementById("location");
                    for(var i=0;i<data.length;i++)
                        {
                            var id=data[i].substring(0,data[i].indexOf(":"));
                            var name=data[i].substring(data[i].indexOf(":")+1);
                            optn[i]=new Option(name,id);
                        }
                    }
                }
                else
                    {
                        alert("error:"+xmlHttp.status);
                    }
            }
            
        
            </script>
                <form role="form" action="woservlet">
                  <div class="box-body">
                    
                       <div class="form-group">
                          <label for="exampleInputEmail1">Work Order No.</label>
                      <label ><%=workkey%>
                        
                      </label>
                       <input type="hidden" name="key" value="<%=workkey%>">
                      </div>
                      <div class="form-group">
                          <label for="exampleInputEmail1"> Vendor </label>
                      <select name="usertypeid" id="usertypeid">
                        
                      </select>
                      </div>
                      <div class="form-group">
                          <label for="exampleInputEmail1"> </label>
                      <!--<select name="location" id="location"  >
                        
                      </select>-->
                      </div>
                      <div class="box">
                <div class="box-header">
                  <h3 class="box-title">Data Table With Full Features</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <table id="item" class="table table-bordered table-striped">
                      
                          
                  </table>
                </div>
                </div>
                </div><!-- /.box-body -->

                  <div class="box-footer">
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </div>
                 <!--<div class="box-footer">
                     <button type="button" class="btn btn-primary" onclick="CreateItemTable();">Add Item</button>
                  </div>
                </form>
              </div> box -->

              <!-- Form Element sizes -->
             

             

              <!-- Input addon -->
             

            </div><!--/.col (left) -->
            <!-- right column -->
            
          </div>   <!-- /.row -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
        <jsp:include page="footercss.jsp"></jsp:include>
       <!-- Control Sidebar -->
      <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
          <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
          <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
          <!-- Home tab content -->
          <div class="tab-pane" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">Recent Activity</h3>
            <ul class="control-sidebar-menu">
              <li>
                <a href="javascript::;">
                  <i class="menu-icon fa fa-birthday-cake bg-red"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
                    <p>Will be 23 on April 24th</p>
                  </div>
                </a>
              </li>
              <li>
                <a href="javascript::;">
                  <i class="menu-icon fa fa-user bg-yellow"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>
                    <p>New phone +1(800)555-1234</p>
                  </div>
                </a>
              </li>
              <li>
                <a href="javascript::;">
                  <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>
                    <p>nora@example.com</p>
                  </div>
                </a>
              </li>
              <li>
                <a href="javascript::;">
                  <i class="menu-icon fa fa-file-code-o bg-green"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>
                    <p>Execution time 5 seconds</p>
                  </div>
                </a>
              </li>
            </ul><!-- /.control-sidebar-menu -->

            <h3 class="control-sidebar-heading">Tasks Progress</h3>
            <ul class="control-sidebar-menu">
              <li>
                <a href="javascript::;">
                  <h4 class="control-sidebar-subheading">
                    Custom Template Design
                    <span class="label label-danger pull-right">70%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                  </div>
                </a>
              </li>
              <li>
                <a href="javascript::;">
                  <h4 class="control-sidebar-subheading">
                    Update Resume
                    <span class="label label-success pull-right">95%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                  </div>
                </a>
              </li>
              <li>
                <a href="javascript::;">
                  <h4 class="control-sidebar-subheading">
                    Laravel Integration
                    <span class="label label-warning pull-right">50%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                  </div>
                </a>
              </li>
              <li>
                <a href="javascript::;">
                  <h4 class="control-sidebar-subheading">
                    Back End Framework
                    <span class="label label-primary pull-right">68%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                  </div>
                </a>
              </li>
            </ul><!-- /.control-sidebar-menu -->

          </div><!-- /.tab-pane -->
          <!-- Stats tab content -->
          <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div><!-- /.tab-pane -->
          <!-- Settings tab content -->
          <div class="tab-pane" id="control-sidebar-settings-tab">
            <form method="post">
              <h3 class="control-sidebar-heading">General Settings</h3>
              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Report panel usage
                  <input type="checkbox" class="pull-right" checked>
                </label>
                <p>
                  Some information about this general settings option
                </p>
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Allow mail redirect
                  <input type="checkbox" class="pull-right" checked>
                </label>
                <p>
                  Other sets of options are available
                </p>
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Expose author name in posts
                  <input type="checkbox" class="pull-right" checked>
                </label>
                <p>
                  Allow the user to show his name in blog posts
                </p>
              </div><!-- /.form-group -->

              <h3 class="control-sidebar-heading">Chat Settings</h3>

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Show me as online
                  <input type="checkbox" class="pull-right" checked>
                </label>
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Turn off notifications
                  <input type="checkbox" class="pull-right">
                </label>
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Delete chat history
                  <a href="javascript::;" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                </label>
              </div><!-- /.form-group -->
            </form>
          </div><!-- /.tab-pane -->
        </div>
      </aside><!-- /.control-sidebar -->
      <!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
      <div class="control-sidebar-bg"></div>
    </div><!-- ./wrapper -->

    <!-- jQuery 2.1.4 -->
    <script src="admincss/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="admincss/bootstrap/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="admincss/plugins/fastclick/fastclick.min.js"></script>
    <!-- AdminLTE App -->
    <script src="admincss/dist/js/app.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="admincss/dist/js/demo.js"></script>
  </body>
</html>
