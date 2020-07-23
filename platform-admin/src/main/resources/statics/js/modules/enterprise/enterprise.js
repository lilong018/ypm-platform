$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'enterprise/enterprise/list',
        datatype: "json",
        colModel: [			
			// { label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '企业姓名', name: 'name', index: 'name', width: 80 },
			{ label: '企业账号', name: 'useraccount', index: 'userAccount', width: 80 },
			// { label: '统一社会信用代码-营业执照', name: 'uscc', index: 'uscc', width: 80 },
			// { label: '公司详细地址', name: 'address', index: 'address', width: 80 },
			// { label: '营业执照图片', name: 'businesslicenseurl', index: 'businessLicenseUrl', width: 80 },
			// { label: '开户许可证图片', name: 'accountopeninglicenseurl', index: 'accountOpeningLicenseUrl', width: 80 },
			// { label: '法人姓名', name: 'legalrepname', index: 'legalRepName', width: 80 },
			// { label: '法人身份证', name: 'legalrepid', index: 'legalRepId', width: 80 },
			// { label: '法人手机号码', name: 'legalrepphoneno', index: 'legalRepPhoneNo', width: 80 },
			// { label: '法人身份证正面照片', name: 'legalrepidpicfronturl', index: 'legalRepIdPicFrontUrl', width: 80 },
			// { label: '法人身份证背面照片', name: 'legalrepidpicbackurl', index: 'legalRepIdPicBackUrl', width: 80 },
			// { label: '省份', name: 'province', index: 'province', width: 80 },
			// { label: '市', name: 'city', index: 'city', width: 80 },
			// { label: '营业执照到期时间', name: 'businessexpirationdate', index: 'businessExpirationDate', width: 80 },
			// { label: '法人身份证到期时间', name: 'idcardexpirationdate', index: 'idcardExpirationDate', width: 80 },
			//1：买方&卖方 2：卖方
			{ label: '用户角色 ', name: 'roletype', index: 'roleType', width: 80 },
			// { label: '修改时间', name: 'updatetime', index: 'updateTime', width: 80 },
			{ label: '创建时间', name: 'createtime', index: 'createTime', width: 80 },
			{ label: '企业状态', name: 'status', index: 'status', width: 80 },
			{ label: '备注', name: 'remark', index: 'remark', width: 80 },
			// { label: '用户id', name: 'userid', index: 'userId', width: 80 },
			{ label: '原因', name: 'reason', index: 'reason', width: 80 },
			//用户账号-注册手机号
			{ label: '操作人员标识', name: 'operatorid', index: 'operatorId', width: 80 },
			{ label: '平台ID', name: 'platformid', index: 'platformId', width: 80 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
        approveStatus:1,
		enterprise: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.enterprise = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.enterprise.id == null ? "enterprise/enterprise/save" : "enterprise/enterprise/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.enterprise),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "enterprise/enterprise/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(id){
			$.get(baseURL + "enterprise/enterprise/info/"+id, function(r){
                vm.enterprise = r.enterprise;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        toPass: function (status) {

        },
        examine:function (status) {
            console.log(status);
            let reasons = $('#reason').val();
            let remark = $('#remark').val();
            if (status == 2){
                $('#examine').button('loading').delay(1000).queue(function() {
                    var url =  "enterprise/enterprise/noPass";
                    var ajData = {};
                    ajData.id = vm.enterprise.id;
                    ajData.reasons = reasons;
                    ajData.remark = remark;
                    $.ajax({
                        type: "POST",
                        url: baseURL + url,
                        contentType: "application/json",
                        data: JSON.stringify(ajData),
                        success: function(r){
                            if(r.code === 0){
                                layer.msg("操作成功", {icon: 1});
                                vm.reload();
                                $('#examine').button('reset');
                                $('#examine').dequeue();
                            }else{
                                layer.alert(r.msg);
                                $('#examine').button('reset');
                                $('#examine').dequeue();
                            }
                        }
                    });
                });
            }
        }
	}
});
function previewImg(obj) {
    var img = new Image();
    img.src = obj.src;
    var height = img.height + 50; //获取图片高度
    var width = img.width; //获取图片宽度
    var imgHtml = "<img src='" + obj.src + "' />";
    //弹出层
    layer.open({
        type: 1,
        shade: 0.8,
        offset: 'auto',
        area: [width + 'px',height+'px'],
        shadeClose:true,//点击外围关闭弹窗
        scrollbar: false,//不现实滚动条
        title: "图片预览", //不显示标题
        content: imgHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
        cancel: function () {
            //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });
        }
    });
}