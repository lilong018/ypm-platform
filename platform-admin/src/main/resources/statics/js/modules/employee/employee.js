$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'employee/employee/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '员工姓名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '性别', name: 'gender', index: 'gender', width: 80 ,formatter:function(cellvalue, options, rowObject) {
                if(cellvalue == 1){
                    return "男";
                }else{
                    return "女";
                }
            } },
			{ label: '部门', name: 'department', index: 'department', width: 80 ,formatter:function(cellvalue, options, rowObject) {
                if(cellvalue == 0){
                    return "未知";
                }else if(cellvalue == 1){
                    return "管理部门";
                }else if(cellvalue == 2){
                    return "客服";
                }else if(cellvalue == 3){
                    return "财务";
                }
            } },
			{ label: '手机号码', name: 'phoneno', index: 'phoneNo', width: 80 },
			{ label: '地址', name: 'address', index: 'address', width: 80 }, 			
			{ label: '职称', name: 'title', index: 'title', width: 80 }, 			
			{ label: '照片', name: 'photourl', index: 'photoUrl', width: 80 }, 			
			{ label: '状态', name: 'status', index: 'status', width: 80 ,formatter:function(cellvalue, options, rowObject) {
                if(cellvalue == 0){
                    return "启用";
                }else{
                    return "停用";
                }
			 } },
			{ label: '平台id', name: 'platformid', index: 'platformId', width: 80 },
			{ label: '到职时间', name: 'onboardtimeinmillis', index: 'onBoardTimeInMillis', width: 80 }, 			
			{ label: '离职时间', name: 'lefttimeinmillis', index: 'leftTimeInMillis', width: 80 }, 			
			{ label: '创建时间', name: 'createtimeinmillis', index: 'createTimeInMillis', width: 80 }			
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
		employee: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.employee = {};
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
                var url = vm.employee.id == null ? "employee/employee/save" : "employee/employee/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.employee),
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
                        url: baseURL + "employee/employee/delete",
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
			$.get(baseURL + "employee/employee/info/"+id, function(r){
                vm.employee = r.employee;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});