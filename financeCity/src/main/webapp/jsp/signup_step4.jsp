<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String url = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString();
    request.setAttribute("basePath", basePath);
%>
  <title>InvestGO</title>
 <base href="<%=basePath%>">


    <link type="text/css" rel="stylesheet" href="${basePath}plugins/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="${basePath}plugins/bootstrap-toggle-master/css/bootstrap-toggle.min.css"/>
    <link type="text/css" rel="stylesheet" href="${basePath}plugins/ion.rangeSlider-master/css/ion.rangeSlider.css"/>
    <link type="text/css" rel="stylesheet" href="${basePath}plugins/ion.rangeSlider-master/css/ion.rangeSlider.skinFlat.css"/>
    <link type="text/css" rel="stylesheet" href="${basePath}css/order.css"/>
  <link type="text/css" rel="stylesheet" href="${basePath}css/mycss.css"/>
    <script type="text/javascript" rel="script" src="js/jquery.min.js"></script>
    <script type="text/javascript" rel="script" src="plugins/bootstrap-toggle-master/js/bootstrap-toggle.min.js"></script>
    <script type="text/javascript" rel="script" src="plugins/ion.rangeSlider-master/js/ion.rangeSlider.min.js"></script>
    <script type="text/javascript" rel="script" src="js/signup-step.js"></script>

<script type="text/javascript">
  function jump1(){
	  if(document.getElementById('select1').value=="0"){
		  var showDiv=document.getElementById('div2');
		  showDiv.style.display="";
	  }else{
		  if(document.getElementById('div2')!=null){
			  document.getElementById('div2').style.display="none";
		  }
		  if(document.getElementById('div3')!=null){
			  document.getElementById('div3').style.display="none";
		  }
		  if(document.getElementById('div4')!=null){
			  document.getElementById('div4').style.display="none";
		  }
		  if(document.getElementById('div5')!=null){
			  document.getElementById('div5').style.display="none";
		  }
		  if(document.getElementById('div6')!=null){
			  document.getElementById('div6').style.display="none";
		  }
	  }
  }
  
  function jump2(){
	  if(document.getElementById('select2').value=="0"){
		  var showDiv=document.getElementById('div3');
		  showDiv.style.display="";
		  var showDiv2=document.getElementById('div4');
		  showDiv2.style.display="";
		  var showDiv3=document.getElementById('div5');
		  showDiv3.style.display="";
	  }else{
		  if(document.getElementById('div3')!=null){
			  document.getElementById('div3').style.display="none";
		  }
		  if(document.getElementById('div4')!=null){
			  document.getElementById('div4').style.display="none";
		  }
		  if(document.getElementById('div5')!=null){
			  document.getElementById('div5').style.display="none";
		  }
		  if(document.getElementById('div6')!=null){
			  document.getElementById('div6').style.display="none";
		  }
	  }
  }
  
  function jump3(){
	  if(document.getElementById('select3').value=="0"){
		  var showDiv=document.getElementById('div4');
		  showDiv.style.display="none";
		  var showDiv2=document.getElementById('div5');
		  showDiv2.style.display="none";
		  var showDiv3=document.getElementById('div6');
		  showDiv3.style.display="";
	  }else{
		  var showDiv=document.getElementById('div4');
		  showDiv.style.display="";
		  var showDiv2=document.getElementById('div5');
		  showDiv2.style.display="";
		  var showDiv3=document.getElementById('div6');
		  showDiv3.style.display="none";
	  }
  }
</script>
</head>
<body>
<s:include value="header.jsp"></s:include>
	<div style="">
		<div class="container"
			style="margin-top: 30px; background-color: white;height: 1100px;margin-bottom:30px">
			<br />
			<div class="smallBlock"></div>
			<span class="blueFont">投资偏好</span>
			<div class="signup2Content">
				<span style="font-size:15px">请输入您想投资的金额(单位：元)</span><br/>
				<input type="text" style="height:26px;width:340px">
                  <br/><br/>
                 	<span style="font-size:15px">请再次输入您想投资的金额(单位：元)</span><br/>
				<input type="text" style="height:26px;width:340px">
                  <br/><br/>
                  <span style="font-size:15px">请选择您的投资期限</span><br/>
				 <select class="signSelector">
                    <option>2016</option>
                    <option>2017</option>
                    <option>2018</option>
                </select>
                <select class="signSelector">
                    <option>1月</option>
                    <option>2月</option>
                    <option>3月</option>
                </select>
                <select class="signSelector">
                    <option>1日</option>
                    <option>2日</option>
                    <option>3日</option>
                </select>
                <br/><br/>
                <span style="font-size:15px">在此期间是否做好意外大额支出准备</span><br/>
                <select id="select1" class="signLongSelector" onchange="jump1()">
                    <option value="1">是</option>
                      	<option value="0">否</option>
                </select>
                  <br/><br/>
                  
                  <div id="div2" style="display:none">
                  	<span style="font-size:15px">您在此投资期间是否需要专门配置大额支出准备</span><br/>
                	<select id="select2" class="signLongSelector" onchange="jump2()">
                    	<option value="1">不需要</option>
                     	<option value="0">需要</option>
               		 </select>
                  <br/><br/>
                  </div>
                  
                   <div id="div3" style="display:none">
                  	<span style="font-size:15px">请选择专门配置大额支出准备的类型</span><br/>
                	<select id="select3" class="signLongSelector" onchange="jump3()">
                    	<option value="1">大额资金中途赎回</option>
                     	<option value="0">保险</option>
               		 </select>
                  <br/><br/>
                  </div>
                  
                  <div id="div4" style="display:none">
                  	<span style="font-size:15px">请输入您对预期赎回准备的金额</span><br/>
                	<input type="text" style="height:26px;width:340px">
                  	<br/><br/>
                  </div>
                  
                  <div id="div5" style="display:none">
                    <span style="font-size:15px">请选择您预期赎回时间</span><br/>
					 <select class="signSelector">
	                    <option>2016</option>
	                    <option>2017</option>
	                    <option>2018</option>
	                </select>
	                <select class="signSelector">
	                    <option>1月</option>
	                    <option>2月</option>
	                    <option>3月</option>
	                </select>
	                <select class="signSelector">
	                    <option>1日</option>
	                    <option>2日</option>
	                    <option>3日</option>
	                </select>
	                <br/><br/>
                  </div>
                  
                  <div id="div6" style="display:none">
                  	<span style="font-size:15px">请输入您购买保险金额</span><br/>
                	<input type="text" style="height:26px;width:340px">
                  	<br/><br/>
                  </div>
                  
                  <div style="width:340px">
                  	<span style="font-size:15px">您愿意承受多大的风险</span><br/>
                    <input type="text" id="risk" name="risk" value="" class="input-add-on-field"/>
                  	<br/><br/>
                  </div>
                  
                   <div style="width:340px">
                   	<span style="font-size:15px">您预期的收益率是多少</span><br/>
                	 <input type="text" id="income" name="income" value="" class="input-add-on-field"/>
                  	<br/><br/>
                  </div>
                  <div>
                   <span style="font-size:15px">请选择您偏好的投资品种</span><br/>
                <select class="signLongSelector">
                    <option>保险</option>
                    <option>基金</option>
                </select>
                  <br/><br/>
                  </div>
                
                <span style="font-size:15px;color:red">提示信息</span><br/>
                <button class="wideButton">确定</button>
			</div>

		</div>
	</div>

	<s:include value="footer.jsp"></s:include>
</body>
</html>