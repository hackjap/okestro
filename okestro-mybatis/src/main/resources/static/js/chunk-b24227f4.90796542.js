(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b24227f4"],{b0c0:function(e,t,n){var a=n("83ab"),r=n("9bf2").f,s=Function.prototype,o=s.toString,i=/^\s*function ([^ (]*)/,u="name";a&&!(u in s)&&r(s,u,{configurable:!0,get:function(){try{return o.call(this).match(i)[1]}catch(e){return""}}})},f938:function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("CompanyForm")],1)},r=[],s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"contents"},[n("div",{staticClass:"form-wrapper form-wrapper-sm"},[n("form",{staticClass:"form",on:{submit:function(t){return t.preventDefault(),e.submitForm.apply(null,arguments)}}},[n("div",[n("label",{attrs:{for:"name"}},[e._v("회사명 ")]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.name,expression:"name"}],attrs:{id:"name",type:"text"},domProps:{value:e.name},on:{input:function(t){t.target.composing||(e.name=t.target.value)}}})]),n("div",[n("label",{attrs:{for:"address"}},[e._v("주소 ")]),n("input",{directives:[{name:"model",rawName:"v-model",value:e.address,expression:"address"}],attrs:{id:"address",type:"text"},domProps:{value:e.address},on:{input:function(t){t.target.composing||(e.address=t.target.value)}}})]),n("button",{staticClass:"btn",attrs:{type:"submit"}},[e._v("등록하기")])]),n("p",{staticClass:"log"},[e._v(e._s(e.logMessage))])])])},o=[],i=n("1da1"),u=(n("96cf"),n("b0c0"),n("365c")),c={data:function(){return{name:"",address:""}},methods:{submitForm:function(){var e=this;return Object(i["a"])(regeneratorRuntime.mark((function t(){var n,a,r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return n={name:e.name,address:e.address},t.next=3,Object(u["b"])(n);case 3:a=t.sent,r=a.data,console.log(r),alert("등록성공"+r);case 7:case"end":return t.stop()}}),t)})))()}}},l=c,m=n("2877"),d=Object(m["a"])(l,s,o,!1,null,null,null),p=d.exports,f={components:{CompanyForm:p}},v=f,b=Object(m["a"])(v,a,r,!1,null,null,null);t["default"]=b.exports}}]);
//# sourceMappingURL=chunk-b24227f4.90796542.js.map