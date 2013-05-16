<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>前台显示单条简介信息</title>
<link href="css/homepage/qywh.css" rel="stylesheet" type="text/css" />
<link href="css/homepage/Index.css" rel="stylesheet" type="text/css" />
<link href="css/homepage/lanrentuku2.css" rel="stylesheet" type="text/css" />
<link href="css/homepage/public.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.6.js"></script>
<script  language="javascript" src="js/daohang.js" ></script>
<script type="text/javascript">
var $one = function (id) {
	return "string" == typeof id ? document.getElementById(id) : id;
};

var Extend = function(destination, source) {
	for (var property in source) {
		destination[property] = source[property];
	}
	return destination;
}

var CurrentStyle = function(element){
	return element.currentStyle || document.defaultView.getComputedStyle(element, null);
}

var Bind = function(object, fun) {
	var args = Array.prototype.slice.call(arguments).slice(2);
	return function() {
		return fun.apply(object, args.concat(Array.prototype.slice.call(arguments)));
	}
}

var Tween = {
	Quart: {
		easeOut: function(t,b,c,d){
			return -c * ((t=t/d-1)*t*t*t - 1) + b;
		}
	},
	Back: {
		easeOut: function(t,b,c,d,s){
			if (s == undefined) s = 1.70158;
			return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
		}
	},
	Bounce: {
		easeOut: function(t,b,c,d){
			if ((t/=d) < (1/2.75)) {
				return c*(7.5625*t*t) + b;
			} else if (t < (2/2.75)) {
				return c*(7.5625*(t-=(1.5/2.75))*t + .75) + b;
			} else if (t < (2.5/2.75)) {
				return c*(7.5625*(t-=(2.25/2.75))*t + .9375) + b;
			} else {
				return c*(7.5625*(t-=(2.625/2.75))*t + .984375) + b;
			}
		}
	}
}


