(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-779e"],{"215I":function(e,t,a){"use strict";var o=a("5tTp");a.n(o).a},"5tTp":function(e,t,a){},FyfS:function(e,t,a){e.exports={default:a("Rp86"),__esModule:!0}},"L34+":function(e,t){Array.prototype.remove=function(e){var t=this.indexOf(e);t>-1&&this.splice(t,1)}},Rp86:function(e,t,a){a("bBy9"),a("FlQf"),e.exports=a("fXsU")},YsRc:function(e,t,a){"use strict";a.r(t);var o=a("gDS+"),n=a.n(o),i=a("FyfS"),r=a.n(i);function l(e,t,a){localStorage.setItem(e,t)}function s(e){return localStorage.getItem(e)}function c(e){localStorage.removeItem(e)}a("D66Q");var m=a("t3Un");function p(e,t){return console.log(URL),Object(m.a)({url:t,method:"post",data:e}).catch(function(e){console.log(e)})}a("L34+");var d={data:function(){var e=this;return{transferIndex:null,contextMenuData:{menuName:"demo",axis:{x:null,y:null},menulists:[{fnHandler:"updateDate",icoName:"el-icon-edit",btnName:"修改"},{fnHandler:"deleteDate",icoName:"el-icon-delete",btnName:"删除"}]},xmlPath:"",facadeImplPath:"",myOptionItem:null,myOptionItemType:null,dialogTableXmlVisible:!1,dialogTableImplVisible:!1,dialogTableVisible:!1,defaultProps:{children:"children",label:"label",value:"value",id:"id"},directory:[{id:"1",label:"/",value:"/",children:[]}],activeNames:["1","2","3","4","5","6","7","8"],tip:"操作步骤：1.添加连接，指定对应的数据源 <br/> 2.选择对应连接，加载该数据源下的所有表记录 <br/> 3.双击表结构，点击代码生成",rightClickMenuDel:[{text:"编辑",icon:"iconfont icon-bofang"},{text:"删除",icon:"iconfont icon-bofang"}],connections:[],connectionsNew:[],optionsEncoding:[{value:"1",label:"utf-8"},{value:"2",label:"gb2312"},{value:"3",label:"gbk"}],delConnection:null,fileName:"",options:[{value:"1",label:"MySQL"},{value:"2",label:"MySQL_v8"},{value:"3",label:"Oracle"},{value:"4",label:"IBM DB2"},{value:"5",label:"PostgreSQL"},{value:"6",label:"SQL_Server"},{value:"7",label:"Sqllite"}],value:"",dialogEditVisible:!1,saveForm:{index:-1,connectionName:"",databaseType:"",hostName:"",port:"",userName:"",password:"",database:"",encoding:""},updForm:{index:-1,connectionName:"",databaseType:"",hostName:"",port:"",userName:"",password:"",database:"",encoding:""},connectionForm:{index:-1,connectionName:"",databaseType:"",hostName:"",port:"",userName:"",password:"",database:"",encoding:""},form:{isPaging:!0,tableName:"t_xxx",encoding:"",author:"minivision",controller:{name:"XxxController",packageName:"com.minivision.sms.agw.gateway.controller.xxx",path:"",generate:!0},service:{name:"XxxService",packageName:"com.minivision.sms.agw.gateway.service.xxx",path:"",generate:!0},dto:{name:"XxxDTO",packageName:"com.minivision.sms.api.domain.dto.xxx",path:"",generate:!0},entity:{id:"XxxId",name:"Xxx",packageName:"com.minivision.sms.main.domain.entity.xxx",path:"",generate:!0},mapper:{name:"XxxMapper",packageName:"com.minivision.sms.main.domain.mapper.xxx",path:"",generate:!0},facade:{name:"XxxFacade",packageName:"com.minivision.sms.api.domain.facade.xxx",path:"",generate:!0},mainService:{name:"XxxService",packageName:"com.minivision.sms.main.domain.service.xxx",path:"",generate:!0},name:"",region:"",date1:"",date2:"",delivery:!1,type:[],resource:"",desc:""},sortType:"",dialogVisible:!1,aaa:!1,nowConnectionKey:"",filePath:"",rules:{controllerPath:[{validator:function(t,a,o){e.form.controller.generate&&""===e.form.controller.path?o(new Error("请选择网关层的Controller类生成路径")):o()},trigger:"change"}],servicePath:[{validator:function(t,a,o){e.form.service.generate&&""===e.form.service.path?o(new Error("请选择网关层的Service类生成路径")):o()},trigger:"change"}],dtoPath:[{validator:function(t,a,o){e.form.dto.generate&&""===e.form.dto.path?o(new Error("请选择DTO类的生成路径")):o()},trigger:"change"}],facadePath:[{validator:function(t,a,o){e.form.facade.generate&&""===e.form.facade.path?o(new Error("请选择Facade类的生成路径")):o()},trigger:"change"}],facadeImplPath:[{validator:function(t,a,o){e.form.facade.generate&&""===e.facadeImplPath?o(new Error("请选择Facade实现类的生成路径")):o()},trigger:"change"}],mainServicePath:[{validator:function(t,a,o){e.form.mainService.generate&&""===e.form.mainService.path?o(new Error("请选择Main层的Service类生成路径")):o()},trigger:"change"}],mapperFileName:[{validator:function(t,a,o){e.form.mapper.generate&&""===e.form.mapper.name?o(new Error("Xml文件名称不能为空")):o()},trigger:"change"}],mapperPath:[{validator:function(t,a,o){e.form.mapper.generate&&""===e.form.mapper.path?o(new Error("请选择Mapper类的生成路径")):o()},trigger:"change"}],mapperXmlPath:[{validator:function(t,a,o){e.form.mapper.generate&&""===e.form.mapper.path?o(new Error("请选择Xml文件的生成路径")):o()},trigger:"change"}],entityPath:[{validator:function(t,a,o){e.form.entity.generate&&""===e.form.entity.path?o(new Error("请选择Entity类的生成路径")):o()},trigger:"change"}],authorName:[{validator:function(t,a,o){""===e.form.author?o(new Error("请输入作者名称")):o()},trigger:"change"}],connectionName:[{required:!0,message:"请输入连接名称",trigger:"blur"}],databaseType:[{required:!0,message:"请选择数据类型",trigger:"blur"}],hostName:[{required:!0,message:"请输入主机名/IP地址",trigger:"blur"}],port:[{required:!0,message:"请输入端口号",trigger:"blur"}],userName:[{required:!0,message:"请输入用户名",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}],database:[{required:!0,message:"请输入Schema/数据库",trigger:"blur"}]}}},methods:{updateCheckConnection:function(e){this.nowConnectionKey=e;var t=s(e),a=JSON.parse(t);this.updForm={index:-1,connectionName:a.connectionName,databaseType:a.databaseType,hostName:a.hostName,port:a.port,userName:a.userName,password:a.password,database:a.database,encoding:a.encoding},this.dialogEditVisible=!0},deleteCheckConnection:function(e){var t=JSON.parse(s("connectionsIndex"));c(e);var a=!0,o=!1,i=void 0;try{for(var m,p=r()(t);!(a=(m=p.next()).done);a=!0){var d=m.value;if(d.key===e){for(var f=0;f<t.length;f++)d.index<t[f].index&&(t[f].index=t[f].index-1);t.remove(d),l("connectionsIndex",n()(t));break}}}catch(e){o=!0,i=e}finally{try{!a&&p.return&&p.return()}finally{if(o)throw i}}this.loadConnection()},showMenu:function(e){document.getElementById("myContext").getElementsByClassName("vue-contextmenu-listWrapper");this.transferIndex=e,event.preventDefault();var t=event.clientX,a=event.clientY;this.contextMenuData.axis={x:t,y:a}},handleTreeClickByXml:function(e){this.dialogTableXmlVisible=!1,this.xmlPath=e.value+"\\src\\main\\resources\\"},handleTreeClickByImpl:function(e){this.dialogTableImplVisible=!1,""===this.form.entity.path&&(this.form.entity.path=e.value+"\\src\\main\\java\\"),""===this.form.mapper.path&&(this.form.mapper.path=e.value+"\\src\\main\\java\\"),""===this.form.mainService.path&&(this.form.mainService.path=e.value+"\\src\\main\\java\\"),this.xmlPath=e.value+"\\src\\main\\resources\\",this.facadeImplPath=e.value+"\\src\\main\\java\\"},handleTreeClick:function(e){this.dialogTableVisible=!1,1===this.myOptionItemType&&""===this.form.service.path&&(this.form.service.path=e.value+"\\src\\main\\java\\"),2===this.myOptionItemType&&""===this.form.controller.path&&(this.form.controller.path=e.value+"\\src\\main\\java\\"),4===this.myOptionItemType&&""===this.form.dto.path&&(this.form.dto.path=e.value+"\\src\\main\\java\\"),5===this.myOptionItemType&&""===this.form.facade.path&&(this.form.facade.path=e.value+"\\src\\main\\java\\"),(3===this.myOptionItemType&&""===this.form.entity.path||3===this.myOptionItemType&&""===this.form.mapper.path)&&(""===this.form.mapper.path&&(this.form.mapper.path=e.value+"\\src\\main\\java\\"),""===this.facadeImplPath&&(this.facadeImplPath=e.value+"\\src\\main\\java\\"),""===this.form.entity.path&&(this.form.entity.path=e.value+"\\src\\main\\java\\"),this.xmlPath=e.value+"\\src\\main\\resources\\"),(6===this.myOptionItemType&&""===this.form.mainService.path||6===this.myOptionItemType&&""===this.form.entity.path||6===this.myOptionItemType&&""!==this.xmlPath)&&(""===this.form.mainService.path&&(this.form.mainService.path=e.value+"\\src\\main\\java\\"),""===this.facadeImplPath&&(this.facadeImplPath=e.value+"\\src\\main\\java\\"),""===this.form.entity.path&&(this.form.entity.path=e.value+"\\src\\main\\java\\"),this.xmlPath=e.value+"\\src\\main\\resources\\"),(8===this.myOptionItemType&&""===this.form.mapper.path||8===this.myOptionItemType&&""===this.form.mainService.path)&&(""===this.form.mapper.path&&(this.form.mapper.path=e.value+"\\src\\main\\java\\"),""===this.facadeImplPath&&(this.facadeImplPath=e.value+"\\src\\main\\java\\"),""===this.form.mainService.path&&(this.form.mainService.path=e.value+"\\src\\main\\java\\"),this.xmlPath=e.value+"\\src\\main\\resources\\"),this.myOptionItem.path=e.value+"\\src\\main\\java\\"},loadNode:function(e,t){if(0===e.level){p(n()({id:"1",directory:"/"}),"/code/getDirectory").then(function(e){return t(e.data.data)})}else{var a={id:e.data.id,directory:e.data.value};p(n()(a),"/code/getDirectory").then(function(e){return 1===e.data.code&&e?t(e.data.data):t([])})}},getObjectURL:function(e){var t=null;return void 0!=window.createObjcectURL?t=window.createOjcectURL(e):void 0!=window.URL?t=window.URL.createObjectURL(e):void 0!=window.webkitURL&&(t=window.webkitURL.createObjectURL(e)),t},browseFolder:function(e){var t=this.$refs.myFile.files[0],a=this.getObjectURL(t);window.open(a)},handleChange:function(e){},updateConnection:function(e){var t=s(this.nowConnectionKey),a=JSON.parse(t);a.connectionName=e.connectionName,a.databaseType=e.databaseType,a.hostName=e.hostName,a.port=e.port,a.userName=e.userName,a.password=e.password,a.database=e.database,a.encoding=e.encoding;var o=JSON.parse(s("connectionsIndex"));c(this.nowConnectionKey);var i=!0,m=!1,p=void 0;try{for(var d,f=r()(o);!(i=(d=f.next()).done);i=!0){var u=d.value;if(u.key===this.nowConnectionKey){o.remove(u),0===u.index?a.index=0:a.index=u.index,l("connectionsIndex",n()(o));break}}}catch(e){m=!0,p=e}finally{try{!i&&f.return&&f.return()}finally{if(m)throw p}}l(a.connectionName,n()(a));var v=JSON.parse(s("connectionsIndex"));v.push({key:a.connectionName,index:a.index,tables:[]}),l("connectionsIndex",n()(v)),this.dialogEditVisible=!1,this.loadConnection()},popMenu:function(e){if(e.preventDefault(),2===e.button){var t=e.layerX,a=e.layerY;this.mousePosition=[t,a]}else 0===e.button&&(this.mousePosition=["close"])},list_item_click:function(e){switch(e){case 0:alert("第一项被点击");break;case 1:alert("第二项被点击")}},rightShow:function(){alert("right-click")},loadDatabase:function(e){alert(e)},openDialogNewConnection:function(){this.saveForm={index:-1,connectionName:"新建连接1",databaseType:"MySQL",hostName:"127.0.0.1",port:3306,userName:"root",password:"",database:"",encoding:"UTF-8"},this.dialogVisible=!0},closeDialogUpdateConnection:function(e){this.dialogEditVisible=!1,this.$refs[e].resetFields(),this.loadConnection()},closeDialogNewConnection:function(e){this.dialogVisible=!1,this.$refs[e].resetFields(),this.loadConnection()},generateCode:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return t.$message.error("请完善参数后再继续操作按钮！"),!1;var a={tableName:t.form.tableName,encoding:"utf-8",author:t.form.author,xmlPath:t.xmlPath,facadeImplPath:t.facadeImplPath,mapperName:t.form.mapper.name,primaryKey:t.form.entity.id,dataSource:t.connectionForm,controller:{name:t.form.controller.name,packageName:t.form.controller.packageName,path:t.form.controller.path,isGenerate:t.form.controller.generate},service:{name:t.form.service.name,packageName:t.form.service.packageName,path:t.form.service.path,isGenerate:t.form.service.generate},dto:{name:t.form.dto.name,packageName:t.form.dto.packageName,path:t.form.dto.path,isGenerate:t.form.dto.generate},entity:{name:t.form.entity.name,packageName:t.form.entity.packageName,path:t.form.entity.path,isGenerate:t.form.entity.generate},mapper:{name:t.form.mapper.name,packageName:t.form.mapper.packageName,path:t.form.mapper.path,isGenerate:t.form.mapper.generate},facade:{name:t.form.facade.name,packageName:t.form.facade.packageName,path:t.form.facade.path,isGenerate:t.form.facade.generate},mainService:{name:t.form.mainService.name,packageName:t.form.mainService.packageName,path:t.form.mainService.path,isGenerate:t.form.mainService.generate}};p(n()(a),"/code/generate").then(function(e){1===e.data.code?(t.$message.success(e.data.msg[0].msgText),t.$alert("网关层Controller类生成路径："+t.form.controller.path+"</br>网关层Service类生成路径："+t.form.service.path+"</br>Facade接口类生成路径："+t.form.facade.path+"</br>Facade实现类生成路径："+t.facadeImplPath+"</br>DTO类生成路径："+t.form.dto.path+"</br>Main层Service类生成路径："+t.form.mainService.path+"</br>Mapper接口类生成路径："+t.form.mapper.path+"</br>Xml文件生成路径："+t.xmlPath+"</br>Entity类生成路径："+t.form.entity.path+"</br>","生成文件的路径：",{confirmButtonText:"确定",dangerouslyUseHTMLString:!0})):t.$message.error(e.data.msg[0].msgText)})})},handleKey:function(e){if(null==s(e)){if(null!=s("connectionsIndex")){var t=JSON.parse(s("connectionsIndex")),a=t.length;return t.push({key:e,index:a,tables:[]}),l("connectionsIndex",n()(t)),a}l("connectionsIndex",n()([{key:e,index:0}]))}},saveNewConnection:function(e){var t=this;this.$refs[e].validate(function(a){if(!a)return!1;var o=t.saveForm.connectionName,i=t.handleKey(o);null==s(o)?(t.saveForm.index=i,l(o,n()(t.saveForm)),t.dialogVisible=!1,t.$refs[e].resetFields(),t.loadConnection()):t.$message({message:"该名称已经存在",type:"warning"})})},handleOpen:function(e,t){},handleSelect:function(e,t){var a=this,o=this;p(s(e),"/database/connect").then(function(t){if(1!=t.data.code)""!=t.data.msg[0].msgText?a.$message.error(t.data.msg[0].msgText):a.$message.error("数据库连接异常,请检查配置后再次点击连接");else{for(var i=0;i<o.connections.length;i++)o.connections[i].key===e&&(o.connections[i].tables=t.data.data);l("connectionsIndex",n()(o.connections))}})},handleClick:function(e,t){var a=this,o=this;p({tableName:e},"/code/getPackageAndClass").then(function(e){if(0===e.data.code)a.$message.error(e.data.msg[0].msgText);else{var n=e.data.data;o.form.controller=n.controller,o.form.mapper=n.mapper,o.form.service=n.service,o.form.dto=n.dto,o.form.entity=n.entity,o.form.mainService=n.mainService,o.form.facade=n.facade,o.form.tableName=n.tableName,a.connectionForm=JSON.parse(s(t.key))}})},onSubmit:function(){},handleClose:function(e){this.loadConnection(),e()},loadConnection:function(){var e=JSON.parse(s("connectionsIndex"));if(null!==e&&0!==e.length)for(var t=0;t<e.length-1;t++)for(var a=0;a<e.length-1-t;a++)if(e[a].index>e[a+1].index){var o=e[a];e[a]=e[a+1],e[a+1]=o}this.connections=e}},created:function(){this.connectionForm={index:-1,connectionName:"sms_cloud_baseline",databaseType:"MySQL",hostName:"192.168.109.24",port:3306,userName:"root",password:"xskj2017",database:"sms_prod",encoding:"UTF-8"},this.saveForm={index:-1,connectionName:"",databaseType:"",hostName:"",port:-1,userName:"",password:"",database:"",encoding:""},this.loadConnection()}},f=(a("215I"),a("KHd+")),u=Object(f.a)(d,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{staticStyle:{"min-height":"900px",border:"1px solid #eee"}},[a("el-dialog",{attrs:{title:"选择路径",visible:e.dialogTableVisible},on:{"update:visible":function(t){e.dialogTableVisible=t}}},[a("el-tree",{attrs:{props:e.defaultProps,load:e.loadNode,lazy:""},on:{"node-click":e.handleTreeClick}})],1),e._v(" "),a("el-dialog",{attrs:{title:"选择路径",visible:e.dialogTableImplVisible},on:{"update:visible":function(t){e.dialogTableImplVisible=t}}},[a("el-tree",{attrs:{props:e.defaultProps,load:e.loadNode,lazy:""},on:{"node-click":e.handleTreeClickByImpl}})],1),e._v(" "),a("el-dialog",{attrs:{visible:e.dialogVisible,"before-close":e.handleClose,title:"新建数据库连接",width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-form",{ref:"saveForm",attrs:{model:e.saveForm,rules:e.rules,"label-width":"180px"}},[a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"保存名称",prop:"connectionName"}},[a("el-input",{attrs:{size:"mini"},model:{value:e.saveForm.connectionName,callback:function(t){e.$set(e.saveForm,"connectionName",t)},expression:"saveForm.connectionName"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"数据库类型",prop:"databaseType"}},[a("el-select",{attrs:{placeholder:"请选择",size:"mini"},model:{value:e.saveForm.databaseType,callback:function(t){e.$set(e.saveForm,"databaseType",t)},expression:"saveForm.databaseType"}},e._l(e.options,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.label}})}))],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"主机名/IP地址",prop:"hostName"}},[a("el-input",{attrs:{name:"hostName",size:"mini"},model:{value:e.saveForm.hostName,callback:function(t){e.$set(e.saveForm,"hostName",t)},expression:"saveForm.hostName"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:11}},[a("el-form-item",{attrs:{label:"端口号",prop:"port"}},[a("el-input",{attrs:{name:"port",size:"mini"},model:{value:e.saveForm.port,callback:function(t){e.$set(e.saveForm,"port",t)},expression:"saveForm.port"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:17}},[a("el-form-item",{attrs:{label:"用户名",prop:"userName"}},[a("el-input",{attrs:{name:"userName",size:"mini"},model:{value:e.saveForm.userName,callback:function(t){e.$set(e.saveForm,"userName",t)},expression:"saveForm.userName"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:17}},[a("el-form-item",{attrs:{label:"密码",prop:"password"}},[a("el-input",{attrs:{name:"password","auto-complete":"new-password",type:"text",size:"mini"},model:{value:e.saveForm.password,callback:function(t){e.$set(e.saveForm,"password",t)},expression:"saveForm.password"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:17}},[a("el-form-item",{attrs:{label:"Schema/数据库",prop:"database"}},[a("el-input",{attrs:{name:"database",size:"mini"},model:{value:e.saveForm.database,callback:function(t){e.$set(e.saveForm,"database",t)},expression:"saveForm.database"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:17}},[a("el-form-item",{attrs:{label:"编码",prop:"encoding"}},[a("el-select",{attrs:{name:"encoding",placeholder:"请选择",size:"mini"},model:{value:e.saveForm.encoding,callback:function(t){e.$set(e.saveForm,"encoding",t)},expression:"saveForm.encoding"}},e._l(e.optionsEncoding,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.label}})}))],1)],1)],1)],1),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.closeDialogNewConnection("saveForm")}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.saveNewConnection("saveForm")}}},[e._v("确 定")])],1)],1),e._v(" "),a("el-dialog",{attrs:{visible:e.dialogEditVisible,"before-close":e.handleClose,title:"修改数据库连接",width:"30%"},on:{"update:visible":function(t){e.dialogEditVisible=t}}},[a("el-form",{ref:"updForm",attrs:{model:e.updForm,rules:e.rules,"label-width":"180px"}},[a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"保存名称",prop:"connectionName"}},[a("el-input",{attrs:{size:"mini"},model:{value:e.updForm.connectionName,callback:function(t){e.$set(e.updForm,"connectionName",t)},expression:"updForm.connectionName"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"数据库类型",prop:"databaseType"}},[a("el-select",{attrs:{placeholder:"请选择",size:"mini"},model:{value:e.updForm.databaseType,callback:function(t){e.$set(e.updForm,"databaseType",t)},expression:"updForm.databaseType"}},e._l(e.options,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.label}})}))],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:20}},[a("el-form-item",{attrs:{label:"主机名/IP地址",prop:"hostName"}},[a("el-input",{attrs:{name:"hostName",size:"mini"},model:{value:e.updForm.hostName,callback:function(t){e.$set(e.updForm,"hostName",t)},expression:"updForm.hostName"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:11}},[a("el-form-item",{attrs:{label:"端口号",prop:"port"}},[a("el-input",{attrs:{name:"port",size:"mini"},model:{value:e.updForm.port,callback:function(t){e.$set(e.updForm,"port",t)},expression:"updForm.port"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:17}},[a("el-form-item",{attrs:{label:"用户名",prop:"userName"}},[a("el-input",{attrs:{name:"userName",size:"mini"},model:{value:e.updForm.userName,callback:function(t){e.$set(e.updForm,"userName",t)},expression:"updForm.userName"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:17}},[a("el-form-item",{attrs:{label:"密码",prop:"password"}},[a("el-input",{attrs:{name:"password",type:"text","auto-complete":"new-password",size:"mini"},model:{value:e.updForm.password,callback:function(t){e.$set(e.updForm,"password",t)},expression:"updForm.password"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:17}},[a("el-form-item",{attrs:{label:"Schema/数据库",prop:"database"}},[a("el-input",{attrs:{name:"database",size:"mini"},model:{value:e.updForm.database,callback:function(t){e.$set(e.updForm,"database",t)},expression:"updForm.database"}})],1)],1)],1),e._v(" "),a("el-row",{attrs:{type:"flex",justify:"start"}},[a("el-col",{attrs:{span:17}},[a("el-form-item",{attrs:{label:"编码",prop:"encoding"}},[a("el-select",{attrs:{name:"encoding",placeholder:"请选择",size:"mini"},model:{value:e.updForm.encoding,callback:function(t){e.$set(e.updForm,"encoding",t)},expression:"updForm.encoding"}},e._l(e.optionsEncoding,function(e){return a("el-option",{key:e.value,attrs:{label:e.label,value:e.label}})}))],1)],1)],1)],1),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.closeDialogUpdateConnection("updForm")}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.updateConnection(e.updForm)}}},[e._v("确 定")])],1)],1),e._v(" "),a("el-aside",{staticStyle:{height:"1500px",width:"430px"},attrs:{"aria-expanded":"true"}},[a("el-button",{attrs:{type:"primary",icon:"el-icon-menu",size:"medium"},on:{click:e.openDialogNewConnection}},[e._v("添加连接")]),e._v(" "),a("el-button",{attrs:{type:"primary",icon:"el-icon-tickets",size:"medium"}},[e._v("配置")]),e._v(" "),a("el-tooltip",{staticClass:"item",staticStyle:{"vertical-align":"middle",width:"1em",height:"1em","margin-left":"6em","margin-top":"1em","white-space":"pre-wrap"},attrs:{effect:"dark",placement:"top-start"}},[a("div",{attrs:{slot:"content"},slot:"content"},[e._v(" 操作步骤："),a("br"),e._v(" 1.添加连接，指定对应的数据源 "),a("br"),e._v(" 2.选择对应连接，加载该数据源下的所有表记录 "),a("br"),e._v(" 3.双击表结构，点击代码生成")]),e._v(" "),a("svg-icon",{attrs:{"icon-class":"tip"}})],1),e._v(" "),a("el-row",{staticClass:"tac"},[a("el-col",{attrs:{span:25}},[a("el-menu",{staticClass:"el-menu-vertical-demo",attrs:{"default-active":"2"},on:{open:e.handleSelect},nativeOn:{contextmenu:function(t){t.preventDefault(),e.$easycm(t,e.$root)}}},e._l(e.connections,function(t){return a("el-submenu",{key:t.key,staticStyle:{width:"400px"},attrs:{index:t.key}},[a("template",{slot:"title"},[a("div",{staticStyle:{width:"390px",height:"56px"},attrs:{id:"myContext"},on:{contextmenu:function(a){e.showMenu(t.index)}}},[a("i",{staticClass:"el-icon-setting"}),e._v(" "),a("span",[e._v(e._s(t.key))]),e._v(" "),a("vue-context-menu",{staticStyle:{width:"150px",height:"86px"},attrs:{contextMenuData:e.contextMenuData,transferIndex:e.transferIndex},on:{updateDate:function(a){e.updateCheckConnection(t.key)},deleteDate:function(a){e.deleteCheckConnection(t.key)}}})],1)]),e._v(" "),e._l(t.tables,function(o){return a("el-menu-item",{attrs:{index:o},on:{click:function(a){e.handleClick(o,t)}}},[a("i",{staticClass:"el-icon-rank"}),e._v(" "),a("span",{staticStyle:{width:"400px"},attrs:{slot:"title"},slot:"title"},[e._v(e._s(o))])])})],2)}))],1)],1)],1),e._v(" "),a("el-container",[a("el-form",{ref:"form",attrs:{rules:e.rules,model:e.form,"label-width":"180px"}},[a("el-collapse",{staticClass:"collapse-title",model:{value:e.activeNames,callback:function(t){e.activeNames=t},expression:"activeNames"}},[a("el-collapse-item",{attrs:{title:"Controller",name:"1",accordion:""}},[a("el-row",[a("el-form-item",{attrs:{label:"Controller类包名"}},[a("el-col",{attrs:{span:12}},[a("el-input",{model:{value:e.form.controller.packageName,callback:function(t){e.$set(e.form.controller,"packageName",t)},expression:"form.controller.packageName"}})],1),e._v(" "),a("el-switch",{staticStyle:{"margin-left":"100px"},attrs:{"inactive-text":"是否生成","active-color":"#13ce66","inactive-color":"#ff4949",span:12},model:{value:e.form.controller.generate,callback:function(t){e.$set(e.form.controller,"generate",t)},expression:"form.controller.generate"}})],1)],1),e._v(" "),a("el-form-item",{staticStyle:{"margin-top":"10px"},attrs:{prop:"controllerPath",label:"路径"}},[a("el-col",{attrs:{span:12}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.controller.path,callback:function(t){e.$set(e.form.controller,"path",t)},expression:"form.controller.path"}})],1),e._v(" "),a("el-button",{staticStyle:{"margin-left":"100px"},attrs:{type:"primary",plain:""},on:{click:function(t){e.dialogTableVisible=!0,e.myOptionItem=e.form.controller,e.myOptionItemType=1}}},[e._v("\n              选择路径\n            ")])],1)],1)],1),e._v(" "),a("el-collapse",{staticClass:"collapse-title",model:{value:e.activeNames,callback:function(t){e.activeNames=t},expression:"activeNames"}},[a("el-collapse-item",{attrs:{title:"Service",name:"2",accordion:""}},[a("el-row",[a("el-form-item",{attrs:{label:"Service类包名"}},[a("el-col",{attrs:{span:12}},[a("el-input",{model:{value:e.form.service.packageName,callback:function(t){e.$set(e.form.service,"packageName",t)},expression:"form.service.packageName"}})],1),e._v(" "),a("el-switch",{staticStyle:{"margin-left":"100px"},attrs:{"inactive-text":"是否生成","active-color":"#13ce66","inactive-color":"#ff4949",span:12},model:{value:e.form.service.generate,callback:function(t){e.$set(e.form.service,"generate",t)},expression:"form.service.generate"}})],1)],1),e._v(" "),a("el-form-item",{staticStyle:{"margin-top":"10px"},attrs:{prop:"servicePath",label:"路径"}},[a("el-col",{attrs:{span:12}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.service.path,callback:function(t){e.$set(e.form.service,"path",t)},expression:"form.service.path"}})],1),e._v(" "),a("el-button",{staticStyle:{"margin-left":"100px"},attrs:{type:"primary",plain:""},on:{click:function(t){e.dialogTableVisible=!0,e.myOptionItem=e.form.service,e.myOptionItemType=2}}},[e._v("选择路径\n            ")])],1)],1)],1),e._v(" "),a("el-collapse",{staticClass:"collapse-title",model:{value:e.activeNames,callback:function(t){e.activeNames=t},expression:"activeNames"}},[a("el-collapse-item",{attrs:{title:"Facade",name:"4",accordion:""}},[a("el-row",[a("el-form-item",{staticStyle:{"margin-top":"10px"},attrs:{label:"Facade类包名"}},[a("el-col",{attrs:{span:12}},[a("el-input",{model:{value:e.form.facade.packageName,callback:function(t){e.$set(e.form.facade,"packageName",t)},expression:"form.facade.packageName"}})],1),e._v(" "),a("el-switch",{staticStyle:{"margin-left":"100px"},attrs:{"inactive-text":"是否生成","active-color":"#13ce66","inactive-color":"#ff4949",span:12},model:{value:e.form.facade.generate,callback:function(t){e.$set(e.form.facade,"generate",t)},expression:"form.facade.generate"}})],1)],1),e._v(" "),a("el-form-item",{staticStyle:{"margin-top":"10px"},attrs:{prop:"facadePath",label:"路径"}},[a("el-col",{attrs:{span:12}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.facade.path,callback:function(t){e.$set(e.form.facade,"path",t)},expression:"form.facade.path"}})],1),e._v(" "),a("el-button",{staticStyle:{"margin-left":"100px"},attrs:{type:"primary",plain:""},on:{click:function(t){e.dialogTableVisible=!0,e.myOptionItem=e.form.facade,e.myOptionItemType=4}}},[e._v("选择路径\n            ")])],1),e._v(" "),a("el-form-item",{staticStyle:{"margin-top":"20px"},attrs:{prop:"facadeImplPath",label:"Impl路径"}},[a("el-col",{attrs:{span:12}},[a("el-input",{attrs:{disabled:""},model:{value:e.facadeImplPath,callback:function(t){e.facadeImplPath=t},expression:"facadeImplPath"}})],1),e._v(" "),a("el-button",{staticStyle:{"margin-left":"100px"},attrs:{type:"primary",plain:""},on:{click:function(t){e.dialogTableImplVisible=!0,e.myOptionItemType=9}}},[e._v("选择路径\n            ")])],1)],1)],1),e._v(" "),a("el-collapse",{staticClass:"collapse-title",model:{value:e.activeNames,callback:function(t){e.activeNames=t},expression:"activeNames"}},[a("el-collapse-item",{attrs:{title:"Dto",name:"5",accordion:""}},[a("el-row",[a("el-form-item",{attrs:{label:"Dto类包名"}},[a("el-col",{attrs:{span:12}},[a("el-input",{model:{value:e.form.dto.packageName,callback:function(t){e.$set(e.form.dto,"packageName",t)},expression:"form.dto.packageName"}})],1),e._v(" "),a("el-switch",{staticStyle:{"margin-left":"100px"},attrs:{"inactive-text":"是否生成","active-color":"#13ce66","inactive-color":"#ff4949",span:12},model:{value:e.form.dto.generate,callback:function(t){e.$set(e.form.dto,"generate",t)},expression:"form.dto.generate"}})],1)],1),e._v(" "),a("el-form-item",{staticStyle:{"margin-top":"10px"},attrs:{prop:"dtoPath",label:"路径"}},[a("el-col",{attrs:{span:12}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.dto.path,callback:function(t){e.$set(e.form.dto,"path",t)},expression:"form.dto.path"}})],1),e._v(" "),a("el-button",{staticStyle:{"margin-left":"100px"},attrs:{type:"primary",plain:""},on:{click:function(t){e.dialogTableVisible=!0,e.myOptionItem=e.form.dto,e.myOptionItemType=5}}},[e._v("选择路径\n            ")])],1)],1)],1),e._v(" "),a("el-collapse",{staticClass:"collapse-title",model:{value:e.activeNames,callback:function(t){e.activeNames=t},expression:"activeNames"}},[a("el-collapse-item",{attrs:{title:"MainService",name:"3",accordion:""}},[a("el-row",[a("el-form-item",{attrs:{label:"MainService类包名"}},[a("el-col",{attrs:{span:12}},[a("el-input",{model:{value:e.form.mainService.packageName,callback:function(t){e.$set(e.form.mainService,"packageName",t)},expression:"form.mainService.packageName"}})],1),e._v(" "),a("el-switch",{staticStyle:{"margin-left":"100px"},attrs:{"inactive-text":"是否生成","active-color":"#13ce66","inactive-color":"#ff4949",span:12},model:{value:e.form.mainService.generate,callback:function(t){e.$set(e.form.mainService,"generate",t)},expression:"form.mainService.generate"}})],1)],1),e._v(" "),a("el-form-item",{staticStyle:{"margin-top":"10px"},attrs:{prop:"mainServicePath",label:"路径"}},[a("el-col",{attrs:{span:12}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.mainService.path,callback:function(t){e.$set(e.form.mainService,"path",t)},expression:"form.mainService.path"}})],1),e._v(" "),a("el-button",{staticStyle:{"margin-left":"100px"},attrs:{type:"primary",plain:""},on:{click:function(t){e.dialogTableVisible=!0,e.myOptionItem=e.form.mainService,e.myOptionItemType=3}}},[e._v("\n              选择路径\n            ")])],1)],1)],1),e._v(" "),a("el-collapse",{staticClass:"collapse-title",model:{value:e.activeNames,callback:function(t){e.activeNames=t},expression:"activeNames"}},[a("el-collapse-item",{attrs:{title:"Mapper",name:"6",accordion:""}},[a("el-row",[a("el-form-item",{attrs:{label:"Mapper类包名"}},[a("el-col",{attrs:{span:12}},[a("el-input",{model:{value:e.form.mapper.packageName,callback:function(t){e.$set(e.form.mapper,"packageName",t)},expression:"form.mapper.packageName"}})],1),e._v(" "),a("el-switch",{staticStyle:{"margin-left":"100px"},attrs:{"inactive-text":"是否生成","active-color":"#13ce66","inactive-color":"#ff4949",span:12},model:{value:e.form.mapper.generate,callback:function(t){e.$set(e.form.mapper,"generate",t)},expression:"form.mapper.generate"}})],1),e._v(" "),a("el-form-item",{staticStyle:{"margin-top":"20px"},attrs:{prop:"mapperFileName",label:"Xml文件名称（自定义）"}},[a("el-col",{attrs:{span:12}},[a("el-input",{model:{value:e.form.mapper.name,callback:function(t){e.$set(e.form.mapper,"name",t)},expression:"form.mapper.name"}})],1)],1)],1),e._v(" "),a("el-form-item",{staticStyle:{"margin-top":"10px"},attrs:{prop:"mapperPath",label:"路径"}},[a("el-col",{attrs:{span:12}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.mapper.path,callback:function(t){e.$set(e.form.mapper,"path",t)},expression:"form.mapper.path"}})],1),e._v(" "),a("el-button",{staticStyle:{"margin-left":"100px"},attrs:{type:"primary",plain:""},on:{click:function(t){e.dialogTableVisible=!0,e.myOptionItem=e.form.mapper,e.myOptionItemType=6}}},[e._v("选择路径\n            ")])],1),e._v(" "),a("el-form-item",{staticStyle:{"margin-top":"20px"},attrs:{prop:"mapperXmlPath",label:"Xml路径"}},[a("el-col",{attrs:{span:12}},[a("el-input",{attrs:{disabled:""},model:{value:e.xmlPath,callback:function(t){e.xmlPath=t},expression:"xmlPath"}})],1)],1)],1)],1),e._v(" "),a("el-collapse",{staticClass:"collapse-title",model:{value:e.activeNames,callback:function(t){e.activeNames=t},expression:"activeNames"}},[a("el-collapse-item",{attrs:{title:"Entity",name:"7",accordion:""}},[a("el-row",[a("el-form-item",{attrs:{label:"Entity类包名"}},[a("el-col",{attrs:{span:12}},[a("el-input",{model:{value:e.form.entity.packageName,callback:function(t){e.$set(e.form.entity,"packageName",t)},expression:"form.entity.packageName"}})],1),e._v(" "),a("el-switch",{staticStyle:{"margin-left":"100px"},attrs:{"inactive-text":"是否生成","active-color":"#13ce66","inactive-color":"#ff4949",span:12},model:{value:e.form.entity.generate,callback:function(t){e.$set(e.form.entity,"generate",t)},expression:"form.entity.generate"}})],1)],1),e._v(" "),a("el-form-item",{staticStyle:{"margin-top":"10px"},attrs:{prop:"entityPath",label:"路径"}},[a("el-col",{attrs:{span:12}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.entity.path,callback:function(t){e.$set(e.form.entity,"path",t)},expression:"form.entity.path"}})],1),e._v(" "),a("el-button",{staticStyle:{"margin-left":"100px"},attrs:{type:"primary",plain:""},on:{click:function(t){e.dialogTableVisible=!0,e.myOptionItem=e.form.entity,e.myOptionItemType=8}}},[e._v("选择路径\n            ")])],1)],1)],1),e._v(" "),a("el-collapse",{staticClass:"collapse-title",model:{value:e.activeNames,callback:function(t){e.activeNames=t},expression:"activeNames"}},[a("el-collapse-item",{attrs:{title:"其他",name:"8",accordion:""}},[a("el-row",[a("el-form-item",{attrs:{label:"表名"}},[a("el-col",{attrs:{span:6}},[a("el-input",{attrs:{disabled:!0},model:{value:e.form.tableName,callback:function(t){e.$set(e.form,"tableName",t)},expression:"form.tableName"}})],1)],1),e._v(" "),a("el-form-item",{staticStyle:{"margin-top":"20px"},attrs:{prop:"authorName",label:"作者名"}},[a("el-col",{attrs:{span:12}},[a("el-input",{model:{value:e.form.author,callback:function(t){e.$set(e.form,"author",t)},expression:"form.author"}})],1)],1),e._v(" "),a("el-form-item",[a("el-col",{attrs:{hidden:"hidden",span:12}},[a("el-switch",{attrs:{"active-text":"分页"},model:{value:e.form.isPaging,callback:function(t){e.$set(e.form,"isPaging",t)},expression:"form.isPaging"}}),e._v(" "),a("el-switch",{attrs:{"active-text":"生成注释"},model:{value:e.form.isPaging,callback:function(t){e.$set(e.form,"isPaging",t)},expression:"form.isPaging"}})],1)],1)],1)],1)],1),e._v(" "),a("el-button",{staticStyle:{"margin-left":"100px"},attrs:{type:"success"},on:{click:function(t){e.generateCode("form")}}},[e._v("代码生成")]),e._v(" "),a("el-button",{attrs:{type:"primary"}},[e._v("确定")])],1)],1)],1)},[],!1,null,null,null);u.options.__file="index.vue";t.default=u.exports},fXsU:function(e,t,a){var o=a("5K7Z"),n=a("fNZA");e.exports=a("WEpk").getIterator=function(e){var t=n(e);if("function"!=typeof t)throw TypeError(e+" is not iterable!");return o(t.call(e))}},"gDS+":function(e,t,a){e.exports={default:a("oh+g"),__esModule:!0}},"oh+g":function(e,t,a){var o=a("WEpk"),n=o.JSON||(o.JSON={stringify:JSON.stringify});e.exports=function(e){return n.stringify.apply(n,arguments)}}}]);