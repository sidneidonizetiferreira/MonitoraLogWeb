!function(t){function e(){return new Date(Date.UTC.apply(Date,arguments))}var i=function(e,i){var n=this;switch(this.element=t(e),this.language=i.language||this.element.data("date-language")||"en",this.language=this.language in a?this.language:"en",this.isRTL=a[this.language].rtl||!1,this.format=s.parseFormat(i.format||this.element.data("date-format")||"mm/dd/yyyy"),this.isInline=!1,this.isInput=this.element.is("input"),this.component=!!this.element.is(".date")&&this.element.find(".add-on"),this.hasInput=this.component&&this.element.find("input").length,this.component&&0===this.component.length&&(this.component=!1),this._attachEvents(),this.forceParse=!0,"forceParse"in i?this.forceParse=i.forceParse:"dateForceParse"in this.element.data()&&(this.forceParse=this.element.data("date-force-parse")),this.picker=t(s.template).appendTo(this.isInline?this.element:"body").on({click:t.proxy(this.click,this),mousedown:t.proxy(this.mousedown,this)}),this.isInline?this.picker.addClass("datepicker-inline"):this.picker.addClass("datepicker-dropdown dropdown-menu"),this.isRTL&&(this.picker.addClass("datepicker-rtl"),this.picker.find(".prev i, .next i").toggleClass("icon-arrow-left icon-arrow-right")),t(document).on("mousedown",function(e){0===t(e.target).closest(".datepicker").length&&n.hide()}),this.autoclose=!1,"autoclose"in i?this.autoclose=i.autoclose:"dateAutoclose"in this.element.data()&&(this.autoclose=this.element.data("date-autoclose")),this.keyboardNavigation=!0,"keyboardNavigation"in i?this.keyboardNavigation=i.keyboardNavigation:"dateKeyboardNavigation"in this.element.data()&&(this.keyboardNavigation=this.element.data("date-keyboard-navigation")),this.viewMode=this.startViewMode=0,i.startView||this.element.data("date-start-view")){case 2:case"decade":this.viewMode=this.startViewMode=2;break;case 1:case"year":this.viewMode=this.startViewMode=1}this.todayBtn=i.todayBtn||this.element.data("date-today-btn")||!1,this.todayHighlight=i.todayHighlight||this.element.data("date-today-highlight")||!1,this.weekStart=(i.weekStart||this.element.data("date-weekstart")||a[this.language].weekStart||0)%7,this.weekEnd=(this.weekStart+6)%7,this.startDate=-1/0,this.endDate=1/0,this.daysOfWeekDisabled=[],this.setStartDate(i.startDate||this.element.data("date-startdate")),this.setEndDate(i.endDate||this.element.data("date-enddate")),this.setDaysOfWeekDisabled(i.daysOfWeekDisabled||this.element.data("date-days-of-week-disabled")),this.fillDow(),this.fillMonths(),this.update(),this.showMode(),this.isInline&&this.show()};i.prototype={constructor:i,_events:[],_attachEvents:function(){this._detachEvents(),this.isInput?this._events=[[this.element,{focus:t.proxy(this.show,this),keyup:t.proxy(this.update,this),keydown:t.proxy(this.keydown,this)}]]:this.component&&this.hasInput?this._events=[[this.element.find("input"),{focus:t.proxy(this.show,this),keyup:t.proxy(this.update,this),keydown:t.proxy(this.keydown,this)}],[this.component,{click:t.proxy(this.show,this)}]]:this.element.is("div")?this.isInline=!0:this._events=[[this.element,{click:t.proxy(this.show,this)}]];for(var e,i,a=0;a<this._events.length;a++)e=this._events[a][0],i=this._events[a][1],e.on(i)},_detachEvents:function(){for(var t,e,i=0;i<this._events.length;i++)t=this._events[i][0],e=this._events[i][1],t.off(e);this._events=[]},show:function(e){this.picker.show(),this.height=this.component?this.component.outerHeight():this.element.outerHeight(),this.update(),this.place(),t(window).on("resize",t.proxy(this.place,this)),e&&(e.stopPropagation(),e.preventDefault()),this.element.trigger({type:"show",date:this.date})},hide:function(e){this.isInline||(this.picker.hide(),t(window).off("resize",this.place),this.viewMode=this.startViewMode,this.showMode(),this.isInput||t(document).off("mousedown",this.hide),this.forceParse&&(this.isInput&&this.element.val()||this.hasInput&&this.element.find("input").val())&&this.setValue(),this.element.trigger({type:"hide",date:this.date}))},remove:function(){this._detachEvents(),this.picker.remove(),delete this.element.data().datepicker},getDate:function(){var t=this.getUTCDate();return new Date(t.getTime()+6e4*t.getTimezoneOffset())},getUTCDate:function(){return this.date},setDate:function(t){this.setUTCDate(new Date(t.getTime()-6e4*t.getTimezoneOffset()))},setUTCDate:function(t){this.date=t,this.setValue()},setValue:function(){var t=this.getFormattedDate();this.isInput?this.element.val(t):(this.component&&this.element.find("input").val(t),this.element.data("date",t))},getFormattedDate:function(t){return void 0===t&&(t=this.format),s.formatDate(this.date,t,this.language)},setStartDate:function(t){this.startDate=t||-1/0,this.startDate!==-1/0&&(this.startDate=s.parseDate(this.startDate,this.format,this.language)),this.update(),this.updateNavArrows()},setEndDate:function(t){this.endDate=t||1/0,this.endDate!==1/0&&(this.endDate=s.parseDate(this.endDate,this.format,this.language)),this.update(),this.updateNavArrows()},setDaysOfWeekDisabled:function(e){this.daysOfWeekDisabled=e||[],t.isArray(this.daysOfWeekDisabled)||(this.daysOfWeekDisabled=this.daysOfWeekDisabled.split(/,\s*/)),this.daysOfWeekDisabled=t.map(this.daysOfWeekDisabled,function(t){return parseInt(t,10)}),this.update(),this.updateNavArrows()},place:function(){if(!this.isInline){var e=parseInt(this.element.parents().filter(function(){return"auto"!=t(this).css("z-index")}).first().css("z-index"))+10,i=this.component?this.component.offset():this.element.offset(),a=this.component?this.component.outerHeight(!0):this.element.outerHeight(!0);this.picker.css({top:i.top+a,left:i.left,zIndex:e})}},update:function(){var t,e=!1;arguments&&arguments.length&&("string"==typeof arguments[0]||arguments[0]instanceof Date)?(t=arguments[0],e=!0):t=this.isInput?this.element.val():this.element.data("date")||this.element.find("input").val(),this.date=s.parseDate(t,this.format,this.language),e&&this.setValue();var i=this.viewDate;this.date<this.startDate?this.viewDate=new Date(this.startDate):this.date>this.endDate?this.viewDate=new Date(this.endDate):this.viewDate=new Date(this.date),i&&i.getTime()!=this.viewDate.getTime()&&this.element.trigger({type:"changeDate",date:this.viewDate}),this.fill()},fillDow:function(){for(var t=this.weekStart,e="<tr>";t<this.weekStart+7;)e+='<th class="dow">'+a[this.language].daysMin[t++%7]+"</th>";e+="</tr>",this.picker.find(".datepicker-days thead").append(e)},fillMonths:function(){for(var t="",e=0;e<12;)t+='<span class="month">'+a[this.language].monthsShort[e++]+"</span>";this.picker.find(".datepicker-months td").html(t)},fill:function(){var i=new Date(this.viewDate),n=i.getUTCFullYear(),h=i.getUTCMonth(),o=this.startDate!==-1/0?this.startDate.getUTCFullYear():-1/0,r=this.startDate!==-1/0?this.startDate.getUTCMonth():-1/0,d=this.endDate!==1/0?this.endDate.getUTCFullYear():1/0,l=this.endDate!==1/0?this.endDate.getUTCMonth():1/0,c=this.date&&this.date.valueOf(),p=new Date;this.picker.find(".datepicker-days thead th:eq(1)").text(a[this.language].months[h]+" "+n),this.picker.find("tfoot th.today").text(a[this.language].today).toggle(!1!==this.todayBtn),this.updateNavArrows(),this.fillMonths();var u=e(n,h-1,28,0,0,0,0),f=s.getDaysInMonth(u.getUTCFullYear(),u.getUTCMonth());u.setUTCDate(f),u.setUTCDate(f-(u.getUTCDay()-this.weekStart+7)%7);var v=new Date(u);v.setUTCDate(v.getUTCDate()+42),v=v.valueOf();for(var g,D=[];u.valueOf()<v;)u.getUTCDay()==this.weekStart&&D.push("<tr>"),g="",u.getUTCFullYear()<n||u.getUTCFullYear()==n&&u.getUTCMonth()<h?g+=" old":(u.getUTCFullYear()>n||u.getUTCFullYear()==n&&u.getUTCMonth()>h)&&(g+=" new"),this.todayHighlight&&u.getUTCFullYear()==p.getFullYear()&&u.getUTCMonth()==p.getMonth()&&u.getUTCDate()==p.getDate()&&(g+=" today"),c&&u.valueOf()==c&&(g+=" active"),(u.valueOf()<this.startDate||u.valueOf()>this.endDate||-1!==t.inArray(u.getUTCDay(),this.daysOfWeekDisabled))&&(g+=" disabled"),D.push('<td class="day'+g+'">'+u.getUTCDate()+"</td>"),u.getUTCDay()==this.weekEnd&&D.push("</tr>"),u.setUTCDate(u.getUTCDate()+1);this.picker.find(".datepicker-days tbody").empty().append(D.join(""));var m=this.date&&this.date.getUTCFullYear(),y=this.picker.find(".datepicker-months").find("th:eq(1)").text(n).end().find("span").removeClass("active");m&&m==n&&y.eq(this.date.getUTCMonth()).addClass("active"),(n<o||n>d)&&y.addClass("disabled"),n==o&&y.slice(0,r).addClass("disabled"),n==d&&y.slice(l+1).addClass("disabled"),D="",n=10*parseInt(n/10,10);var w=this.picker.find(".datepicker-years").find("th:eq(1)").text(n+"-"+(n+9)).end().find("td");n-=1;for(var k=-1;k<11;k++)D+='<span class="year'+(-1==k||10==k?" old":"")+(m==n?" active":"")+(n<o||n>d?" disabled":"")+'">'+n+"</span>",n+=1;w.html(D)},updateNavArrows:function(){var t=new Date(this.viewDate),e=t.getUTCFullYear(),i=t.getUTCMonth();switch(this.viewMode){case 0:this.startDate!==-1/0&&e<=this.startDate.getUTCFullYear()&&i<=this.startDate.getUTCMonth()?this.picker.find(".prev").css({visibility:"hidden"}):this.picker.find(".prev").css({visibility:"visible"}),this.endDate!==1/0&&e>=this.endDate.getUTCFullYear()&&i>=this.endDate.getUTCMonth()?this.picker.find(".next").css({visibility:"hidden"}):this.picker.find(".next").css({visibility:"visible"});break;case 1:case 2:this.startDate!==-1/0&&e<=this.startDate.getUTCFullYear()?this.picker.find(".prev").css({visibility:"hidden"}):this.picker.find(".prev").css({visibility:"visible"}),this.endDate!==1/0&&e>=this.endDate.getUTCFullYear()?this.picker.find(".next").css({visibility:"hidden"}):this.picker.find(".next").css({visibility:"visible"})}},click:function(i){i.stopPropagation(),i.preventDefault();var a=t(i.target).closest("span, td, th");if(1==a.length)switch(a[0].nodeName.toLowerCase()){case"th":switch(a[0].className){case"switch":this.showMode(1);break;case"prev":case"next":var n=s.modes[this.viewMode].navStep*("prev"==a[0].className?-1:1);switch(this.viewMode){case 0:this.viewDate=this.moveMonth(this.viewDate,n);break;case 1:case 2:this.viewDate=this.moveYear(this.viewDate,n)}this.fill();break;case"today":var h=new Date;h=e(h.getFullYear(),h.getMonth(),h.getDate(),0,0,0),this.showMode(-2);var o="linked"==this.todayBtn?null:"view";this._setDate(h,o)}break;case"span":if(!a.is(".disabled")){if(this.viewDate.setUTCDate(1),a.is(".month")){var r=a.parent().find("span").index(a);this.viewDate.setUTCMonth(r),this.element.trigger({type:"changeMonth",date:this.viewDate})}else{var d=parseInt(a.text(),10)||0;this.viewDate.setUTCFullYear(d),this.element.trigger({type:"changeYear",date:this.viewDate})}this.showMode(-1),this.fill()}break;case"td":if(a.is(".day")&&!a.is(".disabled")){var l=parseInt(a.text(),10)||1;d=this.viewDate.getUTCFullYear(),r=this.viewDate.getUTCMonth();a.is(".old")?0===r?(r=11,d-=1):r-=1:a.is(".new")&&(11==r?(r=0,d+=1):r+=1),this._setDate(e(d,r,l,0,0,0,0))}}},_setDate:function(t,e){var i;e&&"date"!=e||(this.date=t),e&&"view"!=e||(this.viewDate=t),this.fill(),this.setValue(),this.element.trigger({type:"changeDate",date:this.date}),this.isInput?i=this.element:this.component&&(i=this.element.find("input")),i&&(i.change(),!this.autoclose||e&&"date"!=e||this.hide())},moveMonth:function(t,e){if(!e)return t;var i,a,s=new Date(t.valueOf()),n=s.getUTCDate(),h=s.getUTCMonth(),o=Math.abs(e);if(e=e>0?1:-1,1==o)a=-1==e?function(){return s.getUTCMonth()==h}:function(){return s.getUTCMonth()!=i},i=h+e,s.setUTCMonth(i),(i<0||i>11)&&(i=(i+12)%12);else{for(var r=0;r<o;r++)s=this.moveMonth(s,e);i=s.getUTCMonth(),s.setUTCDate(n),a=function(){return i!=s.getUTCMonth()}}for(;a();)s.setUTCDate(--n),s.setUTCMonth(i);return s},moveYear:function(t,e){return this.moveMonth(t,12*e)},dateWithinRange:function(t){return t>=this.startDate&&t<=this.endDate},keydown:function(t){if(this.picker.is(":not(:visible)"))27==t.keyCode&&this.show();else{var e,i,a,s,n=!1;switch(t.keyCode){case 27:this.hide(),t.preventDefault();break;case 37:case 39:if(!this.keyboardNavigation)break;e=37==t.keyCode?-1:1,t.ctrlKey?(i=this.moveYear(this.date,e),a=this.moveYear(this.viewDate,e)):t.shiftKey?(i=this.moveMonth(this.date,e),a=this.moveMonth(this.viewDate,e)):((i=new Date(this.date)).setUTCDate(this.date.getUTCDate()+e),(a=new Date(this.viewDate)).setUTCDate(this.viewDate.getUTCDate()+e)),this.dateWithinRange(i)&&(this.date=i,this.viewDate=a,this.setValue(),this.update(),t.preventDefault(),n=!0);break;case 38:case 40:if(!this.keyboardNavigation)break;e=38==t.keyCode?-1:1,t.ctrlKey?(i=this.moveYear(this.date,e),a=this.moveYear(this.viewDate,e)):t.shiftKey?(i=this.moveMonth(this.date,e),a=this.moveMonth(this.viewDate,e)):((i=new Date(this.date)).setUTCDate(this.date.getUTCDate()+7*e),(a=new Date(this.viewDate)).setUTCDate(this.viewDate.getUTCDate()+7*e)),this.dateWithinRange(i)&&(this.date=i,this.viewDate=a,this.setValue(),this.update(),t.preventDefault(),n=!0);break;case 13:this.hide(),t.preventDefault();break;case 9:this.hide()}if(n)this.element.trigger({type:"changeDate",date:this.date}),this.isInput?s=this.element:this.component&&(s=this.element.find("input")),s&&s.change()}},showMode:function(t){t&&(this.viewMode=Math.max(0,Math.min(2,this.viewMode+t))),this.picker.find(">div").hide().filter(".datepicker-"+s.modes[this.viewMode].clsName).css("display","block"),this.updateNavArrows()}},t.fn.datepicker=function(e){var a=Array.apply(null,arguments);return a.shift(),this.each(function(){var s=t(this),n=s.data("datepicker"),h="object"==typeof e&&e;n||s.data("datepicker",n=new i(this,t.extend({},t.fn.datepicker.defaults,h))),"string"==typeof e&&"function"==typeof n[e]&&n[e].apply(n,a)})},t.fn.datepicker.defaults={},t.fn.datepicker.Constructor=i;var a=t.fn.datepicker.dates={en:{days:["Domingo","Segunda","Terça","Quarta","Quinta","Sexta","Sábado","Domingo"],daysShort:["Dom","Seg","Ter","Qua","Qui","Sex","Sáb","Dom"],daysMin:["Do","Se","Te","Qu","Qu","Se","Sa","Do"],months:["Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"],monthsShort:["Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Set","Out","Nov","Dez"],today:"Hoje"}},s={modes:[{clsName:"days",navFnc:"Month",navStep:1},{clsName:"months",navFnc:"FullYear",navStep:1},{clsName:"years",navFnc:"FullYear",navStep:10}],isLeapYear:function(t){return t%4==0&&t%100!=0||t%400==0},getDaysInMonth:function(t,e){return[31,s.isLeapYear(t)?29:28,31,30,31,30,31,31,30,31,30,31][e]},validParts:/dd?|DD?|mm?|MM?|yy(?:yy)?/g,nonpunctuation:/[^ -\/:-@\[\u3400-\u9fff-`{-~\t\n\r]+/g,parseFormat:function(t){var e=t.replace(this.validParts,"\0").split("\0"),i=t.match(this.validParts);if(!e||!e.length||!i||0===i.length)throw new Error("Invalid date format.");return{separators:e,parts:i}},parseDate:function(s,n,h){if(s instanceof Date)return s;if(/^[\-+]\d+[dmwy]([\s,]+[\-+]\d+[dmwy])*$/.test(s)){var o,r=/([\-+]\d+)([dmwy])/,d=s.match(/([\-+]\d+)([dmwy])/g);s=new Date;for(var l=0;l<d.length;l++)switch(u=r.exec(d[l]),o=parseInt(u[1]),u[2]){case"d":s.setUTCDate(s.getUTCDate()+o);break;case"m":s=i.prototype.moveMonth.call(i.prototype,s,o);break;case"w":s.setUTCDate(s.getUTCDate()+7*o);break;case"y":s=i.prototype.moveYear.call(i.prototype,s,o)}return e(s.getUTCFullYear(),s.getUTCMonth(),s.getUTCDate(),0,0,0)}d=s&&s.match(this.nonpunctuation)||[],s=new Date;var c,p,u,f={},v=["yyyy","yy","M","MM","m","mm","d","dd"],g={yyyy:function(t,e){return t.setUTCFullYear(e)},yy:function(t,e){return t.setUTCFullYear(2e3+e)},m:function(t,e){for(e-=1;e<0;)e+=12;for(e%=12,t.setUTCMonth(e);t.getUTCMonth()!=e;)t.setUTCDate(t.getUTCDate()-1);return t},d:function(t,e){return t.setUTCDate(e)}};g.M=g.MM=g.mm=g.m,g.dd=g.d,s=e(s.getFullYear(),s.getMonth(),s.getDate(),0,0,0);var D=n.parts.slice();if(d.length!=D.length&&(D=t(D).filter(function(e,i){return-1!==t.inArray(i,v)}).toArray()),d.length==D.length){l=0;for(var m=D.length;l<m;l++){if(c=parseInt(d[l],10),u=D[l],isNaN(c))switch(u){case"MM":p=t(a[h].months).filter(function(){var t=this.slice(0,d[l].length);return t==d[l].slice(0,t.length)}),c=t.inArray(p[0],a[h].months)+1;break;case"M":p=t(a[h].monthsShort).filter(function(){var t=this.slice(0,d[l].length);return t==d[l].slice(0,t.length)}),c=t.inArray(p[0],a[h].monthsShort)+1}f[u]=c}var y;for(l=0;l<v.length;l++)(y=v[l])in f&&!isNaN(f[y])&&g[y](s,f[y])}return s},formatDate:function(e,i,s){var n={d:e.getUTCDate(),D:a[s].daysShort[e.getUTCDay()],DD:a[s].days[e.getUTCDay()],m:e.getUTCMonth()+1,M:a[s].monthsShort[e.getUTCMonth()],MM:a[s].months[e.getUTCMonth()],yy:e.getUTCFullYear().toString().substring(2),yyyy:e.getUTCFullYear()};n.dd=(n.d<10?"0":"")+n.d,n.mm=(n.m<10?"0":"")+n.m;e=[];for(var h=t.extend([],i.separators),o=0,r=i.parts.length;o<r;o++)h.length&&e.push(h.shift()),e.push(n[i.parts[o]]);return e.join("")},headTemplate:'<thead><tr><th class="prev"><i class="icon-arrow-left"/></th><th colspan="5" class="switch"></th><th class="next"><i class="icon-arrow-right"/></th></tr></thead>',contTemplate:'<tbody><tr><td colspan="7"></td></tr></tbody>',footTemplate:'<tfoot><tr><th colspan="7" class="today"></th></tr></tfoot>'};s.template='<div class="datepicker"><div class="datepicker-days"><table class=" table-condensed">'+s.headTemplate+"<tbody></tbody>"+s.footTemplate+'</table></div><div class="datepicker-months"><table class="table-condensed">'+s.headTemplate+s.contTemplate+s.footTemplate+'</table></div><div class="datepicker-years"><table class="table-condensed">'+s.headTemplate+s.contTemplate+s.footTemplate+"</table></div></div>",t.fn.datepicker.DPGlobal=s}(window.jQuery);