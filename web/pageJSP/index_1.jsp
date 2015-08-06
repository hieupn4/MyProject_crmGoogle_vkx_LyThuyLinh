<%-- 
    Document   : index
    Created on : Jul 17, 2015, 11:53:42 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head runat="server">
    <title></title>
    <style type="text/css">
        .style1
        {
        }
        #Text1
        {
            width: 175px;
        }
        #Text2
        {
            width: 224px;
        }
        #Text3
        {
            width: 224px;
            margin-left: 4px;
        }
        #Text4
        {
            width: 222px;
        }
        .style2
        {
            width: 424px;
        }
        .style3
        {
            width: 169px;
        }
        .style4
        {
            text-align: center;
        }
        #Submit1
        {}
    </style>
   
</head>
<body style="height: 437px; width: 663px" onload="chance()">
     <div id="map" style="width:500px;height:380px;"></div>
     <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false">
 </script> 
 <script type="text/javascript">
  var delay = 100;
  var infowindow = new google.maps.InfoWindow();
  var latlng = new google.maps.LatLng(21.0000, 78.0000);
  var mapOptions = {
    zoom: 5,
    center: latlng,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  }
  var geocoder = new google.maps.Geocoder(); 
  var map = new google.maps.Map(document.getElementById("map"), mapOptions);
  var bounds = new google.maps.LatLngBounds();

  function geocodeAddress(address, next) {
    geocoder.geocode({address:address}, function (results,status)
      { 
         if (status == google.maps.GeocoderStatus.OK) {
          var p = results[0].geometry.location;
          var lat=p.lat();
          var lng=p.lng();
          createMarker(address,lat,lng);
        }
        else {
           if (status == google.maps.GeocoderStatus.OVER_QUERY_LIMIT) {
            nextAddress--;
            delay++;
          } else {
                        }   
        }
        next();
      }
    );
  }
 function createMarker(add,lat,lng) {
   var contentString = add;
   var marker = new google.maps.Marker({
     position: new google.maps.LatLng(lat,lng),
     map: map,
           });

  google.maps.event.addListener(marker, 'click', function() {
     infowindow.setContent(contentString); 
     infowindow.open(map,marker);
   });

   bounds.extend(marker.position);

 }
  var locations = [
           
  ];
  var nextAddress = 0;
  function theNext() {
    if (nextAddress < locations.length) {
      setTimeout('geocodeAddress("'+locations[nextAddress]+'",theNext)', delay);
      nextAddress++;
    } else {
      map.fitBounds(bounds);
    }
  }
  theNext();

</script>   
    <form id="form1" action="../Process" method="post">
    <div class="style4">
        DEMO PROJECT CRM</div>
    
    <table style="width:100%;">
        <tr>
            <td bgcolor="#FF9999" class="style3">
                Phía Khách Hàng</td>
            <td class="style2">
                Phía Doanh Nghiệp</td>
        </tr>
        <tr>
            <td bgcolor="#FF9999" class="style3">
                Nhập số điện thoại của bạn :</td>
            <td class="style2">
&nbsp;Họ tên khách hàng đang gọi :&nbsp;&nbsp;&nbsp;
               ${requestScope.actor.getName()}</td>
        </tr>
        <tr>
            <td bgcolor="#FF9999" class="style3">
                <input id="Text1" type="text" name="phonenumber" /></td>
            <td class="style2">
&nbsp;Địa chỉ khách hàng đang gọi&nbsp;&nbsp;&nbsp; : ${requestScope.actor.getAdress()}</td>
        </tr>
        <tr>
            <td bgcolor="#FF9999" class="style3">
                <input id="Submit1" type="submit" value="Gọi cho tổng đài" onclick="codeAddress()" /></td>
            <td class="style2">
                Số điện thoại đang gọi:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                ${requestScope.actor.getNumberPhone()}</td>
        </tr>
        <tr>
            <td class="style1" colspan="2">
                đây là hệ thống mô phỏng, màu hồng phía khách hàng khi họ gọi tới tổng đài</td>
        </tr>       
    </table>
        </form>
    
     <input id="address2" type="textbox" value='${requestScope.actor.getAdress()}'>
     <input id="address" type="textbox" value="bảo tàng hồ chí minh">      
 
</body>
</html>
