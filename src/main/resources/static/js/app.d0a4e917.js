(function(e){function t(t){for(var n,s,u=t[0],i=t[1],l=t[2],c=0,p=[];c<u.length;c++)s=u[c],Object.prototype.hasOwnProperty.call(a,s)&&a[s]&&p.push(a[s][0]),a[s]=0;for(n in i)Object.prototype.hasOwnProperty.call(i,n)&&(e[n]=i[n]);d&&d(t);while(p.length)p.shift()();return o.push.apply(o,l||[]),r()}function r(){for(var e,t=0;t<o.length;t++){for(var r=o[t],n=!0,s=1;s<r.length;s++){var u=r[s];0!==a[u]&&(n=!1)}n&&(o.splice(t--,1),e=i(i.s=r[0]))}return e}var n={},s={app:0},a={app:0},o=[];function u(e){return i.p+"js/"+({about:"about"}[e]||e)+"."+{about:"e676d351"}[e]+".js"}function i(t){if(n[t])return n[t].exports;var r=n[t]={i:t,l:!1,exports:{}};return e[t].call(r.exports,r,r.exports,i),r.l=!0,r.exports}i.e=function(e){var t=[],r={about:1};s[e]?t.push(s[e]):0!==s[e]&&r[e]&&t.push(s[e]=new Promise((function(t,r){for(var n="css/"+({about:"about"}[e]||e)+"."+{about:"149bd38b"}[e]+".css",a=i.p+n,o=document.getElementsByTagName("link"),u=0;u<o.length;u++){var l=o[u],c=l.getAttribute("data-href")||l.getAttribute("href");if("stylesheet"===l.rel&&(c===n||c===a))return t()}var p=document.getElementsByTagName("style");for(u=0;u<p.length;u++){l=p[u],c=l.getAttribute("data-href");if(c===n||c===a)return t()}var d=document.createElement("link");d.rel="stylesheet",d.type="text/css",d.onload=t,d.onerror=function(t){var n=t&&t.target&&t.target.src||a,o=new Error("Loading CSS chunk "+e+" failed.\n("+n+")");o.code="CSS_CHUNK_LOAD_FAILED",o.request=n,delete s[e],d.parentNode.removeChild(d),r(o)},d.href=a;var h=document.getElementsByTagName("head")[0];h.appendChild(d)})).then((function(){s[e]=0})));var n=a[e];if(0!==n)if(n)t.push(n[2]);else{var o=new Promise((function(t,r){n=a[e]=[t,r]}));t.push(n[2]=o);var l,c=document.createElement("script");c.charset="utf-8",c.timeout=120,i.nc&&c.setAttribute("nonce",i.nc),c.src=u(e);var p=new Error;l=function(t){c.onerror=c.onload=null,clearTimeout(d);var r=a[e];if(0!==r){if(r){var n=t&&("load"===t.type?"missing":t.type),s=t&&t.target&&t.target.src;p.message="Loading chunk "+e+" failed.\n("+n+": "+s+")",p.name="ChunkLoadError",p.type=n,p.request=s,r[1](p)}a[e]=void 0}};var d=setTimeout((function(){l({type:"timeout",target:c})}),12e4);c.onerror=c.onload=l,document.head.appendChild(c)}return Promise.all(t)},i.m=e,i.c=n,i.d=function(e,t,r){i.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:r})},i.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},i.t=function(e,t){if(1&t&&(e=i(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var r=Object.create(null);if(i.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)i.d(r,n,function(t){return e[t]}.bind(null,n));return r},i.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return i.d(t,"a",t),t},i.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},i.p="/",i.oe=function(e){throw console.error(e),e};var l=window["webpackJsonp"]=window["webpackJsonp"]||[],c=l.push.bind(l);l.push=t,l=l.slice();for(var p=0;p<l.length;p++)t(l[p]);var d=c;o.push([0,"chunk-vendors"]),r()})({0:function(e,t,r){e.exports=r("56d7")},"034f":function(e,t,r){"use strict";var n=r("85ec"),s=r.n(n);s.a},"2aad":function(e,t,r){"use strict";var n=r("c676"),s=r.n(n);s.a},"56d7":function(e,t,r){"use strict";r.r(t);r("e260"),r("e6cf"),r("cca6"),r("a79d");var n=r("2b0e"),s=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"app"}},[r("div",{attrs:{id:"nav"}},[r("router-link",{attrs:{to:"/"}},[e._v("Home")]),e._v(" | "),r("router-link",{attrs:{to:"/batch"}},[e._v("Batch")])],1),r("router-view")],1)},a=[],o=(r("034f"),r("2877")),u={},i=Object(o["a"])(u,s,a,!1,null,null,null),l=i.exports,c=(r("d3b7"),r("8c4f")),p=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"home"},[r("FormLog",{attrs:{msg:"Welcome to Your Vue.js App"}})],1)},d=[],h=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"formLog"},[r("ul",{class:{disable:!0,error:e.checkErrorClass(),ok:e.submit.status}},e._l(e.errors,(function(t,n){return r("li",{key:"error_id_"+n},[e._v(" "+e._s(t)+" ")])})),0),r("form",{attrs:{id:"logManualInsert",method:"get"},on:{submit:function(t){return t.preventDefault(),e.checkForm(t)}}},[r("ul",[r("li",{staticClass:"half"},[e._v("Date")]),r("li",{staticClass:"half"},[e._v("Ip")]),r("li",{staticClass:"half"},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.date,expression:"date"}],attrs:{type:"text",name:"date",placeholder:"yyyy-MM-dd HH:mm:ss.SSS"},domProps:{value:e.date},on:{input:function(t){t.target.composing||(e.date=t.target.value)}}})]),r("li",{staticClass:"half"},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.ip,expression:"ip"}],attrs:{type:"text",name:"ip",placeholder:"Ipv4"},domProps:{value:e.ip},on:{input:function(t){t.target.composing||(e.ip=t.target.value)}}})]),r("li",{staticClass:"half"},[e._v("Request")]),r("li",{staticClass:"half"},[e._v("Status")]),r("li",{staticClass:"half"},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.request,expression:"request"}],attrs:{type:"text",name:"request",placeholder:"Http request type"},domProps:{value:e.request},on:{input:function(t){t.target.composing||(e.request=t.target.value)}}})]),r("li",{staticClass:"half"},[r("input",{directives:[{name:"model",rawName:"v-model",value:e.status,expression:"status"}],attrs:{type:"number",name:"status",placeholder:"Http Code"},domProps:{value:e.status},on:{input:function(t){t.target.composing||(e.status=t.target.value)}}})]),r("li",[e._v("User Agent")]),r("li",[r("input",{directives:[{name:"model",rawName:"v-model",value:e.user_agent,expression:"user_agent"}],attrs:{type:"text",name:"user_agent",placeholder:"User Agent"},domProps:{value:e.user_agent},on:{input:function(t){t.target.composing||(e.user_agent=t.target.value)}}})]),e._m(0)])])])},m=[function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("li",{staticClass:"send"},[r("input",{staticClass:"submitLog",attrs:{type:"submit",value:"Submit"}})])}],f=(r("4d63"),r("ac1f"),r("25f0"),{name:"FormLog",props:{msg:String},data:function(){return{dateChecker:new RegExp("(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}(?:.\\d{3}\\b)?)$"),ipChecker:new RegExp("^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$"),errors:[],submit:{status:!1},date:null,ip:null,request:null,status:null,user_agent:null}},methods:{checkErrorClass:function(){return this.errors.length>0},checkForm:function(e){this.errors=[],this.submit.status=!1,this.dateChecker.test(this.date)||(this.errors.push("The Date field must follows yyyy-MM-dd HH:mm:ss.SSS format"),this.date=null),this.ipChecker.test(this.ip)||(this.errors.push("The IP field must follows IPv4 format"),this.ip=null),null!=this.user_agent&&this.user_agent.length>=255&&(this.errors.push("The user_agent must smaller than 255 characters"),this.user_agent=null),0==this.errors.length?this.submitToApi():this.displayerrors=!0,e.preventDefault()},getLogModel:function(){return{date:this.date,ip:this.ip,request:this.request,status:this.status,user_agent:this.user_agent}},submitToApi:function(){var e=this;this.errors=[],this.submit.status=!1;var t=new Headers({"Content-Type":"application/json"});fetch("http://localhost:8080/logs/",{method:"POST",headers:t,body:JSON.stringify(this.getLogModel())}).then((function(t){return console.log(t),201==t.status?(e.submit.status=!0,e.errors.push("Log has been saved")):e.submit.status=!1,t.json()})).then((function(t){null!=t.error_list[0].message&&e.errors.push(t.error_list[0].message),console.log(t)})).catch((function(t){e.errors.push(t),console.error(t)}))}}}),v=f,g=(r("2aad"),Object(o["a"])(v,h,m,!1,null,"202466cc",null)),b=g.exports,y={name:"Home",components:{FormLog:b}},_=y,w=Object(o["a"])(_,p,d,!1,null,null,null),C=w.exports;n["a"].use(c["a"]);var x=[{path:"/",name:"Home",component:C},{path:"/batch",name:"Batch",component:function(){return r.e("about").then(r.bind(null,"ce4d"))}}],S=new c["a"]({mode:"history",base:"/",routes:x}),k=S,P=r("2f62");n["a"].use(P["a"]);var j=new P["a"].Store({state:{},mutations:{},actions:{},modules:{}});n["a"].config.productionTip=!1,new n["a"]({router:k,store:j,render:function(e){return e(l)}}).$mount("#app")},"85ec":function(e,t,r){},c676:function(e,t,r){}});
//# sourceMappingURL=app.d0a4e917.js.map