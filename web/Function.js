/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
            function getVendor()
            {
            xmlHttp=GetXmlHttpObject();
            if(xmlHttp==null)
            {
                alert("somethings wrong");
                return;
            }
            var url="vendordd.jsp";
            xmlHttp.open("GET",url,true);
            xmlHttp.onreadystatechange=displayVendor;
            xmlHttp.send(null);
            }
            
            function displayVendor()
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
                    var optn=document.getElementById("vendor");
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
            
            function getWorkorder()
            {
            var id=document.getElementById("vendor").value;
            xmlHttp=GetXmlHttpObject();
            if(xmlHttp==null)
            {
                alert("somethings wrong");
                return;
            }
            var url="workorderdd.jsp?id="+id;
            xmlHttp.open("GET",url,true);
            xmlHttp.onreadystatechange=displayWorkorder;
            xmlHttp.send(null);
            }
            
            function displayWorkorder()
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
                    var optn=document.getElementById("workorder");
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
            
            function getServiceProvider()
            {
                
            xmlHttp=GetXmlHttpObject();
            if(xmlHttp==null)
            {
                alert("somethings wrong");
                return;
            }
            var url="serviceproviderdd.jsp";
            xmlHttp.open("GET",url,true);
            xmlHttp.onreadystatechange=displayServiceProvider;
            xmlHttp.send(null);
            }
            
            function displayServiceProvider()
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
                    var optn=document.getElementById("serviceprovider");
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
            
            
            function getWorkOrderItem()
            {
                alert("in this function");
            var sp= document.getElementById("serviceprovider").value;
            var workorder = document.getElementById("workorder").value;
            xmlHttp=GetXmlHttpObject();
            if(xmlHttp==null)
            {
                alert("somethings wrong");
                return;
            }
            var url="WorkOrderItemdb.jsp?workorder="+workorder+"&sp="+sp;
            xmlHttp.open("GET",url,true);
            xmlHttp.onreadystatechange=displayWorkOrderItem;
            xmlHttp.send(null);
            }
            
            function displayWorkOrderItem()
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
                        var data=newStatus.split("$");
                        //var data = newStatus.split("$");
                        alert("hello");
                         
                    data[0]=data[0].substring(data[0].indexOf("[")+1,data[0].indexOf("]"));
                    data[1]=data[1].substring(data[1].indexOf("[")+1,data[1].indexOf("]"));
                    
                    alert(data[0]);
                    alert(data[1]);
            
                     var table = document.getElementById("vehicleassignmenttable");
                     table.innerHTML="";
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
            th3.innerHTML = "Unit";
            row.appendChild(th3);

            table.appendChild(thead);
            
            tbody = document.createElement("tbody");
            tbody.setAttribute("id","itembody");
            table.appendChild(tbody);
        }
        //else
        //{
            tbody=document.getElementById("itembody");
            var woitem = data[0].split(",");
            var vehicle = data[1].split(",");
            for(var i=0;i<woitem.length;i++)
            {
            var item = woitem[i].split(":");    
            var row = tbody.insertRow(noofrow-1);
            
            var j;
            for(j=0 ;j<item.length;j++)
            {if(j==0)
                {
                var cell1 = row.insertCell(0);
              
                var element6 = document.createElement("input");
                element6.setAttribute("type", "checkbox");
                element6.setAttribute("name", "chk"+i);
                element6.setAttribute("value", item[0]);
                cell1.appendChild(element6);
                
                }
           else
            {
            var cell3 = row.insertCell(j);
            cell3.innerHTML= item[j];
            }
            }
            
            //  qalert("j="+j);
            var cell4 = row.insertCell(j);
            var element4 = document.createElement("input");
            element4.setAttribute("type", "textbox");
            element4.setAttribute("name", "qty"+i);
          
            cell4.appendChild(element4);//checkbox
            
            
            var cell5 = row.insertCell(j+1);
               
            var element=document.createElement("select");
            element.setAttribute("name","unit"+i);
            
            for(var k=0; k<vehicle.length;k++)
            {
            var option=document.createElement("option");
            option.setAttribute("value",vehicle[k]);
            option.innerHTML=vehicle[k];
            element.appendChild(option);
            }
            
            cell5.appendChild(element);            
            }
            
            
             
              
             
           /* var cell5 = row.insertCell(3);
               
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
            */
           
             
        //}                     
        table.appendChild(tbody);
                        
                        
                    }
                }
                else
                    {
                        alert("error:"+xmlHttp.status);
                    }
            }
            
            
            
        
         