//容器对象,滑动对象,切换数量
var SlideTrans = function(container, slider, count, options) {
	this._slider = $one(slider);
	this._container = $one(container);//容器对象
	this._timer = null;//定时器
	this._count = Math.abs(count);//切换数量
	this._target = 0;//目标值
	this._t = this._b = this._c = 0;//tween参数
	
	this.Index = 0;//当前索引
	
	this.SetOptions(options);
	
	this.Auto = !!this.options.Auto;
	this.Duration = Math.abs(this.options.Duration);
	this.Time = Math.abs(this.options.Time);
	this.Pause = Math.abs(this.options.Pause);
	this.Tween = this.options.Tween;
	this.onStart = this.options.onStart;
	this.onFinish = this.options.onFinish;
	
	var bVertical = !!this.options.Vertical;
	this._css = bVertical ? "top" : "left";//方向
	
	//样式设置
	var p = CurrentStyle(this._container).position;
	p == "relative" || p == "absolute" || (this._container.style.position = "relative");
	this._container.style.overflow = "hidden";
	this._slider.style.position = "absolute";
	
	this.Change = this.options.Change ? this.options.Change :
		this._slider[bVertical ? "offsetHeight" : "offsetWidth"] / this._count;
};
SlideTrans.prototype = {
  //设置默认属性
  SetOptions: function(options) {
	this.options = {//默认值
		Vertical:	true,//是否垂直方向（方向不能改）
		Auto:		true,//是否自动
		Change:		0,//改变量
		Duration:	50,//滑动持续时间
		Time:		10,//滑动延时
		Pause:		4000,//停顿时间(Auto为true时有效)
		onStart:	function(){},//开始转换时执行
		onFinish:	function(){},//完成转换时执行
		Tween:		Tween.Quart.easeOut//tween算子
	};
	Extend(this.options, options || {});
  },
  //开始切换
  Run: function(index) {
	//修正index
	index == undefined && (index = this.Index);
	index < 0 && (index = this._count - 1) || index >= this._count && (index = 0);
	//设置参数
	this._target = -Math.abs(this.Change) * (this.Index = index);
	this._t = 0;
	this._b = parseInt(CurrentStyle(this._slider)[this.options.Vertical ? "top" : "left"]);
	this._c = this._target - this._b;
	
	this.onStart();
	this.Move();
  },
  //移动
  Move: function() {
	clearTimeout(this._timer);
	//未到达目标继续移动否则进行下一次滑动
	if (this._c && this._t < this.Duration) {
		this.MoveTo(Math.round(this.Tween(this._t++, this._b, this._c, this.Duration)));
		this._timer = setTimeout(Bind(this, this.Move), this.Time);
	}else{
		this.MoveTo(this._target);
		this.Auto && (this._timer = setTimeout(Bind(this, this.Next), this.Pause));
	}
  },
  //移动到
  MoveTo: function(i) {
	this._slider.style[this._css] = i + "px";
  },
  //下一个
  Next: function() {
	this.Run(++this.Index);
  },
  //上一个
  Previous: function() {
	this.Run(--this.Index);
  },
  //停止
  Stop: function() {
	clearTimeout(this._timer); this.MoveTo(this._target);
  }
};
</script>
</head>
<body>
  <div id="actfv">
    <p class="patext"><a href="IndexBefore_getTopNews.action">首页</a>  |  <a href="secure/secureSearch.html">校园简介详细</a>  </p>
  </div>
 <div id="whole"> 
 	<!-- <p class="cpcx">首页 >> <span style="color:#1a9ae5"> &nbsp;校园简介详细</span></p> -->
   <!--news-->
   <div class="news">
   <c:forEach items="${brieflist}" var="m">	
   		<div class="newlist fl">
        	<div class="zxyh wd">
                <p class="salsetext">校园简介</p>
            </div>
        	<div class="listd">
            	<p class="title">${m.title}</p>
                <p class="date alg">发布日期：${m.pubtime} <%--  点击：${m.browsevolume} --%></p>
                <div class="lstnr du">
                	<!-- 意外伤残的保险金是根据伤害程度按比例支付的，这个标准明确地附注在保险条款上。需要提醒的是，意外残疾和意外烧伤在实际的保险产品中，常常是被拆开的，不是所有意外险产品都包含对意外烧伤的责任。另外，在生活中，诸如被歹徒袭击导致脾脏、肾脏等脏器摘除的事件时有耳闻，而类似情况无法获得意外险的理赔，除非是有附加意外医疗保障，则可以为治疗提供费用报销或住院津贴补偿。 -->
                   ${m.content}
                </div>
                <div class="lstnr">
                  <c:choose>    
			 <c:when test="${fn:length(m.url)!= 0}">  
             <img src="./${m.url}" width=600 height=500/>
             </c:when>
              <c:otherwise>
              </c:otherwise>
              </c:choose>
                	<!-- 意外伤残的保险金是根据伤害程度按比例支付的，这个标准明确地附注在保险条款上。需要提醒的是，意外残疾和意外烧伤在实际的保险产品中，常常是被拆开的，不是所有意外险产品都包含对意外烧伤的责任。另外，在生活中，诸如被歹徒袭击导致脾脏、肾脏等脏器摘除的事件时有耳闻，而类似情况无法获得意外险的理赔，除非是有附加意外医疗保障，则可以为治疗提供费用报销或住院津贴补偿。
                    意外伤残的保险金是根据伤害程度按比例支付的，这个标准明确地附注在保险条款上。需要提醒的是，意外残疾和意外烧伤在实际的保险产品中，常常是被拆开的，不是所有意外险产品都包含对意外烧伤的责任。另外，在生活中，诸如被歹徒袭击导致脾脏、肾脏等脏器摘除的事件时有耳闻，而类似情况无法获得意外险的理赔，除非是有附加意外医疗保障，则可以为治疗提供费用报销或住院津贴补偿。
                    意外伤残的保险金是根据伤害程度按比例支付的，这个标准明确地附注在保险条款上。需要提醒的是，意外残疾和意外烧伤在实际的保险产品中，常常是被拆开的，不是所有意外险产品都包含对意外烧伤的责任。另外，在生活中，诸如被歹徒袭击导致脾脏、肾脏等脏器摘除的事件时有耳闻，而类似情况无法获得意外险的理赔，除非是有附加意外医疗保障，则可以为治疗提供费用报销或住院津贴补偿。
                    意外伤残的保险金是根据伤害程度按比例支付的，这个标准明确地附注在保险条款上。需要提醒的是，意外残疾和意外烧伤在实际的保险产品中，常常是被拆开的，不是所有意外险产品都包含对意外烧伤的责任。另外，在生活中，诸如被歹徒袭击导致脾脏、肾脏等脏器摘除的事件时有耳闻，而类似情况无法获得意外险的理赔，除非是有附加意外医疗保障，则可以为治疗提供费用报销或住院津贴补偿。意外伤残的保险金是根据伤害程度按比例支付的，这个标准明确地附注在保险条款上。需要提醒的是，意外残疾和意外烧伤在实际的保险产品中，常常是被拆开的，不是所有意外险产品都包含对意外烧伤的责任。另外，在生活中，诸如被歹徒袭击导致脾脏、肾脏等脏器摘除的事件时有耳闻，而类似情况无法获得意外险的理赔，除非是有附加意外医疗保障，则可以为治疗提供费用报销或住院津贴补偿。意外伤残的保险金是根据伤害程度按比例支付的，这个标准明确地附注在保险条款上。需要提醒的是，意外残疾和意外烧伤在实际的保险产品中，常常是被拆开的，不是所有意外险产品都包含对意外烧伤的责任。另外，在生活中，诸如被歹徒袭击导致脾脏、肾脏等脏器摘除的事件时有耳闻，而类似情况无法获得意外险的理赔，除非是有附加意外医疗保障，则可以为治疗提供费用报销或住院津贴补偿。意外伤残的保险金是根据伤害程度按比例支付的，这个标准明确地附注在保险条款上。需要提醒的是，意外残疾和意外烧伤在实际的保险产品中，常常是被拆开的，不是所有意外险产品都包含对意外烧伤的责任。另外，在生活中，诸如被歹徒袭击导致脾脏、肾脏等脏器摘除的事件时有耳闻，而类似情况无法获得意外险的理赔，除非是有附加意外医疗保障，则可以为治疗提供费用报销或住院津贴补偿。 -->
             
              <br />
    <p align="center"> <a href="IndexBefore_getTopNews.action" ><font color="red">【关闭窗口】</font></a></p></td>
             
                </div>
            </div>
        </div>
   </c:forEach>     
        
        
        
        <div class="newlink fr">
        	<div><p class="" style="background:#ffeec5;"><span class="hzhb">广告展示</span></p></div>
             <div  class="ggnr">
      		<div id=idContainer2 class=container_pic>
              <table id=idSlider2 border=0 cellspacing=0 cellpadding=0>
                  <tbody>
                  <tr>
                 <td class=td_f><a href="http://www.lanrentuku.com/" target="_blank"><img src="images/homepage/cai3.jpg"/></a></td>
                    <td class=td_f><a href="http://www.lanrentuku.com/" target="_blank"><img src="images/homepage/cai2.jpg"/></a></td>
                    <td class=td_f><a href="http://www.lanrentuku.com/" target="_blank"><img src="images/homepage/cai1.jpg"/></a></td>
                    <td class=td_f><a href="http://www.lanrentuku.com/" target="_blank"><img src="images/homepage/cai4.jpg"/></a></td>
                    <td class=td_f><a href="http://www.lanrentuku.com/" target="_blank"><img src="images/homepage/cai5.jpg"/></a></td>
                    <td class=td_f><a href="http://www.lanrentuku.com/" target="_blank"><img src="images/homepage/cai6.jpg"/></a></td>
                    <td class=td_f><a href="http://www.lanrentuku.com/" target="_blank"><img src="images/homepage/cai7.jpg"/></a></td>       
                   </tr></tbody>
                 </table>
                 <ul style="width:260px; height:37px; left:0px; background:#000000; POSITION: absolute; bottom:0px; filter:alpha(Opacity=80);-moz-opacity:0.5;opacity: 0.5;"></ul>
                <ul id=idNum class=num></ul>
            </div>
            </div>
            <!--热门咨询-->
            <div class="fgzt">
                <p class="bxnestitle">
                    <span class="yellow">热门咨询</span>
                    <span class="m2"></span>
              </p>
                <div class="listli heh">
                 <ul>
                	<li><a href="###">公司网站上线</a></li>
                    <li><a href="###">保监会颁布《保险代理、经济公司……</a></li>
                    <li><a href="###">关于2013年第三季度保险中介公司……</a></li>
                    <li><a href="###">保监会颁布《保险代理、经济公司……</a></li>
                    <li><a href="###">关于2013年第三季度保险中介公司……</a></li>
                    <li><a href="###">保监会颁布《保险代理、经济公司……</a></li>
                    <li><a href="###">关于2013年第三季度保险中介公司……</a></li>
                    <li><a href="###">公司网站上线</a></li>
                    <li><a href="###">保监会颁布《保险代理、经济公司……</a></li>
                    <li><a href="###">关于2013年第三季度保险中介公司……</a></li>
                    <li><a href="###">保监会颁布《保险代理、经济公司……</a></li>
                    <li><a href="###">关于2013年第三季度保险中介公司……</a></li>
                    <li><a href="###">保监会颁布《保险代理、经济公司……</a></li>
                    <li><a href="###">关于2013年第三季度保险中介公司……</a></li>
                    <li><a href="###">公司网站上线</a></li>
                    <li><a href="###">保监会颁布《保险代理、经济公司……</a></li>
                    <li><a href="###">关于2013年第三季度保险中介公司……</a></li>
                    <li><a href="###">保监会颁布《保险代理、经济公司……</a></li>
                    <li><a href="###">关于2013年第三季度保险中介公司……</a></li>
                    <li><a href="###">保监会颁布《保险代理、经济公司……</a></li>
                </ul>
             </div>
            </div>
            <!--热门咨询-->
        </div>
        <p class="clear"></p>
   </div>
 </div>
<script>
	var forEach = function(array, callback, thisObject){
		if(array.forEach){
			array.forEach(callback, thisObject);
		}else{
			for (var i = 0, len = array.length; i < len; i++) { callback.call(thisObject, array[i], i, array); }
		}
	}
	
	var st = new SlideTrans("idContainer2", "idSlider2", 7, { Vertical: false });
	
	var nums = [];
	//插入数字
	for(var i = 0, n = st._count - 1; i <= n;){
		(nums[i] = $one("idNum").appendChild(document.createElement("li"))).innerHTML = ++i;
	}
	
	forEach(nums, function(o, i){
		o.onmouseover = function(){ o.className = "on"; st.Auto = false; st.Run(i); }
		o.onmouseout = function(){ o.className = ""; st.Auto = true; st.Run(); }
	})
	
	//设置按钮样式
	st.onStart = function(){
		forEach(nums, function(o, i){ o.className = st.Index == i ? "on" : ""; })
	}
	st.Run();
</script>
</body>
</html>