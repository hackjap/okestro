(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b80d29a2","chunk-44cc3b82"],{"16d3":function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-container",[a("p",{staticClass:"text-center white--text grey darken-1 mt-8"}),a("v-card",[a("v-card-title",{staticClass:"text-center black--text"},[t._v(" 백신 등록 리스트")]),a("v-card-text",[a("v-simple-table",{scopedSlots:t._u([{key:"default",fn:function(){return[a("thead",[a("tr",[a("th",{staticClass:"text-left"},[t._v(" 백신명 ")]),a("th",{staticClass:"text-left"},[t._v(" 가격 ")]),a("th",{staticClass:"text-left "},[t._v("수량")]),a("th",{staticClass:"text-left"},[t._v("국가")])])]),a("tbody",t._l(t.datas,(function(e){return a("tr",{key:e.name},[a("td",[t._v(t._s(e.name))]),a("td",{staticClass:"indigo--text"},[t._v(" "+t._s(e.price.toLocaleString()+"원")+" ")]),a("td",{staticClass:"red--text"},[t._v(t._s(e.quantity+"개"))]),a("td",[t._v(t._s(e.country))])])})),0)]},proxy:!0}])})],1)],1),this.$store.getters.isAdmin?[a("v-card",{staticClass:"mt-8 pa-3"},[a("v-card-title",[t._v("백신 예방 접종 리스트")]),a("VaccineList",{staticClass:"pa-1"})],1)]:t._e()],2)},n=[],s=a("1da1"),i=(a("96cf"),a("29fd")),c=a("eaae"),o=a("d8ad"),u={data:function(){return{datas:[]}},mounted:function(){this.getData(),o["a"].$on("set:quantity",this.getData),o["a"].$on("refresh",this.getData)},beforeDestroy:function(){o["a"].$off("refresh",this.getData),o["a"].$off("set:quantity",this.getData)},watch:{},methods:{getData:function(){var t=this;return Object(s["a"])(regeneratorRuntime.mark((function e(){var a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,Object(i["f"])();case 2:a=e.sent,t.datas=a.data,t.$store.commit("setOrderitem",t.datas);case 5:case"end":return e.stop()}}),e)})))()}},components:{VaccineList:c["default"]}},l=u,d=a("2877"),f=a("6544"),v=a.n(f),m=a("b0af"),h=a("99d9"),p=a("a523"),b=a("1f4f"),g=Object(d["a"])(l,r,n,!1,null,null,null);e["default"]=g.exports;v()(g,{VCard:m["a"],VCardText:h["a"],VCardTitle:h["b"],VContainer:p["a"],VSimpleTable:b["a"]})},"1f4f":function(t,e,a){"use strict";var r=a("5530"),n=(a("a9e3"),a("8b37"),a("80d2")),s=a("7560"),i=a("58df");e["a"]=Object(i["a"])(s["a"]).extend({name:"v-simple-table",props:{dense:Boolean,fixedHeader:Boolean,height:[Number,String]},computed:{classes:function(){return Object(r["a"])({"v-data-table--dense":this.dense,"v-data-table--fixed-height":!!this.height&&!this.fixedHeader,"v-data-table--fixed-header":this.fixedHeader,"v-data-table--has-top":!!this.$slots.top,"v-data-table--has-bottom":!!this.$slots.bottom},this.themeClasses)}},methods:{genWrapper:function(){return this.$slots.wrapper||this.$createElement("div",{staticClass:"v-data-table__wrapper",style:{height:Object(n["f"])(this.height)}},[this.$createElement("table",this.$slots.default)])}},render:function(t){return t("div",{staticClass:"v-data-table",class:this.classes},[this.$slots.top,this.genWrapper(),this.$slots.bottom])}})},"29fd":function(t,e,a){"use strict";a.d(e,"i",(function(){return f})),a.d(e,"j",(function(){return u})),a.d(e,"e",(function(){return i})),a.d(e,"h",(function(){return c})),a.d(e,"f",(function(){return o})),a.d(e,"d",(function(){return d})),a.d(e,"g",(function(){return l})),a.d(e,"a",(function(){return v})),a.d(e,"c",(function(){return h})),a.d(e,"b",(function(){return m}));a("99af");var r=a("bc3a"),n=a.n(r),s=a("365c");function i(t,e){var a=s["a"].get("covid/day?date=".concat(t,"&cycle=").concat(e));return a}function c(){var t="https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=200&serviceKey=%2F6YC05LX402Mq1%2Beg8O2m74njrcI2N0h7Km4BNbneOT0MOJlEhWA7Zj7y5c0NrBO2PYPPHWjGBfMFEk6731aug%3D%3D",e=n.a.get(t);return e}function o(){var t=s["a"].get("items");return t}function u(t){var e=s["a"].post("items/new",t);return e}function l(){var t=s["a"].get("users");return t}function d(){var t=s["a"].get("orders/list");return t}function f(t){var e=s["a"].post("orders/",t);return e}function v(t){var e=s["a"].post("orders/".concat(t,"/cancel"));return e}function m(t){var e=s["a"].put("orders/".concat(t,"/complete"));return e}function h(t){var e=s["a"].delete("orders/".concat(t,"/delete"));return e}},"615b":function(t,e,a){},"8b37":function(t,e,a){},"99d9":function(t,e,a){"use strict";a.d(e,"a",(function(){return c})),a.d(e,"b",(function(){return o}));var r=a("b0af"),n=a("80d2"),s=Object(n["g"])("v-card__actions"),i=Object(n["g"])("v-card__subtitle"),c=Object(n["g"])("v-card__text"),o=Object(n["g"])("v-card__title");r["a"]},b0af:function(t,e,a){"use strict";var r=a("5530"),n=(a("a9e3"),a("0481"),a("615b"),a("10d2")),s=a("297c"),i=a("1c87"),c=a("58df");e["a"]=Object(c["a"])(s["a"],i["a"],n["a"]).extend({name:"v-card",props:{flat:Boolean,hover:Boolean,img:String,link:Boolean,loaderHeight:{type:[Number,String],default:4},raised:Boolean},computed:{classes:function(){return Object(r["a"])(Object(r["a"])({"v-card":!0},i["a"].options.computed.classes.call(this)),{},{"v-card--flat":this.flat,"v-card--hover":this.hover,"v-card--link":this.isClickable,"v-card--loading":this.loading,"v-card--disabled":this.disabled,"v-card--raised":this.raised},n["a"].options.computed.classes.call(this))},styles:function(){var t=Object(r["a"])({},n["a"].options.computed.styles.call(this));return this.img&&(t.background='url("'.concat(this.img,'") center center / cover no-repeat')),t}},methods:{genProgress:function(){var t=s["a"].options.methods.genProgress.call(this);return t?this.$createElement("div",{staticClass:"v-card__progress",key:"progress"},[t]):null}},render:function(t){var e=this.generateRouteLink(),a=e.tag,r=e.data;return r.style=this.styles,this.isClickable&&(r.attrs=r.attrs||{},r.attrs.tabindex=0),t(a,this.setBackgroundColor(this.color,r),[this.genProgress(),this.$slots.default])}})},d8ad:function(t,e,a){"use strict";var r=a("2b0e");e["a"]=new r["a"]({})},eaae:function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("v-simple-table",{scopedSlots:t._u([{key:"default",fn:function(){return[a("thead",[a("tr",[a("th",{staticClass:"text-left indigo--text",staticStyle:{"font-size":"15px"}},[t._v(" 회원명 ")]),a("th",{staticClass:"text-left indigo--text",staticStyle:{"font-size":"15px"}},[t._v(" 백신종류 ")]),a("th",{staticClass:"text-left indigo--text",staticStyle:{"font-size":"15px"}},[t._v(" 상태 ")]),a("th",{staticClass:"text-left indigo--text",staticStyle:{"font-size":"15px"}},[t._v(" 수량 ")]),a("th",{staticClass:"text-left indigo--text",staticStyle:{"font-size":"15px"}},[t._v(" 날짜 ")])])]),a("tbody",t._l(t.items,(function(e){return a("tr",{key:e.name},[a("td",[t._v(t._s(e.userName))]),a("td",[t._v(t._s(e.orderName))]),a("td",{staticClass:"primary--text"},[t._v(t._s(e.orderStatus))]),a("td",{staticClass:"red--text"},[t._v(t._s(e.orderCount+"개"))]),a("td",[t._v(t._s(""+e.orderDate.slice(0,10)))]),a("v-container",{staticClass:"pa-1"},[t.isAdmin||e.userEmail==t.$store.state.name?a("v-btn",{staticClass:"mt-1",attrs:{color:"primary"},on:{click:function(a){return t.deleteOrder(e.orderId)}}},[t._v(" 취소 ")]):t._e(),t.isAdmin?a("v-btn",{staticClass:"mt-1",attrs:{color:"primary"},on:{click:function(a){return t.cancelOrder(e.orderId)}}},[t._v(" 대기 ")]):t._e(),t.isAdmin?a("v-btn",{staticClass:"mt-1",attrs:{color:"primary"},on:{click:function(a){return t.finishOrder(e.orderId)}}},[t._v(" 완료 ")]):t._e()],1)],1)})),0)]},proxy:!0}])})],1)},n=[],s=a("1da1"),i=(a("96cf"),a("b0c0"),a("29fd")),c=a("d8ad"),o={data:function(){return{items:[],oneOrderId:0}},computed:{isAdmin:function(){return"admin@naver.com"==this.$store.state.name},isUser:function(t){return this.$store.state.name==t}},mounted:function(){var t=this;return Object(s["a"])(regeneratorRuntime.mark((function e(){var a,r;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,Object(i["d"])();case 2:a=e.sent,r=a.data,t.items=r,console.log(t.items);case 6:case"end":return e.stop()}}),e)})))()},methods:{cancelOrder:function(t){var e=this;return Object(s["a"])(regeneratorRuntime.mark((function a(){var r,n;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:return a.next=2,Object(i["a"])(t);case 2:return a.next=4,Object(i["d"])();case 4:r=a.sent,n=r.data,e.items=n,console.log(n);case 8:case"end":return a.stop()}}),a)})))()},deleteOrder:function(t){var e=this;return Object(s["a"])(regeneratorRuntime.mark((function a(){var r,n,s;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:if(r=confirm("정말로 취소 하시겠습니까?"),1!=r){a.next=12;break}return a.next=4,Object(i["c"])(t);case 4:return a.next=6,Object(i["d"])();case 6:n=a.sent,s=n.data,e.items=s,c["a"].$emit("set:quantity"),a.next=13;break;case 12:0==r&&console.log("취소");case 13:case"end":return a.stop()}}),a)})))()},finishOrder:function(t){var e=this;return Object(s["a"])(regeneratorRuntime.mark((function a(){var r,n;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:return a.next=2,Object(i["b"])(t);case 2:return a.next=4,Object(i["d"])();case 4:r=a.sent,n=r.data,e.items=n;case 7:case"end":return a.stop()}}),a)})))()}}},u=o,l=a("2877"),d=a("6544"),f=a.n(d),v=a("8336"),m=a("a523"),h=a("1f4f"),p=Object(l["a"])(u,r,n,!1,null,null,null);e["default"]=p.exports;f()(p,{VBtn:v["a"],VContainer:m["a"],VSimpleTable:h["a"]})},f93e:function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-content",{staticClass:"pa-3 "},[a("v-card",{staticClass:"grey lighten-4 pa-5"},[a("VaccineRegistList",{staticClass:"pa-3"})],1),a("v-form",{ref:"form",staticClass:"mt-5",attrs:{"lazy-validation":""},model:{value:t.valid,callback:function(e){t.valid=e},expression:"valid"}},[a("v-select",{attrs:{items:t.select.userList,"item-text":"name","item-value":"id",label:"회원조회",required:""},model:{value:t.userId,callback:function(e){t.userId=e},expression:"userId"}}),a("v-select",{attrs:{items:t.select.vaccineList,"item-text":"name","item-value":"id",rules:[function(t){return!!t||"Item is required"}],label:"백신조회",required:""},model:{value:t.vaccineId,callback:function(e){t.vaccineId=e},expression:"vaccineId"}}),a("v-text-field",{attrs:{label:"수량",required:""},model:{value:t.count,callback:function(e){t.count=e},expression:"count"}}),a("v-btn",{staticClass:"mr-4",attrs:{disabled:!t.valid,color:"success"},on:{click:t.submitForm}},[t._v(" 신청하기 ")])],1)],1)},n=[],s=a("1da1"),i=(a("159b"),a("b0c0"),a("96cf"),a("29fd")),c=a("16d3"),o=a("d8ad"),u={mounted:function(){var t=this;return Object(s["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:t.fillData();case 1:case"end":return e.stop()}}),e)})))()},data:function(){return{userId:"",vaccineId:"",count:"",valid:!0,nameRules:[function(t){return!!t||"Name is required"},function(t){return t&&t.length<=10||"Name must be less than 10 characters"}],email:"",emailRules:[function(t){return!!t||"E-mail is required"},function(t){return/.+@.+\..+/.test(t)||"E-mail must be valid"}],select:{userList:[],vaccineList:[],count:"",checkbox:!1,password:""}}},methods:{submitForm:function(){var t=this;return Object(s["a"])(regeneratorRuntime.mark((function e(){var a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return a={userId:t.userId,itemId:t.vaccineId,count:t.count},console.log(a),e.prev=2,e.next=5,Object(i["i"])(a);case 5:alert("등록완료"),t.initForm(),o["a"].$emit("refresh"),e.next=13;break;case 10:e.prev=10,e.t0=e["catch"](2),alert("올바른 수량 입력하세요");case 13:case"end":return e.stop()}}),e,null,[[2,10]])})))()},fillData:function(){var t=this;return Object(s["a"])(regeneratorRuntime.mark((function e(){var a,r,n,s;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,Object(i["f"])();case 2:return a=e.sent,e.next=5,Object(i["g"])();case 5:r=e.sent,n=r.data,s=a.data,n.data.forEach((function(e){t.$store.state.name==e.email&&t.select.userList.push(e)})),s.forEach((function(e){t.select.vaccineList.push(e)}));case 10:case"end":return e.stop()}}),e)})))()},validate:function(){this.$refs.form.validate()},reset:function(){this.$refs.form.reset(),this.resetValidation()},initForm:function(){this.userId="",this.itemId="",this.count=1}},components:{VaccineRegistList:c["default"]}},l=u,d=a("2877"),f=a("6544"),v=a.n(f),m=a("8336"),h=a("b0af"),p=a("a75b"),b=a("4bd4"),g=a("b974"),x=a("8654"),_=Object(d["a"])(l,r,n,!1,null,null,null);e["default"]=_.exports;v()(_,{VBtn:m["a"],VCard:h["a"],VContent:p["a"],VForm:b["a"],VSelect:g["a"],VTextField:x["a"]})}}]);
//# sourceMappingURL=chunk-b80d29a2.625f55e5.js.map